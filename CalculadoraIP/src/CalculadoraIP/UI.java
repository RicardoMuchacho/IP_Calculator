package CalculadoraIP;

import java.awt.BorderLayout;
import Database.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class UI {

	public static JFrame frame = new JFrame();
	private JPanel panel;
	private JTextField ip1;
	private JTextField ip2;
	private JTextField ip3;
	private JTextField ip4;
	private JTextField mask;
	private JLabel rA;
	private JLabel rB;
	private JLabel rC;
	private JLabel rD;
	private JLabel rE;
	private JLabel rF1;
	private JLabel rF2;
	private JLabel rF3;
	private JLabel rF4;

	
	/**
	 * Create the frame.
	 */
	public UI() {
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 400);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Calculadora de IP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(170, 0, 154, 32);
		panel.add(lblNewLabel);
		
		JLabel lblip = new JLabel("Ingrese IP:");
		lblip.setBounds(22, 33, 72, 16);
		panel.add(lblip);
		
		ip1 = new JTextField();
		ip1.setBounds(22, 52, 56, 22);
		panel.add(ip1);
		
		
		ip2 = new JTextField();
		ip2.setBounds(92, 52, 56, 22);
		panel.add(ip2);
		
		ip3 = new JTextField();
		ip3.setBounds(160, 52, 56, 22);
		panel.add(ip3);
		
		mask = new JTextField();
		mask.setColumns(10);
		mask.setBounds(313, 52, 56, 22);
		panel.add(mask);
		
		JLabel lblMask = new JLabel("Mask:");
		lblMask.setBounds(313, 33, 56, 16);
		panel.add(lblMask);
		
		JLabel lblA = new JLabel("Publica o Privada:");
		lblA.setBounds(22, 87, 119, 16);
		panel.add(lblA);
		
		JLabel lblB = new JLabel("Clase:");
		lblB.setBounds(22, 114, 119, 16);
		panel.add(lblB);
		
		JLabel lblC = new JLabel("Pertenece APIPA:");
		lblC.setBounds(22, 142, 119, 16);
		panel.add(lblC);
		
		JLabel lblD = new JLabel("Reservada:");
		lblD.setBounds(22, 172, 119, 16);
		panel.add(lblD);
		
		JLabel lblE = new JLabel("Unicast/Multicast/Broadcast:");
		lblE.setBounds(22, 201, 166, 16);
		panel.add(lblE);
		
		JLabel lblF1 = new JLabel("Network Address");
		lblF1.setBounds(22, 230, 119, 16);
		panel.add(lblF1);
		
		JLabel lblF2 = new JLabel("Gateway:");
		lblF2.setBounds(22, 259, 119, 16);
		panel.add(lblF2);
		
		JLabel lblF3 = new JLabel("Broadcast:");
		lblF3.setBounds(22, 288, 119, 16);
		panel.add(lblF3);
		
		JLabel lblF4 = new JLabel("Rango:");
		lblF4.setBounds(22, 317, 119, 16);
		panel.add(lblF4);
		
		rA = new JLabel("...");
		rA.setBounds(208, 86, 161, 16);
		panel.add(rA);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(190, 87, 6, 254);
		panel.add(separator);
		
		rB = new JLabel("...");
		rB.setBounds(208, 113, 161, 16);
		panel.add(rB);
		
		JButton calcularBtn = new JButton("Calcular");
		calcularBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculos();
			}
		});
		calcularBtn.setBounds(381, 52, 85, 25);
		panel.add(calcularBtn);
		
		rC = new JLabel("...");
		rC.setBounds(208, 141, 161, 16);
		panel.add(rC);
		
		rD = new JLabel("...");
		rD.setBounds(208, 171, 208, 16);
		panel.add(rD);
		
		rE = new JLabel("...");
		rE.setBounds(208, 200, 208, 16);
		panel.add(rE);
		
		rF1 = new JLabel("...");
		rF1.setBounds(208, 229, 208, 16);
		panel.add(rF1);
		
		rF2 = new JLabel("...");
		rF2.setBounds(208, 258, 208, 16);
		panel.add(rF2);
		
		rF3 = new JLabel("...");
		rF3.setBounds(208, 287, 208, 16);
		panel.add(rF3);
		
		rF4 = new JLabel("...");
		rF4.setBounds(208, 316, 208, 16);
		panel.add(rF4);
		
		JLabel lblName = new JLabel("Ricardo Muchacho ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(370, 349, 124, 16);
		panel.add(lblName);
		
		JButton historialBtn = new JButton("Historial");
		historialBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI2 ui2 = new UI2();
				frame.setContentPane(ui2.getJPanel());
				frame.revalidate();
			}
		});
		historialBtn.setBounds(381, 88, 85, 25);
		panel.add(historialBtn);
		
		ip4 = new JTextField();
		ip4.setBounds(228, 52, 56, 22);
		panel.add(ip4);
		
		JLabel lblNewLabel_1 = new JLabel("/");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(290, 52, 18, 22);
		panel.add(lblNewLabel_1);
		
		frame.setVisible(true);
	}
	
	public void calculos() {
	int i;

	Integer ip1 = Integer.parseInt(this.ip1.getText());
	Integer ip2 = Integer.parseInt(this.ip2.getText());
	Integer ip3 = Integer.parseInt(this.ip3.getText());
	Integer ip4 = Integer.parseInt(this.ip4.getText());
	Integer mask = Integer.parseInt(this.mask.getText());

	//binary ip
	String ip1b = Integer.toBinaryString(ip1);
	String ip2b = Integer.toBinaryString(ip2);
	String ip3b = Integer.toBinaryString(ip3);
	String ip4b = Integer.toBinaryString(ip4);
	String maskByte = new String();
	
	//binary ip en bytes
	String ip1Byte = String.format("%08d", Integer.parseInt(ip1b));
	String ip2Byte = String.format("%08d", Integer.parseInt(ip2b));
	String ip3Byte = String.format("%08d", Integer.parseInt(ip3b));
	String ip4Byte = String.format("%08d", Integer.parseInt(ip4b));
	
	//generating mask
	for (i=1; i<=mask;i++) {
		maskByte+="1";
	}
	for (i=1; i<=(32-mask);i++) {
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

    //network address
    int network1 = ip1&mask1ByteD;
    int network2 = ip2&mask2ByteD;
    int network3 = ip3&mask3ByteD;
    int network4 = ip4&mask4ByteD;
    
    //Mask invertida
    String mask1Inv = mask1Byte.replace('0', '2').replace('1', '0').replace('2', '1');
    String mask2Inv = mask2Byte.replace('0', '2').replace('1', '0').replace('2', '1');
    String mask3Inv = mask3Byte.replace('0', '2').replace('1', '0').replace('2', '1');
    String mask4Inv = mask4Byte.replace('0', '2').replace('1', '0').replace('2', '1');
    
    int mask1InvD = Integer.parseInt(mask1Inv,2);  
    int mask2InvD = Integer.parseInt(mask2Inv,2);  
    int mask3InvD = Integer.parseInt(mask3Inv,2);  
    int mask4InvD = Integer.parseInt(mask4Inv,2);  
    
    //broadcast
    int br1 = ip1 | mask1InvD;
    int br2 = ip2 | mask2InvD;
    int br3 = ip3 | mask3InvD;
    int br4 = ip4 | mask4InvD;

	//errores
	if (ip1>255 || ip2>255 || ip3>255 || ip4>255 || ip1<0 || mask>32) {
		rA.setText("no existe");
		rB.setText("no existe");
		rC.setText("no existe");
		rD.setText("no existe");
		rE.setText("no existe");
		rF1.setText("no existe");
		rF2.setText("no existe");
		rF3.setText("no existe");
		rF4.setText("no existe");
		
	}	else { 
		//Reservada y que tipo
		 if (ip1==br1 && ip2==br2 && ip3==br3 && ip4==br4) {
			rD.setText("Reservada para Broadcast");
		 }
		 else if (ip1==network1 && ip2==network2 && ip3==network3 && ip4==network4) {
			rD.setText("Reservada para Network Address");
		 } 
		 else if (ip1==127 && ip2==0 && ip3==0 && ip4==1) {
		    rD.setText("Reservada para loopback/localhost");
		} 
		 else if (ip1==network1 && ip2==network2 && ip3==network3 && ip4==(network4+1)) {
			rD.setText("Reservada para Gateway");
	     } 
		 else {
			rD.setText("no reservada");
		 }
		 
		//privada o publica
		if(ip1 == 192 && ip2 == 168 && ip3<=255) {
			rA.setText("Privada");
		} 
		else if (ip1 == 172 && ip2>=16 && ip2<=31 && ip3<=255 && ip4<=255) {
			rA.setText("Privada");
		}
		else if (ip1 == 10 && ip2>=0 && ip2<=255 && ip3<=255 && ip4<=255) {
			rA.setText("Privada");
		} 
		else {
			rA.setText("Publica");
		}
			
		//Clase
		if(ip1 >= 1 && ip1 <=126) {
			rB.setText("Clase A");
		} 
		else if (ip1 >= 128 && ip1<=191) {
			rB.setText("Clase B");
		}
		else if (ip1>=192 && ip1<=223) {
			rB.setText("Clase C");
		}
		else if (ip1>=224 && ip1<=239) {
			rB.setText("Clase D");
		}
		else if (ip1>=240 && ip1<=254) {
			rB.setText("Clase E");
		}
		else {
			rB.setText("pertenece a ninguna clase");
		}
		
		//APIPA
		if(ip1 == 169 && ip2==254 && ip3 <=255 && ip4 <=255) {
			rC.setText("si pertenece");
		} else  {
			rC.setText("no pertenece");
		}
		
		//Unicast Multicast o Broadcast
		if(ip1b.substring(0,4).contentEquals("1110")) {
			rE.setText("Multicast");
		} 
		else if (ip1==br1 && ip2==br2 && ip3==br3 && ip4==br4) {
			rE.setText("Broadcast");
		}
		else {
			rE.setText("Unicast");
		}
		
		//Network Address
		rF1.setText(network1+"."+network2+"."+network3+"."+network4);
		
		//Gateway
		
		rF2.setText(network1+"."+network2+"."+network3+"."+(network4+1));
		
		//Broadcast
		rF3.setText(br1+"."+br2+"."+br3+"."+br4);
	
		//Range
		rF4.setText(network1+"."+network2+"."+network3+"."+network4+" - "+br1+"."+br2+"."+br3+"."+br4);
		
		//Ingreso a la DB
		DB db = DB.getInstances();
		
		String ipAddress = this.ip1.getText()+"."+this.ip2.getText()+"."+this.ip3.getText()+"."
		+this.ip4.getText()+"/"+this.mask.getText();
		
		Object [] obj = {ipAddress, rA.getText(), rB.getText(), rC.getText(), rD.getText(), rE.getText(), 
				rF1.getText(), rF2.getText(), rF3.getText(), rF4.getText()};
		
		System.out.println(ipAddress);
		
		db.dbPrepareStatement("insert into ip(ip_address, priv_public, clase, apipa, reservada, uni_multi_broad, "
		+ "network_address, gateway, broadcast, rango) values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", obj );
	}
	}
	
	public JPanel getJPanel() {
		return panel;
	}
}
