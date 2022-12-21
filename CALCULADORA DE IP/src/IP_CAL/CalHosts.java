package IP_CAL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.*;

public class CalHosts {

	private JTextField tfhostsbusqueda;
    private JPanel panel;
    private JTextArea maskred;
	
	public CalHosts() {
		
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
		
		JLabel cantidad = new JLabel("Ingrese la Cantidad de Hosts ");
		cantidad.setForeground(Color.CYAN);
		cantidad.setFont(new Font("Consolas", Font.BOLD, 25));
		cantidad.setBounds(489, 107, 411, 43);
		panel.add(cantidad);
		
		tfhostsbusqueda = new JTextField();
		tfhostsbusqueda.setFont(new Font("Consolas", Font.BOLD, 22));
		tfhostsbusqueda.setBounds(491, 163, 395, 43);
		panel.add(tfhostsbusqueda);
		tfhostsbusqueda.setColumns(10);
		
		JLabel maskbuscada = new JLabel("Su Mascara de Red Deberia Ser:");
		maskbuscada.setForeground(Color.CYAN);
		maskbuscada.setFont(new Font("Consolas", Font.BOLD, 25));
		maskbuscada.setBounds(480, 367, 420, 43);
		panel.add(maskbuscada);
		
		maskred = new JTextArea();
		maskred.setEditable(false);
		maskred.setFont(new Font("Consolas", Font.BOLD, 30));
		maskred.setText("000.000.000.000");
		maskred.setBounds(562, 422, 259, 43);
		panel.add(maskred);
		
		JButton buscar = new JButton("BUSCAR");
		buscar.setFont(new Font("Consolas", Font.PLAIN, 20));
		buscar.setBackground(Color.CYAN);
		buscar.setBounds(491, 232, 395, 43);
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	
				String canhosts = tfhostsbusqueda.getText();
				long hostsnum = Long.parseUnsignedLong(canhosts);  
				
				if (hostsnum >= 0 && hostsnum <= 2147483646) {
					
				    if (hostsnum <= 2) { maskred.setText("255.255.255.252"); }
				    
				    else if (hostsnum <= 6) { maskred.setText("255.255.255.248"); }
				    
				    else if (hostsnum <= 14) { maskred.setText("255.255.255.240"); }
				    
				    else if (hostsnum <= 30) { maskred.setText("255.255.255.224"); }
				    
				    else if (hostsnum <= 62) { maskred.setText("255.255.255.192"); }
				    
				    else if (hostsnum <= 126) { maskred.setText("255.255.255.128"); }
				    
				    else if (hostsnum <= 254) { maskred.setText("255.255.255.0"); }
				    
				    else if (hostsnum <= 510) { maskred.setText("255.255.254.0"); }
				    
				    else if (hostsnum <= 1022) { maskred.setText("255.255.252.0"); }
				    
				    else if (hostsnum <= 2046) { maskred.setText("255.255.248.0"); }
				    
				    else if (hostsnum <= 4094) { maskred.setText("255.255.240.0"); }
				    
				    else if (hostsnum <= 8190) { maskred.setText("255.255.224.0"); }
				    
				    else if (hostsnum <= 16382) { maskred.setText("255.255.192.0"); }
				    
				    else if (hostsnum <= 32766) { maskred.setText("255.255.128.0"); }
				    
				    else if (hostsnum <= 65534) { maskred.setText("255.255.0.0"); }
				    
				    else if (hostsnum <= 131070) { maskred.setText("255.254.0.0"); }
				    
				    else if (hostsnum <= 262142) { maskred.setText("255.252.0.0"); }
				    
				    else if (hostsnum <= 524286) { maskred.setText("255.248.0.0"); }
				    
				    else if (hostsnum <= 1048574) { maskred.setText("255.240.0.0"); }
				    
				    else if (hostsnum <= 2097150) { maskred.setText("255.224.0.0"); }
				    
				    else if (hostsnum <= 4194302) { maskred.setText("255.192.0.0"); }
				    
				    else if (hostsnum <= 8388606) { maskred.setText("255.128.0.0"); }
				    
				    else if (hostsnum <= 16777214) { maskred.setText("255.0.0.0"); }
				    
				    else if (hostsnum <= 33554430) { maskred.setText("254.0.0.0"); }
				    
				    else if (hostsnum <= 67108862) { maskred.setText("252.0.0.0"); }
				    
				    else if (hostsnum <= 134217726) { maskred.setText("248.0.0.0"); }
				    
				    else if (hostsnum <= 268435454) { maskred.setText("240.0.0.0"); }
				    
				    else if (hostsnum <= 536870910) { maskred.setText("224.0.0.0"); }
				    
				    else if (hostsnum <= 1073741822) { maskred.setText("192.0.0.0"); }
				    
				    else if (hostsnum <= 2147483646) { maskred.setText("128.0.0.0"); }
					
				} else {
					
					JOptionPane.showMessageDialog(panel, "La cantidad de hosts introducida no es valida");
					
				}
				
				
				
	        }
	    });
		panel.add(buscar);

		this.panel.setSize(1400, 700);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}
	
	public JPanel getcalh() {
		return this.panel;
		
	}
	
	
}
