package IP_CAL;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;



import javax.swing.text.PlainDocument;

import IP_CAL.DB;

public class Cal{

	//VARIABLES    LINEA 33 - LINEA 103
	public static JTextField txt1;
	public static JTextField txt2;
	public static JTextField txt3;
	public static JTextField txt4;
	public static JLabel p1;
	public static JLabel p2;
	public static JLabel p3;
	public static JLabel p4;
	public static JLabel p5;
	public static JLabel p6;
	public static JTextField mask1;
	public static JTextField mask2;
	public static JTextField mask3;
	public static JTextField mask4;
	public static JPanel panel;
	public static JTextArea tipoIP;
	
	public static int parametro1;
	public static int parametro2;
	public static int parametro3;
	public static int parametro4;
	public static int parametro5;
	public static int parametro6;
	public static int parametro7;
	public static int parametro8;
	
	public static String tipo;
	public static String clase;
	public static String apipa;
	public static String reservada;
	public static String metodo;
	public static String red;
	public static String firstip;
	public static String lastip;
	public static String broadcast;
	public static String hosts;
	
	public static String text1;
	public static String text2;
	public static String text3;
	public static String text4;
	public static String ipcompleta;
	public static String mascaradered;
	public static JLabel calip;
	public static JLabel lblNewLabel;
	public static JLabel lblNewLabel_1;
	public static JComboBox mascara;
	public static JLabel layClase;
	public static JTextArea claseIP;
	public static JLabel layPA;
	public static JTextArea paIP;
	public static JTextArea reserIP;
	public static JLabel layIP;
	public static JTextArea metIP;
	public static JLabel laymet;
	public static JLabel layMASK;
	public static JLabel redMASK;
	public static JLabel prIPMASK;
	public static JLabel ultIPMASK;
	public static JLabel broadMASK;
	public static JLabel hostsMASK;
	public static JTextArea tfprIPMASK;
	public static JTextArea tfRED;
	public static JTextArea tfultIPMASK;
	public static JTextArea tfBROADCAST;
	public static JTextArea tfHOSTS;
	public static JLabel GATEWAY;
	public static JTextArea tfGATEWAY;
	public static   JButton btnhistorial;
	public static JButton btnNewButton;
	
	
	
	//METODOS      LINEA 109 - LINEA 11047
	
	//METODOS DE OPERACIONES CON LA IP      LINEA 109 - LINEA 191
	public void operacionesip() {
        	//SABER SI ES PRIVADA O PUBLICA
        	if (parametro1 == 192 && parametro2 == 168){
        		tipo = "Privada";
        		tipoIP.setText(tipo);
            	
            } else if (parametro1 == 172 && parametro2 >= 16 && parametro2 <= 31){
            	tipo = "Privada";
            	tipoIP.setText(tipo);
            	
            } else if (parametro1 == 10){
            	tipo = "Privada";
            	tipoIP.setText(tipo);
            	//System.out.println(mascaradered);
            	
            } else {
            	tipo = "Publica";
            	tipoIP.setText(tipo);
            }
        
        
        //SABER LA CLASE Y EL METODO DE LA IP
        	if (parametro1 <= 126) {
        		clase = "Clase A";
        		metodo = "Unicast";
        		claseIP.setText(clase);
        		metIP.setText(metodo);
        		
        	} else if (parametro1 >= 128 && parametro1 <= 191) {
        		clase = "Clase B";
        		metodo = "Unicast";
        		claseIP.setText(clase);
        		metIP.setText(metodo);
        		
        	} else if (parametro1 >= 192 && parametro1 <= 223) {
        		clase = "Clase C";
        		metodo = "Unicast";
        		claseIP.setText(clase);
        		metIP.setText(metodo);
        		
        	} else if (parametro1 >= 224 && parametro1 <= 239) {
        		clase = "Clase D";
        		metodo = "Multicast";
        		claseIP.setText(clase);
        		metIP.setText(metodo);
        		
        	} else if (parametro1 >= 240 && parametro1 <= 255) {
        		clase = "Clase E";
        		metodo = "Broadcast";
        		claseIP.setText(clase);
        		metIP.setText(metodo);
        	}
        
        
        //PROTOCOLO APIPA
        	if (parametro1 == 169 && parametro2 == 254 && parametro3 >= 1 && parametro3 <= 254) {
        		apipa = "SI";
        		paIP.setText(apipa);
        		
        	} else {
        		apipa = "NO";
        		paIP.setText(apipa);
        	}
        
	
        //RESERVADA
        	if (parametro1 == 10 && parametro2 == 0 && parametro3 == 0 && parametro4 == 0) {
        		reservada = "Si, Tipo A";
        		reserIP.setText(reservada);
        		
        	} else if (parametro1 == 172 && parametro2 >= 16 && parametro2 <= 31 && parametro3 == 0 && parametro4 == 0) {
        		reservada = "Si, Tipo B";
        		reserIP.setText(reservada);
        		
        	} else if (parametro1 == 192 && parametro2 == 168 && parametro4 == 0) {
        		reservada = "Si, Tipo C";
        		reserIP.setText(reservada);
        		
        	} else {
        		reservada = "NO";
        		reserIP.setText(reservada);
        	}
	}
	
	
	//METODOS DE LA MASCARA DE RED    LINEA 197 - 11049
	
	//MASCARA DE RED 255.255.255.XXX      LINEA 197 - 1754
	public void mascara1 () {
		//255.255.255.252
    	if (mascaradered == "255.255.255.252") {
    		if (parametro4 <= 3 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".2";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".3";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 7 && parametro4 >= 4) {
    			red = parametro1+"."+parametro2+"."+parametro3+".4";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".5";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".6";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".7";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 11 && parametro4 >= 8) {
    			red = parametro1+"."+parametro2+"."+parametro3+".8";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".9";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".10";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".11";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 15 && parametro4 >= 12) {
    			red = parametro1+"."+parametro2+"."+parametro3+".12";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".13";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".14";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".15";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 19 && parametro4 >= 16) {
    			red = parametro1+"."+parametro2+"."+parametro3+".16";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".17";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".18";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".19";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 23 && parametro4 >= 20) {
    			red = parametro1+"."+parametro2+"."+parametro3+".20";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".21";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".22";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".23";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 27 && parametro4 >= 24) {
    			red = parametro1+"."+parametro2+"."+parametro3+".24";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".25";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".26";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".27";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 31 && parametro4 >= 28) {
    			red = parametro1+"."+parametro2+"."+parametro3+".28";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".29";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".30";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".31";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 35 && parametro4 >= 32) {
    			red = parametro1+"."+parametro2+"."+parametro3+".32";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".33";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".34";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".35";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 39 && parametro4 >= 36) {
    			red = parametro1+"."+parametro2+"."+parametro3+".36";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".37";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".38";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".39";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 43 && parametro4 >= 40) {
    			red = parametro1+"."+parametro2+"."+parametro3+".40";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".41";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".42";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".43";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 47 && parametro4 >= 44) {
    			red = parametro1+"."+parametro2+"."+parametro3+".44";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".45";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".46";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".47";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 51 && parametro4 >= 48) {
    			red = parametro1+"."+parametro2+"."+parametro3+".48";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".49";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".50";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".51";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 55 && parametro4 >= 52) {
    			red = parametro1+"."+parametro2+"."+parametro3+".52";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".53";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".54";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".55";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 59 && parametro4 >= 56) {
    			red = parametro1+"."+parametro2+"."+parametro3+".56";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".57";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".58";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".59";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 63 && parametro4 >= 60) {
    			red = parametro1+"."+parametro2+"."+parametro3+".60";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".61";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".62";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".63";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 67 && parametro4 >= 64) {
    			red = parametro1+"."+parametro2+"."+parametro3+".64";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".65";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".66";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".67";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 71 && parametro4 >= 68) {
    			red = parametro1+"."+parametro2+"."+parametro3+".68";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".69";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".70";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".71";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 75 && parametro4 >= 72) {
    			red = parametro1+"."+parametro2+"."+parametro3+".72";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".73";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".74";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".75";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 79 && parametro4 >= 76) {
    			red = parametro1+"."+parametro2+"."+parametro3+".76";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".77";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".78";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".79";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 83 && parametro4 >= 80) {
    			red = parametro1+"."+parametro2+"."+parametro3+".80";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".81";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".82";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".83";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 87 && parametro4 >= 84) {
    			red = parametro1+"."+parametro2+"."+parametro3+".84";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".85";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".86";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".87";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 91 && parametro4 >= 88) {
    			red = parametro1+"."+parametro2+"."+parametro3+".88";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".89";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".90";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".91";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 95 && parametro4 >= 92) {
    			red = parametro1+"."+parametro2+"."+parametro3+".92";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".93";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".94";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".95";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 99 && parametro4 >= 96) {
    			red = parametro1+"."+parametro2+"."+parametro3+".96";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".97";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".98";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".99";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 103 && parametro4 >= 100) {
    			red = parametro1+"."+parametro2+"."+parametro3+".100";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".101";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".102";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".103";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 107 && parametro4 >= 104) {
    			red = parametro1+"."+parametro2+"."+parametro3+".104";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".105";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".106";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".107";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 111 && parametro4 >= 108) {
    			red = parametro1+"."+parametro2+"."+parametro3+".108";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".109";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".110";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".111";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 115 && parametro4 >= 112) {
    			red = parametro1+"."+parametro2+"."+parametro3+".112";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".113";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".114";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".115";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 119 && parametro4 >= 116) {
    			red = parametro1+"."+parametro2+"."+parametro3+".116";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".117";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".118";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".119";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 123 && parametro4 >= 120) {
    			red = parametro1+"."+parametro2+"."+parametro3+".120";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".121";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".122";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".123";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 127 && parametro4 >= 124) {
    			red = parametro1+"."+parametro2+"."+parametro3+".124";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".125";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 131 && parametro4 >= 128) {
    			red = parametro1+"."+parametro2+"."+parametro3+".128";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".130";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".131";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 135 && parametro4 >= 132) {
    			red = parametro1+"."+parametro2+"."+parametro3+".132";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".133";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".134";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".135";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 139 && parametro4 >= 136) {
    			red = parametro1+"."+parametro2+"."+parametro3+".136";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".137";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".138";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".139";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 143 && parametro4 >= 140) {
    			red = parametro1+"."+parametro2+"."+parametro3+".140";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".141";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".142";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".143";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 147 && parametro4 >= 144) {
    			red = parametro1+"."+parametro2+"."+parametro3+".144";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".145";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".146";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".147";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 151 && parametro4 >= 148) {
    			red = parametro1+"."+parametro2+"."+parametro3+".148";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".149";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".150";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".151";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 155 && parametro4 >= 152) {
    			red = parametro1+"."+parametro2+"."+parametro3+".152";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".153";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".154";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".155";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 159 && parametro4 >= 156) {
    			red = parametro1+"."+parametro2+"."+parametro3+".156";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".157";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".158";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".159";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 163 && parametro4 >= 160) {
    			red = parametro1+"."+parametro2+"."+parametro3+".160";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".161";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".162";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".163";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 167 && parametro4 >= 164) {
    			red = parametro1+"."+parametro2+"."+parametro3+".164";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".165";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".166";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".167";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 171 && parametro4 >= 168) {
    			red = parametro1+"."+parametro2+"."+parametro3+".168";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".169";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".170";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".171";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 175 && parametro4 >= 172) {
    			red = parametro1+"."+parametro2+"."+parametro3+".172";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".173";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".174";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".175";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 179 && parametro4 >= 176) {
    			red = parametro1+"."+parametro2+"."+parametro3+".176";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".177";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".178";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".179";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 183 && parametro4 >= 180) {
    			red = parametro1+"."+parametro2+"."+parametro3+".180";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".181";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".182";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".183";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 187 && parametro4 >= 184) {
    			red = parametro1+"."+parametro2+"."+parametro3+".184";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".185";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".186";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".187";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 191 && parametro4 >= 188) {
    			red = parametro1+"."+parametro2+"."+parametro3+".188";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".189";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".190";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".191";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 195 && parametro4 >= 192) {
    			red = parametro1+"."+parametro2+"."+parametro3+".192";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".193";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".194";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".195";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 199 && parametro4 >= 196) {
    			red = parametro1+"."+parametro2+"."+parametro3+".196";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".197";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".198";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".199";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 203 && parametro4 >= 200) {
    			red = parametro1+"."+parametro2+"."+parametro3+".200";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".201";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".202";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".203";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 207 && parametro4 >= 204) {
    			red = parametro1+"."+parametro2+"."+parametro3+".204";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".205";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".206";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".207";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 211 && parametro4 >= 208) {
    			red = parametro1+"."+parametro2+"."+parametro3+".208";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".209";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".210";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".211";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 215 && parametro4 >= 212) {
    			red = parametro1+"."+parametro2+"."+parametro3+".212";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".213";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".214";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".215";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 219 && parametro4 >= 216) {
    			red = parametro1+"."+parametro2+"."+parametro3+".216";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".217";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".218";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".219";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 223 && parametro4 >= 220) {
    			red = parametro1+"."+parametro2+"."+parametro3+".220";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".221";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".222";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".223";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 227 && parametro4 >= 224) {
    			red = parametro1+"."+parametro2+"."+parametro3+".224";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".225";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".226";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".227";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 231 && parametro4 >= 228) {
    			red = parametro1+"."+parametro2+"."+parametro3+".228";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".229";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".230";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".231";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 235 && parametro4 >= 232) {
    			red = parametro1+"."+parametro2+"."+parametro3+".232";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".233";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".234";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".235";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 239 && parametro4 >= 236) {
    			red = parametro1+"."+parametro2+"."+parametro3+".236";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".237";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".238";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".239";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 243 && parametro4 >= 240) {
    			red = parametro1+"."+parametro2+"."+parametro3+".240";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".241";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".242";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".243";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 247 && parametro4 >= 244) {
    			red = parametro1+"."+parametro2+"."+parametro3+".244";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".245";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".246";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".247";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 251 && parametro4 >= 248) {
    			red = parametro1+"."+parametro2+"."+parametro3+".248";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".249";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".250";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".251";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 255 && parametro4 >= 252) {
    			red = parametro1+"."+parametro2+"."+parametro3+".252";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".253";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}	
    	}
    	
    	//255.255.255.248
    	if (mascaradered == "255.255.255.248") {
    		if (parametro4 <= 7 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".6";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".7";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 15 && parametro4 >= 8) {
    			red = parametro1+"."+parametro2+"."+parametro3+".8";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".9";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".14";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".15";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 23 && parametro4 >= 16) {
    			red = parametro1+"."+parametro2+"."+parametro3+".16";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".17";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".22";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".23";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 31 && parametro4 >= 24) {
    			red = parametro1+"."+parametro2+"."+parametro3+".24";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".25";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".30";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".31";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 39 && parametro4 >= 32) {
    			red = parametro1+"."+parametro2+"."+parametro3+".32";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".33";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".38";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".39";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 47 && parametro4 >= 40) {
    			red = parametro1+"."+parametro2+"."+parametro3+".40";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".41";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".46";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".47";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 55 && parametro4 >= 48) {
    			red = parametro1+"."+parametro2+"."+parametro3+".48";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".49";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".54";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".55";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 63 && parametro4 >= 56) {
    			red = parametro1+"."+parametro2+"."+parametro3+".56";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".57";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".62";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".63";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 71 && parametro4 >= 64) {
    			red = parametro1+"."+parametro2+"."+parametro3+".64";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".65";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".70";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".71";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 79 && parametro4 >= 72) {
    			red = parametro1+"."+parametro2+"."+parametro3+".72";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".73";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".78";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".79";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 87 && parametro4 >= 80) {
    			red = parametro1+"."+parametro2+"."+parametro3+".80";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".81";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".86";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".87";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 95 && parametro4 >= 88) {
    			red = parametro1+"."+parametro2+"."+parametro3+".88";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".89";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".94";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".95";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 103 && parametro4 >= 96) {
    			red = parametro1+"."+parametro2+"."+parametro3+".96";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".97";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".102";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".103";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 11 && parametro4 >= 104) {
    			red = parametro1+"."+parametro2+"."+parametro3+".104";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".105";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".110";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".111";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 119 && parametro4 >= 112) {
    			red = parametro1+"."+parametro2+"."+parametro3+".112";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".113";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".118";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".119";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 127 && parametro4 >= 120) {
    			red = parametro1+"."+parametro2+"."+parametro3+".120";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".121";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 135 && parametro4 >= 128) {
    			red = parametro1+"."+parametro2+"."+parametro3+".128";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".134";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".135";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 143 && parametro4 >= 136) {
    			red = parametro1+"."+parametro2+"."+parametro3+".136";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".137";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".142";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".143";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 151 && parametro4 >= 144) {
    			red = parametro1+"."+parametro2+"."+parametro3+".144";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".145";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".150";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".151";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 159 && parametro4 >= 152) {
    			red = parametro1+"."+parametro2+"."+parametro3+".152";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".153";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".158";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".159";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 167 && parametro4 >= 160) {
    			red = parametro1+"."+parametro2+"."+parametro3+".160";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".161";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".166";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".167";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 175 && parametro4 >= 168) {
    			red = parametro1+"."+parametro2+"."+parametro3+".168";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".169";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".174";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".175";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 183 && parametro4 >= 176) {
    			red = parametro1+"."+parametro2+"."+parametro3+".176";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".177";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".182";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".183";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 191 && parametro4 >= 184) {
    			red = parametro1+"."+parametro2+"."+parametro3+".184";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".185";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".190";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".191";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 199 && parametro4 >= 192) {
    			red = parametro1+"."+parametro2+"."+parametro3+".192";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".193";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".198";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".199";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 207 && parametro4 >= 200) {
    			red = parametro1+"."+parametro2+"."+parametro3+".200";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".201";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".206";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".207";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 215 && parametro4 >= 208) {
    			red = parametro1+"."+parametro2+"."+parametro3+".208";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".209";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".214";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".215";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 223 && parametro4 >= 216) {
    			red = parametro1+"."+parametro2+"."+parametro3+".216";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".217";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".222";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".223";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 231 && parametro4 >= 224) {
    			red = parametro1+"."+parametro2+"."+parametro3+".224";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".225";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".230";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".231";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 239 && parametro4 >= 232) {
    			red = parametro1+"."+parametro2+"."+parametro3+".232";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".233";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".238";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".239";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 247 && parametro4 >= 240) {
    			red = parametro1+"."+parametro2+"."+parametro3+".240";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".241";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".246";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".247";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 255 && parametro4 >= 248) {
    			red = parametro1+"."+parametro2+"."+parametro3+".248";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".249";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "6";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.255.240
    	if (mascaradered == "255.255.255.240") {
    		if (parametro4 <= 15 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".14";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".15";
    			tfBROADCAST.setText(broadcast);
    			hosts = "14";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 31 && parametro4 >= 16) {
    			red = parametro1+"."+parametro2+"."+parametro3+".16";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".17";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".30";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".31";
    			tfBROADCAST.setText(broadcast);
    			hosts = "14";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 47 && parametro4 >= 32) {
    			red = parametro1+"."+parametro2+"."+parametro3+".32";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".33";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".46";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".47";
    			tfBROADCAST.setText(broadcast);
    			hosts = "14";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 63 && parametro4 >= 48) {
    			red = parametro1+"."+parametro2+"."+parametro3+".48";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".49";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".62";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".63";
    			tfBROADCAST.setText(broadcast);
    			hosts = "14";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 79 && parametro4 >= 64) {
    			red = parametro1+"."+parametro2+"."+parametro3+".64";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".65";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".78";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".79";
    			tfBROADCAST.setText(broadcast);
    			hosts = "14";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 95 && parametro4 >= 80) {
        			red = parametro1+"."+parametro2+"."+parametro3+".80";
        			tfRED.setText(red);
        			firstip = parametro1+"."+parametro2+"."+parametro3+".81";
        			tfprIPMASK.setText(firstip);
        			lastip = parametro1+"."+parametro2+"."+parametro3+".94";
        			tfultIPMASK.setText(lastip);
        			broadcast = parametro1+"."+parametro2+"."+parametro3+".95";
        			tfBROADCAST.setText(broadcast);
        			hosts = "14";
        			tfHOSTS.setText(hosts);
        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
        		}else if (parametro4 <= 101 && parametro4 >= 96) {
        			red = parametro1+"."+parametro2+"."+parametro3+".96";
        			tfRED.setText(red);
        			firstip = parametro1+"."+parametro2+"."+parametro3+".97";
        			tfprIPMASK.setText(firstip);
        			lastip = parametro1+"."+parametro2+"."+parametro3+".110";
        			tfultIPMASK.setText(lastip);
        			broadcast = parametro1+"."+parametro2+"."+parametro3+".111";
        			tfBROADCAST.setText(broadcast);
        			hosts = "14";
        			tfHOSTS.setText(hosts);
        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
        		}else if (parametro4 <= 127 && parametro4 >= 112) {
        			red = parametro1+"."+parametro2+"."+parametro3+".112";
        			tfRED.setText(red);
        			firstip = parametro1+"."+parametro2+"."+parametro3+".113";
        			tfprIPMASK.setText(firstip);
        			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
        			tfultIPMASK.setText(lastip);
        			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
        			tfBROADCAST.setText(broadcast);
        			hosts = "14";
        			tfHOSTS.setText(hosts);
        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
        		}else if (parametro4 <= 143 && parametro4 >= 128) {
        			red = parametro1+"."+parametro2+"."+parametro3+".128";
        			tfRED.setText(red);
        			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
        			tfprIPMASK.setText(firstip);
        			lastip = parametro1+"."+parametro2+"."+parametro3+".142";
        			tfultIPMASK.setText(lastip);
        			broadcast = parametro1+"."+parametro2+"."+parametro3+".143";
        			tfBROADCAST.setText(broadcast);
        			hosts = "14";
        			tfHOSTS.setText(hosts);
        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
        		}else if (parametro4 <= 159 && parametro4 >= 144) {
        			red = parametro1+"."+parametro2+"."+parametro3+".144";
        			tfRED.setText(red);
        			firstip = parametro1+"."+parametro2+"."+parametro3+".145";
        			tfprIPMASK.setText(firstip);
        			lastip = parametro1+"."+parametro2+"."+parametro3+".158";
        			tfultIPMASK.setText(lastip);
        			broadcast = parametro1+"."+parametro2+"."+parametro3+".159";
        			tfBROADCAST.setText(broadcast);
        			hosts = "14";
        			tfHOSTS.setText(hosts);
        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
        		}else if (parametro4 <= 175 && parametro4 >= 160) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".160";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".161";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".174";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".175";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}else if (parametro4 <= 191 && parametro4 >= 176) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".176";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".177";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".190";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".191";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}else if (parametro4 <= 207 && parametro4 >= 192) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".192";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".193";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".206";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".207";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}else if (parametro4 <= 223 && parametro4 >= 208) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".208";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".209";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".222";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".223";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}else if (parametro4 <= 239 && parametro4 >= 224) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".224";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".225";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".238";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".239";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}else if (parametro4 <= 255 && parametro4 >= 240) {
	        			red = parametro1+"."+parametro2+"."+parametro3+".240";
	        			tfRED.setText(red);
	        			firstip = parametro1+"."+parametro2+"."+parametro3+".241";
	        			tfprIPMASK.setText(firstip);
	        			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
	        			tfultIPMASK.setText(lastip);
	        			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
	        			tfBROADCAST.setText(broadcast);
	        			hosts = "14";
	        			tfHOSTS.setText(hosts);
	        			tfGATEWAY.setText("Cualquier IP dentro de la subred");
	        		}
    	}
    	
    	//255.255.255.224
    	if (mascaradered == "255.255.255.224") {
    		if (parametro4 <= 31 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".30";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".31";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 63 && parametro4 >= 32) {
    			red = parametro1+"."+parametro2+"."+parametro3+".32";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".33";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".62";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".63";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 95 && parametro4 >= 64) {
    			red = parametro1+"."+parametro2+"."+parametro3+".64";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".65";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".94";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".95";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 127 && parametro4 >= 96) {
    			red = parametro1+"."+parametro2+"."+parametro3+".96";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".97";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 159 && parametro4 >= 128) {
    			red = parametro1+"."+parametro2+"."+parametro3+".128";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".158";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".159";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 191 && parametro4 >= 160) {
    			red = parametro1+"."+parametro2+"."+parametro3+".160";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".161";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".190";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".191";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 223 && parametro4 >= 192) {
    			red = parametro1+"."+parametro2+"."+parametro3+".192";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".193";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".222";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".223";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 255 && parametro4 >= 224) {
    			red = parametro1+"."+parametro2+"."+parametro3+".224";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".225";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "30";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.255.192
    	if (mascaradered == "255.255.255.192") {
    		if (parametro4 <= 63 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".62";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".63";
    			tfBROADCAST.setText(broadcast);
    			hosts = "62";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 127 && parametro4 >= 64) {
    			red = parametro1+"."+parametro2+"."+parametro3+".64";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".65";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
    			tfBROADCAST.setText(broadcast);
    			hosts = "62";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 191 && parametro4 >= 128) {
    			red = parametro1+"."+parametro2+"."+parametro3+".128";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".190";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".191";
    			tfBROADCAST.setText(broadcast);
    			hosts = "62";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 255 && parametro4 >= 192) {
    			red = parametro1+"."+parametro2+"."+parametro3+".192";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".193";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "62";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.255.128
    	if (mascaradered == "255.255.255.128") {
    		if (parametro4 <= 127 && parametro4 >= 0) {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".126";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".127";
    			tfBROADCAST.setText(broadcast);
    			hosts = "126";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}else if (parametro4 <= 255 && parametro4 >= 128) {
    			red = parametro1+"."+parametro2+"."+parametro3+".128";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".129";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "126";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.255.0
    	if (mascaradered == "255.255.255.0") {
    			red = parametro1+"."+parametro2+"."+parametro3+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+"."+parametro3+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+"."+parametro3+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+"."+parametro3+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "254";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
	}
	
	
	//MASCARA DE RED 255.255.XXX.0     LINEA 1757 - 4856
	public void mascara2 () {
		//255.255.254.0
    	if (mascaradered == "255.255.254.0") {
    		if (parametro3 <= 1 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".1"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".1"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 3 && parametro3 >= 2) {
    			red = parametro1+"."+parametro2+".2"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".2"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".3"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".3"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 5 && parametro3 >= 4) {
    			red = parametro1+"."+parametro2+".4"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".4"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".5"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".5"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 7 && parametro3 >= 6) {
    			red = parametro1+"."+parametro2+".6"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".6"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".7"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".7"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 9 && parametro3 >= 8) {
    			red = parametro1+"."+parametro2+".8"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".8"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".9"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".9"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 11 && parametro3 >= 10) {
    			red = parametro1+"."+parametro2+".10"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".10"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".11"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".11"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 13 && parametro3 >= 12) {
    			red = parametro1+"."+parametro2+".12"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".12"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".13"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".13"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 15 && parametro3 >= 14) {
    			red = parametro1+"."+parametro2+".14"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".14"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".15"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".15"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 17 && parametro3 >= 16) {
    			red = parametro1+"."+parametro2+".16"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".16"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".17"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".17"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 19 && parametro3 >= 18) {
    			red = parametro1+"."+parametro2+".18"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".18"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".19"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".19"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 21 && parametro3 >= 20) {
    			red = parametro1+"."+parametro2+".20"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".20"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".21"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".21"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 23 && parametro3 >= 22) {
    			red = parametro1+"."+parametro2+".22"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".22"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".23"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".23"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 25 && parametro3 >= 24) {
    			red = parametro1+"."+parametro2+".24"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".24"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".25"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".25"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 27 && parametro3 >= 26) {
    			red = parametro1+"."+parametro2+".26"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".26"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".27"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".27"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 29 && parametro3 >= 28) {
    			red = parametro1+"."+parametro2+".28"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".28"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".29"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".29"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 31 && parametro3 >= 30) {
    			red = parametro1+"."+parametro2+".30"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".30"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".31"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".31"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 33 && parametro3 >= 32) {
    			red = parametro1+"."+parametro2+".32"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".32"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".33"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".33"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 35 && parametro3 >= 34) {
    			red = parametro1+"."+parametro2+".34"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".34"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".35"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".35"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 37 && parametro3 >= 36) {
    			red = parametro1+"."+parametro2+".36"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".36"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".37"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".37"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 39 && parametro3 >= 38) {
    			red = parametro1+"."+parametro2+".38"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".38"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".39"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".39"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 41 && parametro3 >= 40) {
    			red = parametro1+"."+parametro2+".40"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".40"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".41"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".41"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 43 && parametro3 >= 42) {
    			red = parametro1+"."+parametro2+".42"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".42"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".43"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".43"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 45 && parametro3 >= 44) {
    			red = parametro1+"."+parametro2+".44"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".44"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".45"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".45"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 47 && parametro3 >= 46) {
    			red = parametro1+"."+parametro2+".46"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".46"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".47"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".47"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 49 && parametro3 >= 48) {
    			red = parametro1+"."+parametro2+".48"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".48"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".49"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".49"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 51 && parametro3 >= 50) {
    			red = parametro1+"."+parametro2+".50"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".50"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".51"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".51"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 53 && parametro3 >= 52) {
    			red = parametro1+"."+parametro2+".52"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".52"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".53"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".53"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 55 && parametro3 >= 54) {
    			red = parametro1+"."+parametro2+".54"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".54"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".55"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".55"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 57 && parametro3 >= 56) {
    			red = parametro1+"."+parametro2+".56"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".56"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".57"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".57"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 59 && parametro3 >= 58) {
    			red = parametro1+"."+parametro2+".58"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".58"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".59"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".59"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 61 && parametro3 >= 60) {
    			red = parametro1+"."+parametro2+".60"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".60"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".61"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".61"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 63 && parametro3 >= 62) {
    			red = parametro1+"."+parametro2+".62"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".62"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 65 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".65"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".65"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 67 && parametro3 >= 66) {
    			red = parametro1+"."+parametro2+".66"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".66"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".67"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".67"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 69 && parametro3 >= 68) {
    			red = parametro1+"."+parametro2+".68"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".68"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".69"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".69"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 71 && parametro3 >= 70) {
    			red = parametro1+"."+parametro2+".70"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".70"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".71"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".71"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 73 && parametro3 >= 72) {
    			red = parametro1+"."+parametro2+".72"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".72"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".73"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".73"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 75 && parametro3 >= 74) {
    			red = parametro1+"."+parametro2+".74"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".74"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".75"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".75"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 77 && parametro3 >= 76) {
    			red = parametro1+"."+parametro2+".76"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".76"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".77"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".77"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 79 && parametro3 >= 78) {
    			red = parametro1+"."+parametro2+".78"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".78"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".79"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".79"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 81 && parametro3 >= 80) {
    			red = parametro1+"."+parametro2+".80"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".80"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".81"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".81"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 83 && parametro3 >= 82) {
    			red = parametro1+"."+parametro2+".82"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".82"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".83"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".83"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 85 && parametro3 >= 84) {
    			red = parametro1+"."+parametro2+".84"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".84"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".85"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".85"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 87 && parametro3 >= 86) {
    			red = parametro1+"."+parametro2+".86"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".86"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".87"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".87"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 89 && parametro3 >= 88) {
    			red = parametro1+"."+parametro2+".88"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".88"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".89"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".89"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 91 && parametro3 >= 90) {
    			red = parametro1+"."+parametro2+".90"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".90"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".91"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".91"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 93 && parametro3 >= 92) {
    			red = parametro1+"."+parametro2+".92"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".92"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".93"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".93"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 95 && parametro3 >= 94) {
    			red = parametro1+"."+parametro2+".94"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".94"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".95"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 97 && parametro3 >= 96) {
    			red = parametro1+"."+parametro2+".96"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".96"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".97"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".97"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 99 && parametro3 >= 98) {
    			red = parametro1+"."+parametro2+".98"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".98"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".99"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".99"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 101 && parametro3 >= 100) {
    			red = parametro1+"."+parametro2+".100"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".100"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".101"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".101"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 103 && parametro3 >= 102) {
    			red = parametro1+"."+parametro2+".102"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".102"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".103"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".103"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 105 && parametro3 >= 104) {
    			red = parametro1+"."+parametro2+".104"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".104"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".105"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".105"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 107 && parametro3 >= 106) {
    			red = parametro1+"."+parametro2+".106"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".106"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".107"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".107"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 109 && parametro3 >= 108) {
    			red = parametro1+"."+parametro2+".108"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".108"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".109"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".109"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 111 && parametro3 >= 110) {
    			red = parametro1+"."+parametro2+".110"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".110"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".111"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".111"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 113 && parametro3 >= 112) {
    			red = parametro1+"."+parametro2+".112"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".112"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".113"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".113"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 115 && parametro3 >= 114) {
    			red = parametro1+"."+parametro2+".114"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".114"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".115"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".115"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 117 && parametro3 >= 116) {
    			red = parametro1+"."+parametro2+".116"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".116"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".117"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".117"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 119 && parametro3 >= 118) {
    			red = parametro1+"."+parametro2+".118"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".118"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".119"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".119"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 121 && parametro3 >= 120) {
    			red = parametro1+"."+parametro2+".120"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".120"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".121"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".121"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 123 && parametro3 >= 122) {
    			red = parametro1+"."+parametro2+".122"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".122"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".123"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".123"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 125 && parametro3 >= 124) {
    			red = parametro1+"."+parametro2+".124"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".124"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".125"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".125"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 126) {
    			red = parametro1+"."+parametro2+".126"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".126"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 129 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".129"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".129"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 131 && parametro3 >= 130) {
    			red = parametro1+"."+parametro2+".130"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".130"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".131"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".131"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 133 && parametro3 >= 132) {
    			red = parametro1+"."+parametro2+".132"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".132"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".133"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".133"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 135 && parametro3 >= 134) {
    			red = parametro1+"."+parametro2+".134"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".134"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".135"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".135"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 137 && parametro3 >= 136) {
    			red = parametro1+"."+parametro2+".136"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".136"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".137"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".137"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 139 && parametro3 >= 138) {
    			red = parametro1+"."+parametro2+".138"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".138"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".139"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".139"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 141 && parametro3 >= 140) {
    			red = parametro1+"."+parametro2+".140"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".140"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".141"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".141"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 143 && parametro3 >= 142) {
    			red = parametro1+"."+parametro2+".142"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".142"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".143"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".143"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 145 && parametro3 >= 144) {
    			red = parametro1+"."+parametro2+".144"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".144"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".145"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".145"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 147 && parametro3 >= 146) {
    			red = parametro1+"."+parametro2+".146"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".146"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".147"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".147"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 149 && parametro3 >= 148) {
    			red = parametro1+"."+parametro2+".148"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".148"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".149"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".149"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 151 && parametro3 >= 150) {
    			red = parametro1+"."+parametro2+".150"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".150"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".151"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".151"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 153 && parametro3 >= 152) {
    			red = parametro1+"."+parametro2+".152"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".152"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".153"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".153"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 155 && parametro3 >= 154) {
    			red = parametro1+"."+parametro2+".154"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".154"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".155"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".155"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 157 && parametro3 >= 156) {
    			red = parametro1+"."+parametro2+".156"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".156"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".157"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".157"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 159 && parametro3 >= 158) {
    			red = parametro1+"."+parametro2+".158"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".158"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".159"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".159"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 161 && parametro3 >= 160) {
    			red = parametro1+"."+parametro2+".160"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".160"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".161"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".161"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 163 && parametro3 >= 162) {
    			red = parametro1+"."+parametro2+".162"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".162"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".163"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".163"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 165 && parametro3 >= 164) {
    			red = parametro1+"."+parametro2+".164"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".164"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".165"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".165"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 167 && parametro3 >= 166) {
    			red = parametro1+"."+parametro2+".166"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".166"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".167"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".167"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 169 && parametro3 >= 168) {
    			red = parametro1+"."+parametro2+".68"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".68"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".69"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".69"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 171 && parametro3 >= 170) {
    			red = parametro1+"."+parametro2+".170"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".170"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".171"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".171"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 173 && parametro3 >= 172) {
    			red = parametro1+"."+parametro2+".172"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".172"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".173"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".173"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 175 && parametro3 >= 174) {
    			red = parametro1+"."+parametro2+".174"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".174"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".175"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".175"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 177 && parametro3 >= 176) {
    			red = parametro1+"."+parametro2+".176"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".176"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".177"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".177"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 179 && parametro3 >= 178) {
    			red = parametro1+"."+parametro2+".178"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".178"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".179"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".179"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 181 && parametro3 >= 180) {
    			red = parametro1+"."+parametro2+".180"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".180"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".181"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".181"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 183 && parametro3 >= 182) {
    			red = parametro1+"."+parametro2+".182"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".182"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".183"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".183"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 185 && parametro3 >= 184) {
    			red = parametro1+"."+parametro2+".184"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".184"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".185"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".185"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 187 && parametro3 >= 186) {
    			red = parametro1+"."+parametro2+".186"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".186"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".187"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".187"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 189 && parametro3 >= 188) {
    			red = parametro1+"."+parametro2+".188"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".188"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".189"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".189"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 190) {
    			red = parametro1+"."+parametro2+".190"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".190"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 193 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".192"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".192"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".193"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".193"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 195 && parametro3 >= 194) {
    			red = parametro1+"."+parametro2+".194"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".194"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".195"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 197 && parametro3 >= 196) {
    			red = parametro1+"."+parametro2+".196"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".196"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".197"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".197"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 199 && parametro3 >= 198) {
    			red = parametro1+"."+parametro2+".198"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".198"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".199"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".199"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 201 && parametro3 >= 200) {
    			red = parametro1+"."+parametro2+".200"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".200"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".201"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".201"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 203 && parametro3 >= 202) {
    			red = parametro1+"."+parametro2+".202"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".202"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".203"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".203"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 205 && parametro3 >= 204) {
    			red = parametro1+"."+parametro2+".204"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".204"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".205"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".205"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 207 && parametro3 >= 206) {
    			red = parametro1+"."+parametro2+".206"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".206"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".207"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".207"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 209 && parametro3 >= 208) {
    			red = parametro1+"."+parametro2+".208"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".208"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".209"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".209"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 211 && parametro3 >= 210) {
    			red = parametro1+"."+parametro2+".210"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".210"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".211"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".211"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 213 && parametro3 >= 212) {
    			red = parametro1+"."+parametro2+".212"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".212"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".213"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".213"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 215 && parametro3 >= 214) {
    			red = parametro1+"."+parametro2+".214"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".214"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".215"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".215"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 217 && parametro3 >= 216) {
    			red = parametro1+"."+parametro2+".216"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".216"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".217"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".217"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 219 && parametro3 >= 218) {
    			red = parametro1+"."+parametro2+".218"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".218"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".219"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".219"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 221 && parametro3 >= 220) {
    			red = parametro1+"."+parametro2+".220"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".220"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".221"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".221"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 223 && parametro3 >= 222) {
    			red = parametro1+"."+parametro2+".222"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".222"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".223"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".223"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 225 && parametro3 >= 224) {
    			red = parametro1+"."+parametro2+".224"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".224"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".225"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".225"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 227 && parametro3 >= 226) {
    			red = parametro1+"."+parametro2+".226"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".226"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".227"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".227"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 229 && parametro3 >= 228) {
    			red = parametro1+"."+parametro2+".228"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".228"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".229"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".229"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 231 && parametro3 >= 230) {
    			red = parametro1+"."+parametro2+".230"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".230"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".231"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".231"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 233 && parametro3 >= 232) {
    			red = parametro1+"."+parametro2+".232"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".232"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".233"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".233"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 235 && parametro3 >= 234) {
    			red = parametro1+"."+parametro2+".234"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".234"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".235"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".235"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 237 && parametro3 >= 236) {
    			red = parametro1+"."+parametro2+".236"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".236"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".237"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".237"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 239 && parametro3 >= 238) {
    			red = parametro1+"."+parametro2+".238"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".238"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".239"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".239"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 241 && parametro3 >= 240) {
    			red = parametro1+"."+parametro2+".240"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".240"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".241"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".241"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 243 && parametro3 >= 242) {
    			red = parametro1+"."+parametro2+".242"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".242"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".243"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".243"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 245 && parametro3 >= 244) {
    			red = parametro1+"."+parametro2+".244"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".244"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".245"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".245"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 247 && parametro3 >= 246) {
    			red = parametro1+"."+parametro2+".246"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".246"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".247"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".247"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 249 && parametro3 >= 248) {
    			red = parametro1+"."+parametro2+".248"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".248"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".249"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".249"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 251 && parametro3 >= 250) {
    			red = parametro1+"."+parametro2+".250"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".250"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".251"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".251"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 253 && parametro3 >= 252) {
    			red = parametro1+"."+parametro2+".252"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".252"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".253"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".253"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 254) {
    			red = parametro1+"."+parametro2+".254"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".254"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "510";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.252.0
    	if (mascaradered == "255.255.252.0") {
    		if (parametro3 <= 3 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".3"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".3"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 7 && parametro3 >= 4) {
    			red = parametro1+"."+parametro2+".4"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".4"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".7"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".7"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 11 && parametro3 >= 8) {
    			red = parametro1+"."+parametro2+".8"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".8"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".11"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".11"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 15 && parametro3 >= 12) {
    			red = parametro1+"."+parametro2+".12"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".12"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".15"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".15"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 19 && parametro3 >= 16) {
    			red = parametro1+"."+parametro2+".16"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".16"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".19"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".19"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 23 && parametro3 >= 20) {
    			red = parametro1+"."+parametro2+".20"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".20"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".23"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".23"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 27 && parametro3 >= 24) {
    			red = parametro1+"."+parametro2+".24"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".24"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".27"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".27"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 31 && parametro3 >= 28) {
    			red = parametro1+"."+parametro2+".28"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".28"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".31"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".31"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 35 && parametro3 >= 32) {
    			red = parametro1+"."+parametro2+".32"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".32"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".35"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".35"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 39 && parametro3 >= 36) {
    			red = parametro1+"."+parametro2+".36"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".36"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".39"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".39"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 43 && parametro3 >= 40) {
    			red = parametro1+"."+parametro2+".40"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".40"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".43"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".43"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 47 && parametro3 >= 44) {
    			red = parametro1+"."+parametro2+".44"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".44"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".47"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".47"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 51 && parametro3 >= 48) {
    			red = parametro1+"."+parametro2+".48"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".48"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".51"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".51"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 55 && parametro3 >= 52) {
    			red = parametro1+"."+parametro2+".52"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".52"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".55"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".55"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 59 && parametro3 >= 56) {
    			red = parametro1+"."+parametro2+".56"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".56"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".59"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".59"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 63 && parametro3 >= 60) {
    			red = parametro1+"."+parametro2+".60"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".60"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 67 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".67"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".67"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 71 && parametro3 >= 68) {
    			red = parametro1+"."+parametro2+".68"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".68"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".71"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".71"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 75 && parametro3 >= 72) {
    			red = parametro1+"."+parametro2+".72"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".72"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".75"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".75"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 79 && parametro3 >= 76) {
    			red = parametro1+"."+parametro2+".76"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".76"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".79"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".79"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 83 && parametro3 >= 80) {
    			red = parametro1+"."+parametro2+".80"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".80"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".83"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".83"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 87 && parametro3 >= 84) {
    			red = parametro1+"."+parametro2+".84"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".84"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".87"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".87"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 91 && parametro3 >= 88) {
    			red = parametro1+"."+parametro2+".88"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".88"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".91"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".91"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 95 && parametro3 >= 92) {
    			red = parametro1+"."+parametro2+".92"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".92"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".95"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 99 && parametro3 >= 96) {
    			red = parametro1+"."+parametro2+".96"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".96"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".99"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".99"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 103 && parametro3 >= 100) {
    			red = parametro1+"."+parametro2+".100"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".100"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".103"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".103"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 107 && parametro3 >= 104) {
    			red = parametro1+"."+parametro2+".104"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".104"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".107"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".107"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 111 && parametro3 >= 108) {
    			red = parametro1+"."+parametro2+".108"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".108"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".111"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".111"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 115 && parametro3 >= 112) {
    			red = parametro1+"."+parametro2+".112"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".112"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".115"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".115"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 119 && parametro3 >= 116) {
    			red = parametro1+"."+parametro2+".116"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".116"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".119"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".119"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 123 && parametro3 >= 120) {
    			red = parametro1+"."+parametro2+".120"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".120"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".123"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".123"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 124) {
    			red = parametro1+"."+parametro2+".124"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".124"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 131 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".131"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".131"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 135 && parametro3 >= 132) {
    			red = parametro1+"."+parametro2+".132"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".132"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".135"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".135"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 139 && parametro3 >= 136) {
    			red = parametro1+"."+parametro2+".136"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".136"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".139"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".139"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 143 && parametro3 >= 140) {
    			red = parametro1+"."+parametro2+".140"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".140"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".143"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".143"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 147 && parametro3 >= 144) {
    			red = parametro1+"."+parametro2+".144"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".144"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".147"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".147"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 151 && parametro3 >= 148) {
    			red = parametro1+"."+parametro2+".148"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".148"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".151"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".151"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 155 && parametro3 >= 152) {
    			red = parametro1+"."+parametro2+".152"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".152"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".155"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".155"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 159 && parametro3 >= 156) {
    			red = parametro1+"."+parametro2+".156"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".156"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".159"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".159"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 163 && parametro3 >= 160) {
    			red = parametro1+"."+parametro2+".160"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".160"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".163"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".163"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 167 && parametro3 >= 164) {
    			red = parametro1+"."+parametro2+".164"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".164"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".167"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".167"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 171 && parametro3 >= 168) {
    			red = parametro1+"."+parametro2+".168"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".168"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".171"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".171"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 175 && parametro3 >= 172) {
    			red = parametro1+"."+parametro2+".172"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".172"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".175"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".175"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 179 && parametro3 >= 176) {
    			red = parametro1+"."+parametro2+".176"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".176"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".179"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".179"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 183 && parametro3 >= 180) {
    			red = parametro1+"."+parametro2+".180"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".180"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".183"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".183"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 187 && parametro3 >= 184) {
    			red = parametro1+"."+parametro2+".184"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".184"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".187"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".187"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 188) {
    			red = parametro1+"."+parametro2+".188"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".188"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 195 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".192"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".192"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".195"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".195"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 199 && parametro3 >= 196) {
    			red = parametro1+"."+parametro2+".196"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".196"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".199"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".199"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 203 && parametro3 >= 200) {
    			red = parametro1+"."+parametro2+".200"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".200"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".203"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".203"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 207 && parametro3 >= 204) {
    			red = parametro1+"."+parametro2+".204"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".204"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".207"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".207"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 211 && parametro3 >= 208) {
    			red = parametro1+"."+parametro2+".208"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".208"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".211"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".211"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 215 && parametro3 >= 212) {
    			red = parametro1+"."+parametro2+".212"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".212"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".215"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".215"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 219 && parametro3 >= 216) {
    			red = parametro1+"."+parametro2+".216"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".216"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".219"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".219"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 223 && parametro3 >= 220) {
    			red = parametro1+"."+parametro2+".220"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".220"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".223"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".223"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 227 && parametro3 >= 224) {
    			red = parametro1+"."+parametro2+".224"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".224"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".227"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".227"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 231 && parametro3 >= 228) {
    			red = parametro1+"."+parametro2+".228"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".228"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".231"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".231"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 235 && parametro3 >= 232) {
    			red = parametro1+"."+parametro2+".232"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".232"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".235"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".235"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 239 && parametro3 >= 236) {
    			red = parametro1+"."+parametro2+".236"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".236"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".239"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".239"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 243 && parametro3 >= 240) {
    			red = parametro1+"."+parametro2+".240"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".240"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".243"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".243"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 247 && parametro3 >= 244) {
    			red = parametro1+"."+parametro2+".244"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".244"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".247"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".247"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 251 && parametro3 >= 248) {
    			red = parametro1+"."+parametro2+".248"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".248"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".251"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".251"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 252) {
    			red = parametro1+"."+parametro2+".252"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".252"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1022";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.248.0
    	if (mascaradered == "255.255.248.0") {
    		if (parametro3 <= 7 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".7"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".7"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 15 && parametro3 >= 8) {
    			red = parametro1+"."+parametro2+".8"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".8"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".15"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".15"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 23 && parametro3 >= 16) {
    			red = parametro1+"."+parametro2+".16"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".16"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".23"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".23"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 31 && parametro3 >= 24) {
    			red = parametro1+"."+parametro2+".24"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".24"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".31"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".31"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 39 && parametro3 >= 32) {
    			red = parametro1+"."+parametro2+".32"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".32"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".39"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".39"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 47 && parametro3 >= 40) {
    			red = parametro1+"."+parametro2+".40"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".40"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".47"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".47"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 55 && parametro3 >= 48) {
    			red = parametro1+"."+parametro2+".48"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".48"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".55"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".55"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 63 && parametro3 >= 56) {
    			red = parametro1+"."+parametro2+".56"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".56"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 71 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".71"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".71"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 79 && parametro3 >= 72) {
    			red = parametro1+"."+parametro2+".72"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".72"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".79"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".79"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 87 && parametro3 >= 80) {
    			red = parametro1+"."+parametro2+".80"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".80"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".87"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".87"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 95 && parametro3 >= 88) {
    			red = parametro1+"."+parametro2+".88"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".88"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".95"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 103 && parametro3 >= 96) {
    			red = parametro1+"."+parametro2+".96"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".96"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".103"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".103"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 111 && parametro3 >= 104) {
    			red = parametro1+"."+parametro2+".104"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".104"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".111"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".11"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 119 && parametro3 >= 112) {
    			red = parametro1+"."+parametro2+".112"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".112"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".119"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".119"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 120) {
    			red = parametro1+"."+parametro2+".120"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".120"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 135 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".135"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".135"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 143 && parametro3 >= 136) {
    			red = parametro1+"."+parametro2+".136"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".136"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".143"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".143"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 151 && parametro3 >= 144) {
    			red = parametro1+"."+parametro2+".144"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".144"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".151"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".151"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 159 && parametro3 >= 152) {
    			red = parametro1+"."+parametro2+".152"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".152"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".159"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".159"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 167 && parametro3 >= 160) {
    			red = parametro1+"."+parametro2+".160"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".160"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".167"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".167"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 175 && parametro3 >= 168) {
    			red = parametro1+"."+parametro2+".168"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".168"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".175"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".175"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 183 && parametro3 >= 176) {
    			red = parametro1+"."+parametro2+".176"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".176"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".183"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".183"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 184) {
    			red = parametro1+"."+parametro2+".184"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".184"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 199 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".182"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".182"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".199"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".199"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 207 && parametro3 >= 200) {
    			red = parametro1+"."+parametro2+".200"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".200"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".207"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".207"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 215 && parametro3 >= 208) {
    			red = parametro1+"."+parametro2+".208"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".208"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".215"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".215"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 223 && parametro3 >= 216) {
    			red = parametro1+"."+parametro2+".216"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".216"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".223"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".223"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 231 && parametro3 >= 224) {
    			red = parametro1+"."+parametro2+".224"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".224"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".231"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".231"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 239 && parametro3 >= 232) {
    			red = parametro1+"."+parametro2+".232"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".232"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".239"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".239"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 247 && parametro3 >= 240) {
    			red = parametro1+"."+parametro2+".240"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".240"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".247"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".247"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 248) {
    			red = parametro1+"."+parametro2+".248"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".248"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2046";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.240.0
    	if (mascaradered == "255.255.240.0") {
    		if (parametro3 <= 15 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".15"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".15"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 31 && parametro3 >= 16) {
    			red = parametro1+"."+parametro2+".16"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".16"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".31"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".31"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 47 && parametro3 >= 32) {
    			red = parametro1+"."+parametro2+".32"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".32"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".47"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".47"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 63 && parametro3 >= 48) {
    			red = parametro1+"."+parametro2+".48"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".48"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 79 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".79"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".79"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 95 && parametro3 >= 80) {
    			red = parametro1+"."+parametro2+".80"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".80"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".95"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 111 && parametro3 >= 96) {
    			red = parametro1+"."+parametro2+".96"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".96"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".111"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".111"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 112) {
    			red = parametro1+"."+parametro2+".112"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".112"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 143 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".143"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".143"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 159 && parametro3 >= 144) {
    			red = parametro1+"."+parametro2+".144"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".144"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".159"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".159"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 175 && parametro3 >= 160) {
    			red = parametro1+"."+parametro2+".160"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".160"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".175"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".175"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 176) {
    			red = parametro1+"."+parametro2+".176"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".176"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 207 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".192"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".192"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".207"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".207"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 223 && parametro3 >= 208) {
    			red = parametro1+"."+parametro2+".208"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".208"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".223"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".223"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 239 && parametro3 >= 224) {
    			red = parametro1+"."+parametro2+".224"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".224"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".239"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".239"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 240) {
    			red = parametro1+"."+parametro2+".240"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".240"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4094";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.224.0
    	if (mascaradered == "255.255.224.0") {
    		if (parametro3 <= 31 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".31"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".31"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 63 && parametro3 >= 32) {
    			red = parametro1+"."+parametro2+".32"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".32"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 95 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".95"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".95"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 96) {
    			red = parametro1+"."+parametro2+".96"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".96"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 159 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".159"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".159"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 160) {
    			red = parametro1+"."+parametro2+".160"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".160"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 223 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".192"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".192"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".223"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".223"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 224) {
    			red = parametro1+"."+parametro2+".224"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".224"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8190";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.192.0
    	if (mascaradered == "255.255.192.0") {
    		if (parametro3 <= 63 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".63"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".63"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "16382";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 127 && parametro3 >= 64) {
    			red = parametro1+"."+parametro2+".64"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".64"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "16382";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 191 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".191"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".191"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "16382";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 192) {
    			red = parametro1+"."+parametro2+".192"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".192"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "16382";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.128.0
    	if (mascaradered == "255.255.128.0") {
    		if (parametro3 <= 127 && parametro3 >= 0) {
    			red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".127"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".127"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "32766";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro3 <= 255 && parametro3 >= 128) {
    			red = parametro1+"."+parametro2+".128"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".128"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "32766";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.255.0.0
    	if (mascaradered == "255.255.0.0") {
    		red = parametro1+"."+parametro2+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+"."+parametro2+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+"."+parametro2+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+"."+parametro2+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "65534";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
	}
	
	
	//MASCARA DE RED 255.XXX.0.0       LINEA 4863 - LINEA 7962
	public void mascara3() {
		//255.254.0.0
    	if (mascaradered == "255.254.0.0") {
    		if (parametro2 <= 1 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".1"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".1"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 3 && parametro2 >= 2) {
    			red = parametro1+".2"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".2"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".3"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".3"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 5 && parametro2 >= 4) {
    			red = parametro1+".4"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".4"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".5"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".5"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 7 && parametro2 >= 6) {
    			red = parametro1+".6"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".6"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".7"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".7"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 9 && parametro2 >= 8) {
    			red = parametro1+".8"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".8"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".9"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".9"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 11 && parametro2 >= 10) {
    			red = parametro1+".10"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".10"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".11"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".11"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 13 && parametro2 >= 12) {
    			red = parametro1+".12"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".12"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".13"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".13"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 15 && parametro2 >= 14) {
    			red = parametro1+".14"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".14"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".15"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".15"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 17 && parametro2 >= 16) {
    			red = parametro1+".16"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".16"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".17"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".17"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 19 && parametro2 >= 18) {
    			red = parametro1+".18"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".18"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".19"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".19"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 21 && parametro2 >= 20) {
    			red = parametro1+".20"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".20"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".21"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".21"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 23 && parametro2 >= 22) {
    			red = parametro1+".22"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".22"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".23"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".23"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 25 && parametro2 >= 24) {
    			red = parametro1+".24"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".24"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".25"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".25"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 27 && parametro2 >= 26) {
    			red = parametro1+".26"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".26"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".27"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".27"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 29 && parametro2 >= 28) {
    			red = parametro1+".28"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".28"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".29"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".29"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 31 && parametro2 >= 30) {
    			red = parametro1+".30"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".30"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".31"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".31"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 33 && parametro2 >= 32) {
    			red = parametro1+".32"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".32"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".33"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".33"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 35 && parametro2 >= 34) {
    			red = parametro1+".34"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".34"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".35"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".35"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 37 && parametro2 >= 36) {
    			red = parametro1+".36"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".36"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".37"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".37"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 39 && parametro2 >= 38) {
    			red = parametro1+".38"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".38"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".39"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".39"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 41 && parametro2 >= 40) {
    			red = parametro1+".40"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".40"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".41"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".41"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 43 && parametro2 >= 42) {
    			red = parametro1+".42"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".42"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".43"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".43"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 45 && parametro2 >= 44) {
    			red = parametro1+".44"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".44"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".45"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".45"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 47 && parametro2 >= 46) {
    			red = parametro1+".46"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".46"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".47"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".47"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 49 && parametro2 >= 48) {
    			red = parametro1+".48"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".48"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".49"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".49"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 51 && parametro2 >= 50) {
    			red = parametro1+".50"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".50"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".51"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".51"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 53 && parametro2 >= 52) {
    			red = parametro1+".52"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".52"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".53"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".53"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 55 && parametro2 >= 54) {
    			red = parametro1+".54"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".54"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".55"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".55"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 57 && parametro2 >= 56) {
    			red = parametro1+".56"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".56"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".57"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".57"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 59 && parametro2 >= 58) {
    			red = parametro1+".58"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".58"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".59"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".59"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 61 && parametro2 >= 60) {
    			red = parametro1+".60"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".60"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".61"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".61"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 63 && parametro2 >= 62) {
    			red = parametro1+".62"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".62"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 65 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".65"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".65"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 67 && parametro2 >= 66) {
    			red = parametro1+".66"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".66"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".67"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".67"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 69 && parametro2 >= 68) {
    			red = parametro1+".68"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".68"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".69"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".69"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 71 && parametro2 >= 70) {
    			red = parametro1+".70"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".70"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".71"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".71"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 73 && parametro2 >= 72) {
    			red = parametro1+".72"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".72"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".73"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".73"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 75 && parametro2 >= 74) {
    			red = parametro1+".74"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".74"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".75"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".75"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 77 && parametro2 >= 76) {
    			red = parametro1+".76"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".76"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".77"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".77"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 79 && parametro2 >= 78) {
    			red = parametro1+".78"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".78"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".79"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".79"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 81 && parametro2 >= 80) {
    			red = parametro1+".80"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".80"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".81"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".81"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 83 && parametro2 >= 82) {
    			red = parametro1+".82"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".82"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".83"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".83"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 85 && parametro2 >= 84) {
    			red = parametro1+".84"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".84"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".85"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".85"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 87 && parametro2 >= 86) {
    			red = parametro1+".86"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".86"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".87"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".87"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 89 && parametro2 >= 88) {
    			red = parametro1+".88"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".88"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".89"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".89"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 91 && parametro2 >= 90) {
    			red = parametro1+".90"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".90"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".91"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".91"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 93 && parametro2 >= 92) {
    			red = parametro1+".92"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".92"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".93"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".93"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 95 && parametro2 >= 94) {
    			red = parametro1+".94"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".94"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".95"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".95"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 97 && parametro2 >= 96) {
    			red = parametro1+".96"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".96"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".97"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".97"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 99 && parametro2 >= 98) {
    			red = parametro1+".98"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".98"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".99"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".99"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 101 && parametro2 >= 100) {
    			red = parametro1+".100"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".100"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".101"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".101"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 103 && parametro2 >= 102) {
    			red = parametro1+".102"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".102"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".103"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".103"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 105 && parametro2 >= 104) {
    			red = parametro1+".104"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".104"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".105"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".105"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 107 && parametro2 >= 106) {
    			red = parametro1+".106"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".106"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".107"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".107"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 109 && parametro2 >= 108) {
    			red = parametro1+".108"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".108"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".109"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".109"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 111 && parametro2 >= 110) {
    			red = parametro1+".110"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".110"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".111"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".111"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 113 && parametro2 >= 112) {
    			red = parametro1+".112"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".112"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".113"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".113"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 115 && parametro2 >= 114) {
    			red = parametro1+".114"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".114"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".115"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".115"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 117 && parametro2 >= 116) {
    			red = parametro1+".116"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".116"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".117"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".117"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 119 && parametro2 >= 118) {
    			red = parametro1+".118"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".118"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".119"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".119"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 121 && parametro2 >= 120) {
    			red = parametro1+".120"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".120"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".121"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".121"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 123 && parametro2 >= 122) {
    			red = parametro1+".122"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".122"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".123"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".123"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 125 && parametro2 >= 124) {
    			red = parametro1+".124"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".124"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".125"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".125"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 126) {
    			red = parametro1+".126"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".126"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 129 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".129"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".129"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 131 && parametro2 >= 130) {
    			red = parametro1+".130"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".130"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".131"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".131"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 133 && parametro2 >= 132) {
    			red = parametro1+".132"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".132"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".133"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".133"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 135 && parametro2 >= 134) {
    			red = parametro1+".134"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".134"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".135"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".135"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 137 && parametro2 >= 136) {
    			red = parametro1+".136"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".136"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".137"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".137"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 139 && parametro2 >= 138) {
    			red = parametro1+".138"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".138"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".139"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".139"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 141 && parametro2 >= 140) {
    			red = parametro1+".140"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".140"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".141"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".141"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 143 && parametro2 >= 142) {
    			red = parametro1+".142"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".142"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".143"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".143"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 145 && parametro2 >= 144) {
    			red = parametro1+".144"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".144"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".145"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".145"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 147 && parametro2 >= 146) {
    			red = parametro1+".146"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".146"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".147"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".147"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 149 && parametro2 >= 148) {
    			red = parametro1+".148"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".148"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".149"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".149"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 151 && parametro2 >= 150) {
    			red = parametro1+".150"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".150"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".151"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".151"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 153 && parametro2 >= 152) {
    			red = parametro1+".152"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".152"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".153"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".153"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 155 && parametro2 >= 154) {
    			red = parametro1+".154"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".154"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".155"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".155"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 157 && parametro2 >= 156) {
    			red = parametro1+".156"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".156"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".157"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".157"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 159 && parametro2 >= 158) {
    			red = parametro1+".58"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".58"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".59"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".59"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 161 && parametro2 >= 160) {
    			red = parametro1+".160"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".160"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".161"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".161"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 163 && parametro2 >= 162) {
    			red = parametro1+".162"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".162"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".163"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".163"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 165 && parametro2 >= 164) {
    			red = parametro1+".164"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".164"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".165"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".165"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 167 && parametro2 >= 166) {
    			red = parametro1+".166"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".166"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".167"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".167"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 169 && parametro2 >= 168) {
    			red = parametro1+".168"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".168"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".169"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".169"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 171 && parametro2 >= 170) {
    			red = parametro1+".170"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".170"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".171"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".171"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 173 && parametro2 >= 172) {
    			red = parametro1+".172"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".172"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".173"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".173"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 175 && parametro2 >= 174) {
    			red = parametro1+".174"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".174"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".175"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".175"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 177 && parametro2 >= 176) {
    			red = parametro1+".176"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".176"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".177"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".177"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 179 && parametro2 >= 178) {
    			red = parametro1+".178"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".178"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".179"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".179"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 181 && parametro2 >= 180) {
    			red = parametro1+".180"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".180"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".181"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".181"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 183 && parametro2 >= 182) {
    			red = parametro1+".182"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".182"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".183"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".183"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 185 && parametro2 >= 184) {
    			red = parametro1+".184"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".184"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".185"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".185"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 187 && parametro2 >= 186) {
    			red = parametro1+".186"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".186"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".187"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".187"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 189 && parametro2 >= 188) {
    			red = parametro1+".188"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".188"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".189"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".189"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 190) {
    			red = parametro1+".190"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".190"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 193 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".193"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".193"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 195 && parametro2 >= 194) {
    			red = parametro1+".194"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".194"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".195"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".195"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 197 && parametro2 >= 196) {
    			red = parametro1+".196"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".196"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".197"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".197"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 199 && parametro2 >= 198) {
    			red = parametro1+".198"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".198"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".199"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".199"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 201 && parametro2 >= 200) {
    			red = parametro1+".200"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".200"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".201"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".201"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 203 && parametro2 >= 202) {
    			red = parametro1+".202"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".202"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".203"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".203"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 205 && parametro2 >= 204) {
    			red = parametro1+".204"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".204"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".205"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".205"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 207 && parametro2 >= 206) {
    			red = parametro1+".206"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".206"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".207"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".207"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 209 && parametro2 >= 208) {
    			red = parametro1+".208"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".208"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".209"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".209"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 211 && parametro2 >= 210) {
    			red = parametro1+".210"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".210"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".211"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".211"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 213 && parametro2 >= 212) {
    			red = parametro1+".212"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".212"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".213"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".213"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 215 && parametro2 >= 214) {
    			red = parametro1+".214"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".214"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".215"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".215"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 217 && parametro2 >= 216) {
    			red = parametro1+".216"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".216"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".217"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".217"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 219 && parametro2 >= 218) {
    			red = parametro1+".218"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".218"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".219"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".219"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 221 && parametro2 >= 220) {
    			red = parametro1+".220"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".220"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".221"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".221"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 223 && parametro2 >= 222) {
    			red = parametro1+".222"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".222"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".223"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".223"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 225 && parametro2 >= 224) {
    			red = parametro1+".224"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".224"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".225"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".225"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 227 && parametro2 >= 226) {
    			red = parametro1+".226"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".226"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".227"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".227"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 229 && parametro2 >= 228) {
    			red = parametro1+".228"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".228"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".229"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".229"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 231 && parametro2 >= 230) {
    			red = parametro1+".230"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".230"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".231"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".231"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 233 && parametro2 >= 232) {
    			red = parametro1+".232"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".232"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".233"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".233"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 235 && parametro2 >= 234) {
    			red = parametro1+".234"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".234"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".235"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".235"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 237 && parametro2 >= 236) {
    			red = parametro1+".236"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".236"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".237"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".237"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 239 && parametro2 >= 238) {
    			red = parametro1+".238"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".238"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".239"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".239"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 241 && parametro2 >= 240) {
    			red = parametro1+".240"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".240"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".241"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".241"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 243 && parametro2 >= 242) {
    			red = parametro1+".242"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".242"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".243"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".243"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 245 && parametro2 >= 244) {
    			red = parametro1+".244"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".244"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".45"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".45"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 247 && parametro2 >= 246) {
    			red = parametro1+".46"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".46"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".47"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".47"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 249 && parametro2 >= 248) {
    			red = parametro1+".248"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".248"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".249"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".249"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 251 && parametro2 >= 250) {
    			red = parametro1+".250"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".250"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".251"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".251"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 253 && parametro2 >= 252) {
    			red = parametro1+".252"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".252"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".253"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".253"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 254) {
    			red = parametro1+".254"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".254"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "131070";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
		
    	//255.252.0.0
    	if (mascaradered == "255.252.0.0") {
    		if (parametro2 <= 3 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".3"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".3"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 7 && parametro2 >= 4) {
    			red = parametro1+".4"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".4"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".7"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".7"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 11 && parametro2 >= 8) {
    			red = parametro1+".8"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".8"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".11"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".11"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 15 && parametro2 >= 12) {
    			red = parametro1+".12"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".12"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".15"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".15"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 19 && parametro2 >= 16) {
    			red = parametro1+".16"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".16"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".19"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".19"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 23 && parametro2 >= 20) {
    			red = parametro1+".20"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".20"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".23"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".23"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 27 && parametro2 >= 24) {
    			red = parametro1+".24"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".24"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".27"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".27"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 31 && parametro2 >= 28) {
    			red = parametro1+".28"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".28"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".31"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".31"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 35 && parametro2 >= 32) {
    			red = parametro1+".32"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".32"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".35"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".35"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 39 && parametro2 >= 36) {
    			red = parametro1+".36"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".36"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".39"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".39"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 43 && parametro2 >= 40) {
    			red = parametro1+".40"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".40"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".43"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".43"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 47 && parametro2 >= 44) {
    			red = parametro1+".44"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".44"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".47"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".47"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 51 && parametro2 >= 48) {
    			red = parametro1+".48"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".48"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".51"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".51"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 55 && parametro2 >= 52) {
    			red = parametro1+".52"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".52"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".55"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".55"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 59 && parametro2 >= 56) {
    			red = parametro1+".56"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".56"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".59"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".59"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 63 && parametro2 >= 60) {
    			red = parametro1+".60"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".60"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 67 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".67"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".67"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 71 && parametro2 >= 68) {
    			red = parametro1+".68"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".68"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".71"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".71"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 75 && parametro2 >= 72) {
    			red = parametro1+".72"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".72"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".75"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".75"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 79 && parametro2 >= 76) {
    			red = parametro1+".76"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".76"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".79"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".79"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 83 && parametro2 >= 80) {
    			red = parametro1+".80"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".80"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".83"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".83"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 87 && parametro2 >= 84) {
    			red = parametro1+".84"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".84"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".87"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".87"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 91 && parametro2 >= 88) {
    			red = parametro1+".88"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".88"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".91"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".91"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 95 && parametro2 >= 92) {
    			red = parametro1+".92"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".92"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".95"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".95"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 99 && parametro2 >= 96) {
    			red = parametro1+".96"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".96"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".99"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".99"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 103 && parametro2 >= 100) {
    			red = parametro1+".100"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".100"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".103"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".103"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 107 && parametro2 >= 104) {
    			red = parametro1+".104"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".104"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".107"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".107"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 111 && parametro2 >= 108) {
    			red = parametro1+".108"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".108"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".111"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".111"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 115 && parametro2 >= 112) {
    			red = parametro1+".112"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".112"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".115"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".115"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 119 && parametro2 >= 116) {
    			red = parametro1+".116"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".116"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".119"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".119"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 123 && parametro2 >= 120) {
    			red = parametro1+".120"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".120"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".123"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".123"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 124) {
    			red = parametro1+".124"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".124"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 131 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".131"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".131"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 135 && parametro2 >= 132) {
    			red = parametro1+".132"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".132"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".135"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".135"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 139 && parametro2 >= 136) {
    			red = parametro1+".136"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".136"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".139"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".139"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 143 && parametro2 >= 140) {
    			red = parametro1+".140"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".140"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".143"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".143"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 147 && parametro2 >= 144) {
    			red = parametro1+".144"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".144"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".147"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".147"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 151 && parametro2 >= 148) {
    			red = parametro1+".148"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".148"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".151"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".151"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 155 && parametro2 >= 152) {
    			red = parametro1+".152"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".152"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".155"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".155"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 159 && parametro2 >= 156) {
    			red = parametro1+".156"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".156"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".159"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".159"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 163 && parametro2 >= 160) {
    			red = parametro1+".160"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".160"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".163"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".163"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 167 && parametro2 >= 164) {
    			red = parametro1+".164"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".164"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".167"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".167"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 171 && parametro2 >= 168) {
    			red = parametro1+".168"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".168"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".171"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".171"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 175 && parametro2 >= 172) {
    			red = parametro1+".172"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".172"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".175"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".175"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 179 && parametro2 >= 176) {
    			red = parametro1+".176"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".176"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".179"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".179"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 183 && parametro2 >= 180) {
    			red = parametro1+".180"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".180"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".183"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".183"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 187 && parametro2 >= 184) {
    			red = parametro1+".184"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".184"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".187"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".187"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 188) {
    			red = parametro1+".188"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".188"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 195 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".195"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".195"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 199 && parametro2 >= 196) {
    			red = parametro1+".196"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".196"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".199"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".199"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 203 && parametro2 >= 200) {
    			red = parametro1+".200"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".200"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".203"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".203"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 207 && parametro2 >= 204) {
    			red = parametro1+".204"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".204"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".207"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".207"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 211 && parametro2 >= 208) {
    			red = parametro1+".208"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".208"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".211"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".211"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 215 && parametro2 >= 212) {
    			red = parametro1+".212"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".212"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".215"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".215"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 219 && parametro2 >= 216) {
    			red = parametro1+".216"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".216"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".219"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".219"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 223 && parametro2 >= 220) {
    			red = parametro1+".220"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".220"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".223"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".223"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 227 && parametro2 >= 224) {
    			red = parametro1+".224"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".224"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".227"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".227"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 231 && parametro2 >= 228) {
    			red = parametro1+".228"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".228"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".231"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".231"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 235 && parametro2 >= 232) {
    			red = parametro1+".232"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".232"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".235"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".235"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 239 && parametro2 >= 236) {
    			red = parametro1+".236"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".236"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".239"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".239"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 243 && parametro2 >= 240) {
    			red = parametro1+".240"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".240"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".243"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".243"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 247 && parametro2 >= 244) {
    			red = parametro1+".244"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".244"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".247"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".247"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 251 && parametro2 >= 248) {
    			red = parametro1+".248"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".248"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".251"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".251"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 252) {
    			red = parametro1+".252"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".252"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "262142";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} 
    	}
		
    	//255.248.0.0
    	if (mascaradered == "255.248.0.0") {
    		if (parametro2 <= 7 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".7"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".7"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 15 && parametro2 >= 8) {
    			red = parametro1+".8"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".8"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".15"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".15"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 23 && parametro2 >= 16) {
    			red = parametro1+".16"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".16"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".23"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".23"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 31 && parametro2 >= 24) {
    			red = parametro1+".24"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".24"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".31"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".31"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 39 && parametro2 >= 32) {
    			red = parametro1+".32"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".32"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".39"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".39"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 47 && parametro2 >= 40) {
    			red = parametro1+".40"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".40"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".47"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".47"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 55 && parametro2 >= 48) {
    			red = parametro1+".48"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".48"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".55"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".55"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 63 && parametro2 >= 56) {
    			red = parametro1+".56"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".56"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 71 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".71"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".71"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 79 && parametro2 >= 72) {
    			red = parametro1+".72"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".72"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".79"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".79"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 87 && parametro2 >= 80) {
    			red = parametro1+".80"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".80"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".87"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".87"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 95 && parametro2 >= 88) {
    			red = parametro1+".88"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".88"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".95"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".95"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 103 && parametro2 >= 96) {
    			red = parametro1+".96"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".96"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".103"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".103"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 111 && parametro2 >= 104) {
    			red = parametro1+".104"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".104"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".111"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".111"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 119 && parametro2 >= 112) {
    			red = parametro1+".112"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".112"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".119"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".119"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 120) {
    			red = parametro1+".120"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".120"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 135 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".135"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".135"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 143 && parametro2 >= 136) {
    			red = parametro1+".136"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".136"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".143"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".143"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 151 && parametro2 >= 144) {
    			red = parametro1+".144"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".144"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".151"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".151"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 159 && parametro2 >= 152) {
    			red = parametro1+".152"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".152"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".159"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".159"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 167 && parametro2 >= 160) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".7"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".7"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 175 && parametro2 >= 168) {
    			red = parametro1+".168"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".168"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".175"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".175"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 183 && parametro2 >= 176) {
    			red = parametro1+".176"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".176"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".183"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".183"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 184) {
    			red = parametro1+".184"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".184"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 199 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".199"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".199"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 207 && parametro2 >= 200) {
    			red = parametro1+".200"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".200"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".207"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".207"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 215 && parametro2 >= 208) {
    			red = parametro1+".208"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".208"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".215"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".215"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 223 && parametro2 >= 216) {
    			red = parametro1+".216"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".216"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".223"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".223"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 231 && parametro2 >= 224) {
    			red = parametro1+".224"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".224"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".231"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".231"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 239 && parametro2 >= 232) {
    			red = parametro1+".232"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".232"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".239"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".239"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 247 && parametro2 >= 240) {
    			red = parametro1+".240"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".240"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".247"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".247"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 248) {
    			red = parametro1+".248"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".248"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "524286";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.240.0.0
    	if (mascaradered == "255.240.0.0") {
    		if (parametro2 <= 15 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".15"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".15"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 31 && parametro2 >= 16) {
    			red = parametro1+".16"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".16"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".31"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".31"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 47 && parametro2 >= 32) {
    			red = parametro1+".32"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".32"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".47"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".47"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 63 && parametro2 >= 48) {
    			red = parametro1+".48"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".48"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 79 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".79"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".79"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 95 && parametro2 >= 80) {
    			red = parametro1+".80"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".80"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".95"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".95"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 111 && parametro2 >= 96) {
    			red = parametro1+".96"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".96"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".111"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".111"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 112) {
    			red = parametro1+".112"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".112"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 143 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".143"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".143"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 159 && parametro2 >= 144) {
    			red = parametro1+".144"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".144"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".159"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".159"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 175 && parametro2 >= 160) {
    			red = parametro1+".160"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".160"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".175"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".175"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 176) {
    			red = parametro1+".176"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".176"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 207 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".207"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".207"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 223 && parametro2 >= 208) {
    			red = parametro1+".208"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".208"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".223"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".223"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 239 && parametro2 >= 224) {
    			red = parametro1+".224"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".224"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".239"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".239"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 240) {
    			red = parametro1+".240"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".240"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1048574";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.224.0.0
    	if (mascaradered == "255.224.0.0") {
    		if (parametro2 <= 31 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".31"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".31"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 63 && parametro2 >= 32) {
    			red = parametro1+".32"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".32"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 95 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".95"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".95"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 96) {
    			red = parametro1+".96"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".96"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 159 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".159"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".159"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 160) {
    			red = parametro1+".160"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".160"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 223 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".223"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".223"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 224) {
    			red = parametro1+".224"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".224"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2097150";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.192.0.0
    	if (mascaradered == "255.192.0.0") {
    		if (parametro2 <= 63 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".63"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".63"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4194302";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 127 && parametro2 >= 64) {
    			red = parametro1+".64"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".64"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4194302";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 191 && parametro2 >= 128) {
    			red = parametro1+".128"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".128"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".191"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".191"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4194302";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 192) {
    			red = parametro1+".192"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".192"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "4194302";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.128.0.0
    	if (mascaradered == "255.128.0.0") {
    		if (parametro2 <= 127 && parametro2 >= 0) {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".127"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".127"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8388606";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro2 <= 255 && parametro2 >= 127) {
    			red = parametro1+".127"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".127"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8388606";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//255.0.0.0
    	if (mascaradered == "255.0.0.0") {
    			red = parametro1+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = parametro1+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = parametro1+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = parametro1+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "8388606";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
	}
	
	
	//METODO DE MASCARA DE RED XXX.0.0.0    LINEA 7965 - LINEA 11049
	public void mascara4() {
    	//254.0.0.0
    	if (mascaradered == "254.0.0.0") {
    		if (parametro1 <= 1 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "1"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "1"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 3 && parametro1 >= 2) {
    			red = "2"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "2"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "3"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "3"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 5 && parametro1 >= 4) {
    			red = "4"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "4"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "5"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "5"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 7 && parametro1 >= 6) {
    			red = "6"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "6"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "7"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "7"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 9 && parametro1 >= 8) {
    			red = "8"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "8"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "9"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "9"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 11 && parametro1 >= 10) {
    			red = "10"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "10"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "11"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "11"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 13 && parametro1 >= 12) {
    			red = "12"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "12"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "13"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "13"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 15 && parametro1 >= 14) {
    			red = "14"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "14"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "15"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "15"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 17 && parametro1 >= 16) {
    			red = "16"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "16"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "17"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "17"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 19 && parametro1 >= 18) {
    			red = "18"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "18"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "19"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "19"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 21 && parametro1 >= 20) {
    			red = "20"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "20"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "21"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "21"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 23 && parametro1 >= 22) {
    			red = "22"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "22"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "23"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "23"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 25 && parametro1 >= 24) {
    			red = "24"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "24"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "25"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "25"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 27 && parametro1 >= 26) {
    			red = "26"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "26"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "27"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "27"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 29 && parametro1 >= 28) {
    			red = "28"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "28"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "29"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "29"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 31 && parametro1 >= 30) {
    			red = "30"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "30"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "31"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "31"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 33 && parametro1 >= 32) {
    			red = "32"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "32"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "33"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "33"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 35 && parametro1 >= 34) {
    			red = "34"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "34"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "35"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "35"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 37 && parametro1 >= 36) {
    			red = "36"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "36"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "37"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "37"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 39 && parametro1 >= 38) {
    			red = "38"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "38"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "39"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "39"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 41 && parametro1 >= 40) {
    			red = "40"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "40"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "41"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "41"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 43 && parametro1 >= 42) {
    			red = "42"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "42"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "43"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "43"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 45 && parametro1 >= 44) {
    			red = "44"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "44"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "45"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "45"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 47 && parametro1 >= 46) {
    			red = "46"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "46"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "47"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "47"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 49 && parametro1 >= 48) {
    			red = "48"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "48"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "49"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "49"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 51 && parametro1 >= 50) {
    			red = "50"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "50"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "51"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "51"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 53 && parametro1 >= 52) {
    			red = "52"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "52"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "53"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "53"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 55 && parametro1 >= 54) {
    			red = "54"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "54"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "55"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "55"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 57 && parametro1 >= 56) {
    			red = "56"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "56"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "57"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "57"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 59 && parametro1 >= 58) {
    			red = "58"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "58"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "59"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "59"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 61 && parametro1 >= 60) {
    			red = "60"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "60"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "61"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "61"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 63 && parametro1 >= 62) {
    			red = "62"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "62"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 65 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "65"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "65"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 67 && parametro1 >= 66) {
    			red = "66"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "66"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "67"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "67"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 69 && parametro1 >= 68) {
    			red = "68"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "68"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "69"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "69"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 71 && parametro1 >= 70) {
    			red = "70"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "70"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "71"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "71"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 73 && parametro1 >= 72) {
    			red = "72"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "72"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "73"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "73"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 75 && parametro1 >= 74) {
    			red = "74"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "74"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "75"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "75"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 77 && parametro1 >= 76) {
    			red = "76"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "76"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "77"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "77"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 79 && parametro1 >= 78) {
    			red = "78"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "78"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "79"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "79"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 81 && parametro1 >= 80) {
    			red = "80"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "80"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "81"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "81"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 83 && parametro1 >= 82) {
    			red = "82"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "82"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "83"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "83"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 85 && parametro1 >= 84) {
    			red = "84"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "84"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "85"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "85"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 87 && parametro1 >= 86) {
    			red = "86"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "86"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "87"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "87"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 89 && parametro1 >= 88) {
    			red = "88"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "88"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "89"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "89"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 91 && parametro1 >= 90) {
    			red = "90"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "90"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "91"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "91"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 93 && parametro1 >= 92) {
    			red = "92"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "92"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "93"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "93"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 95 && parametro1 >= 94) {
    			red = "94"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "94"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "95"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "95"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 97 && parametro1 >= 96) {
    			red = "96"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "96"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "97"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "97"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 99 && parametro1 >= 98) {
    			red = "98"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "98"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "99"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "99"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 101 && parametro1 >= 100) {
    			red = "100"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "100"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "101"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "101"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 103 && parametro1 >= 102) {
    			red = "102"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "102"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "103"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "103"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 105 && parametro1 >= 104) {
    			red = "104"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "104"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "105"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "105"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 107 && parametro1 >= 106) {
    			red = "106"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "106"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "107"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "107"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 109 && parametro1 >= 108) {
    			red = "108"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "108"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "109"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "109"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 111 && parametro1 >= 110) {
    			red = "110"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "110"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "111"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "111"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 113 && parametro1 >= 112) {
    			red = "112"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "112"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "113"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "113"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 115 && parametro1 >= 114) {
    			red = "114"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "114"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "115"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "115"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 117 && parametro1 >= 116) {
    			red = "116"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "116"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "117"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "117"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 119 && parametro1 >= 118) {
    			red = "118"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "118"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "119"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "119"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 121 && parametro1 >= 120) {
    			red = "120"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "120"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "121"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "121"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 123 && parametro1 >= 122) {
    			red = "122"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "122"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "123"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "123"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 125 && parametro1 >= 124) {
    			red = "124"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "124"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "125"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "125"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 126) {
    			red = "126"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "126"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 129 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "129"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "129"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 131 && parametro1 >= 130) {
    			red = "130"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "130"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "131"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "131"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 133 && parametro1 >= 132) {
    			red = "132"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "132"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "133"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "133"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 135 && parametro1 >= 134) {
    			red = "134"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "134"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "135"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "135"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 137 && parametro1 >= 136) {
    			red = "136"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "136"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "137"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "137"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 139 && parametro1 >= 138) {
    			red = "138"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "138"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "139"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "139"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 141 && parametro1 >= 140) {
    			red = "140"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "140"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "141"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "141"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 143 && parametro1 >= 142) {
    			red = "142"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "142"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "143"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "143"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 145 && parametro1 >= 144) {
    			red = "144"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "144"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "145"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "145"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 147 && parametro1 >= 146) {
    			red = "146"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "146"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "147"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "147"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 149 && parametro1 >= 148) {
    			red = "148"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "148"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "149"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "149"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 151 && parametro1 >= 150) {
    			red = "150"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "150"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "151"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "151"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 153 && parametro1 >= 152) {
    			red = "152"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "152"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "153"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "153"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 155 && parametro1 >= 154) {
    			red = "154"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "154"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "155"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "155"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 157 && parametro1 >= 156) {
    			red = "156"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "156"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "157"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "157"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 159 && parametro1 >= 158) {
    			red = "158"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "158"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "159"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "159"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 161 && parametro1 >= 160) {
    			red = "160"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "160"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "161"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "161"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 163 && parametro1 >= 162) {
    			red = "162"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "162"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "163"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "163"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 165 && parametro1 >= 164) {
    			red = "164"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "164"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "165"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "165"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 167 && parametro1 >= 166) {
    			red = "166"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "166"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "167"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "167"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 169 && parametro1 >= 168) {
    			red = "168"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "168"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "169"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "169"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 171 && parametro1 >= 170) {
    			red = "170"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "170"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "171"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "171"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 173 && parametro1 >= 172) {
    			red = "172"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "172"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "173"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "173"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 175 && parametro1 >= 174) {
    			red = "174"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "174"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "175"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "175"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 177 && parametro1 >= 176) {
    			red = "176"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "176"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "177"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "177"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 179 && parametro1 >= 178) {
    			red = "178"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "178"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "179"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "179"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 181 && parametro1 >= 180) {
    			red = "180"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "180"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "181"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "181"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 183 && parametro1 >= 182) {
    			red = "182"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "182"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "183"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "183"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 185 && parametro1 >= 184) {
    			red = "184"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "184"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "185"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "185"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 187 && parametro1 >= 186) {
    			red = "186"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "186"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "187"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "187"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 189 && parametro1 >= 188) {
    			red = "188"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "188"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "189"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "189"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 190) {
    			red = "190"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "190"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 193 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "193"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "193"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 195 && parametro1 >= 194) {
    			red = "194"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "194"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "195"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "195"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 197 && parametro1 >= 196) {
    			red = "196"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "196"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "197"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "197"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 199 && parametro1 >= 198) {
    			red = "198"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "198"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "199"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "199"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 201 && parametro1 >= 200) {
    			red = "200"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "200"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "201"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "201"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 203 && parametro1 >= 202) {
    			red = "202"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "202"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "203"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "203"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 205 && parametro1 >= 204) {
    			red = "204"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "204"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "205"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "205"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 207 && parametro1 >= 206) {
    			red = "206"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "206"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "207"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "207"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 209 && parametro1 >= 208) {
    			red = "208"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "208"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "209"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "209"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 211 && parametro1 >= 210) {
    			red = "210"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "210"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "211"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "211"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 213 && parametro1 >= 212) {
    			red = "212"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "212"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "213"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "213"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 215 && parametro1 >= 214) {
    			red = "214"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "214"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "215"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "215"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 217 && parametro1 >= 216) {
    			red = "216"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "216"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "217"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "217"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 219 && parametro1 >= 218) {
    			red = "218"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "218"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "219"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "219"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 221 && parametro1 >= 220) {
    			red = "220"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "220"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "221"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "221"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 223 && parametro1 >= 222) {
    			red = "222"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "222"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "223"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "223"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 225 && parametro1 >= 224) {
    			red = "224"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "224"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "225"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "225"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 227 && parametro1 >= 226) {
    			red = "226"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "226"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "227"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "227"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 229 && parametro1 >= 228) {
    			red = "228"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "228"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "229"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "229"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 231 && parametro1 >= 230) {
    			red = "230"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "230"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "231"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "231"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 233 && parametro1 >= 232) {
    			red = "232"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "232"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "233"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "233"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 235 && parametro1 >= 234) {
    			red = "234"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "234"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "235"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "235"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 237 && parametro1 >= 236) {
    			red = "236"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "236"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "237"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "237"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 239 && parametro1 >= 238) {
    			red = "238"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "238"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "239"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "239"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 241 && parametro1 >= 240) {
    			red = "240"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "240"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "241"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "241"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 243 && parametro1 >= 242) {
    			red = "242"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "242"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "243"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "243"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 245 && parametro1 >= 244) {
    			red = "244"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "244"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "245"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "245"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 247 && parametro1 >= 246) {
    			red = "246"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "246"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "247"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "247"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 249 && parametro1 >= 248) {
    			red = "248"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "248"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "249"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "249"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 251 && parametro1 >= 250) {
    			red = "250"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "250"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "251"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "251"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 253 && parametro1 >= 252) {
    			red = "252"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "252"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "253"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "253"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 254) {
    			red = "254"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "254"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "33554430";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//252.0.0.0
    	if (mascaradered == "252.0.0.0") {
    		if (parametro1 <= 3 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "3"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "3"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 7 && parametro1 >= 4) {
    			red = "4"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "4"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "7"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "7"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 11 && parametro1 >= 8) {
    			red = "8"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "8"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "11"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "11"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 15 && parametro1 >= 12) {
    			red = "12"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "12"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "15"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "15"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 19 && parametro1 >= 16) {
    			red = "16"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "16"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "19"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "19"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 23 && parametro1 >= 20) {
    			red = "20"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "20"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "23"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "23"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 27 && parametro1 >= 24) {
    			red = "24"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "24"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "27"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "27"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 31 && parametro1 >= 28) {
    			red = "28"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "28"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "31"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "31"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 35 && parametro1 >= 32) {
    			red = "32"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "32"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "35"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "35"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 39 && parametro1 >= 36) {
    			red = "36"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "36"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "39"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "39"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 43 && parametro1 >= 40) {
    			red = "40"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "40"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "43"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "43"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 47 && parametro1 >= 44) {
    			red = "44"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "44"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "47"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "47"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 51 && parametro1 >= 48) {
    			red = "48"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "48"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "51"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "51"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 55 && parametro1 >= 52) {
    			red = "52"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "52"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "55"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "55"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 59 && parametro1 >= 56) {
    			red = "56"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "56"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "59"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "59"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 63 && parametro1 >= 60) {
    			red = "60"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "60"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 67 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "67"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "67"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 71 && parametro1 >= 68) {
    			red = "68"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "68"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "71"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "71"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 75 && parametro1 >= 72) {
    			red = "72"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "72"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "75"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "75"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 79 && parametro1 >= 76) {
    			red = "76"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "76"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "79"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "79"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 83 && parametro1 >= 80) {
    			red = "80"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "80"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "83"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "83"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 87 && parametro1 >= 84) {
    			red = "84"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "84"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "87"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "87"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 91 && parametro1 >= 88) {
    			red = "88"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "88"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "91"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "91"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 95 && parametro1 >= 92) {
    			red = "92"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "92"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "95"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "95"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 99 && parametro1 >= 96) {
    			red = "96"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "96"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "99"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "99"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 103 && parametro1 >= 100) {
    			red = "100"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "100"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "103"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "103"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 107 && parametro1 >= 104) {
    			red = "104"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "104"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "107"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "107"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 111 && parametro1 >= 108) {
    			red = "108"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "108"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "111"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "111"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 115 && parametro1 >= 112) {
    			red = "112"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "112"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "115"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "115"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 119 && parametro1 >= 116) {
    			red = "116"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "116"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "119"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "119"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 123 && parametro1 >= 120) {
    			red = "120"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "120"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "123"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "123"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 124) {
    			red = "124"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "124"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 131 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "131"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "131"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 135 && parametro1 >= 132) {
    			red = "132"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "132"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "135"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "135"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 139 && parametro1 >= 136) {
    			red = "136"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "136"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "139"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "139"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 143 && parametro1 >= 140) {
    			red = "140"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "140"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "143"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "143"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 147 && parametro1 >= 144) {
    			red = "144"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "144"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "147"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "147"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 151 && parametro1 >= 148) {
    			red = "148"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "148"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "151"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "151"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 155 && parametro1 >= 152) {
    			red = "152"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "152"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "155"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "155"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 159 && parametro1 >= 156) {
    			red = "156"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "156"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "159"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "159"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 163 && parametro1 >= 160) {
    			red = "160"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "160"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "163"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "163"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 167 && parametro1 >= 164) {
    			red = "164"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "164"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "167"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "167"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 171 && parametro1 >= 168) {
    			red = "168"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "168"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "171"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "171"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 175 && parametro1 >= 172) {
    			red = "172"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "172"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "175"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "175"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 179 && parametro1 >= 176) {
    			red = "176"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "176"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "179"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "179"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 183 && parametro1 >= 180) {
    			red = "180"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "180"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "183"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "183"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 187 && parametro1 >= 184) {
    			red = "184"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "184"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "187"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "187"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 188) {
    			red = "188"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "188"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 195 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "195"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "195"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 199 && parametro1 >= 196) {
    			red = "196"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "196"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "199"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "199"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 203 && parametro1 >= 200) {
    			red = "200"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "200"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "203"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "203"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 207 && parametro1 >= 204) {
    			red = "204"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "204"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "207"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "207"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 211 && parametro1 >= 208) {
    			red = "208"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "208"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "211"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "211"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 215 && parametro1 >= 212) {
    			red = "212"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "212"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "215"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "215"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 219 && parametro1 >= 216) {
    			red = "216"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "216"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "219"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "219"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 223 && parametro1 >= 220) {
    			red = "220"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "220"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "223"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "223"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 227 && parametro1 >= 224) {
    			red = "224"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "224"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "227"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "227"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 231 && parametro1 >= 228) {
    			red = "228"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "228"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "231"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "231"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 235 && parametro1 >= 232) {
    			red = "232"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "232"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "235"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "235"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 239 && parametro1 >= 236) {
    			red = "236"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "236"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "239"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "239"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 243 && parametro1 >= 240) {
    			red = "240"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "240"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "243"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "243"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 247 && parametro1 >= 244) {
    			red = "244"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "244"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "247"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "247"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 251 && parametro1 >= 248) {
    			red = "248"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "248"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "251"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "251"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 52) {
    			red = "252"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "252"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "67108862";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//248.0.0.0
    	if (mascaradered == "248.0.0.0") {
    		if (parametro1 <= 7 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "7"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "7"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 15 && parametro1 >= 8) {
    			red = "8"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "8"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "15"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "15"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 23 && parametro1 >= 16) {
    			red = "16"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "16"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "23"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "23"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 31 && parametro1 >= 24) {
    			red = "24"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "24"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "31"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "31"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 39 && parametro1 >= 32) {
    			red = "32"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "32"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "39"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "39"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 47 && parametro1 >= 40) {
    			red = "40"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "40"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "47"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "47"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 55 && parametro1 >= 48) {
    			red = "48"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "48"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "55"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "55"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 63 && parametro1 >= 56) {
    			red = "56"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "56"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 71 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "71"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "71"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 79 && parametro1 >= 72) {
    			red = "72"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "72"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "79"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "79"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 87 && parametro1 >= 80) {
    			red = "80"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "80"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "87"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "87"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 95 && parametro1 >= 88) {
    			red = "88"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "88"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "95"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "95"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 103 && parametro1 >= 96) {
    			red = "96"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "96"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "103"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "103"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 111 && parametro1 >= 104) {
    			red = "104"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "104"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "111"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "111"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 119 && parametro1 >= 112) {
    			red = "112"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "112"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "119"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "119"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 120) {
    			red = "120"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "120"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 135 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "135"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "135"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 143 && parametro1 >= 136) {
    			red = "136"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "136"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "143"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "143"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 151 && parametro1 >= 144) {
    			red = "144"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "144"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "151"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "151"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 159 && parametro1 >= 152) {
    			red = "152"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "152"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "159"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "159"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 167 && parametro1 >= 160) {
    			red = "160"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "160"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "167"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "167"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 175 && parametro1 >= 168) {
    			red = "168"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "168"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "175"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "175"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 183 && parametro1 >= 176) {
    			red = "176"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "176"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "183"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "183"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 184) {
    			red = "184"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "184"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 199 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "199"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "199"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 207 && parametro1 >= 200) {
    			red = "200"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "200"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "207"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "207"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 215 && parametro1 >= 208) {
    			red = "208"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "208"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "215"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "215"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 223 && parametro1 >= 216) {
    			red = "216"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "216"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "223"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "223"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 231 && parametro1 >= 224) {
    			red = "224"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "224"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "231"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "231"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 239 && parametro1 >= 232) {
    			red = "232"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "232"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "239"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "239"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 247 && parametro1 >= 240) {
    			red = "240"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "240"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "247"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "247"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 248) {
    			red = "248"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "248"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "134217726";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//240.0.0.0
    	if (mascaradered == "240.0.0.0") {
    		if (parametro1 <= 15 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "15"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "15"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 31 && parametro1 >= 16) {
    			red = "16"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "16"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "31"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "31"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 47 && parametro1 >= 32) {
    			red = "32"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "32"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "47"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "47"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 63 && parametro1 >= 48) {
    			red = "48"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "48"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 79 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "79"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "79"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 95 && parametro1 >= 80) {
    			red = "80"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "80"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "95"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "95"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 111 && parametro1 >= 96) {
    			red = "96"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "96"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "111"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "111"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 112) {
    			red = "112"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "112"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 143 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "143"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "143"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 159 && parametro1 >= 144) {
    			red = "144"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "144"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "159"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "159"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 175 && parametro1 >= 160) {
    			red = "160"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "160"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "175"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "175"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 176) {
    			red = "176"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "176"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 207 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "207"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "207"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 223 && parametro1 >= 208) {
    			red = "208"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "208"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "223"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "223"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 239 && parametro1 >= 224) {
    			red = "224"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "224"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "239"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "239"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 240) {
    			red = "240"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "240"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "268435454";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//224.0.0.0
    	if (mascaradered == "224.0.0.0") {
    		if (parametro1 <= 31 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "31"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "31"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 63 && parametro1 >= 32) {
    			red = "32"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "32"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 95 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "95"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "95"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 96) {
    			red = "96"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "96"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 159 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "159"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "159"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 160) {
    			red = "160"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "160"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 223 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "223"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "223"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 224) {
    			red = "224"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "224"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "536870910";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//192.0.0.0
    	if (mascaradered == "192.0.0.0") {
    		if (parametro1 <= 63 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "63"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "63"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1073741822";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 127 && parametro1 >= 64) {
    			red = "64"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "64"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1073741822";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 191 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "191"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "191"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1073741822";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 192) {
    			red = "192"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "192"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "1073741822";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
    	
    	//128.0.0.0
    	if (mascaradered == "128.0.0.0") {
    		if (parametro1 <= 127 && parametro1 >= 0) {
    			red = "0"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "0"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "127"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "127"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2147483646";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		} else if (parametro1 <= 255 && parametro1 >= 128) {
    			red = "128"+".0"+".0"+".0";
    			tfRED.setText(red);
    			firstip = "128"+".0"+".0"+".1";
    			tfprIPMASK.setText(firstip);
    			lastip = "255"+".255"+".255"+".254";
    			tfultIPMASK.setText(lastip);
    			broadcast = "255"+".255"+".255"+".255";
    			tfBROADCAST.setText(broadcast);
    			hosts = "2147483646";
    			tfHOSTS.setText(hosts);
    			tfGATEWAY.setText("Cualquier IP dentro de la subred");
    		}
    	}
	}
	
 
	public Cal() { 
		
		//INTERFAZ GRAFICA
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		//panel.setForeground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		JButton btnregresar = new JButton("Regresar");
		btnregresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnregresar.setBackground(Color.CYAN);
		btnregresar.setBounds(1, 1, 97, 25);
		btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	HUB hub = new HUB();
	        	view.vista.setContentPane(hub.gethub());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregresar);
		
		calip = new JLabel("Calculadora de IP");
		calip.setForeground(Color.CYAN);
		calip.setFont(new Font("Impact", Font.PLAIN, 24));
		calip.setBounds(361, 54, 175, 48);
		panel.add(calip);
		
		lblNewLabel = new JLabel("Introducir IP");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 15));
		lblNewLabel.setBounds(202, 133, 112, 22);
		panel.add(lblNewLabel);
		
		txt1 = new JTextField();
		txt1.setFont(new Font("Liberation Sans Narrow", Font.PLAIN, 20));
		txt1.setBounds(140, 168, 40, 22);
		panel.add(txt1);
		txt1.setColumns(10);
		
		txt2 = new JTextField();
		txt2.setFont(new Font("Liberation Sans Narrow", Font.PLAIN, 20));
		txt2.setBounds(192, 168, 40, 22);
		panel.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setFont(new Font("Liberation Sans Narrow", Font.PLAIN, 20));
		txt3.setBounds(244, 168, 40, 22);
		panel.add(txt3);
		txt3.setColumns(10);
		
		txt4 = new JTextField();
		txt4.setFont(new Font("Liberation Sans Narrow", Font.PLAIN, 20));
		txt4.setBounds(296, 168, 40, 22);
		panel.add(txt4);
		txt4.setColumns(10);
		
		p1 = new JLabel(".");
		p1.setForeground(Color.CYAN);
		p1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p1.setBounds(183, 174, 34, 16);
		panel.add(p1);
		
		p2 = new JLabel(".");
		p2.setForeground(Color.CYAN);
		p2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p2.setBounds(234, 174, 149, 16);
		panel.add(p2);
		
		p3 = new JLabel(".");
		p3.setForeground(Color.CYAN);
		p3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		p3.setBounds(288, 174, 149, 16);
		panel.add(p3);
		
		mascara = new JComboBox();
		mascara.setBackground(Color.WHITE);
		mascara.setModel(new DefaultComboBoxModel(new String[] {"---", "255.255.255.252", "255.255.255.248", "255.255.255.240", "255.255.255.224", "255.255.255.192", "255.255.255.128", "255.255.255.0", "255.255.254.0", "255.255.252.0", "255.255.248.0", "255.255.240.0", "255.255.224.0", "255.255.192.0", "255.255.128.0", "255.255.0.0", "255.254.0.0", "255.252.0.0", "255.248.0.0", "255.240.0.0", "255.224.0.0", "255.192.0.0", "255.128.0.0", "255.0.0.0", "254.0.0.0", "252.0.0.0", "248.0.0.0", "240.0.0.0", "224.0.0.0", "192.0.0.0", "128.0.0.0"}));
		mascara.setMaximumRowCount(8);
		mascara.setBounds(556, 170, 212, 22);
		panel.add(mascara);
		
		lblNewLabel_1 = new JLabel("TIPO");
		lblNewLabel_1.setFont(new Font("Consolas", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(75, 292, 40, 16);
		panel.add(lblNewLabel_1);
		
		tipoIP = new JTextArea();
		tipoIP.setBounds(234, 288, 150, 22);
		tipoIP.setEditable(false);
		panel.add(tipoIP);
		
		layClase = new JLabel("CLASE");
		layClase.setForeground(Color.CYAN);
		layClase.setFont(new Font("Consolas", Font.BOLD, 15));
		layClase.setBounds(75, 330, 56, 16);
		panel.add(layClase);
		
		claseIP = new JTextArea();
		claseIP.setBounds(234, 330, 150, 22);
		claseIP.setEditable(false);
		panel.add(claseIP);
		
		layPA = new JLabel("PROTOCOLO APIPA");
		layPA.setForeground(Color.CYAN);
		layPA.setFont(new Font("Consolas", Font.BOLD, 15));
		layPA.setBounds(75, 378, 123, 16);
		panel.add(layPA);
		
		paIP = new JTextArea();
		paIP.setBounds(234, 374, 150, 22);
		paIP.setEditable(false);
		panel.add(paIP);
		
		reserIP = new JTextArea();
		reserIP.setEditable(false);
		reserIP.setBounds(234, 419, 150, 22);
		panel.add(reserIP);
		
		layIP = new JLabel("RESERVADA");
		layIP.setForeground(Color.CYAN);
		layIP.setFont(new Font("Consolas", Font.BOLD, 15));
		layIP.setBounds(75, 422, 123, 16);
		panel.add(layIP);
		
		metIP = new JTextArea();
		metIP.setEditable(false);
		metIP.setBounds(234, 463, 150, 22);
		panel.add(metIP);
		
		laymet = new JLabel("METODO");
		laymet.setForeground(Color.CYAN);
		laymet.setFont(new Font("Consolas", Font.BOLD, 15));
		laymet.setBounds(75, 466, 105, 16);
		panel.add(laymet);
		
		layMASK = new JLabel("Seleccionar Mascara de Red");
		layMASK.setForeground(Color.WHITE);
		layMASK.setFont(new Font("Impact", Font.PLAIN, 15));
		layMASK.setBounds(572, 136, 218, 16);
		panel.add(layMASK);
		
		redMASK = new JLabel("RED");
		redMASK.setForeground(Color.CYAN);
		redMASK.setFont(new Font("Consolas", Font.BOLD, 15));
		redMASK.setBounds(516, 291, 56, 16);
		panel.add(redMASK);
		
		prIPMASK = new JLabel("PRIMERA DIRECCION");
		prIPMASK.setFont(new Font("Consolas", Font.BOLD, 15));
		prIPMASK.setForeground(Color.CYAN);
		prIPMASK.setBounds(516, 329, 175, 16);
		panel.add(prIPMASK);
		
		ultIPMASK = new JLabel("ULTIMA DIRECCION");
		ultIPMASK.setForeground(Color.CYAN);
		ultIPMASK.setFont(new Font("Consolas", Font.BOLD, 15));
		ultIPMASK.setBounds(516, 377, 139, 16);
		panel.add(ultIPMASK);
		
		broadMASK = new JLabel("BROADCAST");
		broadMASK.setForeground(Color.CYAN);
		broadMASK.setFont(new Font("Consolas", Font.BOLD, 15));
		broadMASK.setBounds(516, 422, 139, 16);
		panel.add(broadMASK);
		
		hostsMASK = new JLabel("CANTIDAD DE HOSTS");
		hostsMASK.setFont(new Font("Consolas", Font.BOLD, 15));
		hostsMASK.setForeground(Color.CYAN);
		hostsMASK.setBounds(516, 466, 139, 16);
		panel.add(hostsMASK);
		
		tfprIPMASK = new JTextArea();
		tfprIPMASK.setEditable(false);
		tfprIPMASK.setBounds(676, 326, 149, 22);
		panel.add(tfprIPMASK);
		
		tfRED = new JTextArea();
		tfRED.setEditable(false);
		tfRED.setBounds(676, 286, 149, 22);
		panel.add(tfRED);
		
		tfultIPMASK = new JTextArea();
		tfultIPMASK.setEditable(false);
		tfultIPMASK.setBounds(676, 374, 149, 22);
		panel.add(tfultIPMASK);
		
		tfBROADCAST = new JTextArea();
		tfBROADCAST.setEditable(false);
		tfBROADCAST.setBounds(676, 419, 149, 22);
		panel.add(tfBROADCAST);
		
		tfHOSTS = new JTextArea();
		tfHOSTS.setEditable(false);
		tfHOSTS.setBounds(676, 463, 149, 22);
		panel.add(tfHOSTS);
		
		GATEWAY = new JLabel("GATEWAY");
		GATEWAY.setForeground(Color.CYAN);
		GATEWAY.setFont(new Font("Consolas", Font.BOLD, 15));
		GATEWAY.setBounds(516, 508, 71, 16);
		panel.add(GATEWAY);
		
		tfGATEWAY = new JTextArea();
		tfGATEWAY.setEditable(false);
		tfGATEWAY.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tfGATEWAY.setBounds(676, 504, 149, 22);
		panel.add(tfGATEWAY);
		
		btnhistorial = new JButton("HISTORIAL");
		btnhistorial.setBackground(Color.CYAN);
		btnhistorial.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnhistorial.setBounds(760, 1, 150, 75);
		btnhistorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	historial his = new historial();
	        	view.vista.setContentPane(his.gethistorial());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnhistorial);
		
		btnNewButton = new JButton("CALCULAR");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnNewButton.setBounds(361, 225, 175, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				text1 = txt1.getText();
				text2 = txt2.getText();
				text3 = txt3.getText();
				text4 = txt4.getText();
				ipcompleta = text1+"."+text2+"."+text3+"."+text4;
				parametro1 = Integer.parseInt(text1);
		        parametro2 = Integer.parseInt(text2);
		        parametro3 = Integer.parseInt(text3);
		        parametro4 = Integer.parseInt(text4);
		        mascaradered = mascara.getSelectedItem().toString();
		        
		        //COMIENZAN LAS OPERACIONES
		        if (text1.isEmpty() || text2.isEmpty() || text3.isEmpty() || text4.isEmpty() ) {
		        	JOptionPane.showMessageDialog(panel, "La IP que se introdujo no es valida");
		        	
		        } else if (parametro1 <= 255 && parametro2 <= 255 && parametro3 <= 255 && parametro4 <= 255 && parametro1 >= 0 && parametro2 >= 0 && parametro3 >= 0 && parametro4 >= 0){
		        
		        	//OPERACIONES CON LA MASCARA DE RED
		        	operacionesip ();
		        	
		        	//255.255.255.xxx
		        	mascara1 ();
		        	
		        	//255.255.xxx.xxx	
		        	mascara2 ();
		        	
		        	//255.xxx.0.0
		        	mascara3 (); 
		        	
		        	//xxx.0.0.0
		        	mascara4 ();
		        	
                
		    //DATO INVALIDO
			} else {
				
				JOptionPane.showMessageDialog(panel, "Alguno de los datos que se introdujo no es valido");
			}
		        
		        
		        try {
	            	String sql= "insert into historialips values('"+ipcompleta+"','"+mascaradered+"','"+tipo+"','"+clase+"','"+apipa+"','"+reservada+"','"+metodo+"','"+red+"','"+firstip+"','"+lastip+"','"+broadcast+"','"+hosts+"')";
	            	
	            	DB.stmt = DB.conn.createStatement();
	    			DB.stmt.executeUpdate(sql);

	            } catch (SQLException f) {
	            
	            	 System.out.print(f);
	            } 
		        
	        }
	    }); 
		panel.add(btnNewButton);

		
		this.panel.setSize(1400, 700);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
}
	public JPanel getcal() {
		return this.panel;
}
}