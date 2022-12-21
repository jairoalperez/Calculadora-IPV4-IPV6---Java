package IP_CAL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HUB {

	JPanel panel;
	JButton calipv4;
	JButton calipv6;
	JButton btnhosts;
	
	public HUB ( ){
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		
		calipv4 = new JButton("CALCULADORA IPV4");
		calipv4.setBackground(Color.CYAN);
		calipv4.setFont(new Font("Arial Black", Font.PLAIN, 13));
		calipv4.setBounds(700, 150, 299, 199);
		calipv4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	Cal cal = new Cal();
	        	view.vista.setContentPane(cal.getcal());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });      
		panel.add(calipv4);
		
		calipv6 = new JButton("CALCULADORA IPV6");
		calipv6.setBackground(Color.CYAN);
		calipv6.setFont(new Font("Arial Black", Font.PLAIN, 13));
		calipv6.setBounds(400, 150, 299, 199);
		calipv6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	Calipv6 cal6 = new Calipv6();
	        	view.vista.setContentPane(cal6.getcalipv6());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });      
		panel.add(calipv6);
		
		btnhosts = new JButton("CALC. POR CANTIDAD DE HOSTS");
		btnhosts.setBackground(Color.CYAN);
		btnhosts.setFont(new Font("Arial Black", Font.PLAIN, 13));
		btnhosts.setBounds(550, 350, 300, 200);
		btnhosts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	CalHosts calh = new CalHosts();
	        	view.vista.setContentPane(calh.getcalh());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });     
		panel.add(btnhosts);
		
		this.panel.setSize(1400, 700);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}
	
	public JPanel gethub() {
		return this.panel;
		
	}	
	}
	
	
	
	
	
	

