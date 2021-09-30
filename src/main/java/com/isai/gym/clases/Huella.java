/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package com.isai.gym.clases;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Color;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
/**
 *
 * @author isai_
 */
public class Huella {
    
    Utilerias util= new Utilerias();
    
    public DPFPCapture lector = DPFPGlobal.getCaptureFactory().createCapture();
    public DPFPEnrollment reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    public DPFPVerification verificador= DPFPGlobal.getVerificationFactory().createVerification();
    public DPFPTemplate template;
    
    
    public DPFPFeatureSet featuresincripcion;
    public DPFPFeatureSet featuresverificacion;
    
    public static String TEMPLATE_PROPERTY="template";
    
    JLabel imgHuella;
    JLabel lblMsg;
    JTextArea lblNombre;
    JTextArea txtMsg;
    JPanel panel;
    JComboBox cmbNombre;
    JLabel lblTerminacion,lblDias,lblContador;
    JPanel panelEstado;
            
    String idClienteEnv;
    
    public boolean banderaGuardado,banderaIdentificador;
    
    
    public void setBandera(boolean bandera,JTextArea nombre,JLabel lblterm,JLabel lbldias,JPanel panelEst,JLabel contador){
        banderaIdentificador=bandera;
        lblNombre=nombre;
        lblTerminacion=lblterm;
        lblDias=lbldias;
        panelEstado=panelEst;
        lblContador=contador;
    }
    public void setLabel(JLabel lblImagen,JLabel lblMsg,JTextArea txtMsg,JPanel panel){
        this.imgHuella=lblImagen;
        this.lblMsg=lblMsg;
        this.txtMsg=txtMsg;
        this.panel=panel;
        banderaIdentificador=false;
    }
    
    public void inciar(){
        lector.addDataListener(new DPFPDataAdapter(){
            public void dataAcquired(final DPFPDataEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        
                        msg("La Huella ha sido Capturada");
                        procesoCaptura(e.getSample());
                        
                    }
                });
            }
        });
        
        lector.addReaderStatusListener(new DPFPReaderStatusAdapter(){
            public void readerConnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        msg("El sensor de huella esta conectado");
                        
                    }
                });
            }
            
            public void readerDisconnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){ 
                    public void run(){
                        msg("El sensor esta desconectado");
                    }
                });
            }
        });
        
        
        lector.addSensorListener(new DPFPSensorAdapter(){
            public void fingerTouched(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        msg("Se ha detectado dedo colocado");
                        
                    }
                });
            }
            
            public void fingerGone(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                        msg("El dedo ha sido retirado");
                        if(banderaIdentificador){
                            
                            identificarHuella();
                            
                        }
                    }
                });
            }
        });
        
        
        lector.addErrorListener(new DPFPErrorAdapter(){
            public void errorReader(final DPFPErrorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    public void run(){
                     msg("Error: "+e.getError());   
                    }
                });
            }
        });
        
        
        
    }
    
    
    public void procesoCaptura(DPFPSample sample){
        featuresincripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

 // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
 featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

 // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
 if (featuresincripcion != null)
     try{
     System.out.println("Las Caracteristicas de la Huella han sido creada");
     reclutador.addFeatures(featuresincripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

     // Dibuja la huella dactilar capturada.
     Image image=crearImagenHuella(sample);
     dibujarHuella(image);
     
     

     }catch (DPFPImageQualityException ex) {
     System.err.println("Error: "+ex.getMessage());
     }

     finally {
     estadoHuellas();
     // Comprueba si la plantilla se ha creado.
	switch(reclutador.getTemplateStatus())
        {
            case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
	    stop();
            setTemplate(reclutador.getTemplate());
	    msg("La Plantilla de la Huella ha Sido Creada");
	    panel.setBackground(Color.decode(util.colorBien));
            banderaGuardado=true;
            break;

	    case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
	    reclutador.clear();
            stop();
	    estadoHuellas();
	    setTemplate(null);
	    JOptionPane.showMessageDialog(null, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
	    start();
            banderaGuardado=false;
	    break;
	}
	     }
    }
    
    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample,DPFPDataPurpose purpose){
            DPFPFeatureExtraction extractor=DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
            try{
                
                return extractor.createFeatureSet(sample, purpose);
            }catch(DPFPImageQualityException e){
                return null;
            }
    }
    
    public Image crearImagenHuella(DPFPSample sample){
     return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }
    
    public void dibujarHuella(Image imagen){
        
        imgHuella.setIcon(new ImageIcon(
        imagen.getScaledInstance(imgHuella.getWidth(), imgHuella.getHeight(), Image.SCALE_DEFAULT)
        ));
    }
    
    
    
    public void estadoHuellas(){
        String msg="Muestras de huellas necesarias: "+reclutador.getFeaturesNeeded();
        if(lblMsg!=null){
            lblMsg.setText(msg);
            panel.setBackground(Color.decode(util.colorWarning));
        }
    }
    
    public void msg(String msg){
        System.out.println(msg);
        if(txtMsg!=null){
            txtMsg.setText(txtMsg.getText()+msg+"\n");
        }
    }
    
    public void start(){
        lector.startCapture();
        msg("Ha comenzado a utilizar el lector");
        
    }
    
    public void stop(){
        banderaGuardado=false;
        lector.stopCapture();
        msg("Se ha detenido el uso del lector");
    }
    
    
    
    public DPFPTemplate getTemplate(){
        return template;
    }
    
    public void setTemplate(DPFPTemplate template){
        DPFPTemplate old=this.template;
        this.template=template;
    }
    
    public boolean guardarHuella(int idCliente, String nombre){
        ByteArrayInputStream huella=new ByteArrayInputStream(template.serialize());
        Integer huellasize=template.serialize().length;
        
        try{
            conexion con=new conexion();
            
            PreparedStatement sent=con.conexion().prepareStatement("INSERT INTO huellas(idClienteHuella,huella,estado,nombreHuella) values(?,?,?,?)");
            sent.setInt(1, idCliente);
            sent.setBinaryStream(2, huella);
            sent.setString(3, "ACTIVO");
            sent.setString(4, nombre);
            sent.execute();
            sent.close();
            con.desconectar();
            return true;
        }catch(SQLException e){
            System.out.println("Error al guardar huela: "+e.getMessage());
            return false;
        }
    }
    
    public void verificarHuella(String nom){
        conexion con =new conexion();
        try{
            
            
            PreparedStatement query=con.conexion().prepareStatement("SELECT huella FROM finger WHERE nombre=?");
            query.setString(1, nom);
            ResultSet rs=query.executeQuery();
            if(rs.next()){
                byte templateBuffer[]=rs.getBytes("huella");
                DPFPTemplate referencia=DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                setTemplate(referencia);
                DPFPVerificationResult resul=verificador.verify(featuresverificacion, getTemplate());
                
                if(resul.isVerified()){
                    JOptionPane.showMessageDialog(null, "Las huellas coinciden");
                }else{
                    JOptionPane.showMessageDialog(null, "Las huellas NO COINCIDEN");
                }
            }
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }finally{
         con.desconectar();
        }
        
    }
    
    public void identificarHuella(){
        conexion con= new conexion();
        try{
            PreparedStatement query=con.conexion().prepareStatement("SELECT * FROM vistahuellas");
            ResultSet rs=query.executeQuery();
            
            while(rs.next()){
                
             
                
                byte templateBuffer[]=rs.getBytes("Huella");
                String idCliente=rs.getString("IDCliente");
                String nombre=rs.getString("Nombre");
                String terminacion=rs.getString("Terminacion");
                String dias=rs.getString("Dias");
                int diasInt=Integer.parseInt(dias);
                
                
                DPFPTemplate referenceTemplate=DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                setTemplate(referenceTemplate);
                DPFPVerificationResult result=verificador.verify(featuresverificacion, getTemplate());
                
                if(result.isVerified()){
                    if(banderaIdentificador){
                        
                        lblNombre.setText("Bienvenido\n"+nombre);
                        
                        if(cmbNombre!=null){
                            cmbNombre.setSelectedItem(nombre);
                            System.out.println("Entramos al combo");
                        }else{
                        
                    
                        
                        lblTerminacion.setText(util.formatoFechaUsuario(terminacion));
                        Notificaciones not=new Notificaciones();
                        
                        not.vigenciaPeriodo(panelEstado, lblDias, diasInt);
                        not.limiteVisita(panel, idCliente);
                        idClienteEnv=idCliente;
                        not.contadorVisita(lblContador);
                        /*
                        lblNombre.setText("Bienvenido "+nombre);
                        reclutador.clear();
                        lblTerminacion.setText(terminacion);
                        
                        if(diasInt>=0){
                            lblDias.setText(""+diasInt);
                            panelEstado.setBackground(Color.decode(util.colorBien));
                        }else{
                            if((diasInt*-1>1)){
                                lblDias.setText("Vencido hace "+diasInt*-1 +" dias");
                                panelEstado.setBackground(Color.decode(util.colorMal));
                            }else{
                                lblDias.setText("Vencido hace "+diasInt*-1 +" dia");
                                panelEstado.setBackground(Color.decode(util.colorMal));
                            }
                            
                        }*/
                        
                    
                    }
                    }
                    reclutador.clear();
                    return;
                }else{
                    
                    buscarClientes();
                    
                }
            }
            
        }catch(Exception e){
            System.out.println("Error en Identificador: "+e.getMessage());
        }finally{
            con.desconectar();
        }
    }
    
    
    public void buscarClientes(){
        conexion con= new conexion();
        try{
            PreparedStatement query=con.conexion().prepareStatement("SELECT * FROM vistahuellasDatos");
            ResultSet rs=query.executeQuery();
            
            while(rs.next()){
                
             
                
                byte templateBuffer[]=rs.getBytes("Huella");
                String idCliente=rs.getString("IDCliente");
                String nombre=rs.getString("Nombre");
                
                
                
                DPFPTemplate referenceTemplate=DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                setTemplate(referenceTemplate);
                DPFPVerificationResult result=verificador.verify(featuresverificacion, getTemplate());
                
                if(result.isVerified()){
                    if(banderaIdentificador){
                        
                        lblNombre.setText("Bienvenido\n"+nombre);
                        
                        if(cmbNombre!=null){
                            cmbNombre.setSelectedItem(nombre);
                            System.out.println("Entramos al combo");
                        }else{
                        
                    }
                        
                        lblTerminacion.setText("");
                        lblDias.setText("");
                    }
                    reclutador.clear();
                    return;
                }else{
                    
                     lblNombre.setText("Usuario no encontrado\n");
                    panelEstado.setBackground(Color.decode(util.colorMal));
                    System.out.println("seguiremos buscando...");
                    
                }
            }
            
        }catch(Exception e){
            System.out.println("Error en Identificador: "+e.getMessage());
        }finally{
            con.desconectar();
        }
        
        
        
       
    }
    
    
    public void ComboNombre(JComboBox jcbNombre){
    this.cmbNombre=jcbNombre;
}
}
