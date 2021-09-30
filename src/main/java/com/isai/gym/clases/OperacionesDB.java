/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isai.gym.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author isai_
 */
public class OperacionesDB {
    
    
    public DefaultTableModel consultaGeneral(String tabla)  {
	
	
	   
	   DefaultTableModel modelo=new DefaultTableModel();
	   
	   try {
		   
		   conexion con=new conexion();
		   
		  PreparedStatement query=con.conexion().prepareStatement("SELECT * FROM "+tabla);
                  ResultSet rs=query.executeQuery();
		  String nvo[]= new String[rs.getMetaData().getColumnCount()];
          for(int j=1;j<=rs.getMetaData().getColumnCount();j++){
               
              modelo.addColumn(rs.getMetaData().getColumnName(j));
              
          }
                 
          while(rs.next())
               
          {
               
              for(int i=1;i<=modelo.getColumnCount();i++)
                   
                  nvo[i-1]=rs.getString(i);
               
                    modelo.addRow(nvo);
               }
          
          con.desconectar();
     
          return modelo;
	   }
	   
      
      
	   catch(SQLException e) {
		   System.out.println("Error en consulta general "+e.getMessage());
		  return modelo; 
	   }
	   

   }
    
    public boolean modificar(String tabla,String [][] datos) {
        
        boolean regreso=false;
		//ultimos valores determinan la condicion
                  String campos="";
        
                  String campoCondicion="";
        for(int i=0; i<(datos.length-1);i++){
            campos=campos+datos[i][0]+"=?,";
        }
        
        campoCondicion=datos[datos.length-1][0];
        campos=campos.substring(0, campos.length()-1);
        
        
        try{
            conexion con=new conexion();
            
            PreparedStatement sent=con.conexion().prepareStatement("UPDATE "+tabla+" SET "+campos+" WHERE "+campoCondicion+"=?");
            for(int i=1;i<=datos.length;i++){
                sent.setString(i, datos[i-1][1]);
           }
            
            sent.execute();
            sent.close();
            con.desconectar();
            regreso= true;
        }catch(SQLException e){
            regreso=false;
            System.out.println(e.getMessage());
        }
        
		return regreso;
	}
    
    
    
    public int guardarRegresandoId(String[][]datos,String tabla){
        int dev=0;
        
        String campos="";
        String values="";
        for(int i=0; i<datos.length;i++){
            campos=campos+datos[i][0]+",";
            values=values+"?,";
        }
        campos=campos.substring(0, campos.length()-1);
        values=values.substring(0, values.length()-1);
        
        try{
            conexion con=new conexion();
            
            PreparedStatement sent=con.conexion().prepareStatement("INSERT INTO "+tabla+"("+campos+") values("+values+")",PreparedStatement.RETURN_GENERATED_KEYS);
            for(int i=1;i<=datos.length;i++){
                sent.setString(i, datos[i-1][1]);
            }
            sent.execute();
            ResultSet rs=sent.getGeneratedKeys();
            while(rs.next()){
                dev=rs.getInt(1);
            }
            sent.close();
            con.desconectar();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return dev;
    }
    
    
    public String[][] datosArreglosCombos(String tabla,String[] campos){
        conexion con =new conexion();
        
        try{
            PreparedStatement query=con.conexion().prepareStatement("SELECT "+campos[0]+","+campos[1]+" FROM "+tabla,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                  ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=query.executeQuery();
           
            int i=0;
            rs.last();
            String [][] regreso=new String[rs.getRow()][2];
            rs.beforeFirst();
            
            while(rs.next()){
                
                regreso[i][0]=rs.getString(campos[0]);
                regreso[i][1]=rs.getString(campos[1]);
                
                i++;
            }
            return regreso;
        }catch(Exception e){
            System.out.println("ERROR EN DATOSARREGLOSCOMBOS"+e.getMessage());
        return null;
        }
       
    }
    public String[] datosRow(String tabla, String[]datos){
        String[] regreso;
        try{
        conexion con=new conexion();
        
        PreparedStatement query=con.conexion().prepareStatement("SELECT * FROM "+tabla+" WHERE "+datos[0]+"=?");
        query.setString(1,datos[1]);
        ResultSet rs=query.executeQuery();
        int columnas=rs.getMetaData().getColumnCount();
        regreso=new String[columnas];
        
        if(rs.next()){
            
           for(int i=1;i<=columnas;i++){
                
               regreso[i-1]=rs.getString(i);
               
           }
        }
        return regreso;
        }catch(Exception e){
            System.out.println("Problemas en datosRow: "+e.getMessage());
            return null;
        }
        
    }
    
    
    public String[] datosRowCondicionesAND(String tabla, String[][]datos){
        String[] regreso;
        String campos="",valores;
        
        for(int i=0; i<datos.length;i++){
            campos=campos+datos[i][0]+"=? AND ";
        }
        
        try{
        conexion con=new conexion();
        
        PreparedStatement query=con.conexion().prepareStatement("SELECT * FROM "+tabla+" WHERE "+campos.substring(0,campos.length()-4));
        
        for(int j=0;j<datos.length;j++){
            query.setString(j+1,datos[j][1]);    
        }
        
        ResultSet rs=query.executeQuery();
        int columnas=rs.getMetaData().getColumnCount();
        regreso=new String[columnas];
        
        while(rs.next()){
            
           for(int i=1;i<=columnas;i++){
                
               regreso[i-1]=rs.getString(i);
               
           }
        }
        return regreso;
        }catch(Exception e){
            System.out.println("Problemas en datosRow con Condiciones: "+e.getMessage());
            return null;
        }
        
    }
}
