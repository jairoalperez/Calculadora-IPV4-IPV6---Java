package IP_CAL;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class historial {
	
	

	JPanel panel;
	private JTable historialtable;

	public void llenartabla() {
		
		String [] titulos= {"IP","Mascara de Red","Tipo","Clase","APIPA","Reservada","Metodo","Red","Primera IP","Ultima IP","Broadcast","Hosts"};
		   
		   String datos []= new String[12];
		   DefaultTableModel modelo =new  DefaultTableModel(null,titulos);
		   String sql="select * from historialips";
		        try {
		        	DB.pstmt = DB.conn.prepareStatement(sql);
					DB.rs = DB.pstmt.executeQuery();
		            while(DB.rs.next())
		            {
		                datos[0]= DB.rs.getString("ip_historial");
		                datos[1]= DB.rs.getString("mascara_historial");
		                datos[2]= DB.rs.getString("tipo_historial");
		                datos[3]= DB.rs.getString("clase_historial");
		                datos[4]= DB.rs.getString("apipa_historial");
		                datos[5]= DB.rs.getString("reservada_historial");
		                datos[6]= DB.rs.getString("metodo_historial");
		                datos[7]= DB.rs.getString("red_historial");
		                datos[8]= DB.rs.getString("firstip_historial");
		                datos[9]= DB.rs.getString("lastip_historial");
		                datos[10]= DB.rs.getString("broadcast_historial");
		                datos[11]= DB.rs.getString("hosts_historial");
		               
		                modelo.addRow(titulos);
		                modelo.addRow(datos);
		            }
		            historialtable.setModel(modelo);
		        } catch (SQLException ex) {
		          
		        }
		
		
	}
	
	
	public historial() {
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(null);
		
		historialtable = new JTable();
		historialtable.setBounds(40, 70, 1300, 525);
		panel.add(historialtable);
		
		llenartabla();
		
		JButton btnregresar = new JButton("Regresar");
		btnregresar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnregresar.setBackground(Color.CYAN);
		btnregresar.setBounds(1, 1, 97, 25);
		btnregresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	        	Cal cal = new Cal();
	        	view.vista.setContentPane(cal.getcal());
	        	view.vista.invalidate();
	        	view.vista.validate();
	        }
	    });
		panel.add(btnregresar);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
	}

	public JPanel gethistorial() {
		return this.panel;
	}
	
}
















