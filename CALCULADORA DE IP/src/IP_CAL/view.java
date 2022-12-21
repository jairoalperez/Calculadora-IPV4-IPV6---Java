package IP_CAL;

import java.util.Scanner;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class view extends JFrame{

	public static JFrame vista;

	protected JButton botoncomenzar;
	protected JLabel label; 

	public view() {

		vista = new JFrame("Calculadora de IP");
		
		this.botoncomenzar = new JButton("Comenzar");
		this.botoncomenzar.setBounds(500, 250, 400, 200);
		botoncomenzar.setBackground(Color.CYAN);
		botoncomenzar.setFont(new Font("Arial Black", Font.PLAIN, 13));
		this.botoncomenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	HUB hub = new HUB();
	        	view.vista.setContentPane(hub.gethub());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		this.vista.add(botoncomenzar);
		
		this.vista.setSize(1400, 700);
		this.vista.setLayout(null);
		this.vista.setVisible(true);
		
	}
	}
	
	
	
	

