package CalculadoraIP;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UIhost {
	private JPanel panel = new JPanel();
	private JTextField fieldHost;
	private JLabel lblHost;

	/**
	 * Create the panel.
	 */
	public UIhost() {
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Recomendacion Para Host");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(134, 0, 231, 39);
		panel.add(lblNewLabel);
		
		fieldHost = new JTextField();
		fieldHost.setBounds(176, 63, 90, 22);
		panel.add(fieldHost);
		fieldHost.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese numero de host:");
		lblNewLabel_1.setBounds(21, 66, 163, 16);
		panel.add(lblNewLabel_1);
		
		JButton calcularBtn = new JButton("Calcular");
		calcularBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculos();
			}
		});
		calcularBtn.setBounds(278, 63, 97, 22);
		panel.add(calcularBtn);
		
		JLabel lblNewLabel_2 = new JLabel("IP Network: ");
		lblNewLabel_2.setBounds(21, 98, 80, 16);
		panel.add(lblNewLabel_2);
		
		lblHost = new JLabel("...");
		lblHost.setBounds(109, 98, 80, 16);
		panel.add(lblHost);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI ui = new UI();
				UI.frame.setContentPane(ui.getJPanel());
				UI.frame.revalidate();
			}
		});
		btnRegresar.setBounds(201, 144, 97, 22);
		panel.add(btnRegresar);

	}
	
	public JPanel getJPanel() {
		return panel;
	}
	
	private void calculos() {
		int hosts = Integer.parseInt(fieldHost.getText());
		int i =1;
		double boundup=0;
		int conteo = 0;

		for (i=1; hosts>boundup; i++) {
		boundup = Math.pow(2, i)-2;
		conteo++;
		} 
		
		//generating mask
		String maskByte = new String();
		
		for (i=1; i<=32-conteo;i++) {
			maskByte+="1";
		}
		for (i=1; i<=(conteo);i++) {
			maskByte+="0";
		}
		
	    String mask1Byte = String.format("%08d", Integer.parseInt(maskByte.substring(0,8)));
	    String mask2Byte = String.format("%08d", Integer.parseInt(maskByte.substring(8,16)));
	    String mask3Byte = String.format("%08d", Integer.parseInt(maskByte.substring(16,24)));
	    String mask4Byte = String.format("%08d", Integer.parseInt(maskByte.substring(24,32)));
	    
	    int mask1ByteD = Integer.parseInt(mask1Byte,2);  
	    int mask2ByteD = Integer.parseInt(mask2Byte,2);  
	    int mask3ByteD = Integer.parseInt(mask3Byte,2);  
	    int mask4ByteD = Integer.parseInt(mask4Byte,2);  
	    
	    String mask1Inv = mask1Byte.replace('0', '2').replace('1', '0').replace('2', '1');
	    String mask2Inv = mask2Byte.replace('0', '2').replace('1', '0').replace('2', '1');
	    String mask3Inv = mask3Byte.replace('0', '2').replace('1', '0').replace('2', '1');
	    String mask4Inv = mask4Byte.replace('0', '2').replace('1', '0').replace('2', '1');
	    
	    //mask invertida en decimal
	    int mask1InvD = Integer.parseInt(mask1Inv,2);  
	    int mask2InvD = Integer.parseInt(mask2Inv,2);  
	    int mask3InvD = Integer.parseInt(mask3Inv,2);  
	    int mask4InvD = Integer.parseInt(mask4Inv,2);  

	    //eleccion de clase de ip dependiendo de los hosts
	    int ip1=0;
	    int ip2=0;
	    int ip3=0;
	    int ip4=0;
	    if(hosts <=254 && hosts>0) {
	    	ip1 = 192;
	    	ip2= 1;
	    	ip3= 1;
	    	ip4=254;
	    } else if (hosts <=65534) {
	    	ip1 = 128;
	    	ip2= 1;
	    	ip3= 254;
	    	ip4=254;
	    } else if (hosts <=16777216) {
	    	ip1 = 124;
	    	ip2= 254;
	    	ip3= 254;
	    	ip4=254;
	    } else {
	    	lblHost.setText("error");
	    }
		//network ip
	    int network1 = ip1&mask1ByteD;
	    int network2 = ip2&mask2ByteD;
	    int network3 = ip3&mask3ByteD;
	    int network4 = ip4&mask4ByteD;
	    
	    lblHost.setText(network1+"."+network2+"."+network3+"."+network4);
	}
}
