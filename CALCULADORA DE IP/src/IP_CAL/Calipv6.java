package IP_CAL;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Calipv6 {

	private JPanel panel;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;

	//METODOS PARA CONVERTIR A DECIMAL
	public static int hex1;
	public static int hexDec1(String num) {
	    hex1=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex1 = (int) (hex1 + newnum*Math.pow(16,i));
	    } return hex1; 
	    }
	
	public static int hex2;
	public static int hexDec2(String num) {
	    hex2=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex2 = (int) (hex2 + newnum*Math.pow(16,i));
	    } return hex2; 
	    }
	
	public static int hex3;
	public static int hexDec3(String num) {
	    hex3=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex3 = (int) (hex3 + newnum*Math.pow(16,i));
	    } return hex3; 
	    }
	
	public static int hex4;
	public static int hexDec4(String num) {
	    hex4=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex4 = (int) (hex4 + newnum*Math.pow(16,i));
	    } return hex4; 
	    }
	
	public static int hex5;
	public static int hexDec5(String num) {
	    hex5=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex5 = (int) (hex5 + newnum*Math.pow(16,i));
	    } return hex5; 
	    }
	
	public static int hex6;
	public static int hexDec6(String num) {
	    hex6=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex6 = (int) (hex6 + newnum*Math.pow(16,i));
	    } return hex6; 
	    }
	
	public static int hex7;
	public static int hexDec7(String num) {
	    hex7=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex7 = (int) (hex7 + newnum*Math.pow(16,i));
	    } return hex7; 
	    }
	
	public static int hex8;
	public static int hexDec8(String num) {
	    hex8=0;
	    int newnum = 0;
	    String digit = num.toUpperCase();
	    for(int i=0;i<digit.length();i++) {
	        char c = digit.charAt(digit.length()-i-1);

	        if(c=='A'){newnum = 10;}
	        else if(c=='B'){newnum = 11;}
	        else if(c=='C'){newnum = 12;}
	        else if(c=='D'){newnum = 13;}
	        else if(c=='E'){newnum = 14;}
	        else if(c=='F'){newnum = 15;}
	        else if(c=='a'){newnum = 10;}
	        else if(c=='b'){newnum = 11;}
	        else if(c=='c'){newnum = 12;}
	        else if(c=='d'){newnum = 13;}
	        else if(c=='e'){newnum = 14;}
	        else if(c=='f'){newnum = 15;}
	        else{newnum = Character.getNumericValue(c);}
	        hex8 = (int) (hex8 + newnum*Math.pow(16,i));
	    } return hex8; 
	    }
	
	
	
	public Calipv6() {
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
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
		
		JLabel IP = new JLabel("Ingrese la IPV6");
		IP.setHorizontalAlignment(SwingConstants.CENTER);
		IP.setForeground(Color.CYAN);
		IP.setFont(new Font("Consolas", Font.BOLD, 25));
		IP.setBounds(557, 107, 252, 43);
		panel.add(IP);
		
		tf2 = new JTextField();
		tf2.setFont(new Font("Consolas", Font.BOLD, 32));
		tf2.setBounds(415, 163, 80, 43);
		panel.add(tf2);
		tf2.setColumns(10);
		
		JLabel labus = new JLabel("El Tipo de su IPV6 es:");
		labus.setForeground(Color.CYAN);
		labus.setFont(new Font("Consolas", Font.BOLD, 25));
		labus.setBounds(540, 366, 308, 43);
		panel.add(labus);
		
		JTextArea tipoipv6 = new JTextArea();
		tipoipv6.setEditable(false);
		tipoipv6.setFont(new Font("Consolas", Font.BOLD, 30));
		tipoipv6.setBounds(562, 422, 259, 43);
		panel.add(tipoipv6);
		
		tf3 = new JTextField();
		tf3.setFont(new Font("Consolas", Font.BOLD, 32));
		tf3.setColumns(10);
		tf3.setBounds(507, 163, 80, 43);
		panel.add(tf3);
		
		tf4 = new JTextField();
		tf4.setFont(new Font("Consolas", Font.BOLD, 32));
		tf4.setColumns(10);
		tf4.setBounds(599, 163, 80, 43);
		panel.add(tf4);
		
		tf5 = new JTextField();
		tf5.setFont(new Font("Consolas", Font.BOLD, 32));
		tf5.setColumns(10);
		tf5.setBounds(691, 163, 80, 43);
		panel.add(tf5);
		
		tf6 = new JTextField();
		tf6.setFont(new Font("Consolas", Font.BOLD, 32));
		tf6.setColumns(10);
		tf6.setBounds(783, 163, 80, 43);
		panel.add(tf6);
		
		tf7 = new JTextField();
		tf7.setFont(new Font("Consolas", Font.BOLD, 32));
		tf7.setColumns(10);
		tf7.setBounds(875, 163, 80, 43);
		panel.add(tf7);
		
		tf1 = new JTextField();
		tf1.setFont(new Font("Consolas", Font.BOLD, 32));
		tf1.setColumns(10);
		tf1.setBounds(323, 163, 80, 43);
		panel.add(tf1);
		
		tf8 = new JTextField();
		tf8.setFont(new Font("Consolas", Font.BOLD, 32));
		tf8.setColumns(10);
		tf8.setBounds(967, 163, 80, 43);
		panel.add(tf8);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.setFont(new Font("Consolas", Font.PLAIN, 20));
		buscar.setBackground(Color.CYAN);
		buscar.setBounds(491, 232, 395, 43);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				String texto1 = tf1.getText();
				String texto2 = tf2.getText();
				String texto3 = tf3.getText();
				String texto4 = tf4.getText();
				String texto5 = tf5.getText();
				String texto6 = tf6.getText();
				String texto7 = tf7.getText();
				String texto8 = tf8.getText();
				hexDec1(texto1);
				hexDec2(texto2);
				hexDec3(texto3);
				hexDec4(texto4);
				hexDec5(texto5);
				hexDec6(texto6);
				hexDec7(texto7);
				hexDec8(texto8);
				int param1 = hex1;
		        int param2 = hex2;
		        int param3 = hex3;
		        int param4 = hex4;
		        int param5 = hex5;
		        int param6 = hex6;
		        int param7 = hex7;
		        int param8 = hex8;
		        
		        //COMIENZAN LAS OPERACIONES
		        if (texto1.isEmpty() || texto2.isEmpty() || texto3.isEmpty() || texto4.isEmpty() || texto5.isEmpty() || texto6.isEmpty() || texto7.isEmpty() || texto8.isEmpty() ) {
		        	JOptionPane.showMessageDialog(panel, "La IP que se introdujo no es valida");
		        	
		        } else if (param1 <= 65535 && param2 <= 65535 && param3 <= 65535 && param4 <= 65535 && param5 <= 65535 && param6 <= 65535 && param7 <= 65535 && param8 <= 65535 && param1 >= 0 && param2 >= 0 && param3 >= 0 && param4 >= 0 && param5 >= 0 && param6 >= 0 && param7 >= 0 && param8 >= 0){
		        
		        	if (param1 == 0 && param2 == 0 && param3 == 0 && param4 == 0 && param5 == 0 && param6 == 0 && param7 == 0 && param8 == 1) {		        		
		        		tipoipv6.setText("Loopback");
		        		
		        	} else if (param1 >= 8192 && param1 <= 16383) {
		        		tipoipv6.setText("Unicast Global");
		        		
		        	} else if (param1 >= 64512 && param1 <= 65023) {
		        		tipoipv6.setText("Local Unicast");
		        		
		        	} else if (param1 >= 65152 && param1 <= 65215) {
		        		tipoipv6.setText("Link-Local Unicast");
		        		
		        	} else if (param1 >= 65280 && param1 <= 65535) {
		        		tipoipv6.setText("Multicast");
		        		
		        	} else {
		        		tipoipv6.setText("Sin Especificar");
		        	}
                
		    //DATO INVALIDO
			} else {
				
				JOptionPane.showMessageDialog(panel, "Alguno de los datos que se introdujo no es valido");
			}  
		    
	        }
	    });
		panel.add(buscar);
		
		this.panel.setSize(1400, 700);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}
	
	public JPanel getcalipv6() {
		return this.panel;
		
	}
}
