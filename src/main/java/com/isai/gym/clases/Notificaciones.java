/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.isai.gym.clases;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author isai_
 */
public class Notificaciones {
    
    OperacionesDB operDB= new OperacionesDB();
    Utilerias util=new Utilerias();
    String [] datos={"idconfiguraciones","1"};
    
    String [] datosConfig=operDB.datosRow("configuraciones",datos);
    
    
    
    public void vigenciaPeriodo(JPanel panel,JLabel label,int dias){
        int diasPrev=Integer.parseInt(datosConfig[1]);
        
        if(dias>diasPrev){
            panel.setBackground(Color.decode(util.colorBien));
            label.setText("GENERAL, vencimiento en "+dias+" dias");
        }else if(dias<=diasPrev && dias>0){
            panel.setBackground(Color.decode(util.colorWarning));
            label.setText("VENCIMIENTO PROXIMO ("+dias+" dias restantes)");
        }else if(dias<=0){
            panel.setBackground(Color.decode(util.colorMal));
            label.setText("¡VENCIDO!, vencido hace "+(dias*-1)+" dias");
        }
        
    }
    
    public void limiteVisita(JPanel panel,String idCliente){
        int visitLim=Integer.parseInt(datosConfig[2]);
        
        String[] datos={"IdCliente",idCliente};
        
        String [] consulta=operDB.datosRow("vistaLimitVisita", datos);
        
        
        System.out.println(consulta[1]);
        if(consulta[1]!=null && Integer.parseInt(consulta[1])>=visitLim){
            panel.setBackground(Color.decode(util.colorMal));
            JOptionPane.showMessageDialog(null,"¡Has revasado el numero de visitas!","ATENCI\u00d3N",JOptionPane.ERROR_MESSAGE);
        }else{
            String [][] datosVisita={{"clienteIdClienteVisita",idCliente},
                                     {"estado","ACTIVO"}};
            if(operDB.guardarRegresandoId(datosVisita,"visitas")>0){
                
            }else{
                System.out.println("ERROR al guardar visita en notificaciones");
            }
        }
        
    }
    
    
    public void contadorVisita(JLabel contador){
        String [] datos={"ID","1"};
        
        String [] consulta=operDB.datosRow("vistaContadorVisitas", datos);
        
        contador.setText("Contador de vistas: "+consulta[1]);
        
    }
}
