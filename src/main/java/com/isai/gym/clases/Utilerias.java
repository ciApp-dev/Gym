/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isai.gym.clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author isai_
 */
public class Utilerias {
    OperacionesDB operDB= new OperacionesDB();
    public String colorWarning="#f4ff81";
    public String colorBien="#4caf50";
    public String colorMal="#f44336";
    public String colorPrimario="#81d4fa";
    public String colorSecundario="#b6ffff";
    public String colorDark="#4ba3c7";
    public String colorFondo="#e3f2fd";
    private String ENCRYPT_KEY="GymAppDev";
    
    public void llenarTabla(JTable table, String tabla) {
    	table.setModel(operDB.consultaGeneral(tabla));
    }
     
    public boolean verificarInt(String dato){
        try{
            int valor;
            valor=Integer.parseInt(dato);
            if(valor>0){
            return true;
        }else{
            return false;
        }
        }catch(NumberFormatException e){
                return false;
                }
        
    }
    
    public boolean verificarDouble(String nombre,String dato){
        try{
            Double valor;
            valor = Double.parseDouble(dato);
            if(valor>0){
                return true;
            }else{
            return false;    
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique el campo "+nombre, "Campo Vacio", JOptionPane.WARNING_MESSAGE);
            return false;
            
        }
    }
    
    public boolean verificarString(String valor){
        if(valor.length()>0){
            return true;
        }else{
            return false;
        }
    }
    
    public String [][] verificarVariosString(String [][] datos){
        String[][] regreso=new String[1][2];
        
        for(int i=0;i<datos.length;i++){
            if(datos[i][1].length()>0){
                regreso[0][0]="CORRECTO";
            }else{
                regreso[0][0]="ERROR";
                regreso[0][1]=datos[i][0];
                break;
            }
        }
        System.out.println(regreso [0][0]);
        return regreso;
    }
    
    public void centrarSubventana(JDialog submenu,int alto,int ancho){
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( ancho, alto );


        submenu.setBounds ( ss.width / 2 - frameSize.width / 2, 
                  ss.height / 2 - frameSize.height / 2,
                  frameSize.width, frameSize.height );
        submenu.setVisible ( true );
    }
    
     public void centrarFrame(JFrame ventana,int alto,int ancho){
        Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
        Dimension frameSize = new Dimension ( ancho, alto );


        ventana.setBounds ( ss.width / 2 - frameSize.width / 2, 
                  ss.height / 2 - frameSize.height / 2,
                  frameSize.width, frameSize.height );
        ventana.setVisible ( true );
    }
            
    public void llenarCombo(JComboBox combo,String[][] datos){
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        combo.removeAllItems();
        for(int i=0;i<datos.length;i++){
           model.addElement(datos[i][1]);
           
        }
        combo.setModel(model);
        combo.updateUI();
    }
    
    public String convSexo(String sex){
        String regreso="";
        switch(sex){
            case "M":
                regreso= "MASCULINO";
                break;
            case "F":
                regreso= "FEMENINO";
                break;
            case "N":
                regreso= "NO ESPECIFICADO";
                break;
        }
                
        return regreso;
    }
    
    public String sumarFecha(Date fecha,String unidad, int cantidad){
        String regreso;
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(fecha);
        switch(unidad){
                case "Dias":
                    calendar.add(Calendar.DAY_OF_YEAR, cantidad);
                    break;
                case "Meses":
                    calendar.add(Calendar.DAY_OF_YEAR,cantidad*30);
                    break;
        }   
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        regreso=formato.format(calendar.getTime());
        return regreso;
    }

    
    public String formatoFechaHora(Date fecha){
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return formato.format(fecha);
    }
    
    
    public String formatoFechaUsuario(String fecha){
        try {
            SimpleDateFormat formatoE=new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat formatoS=new SimpleDateFormat("dd/MM/yyyy");
            Date date=formatoE.parse(fecha);
            return formatoS.format(date);
        } catch (ParseException ex) {
            Logger.getLogger(Utilerias.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
 
    
    public void placeHolder(String mensaje,JTextField campo,String ruta){
        TextPrompt placeHolder=new TextPrompt(mensaje,campo);
        if(ruta!=null){
            //        "/ic_64/ic_home_bn.png"
                    placeHolder.setIcon(new ImageIcon(getClass().getResource(ruta)));
        }
        placeHolder.setForeground(Color.decode(colorPrimario));
    }
    
        public SecretKeySpec CrearClave(String ENCRYPT_KEY) {
    	
    	try {
    		byte[] cadena=ENCRYPT_KEY.getBytes("UTF-8");
    		MessageDigest md=MessageDigest.getInstance("SHA-1");
    		cadena=md.digest(cadena);
    		cadena=Arrays.copyOf(cadena, 16);
    		SecretKeySpec ks=new SecretKeySpec(cadena,"AES");
    		return ks;
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    
    public String encriptacion(String text) {
    	try {
    		SecretKeySpec sks= CrearClave(ENCRYPT_KEY);
    		Cipher cp=Cipher.getInstance("AES");
    		cp.init(Cipher.ENCRYPT_MODE,sks );
    		byte [] cadena=text.getBytes("UTF-8");
    		byte [] encriptar=cp.doFinal(cadena);
    		
    		String cadena_encriptada = new String(encriptar);
    		return cadena_encriptada;
    		
    	}catch(Exception e) {
    		return null;
    	}
    }
    
    public String Desencriptar(String desencriptar) {
        
        try {
            SecretKeySpec secretKeySpec = CrearClave(ENCRYPT_KEY);
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            
            byte [] cadena = desencriptar.getBytes();
            byte [] desencriptacioon = cipher.doFinal(cadena);
            String cadena_desencriptada = new String(desencriptacioon);
            return cadena_desencriptada;
            
        } catch (Exception e) {
            return "";
        }
    }
    
    public void mensajeError(Component componente, String mensaje) {
    	JOptionPane.showMessageDialog(componente,
    		    mensaje,
    		    "Error",
    		    JOptionPane.ERROR_MESSAGE);
    }
}


