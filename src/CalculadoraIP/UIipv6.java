package CalculadoraIP;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class UIipv6 {

	private JPanel panel = new JPanel();
	private JTextField ip1;
	private JTextField ip2;
	private JTextField ip3;
	private JTextField ip4;
	private JTextField ip5;
	private JTextField ip6;
	private JTextField ip7;
	private JTextField ip8;
	private JTextField prefix;
	private JLabel rA;

	
	/**
	 * Create the panel.
	 */
	public UIipv6() {
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.setBounds(201, 302, 97, 25);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI ui = new UI();
				UI.frame.setContentPane(ui.getJPanel());
				UI.frame.revalidate();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Calculadora de IPv6");
		lblNewLabel.setBounds(163, 0, 167, 32);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblNewLabel);
		
		JLabel lblip = new JLabel("Ingrese IP:");
		lblip.setBounds(22, 33, 72, 16);
		panel.add(lblip);
		
		ip1 = new JTextField();
		ip1.setText("0");
		ip1.setBounds(22, 52, 46, 22);
		panel.add(ip1);
		ip1.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip1.setText("");
			}
		});
		
		
		ip2 = new JTextField();
		ip2.setText("0");
		ip2.setBounds(73, 52, 46, 22);
		panel.add(ip2);
		ip2.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip2.setText("");
			}
		});
		
		ip3 = new JTextField();
		ip3.setText("0");
		ip3.setBounds(124, 52, 46, 22);
		panel.add(ip3);
		ip3.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip3.setText("");
			}
		});
		
		ip4 = new JTextField();
		ip4.setText("0");
		ip4.setBounds(176, 52, 46, 22);
		ip4.setColumns(10);
		panel.add(ip4);
		ip4.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip4.setText("");
			}
		});
		
		JLabel lblMask = new JLabel("Prefix:");
		lblMask.setBounds(22, 86, 56, 16);
		panel.add(lblMask);
		
		JLabel lblA = new JLabel("Tipo de ipv6:");
		lblA.setBounds(22, 153, 86, 16);
		panel.add(lblA);
		
		ip5 = new JTextField();
		ip5.setText("0");
		ip5.setColumns(10);
		ip5.setBounds(227, 52, 46, 22);
		panel.add(ip5);
		ip5.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip5.setText("");
			}
		});
		
		ip6 = new JTextField();
		ip6.setText("0");
		ip6.setColumns(10);
		ip6.setBounds(278, 52, 46, 22);
		panel.add(ip6);
		ip6.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip6.setText("");
			}
		});
		
		rA = new JLabel("...");
		rA.setBounds(112, 153, 146, 16);
		panel.add(rA);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculos();
			}
		});
		btnNewButton_1.setBounds(206, 107, 88, 23);
		panel.add(btnNewButton_1);
		
		prefix = new JTextField();
		prefix.setText("64");
		prefix.setBounds(22, 107, 56, 22);
		panel.add(prefix);
		prefix.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				prefix.setText("");
			}
		});
		
		ip7 = new JTextField();
		ip7.setText("0");
		ip7.setColumns(10);
		ip7.setBounds(329, 52, 46, 22);
		panel.add(ip7);
		ip7.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip7.setText("");
			}
		});
		
		ip8 = new JTextField();
		ip8.setText("0");
		ip8.setColumns(10);
		ip8.setBounds(380, 52, 46, 22);
		panel.add(ip8);
		ip8.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				ip8.setText("");
			}
		});

	}
	
	public JPanel getJPanel() {
		return panel;
	}

	private void calculos() {
		
	/*Tipos de ipv6:
	Unspecified              ::/128
	localhost                ::1
	ULA (private ip address) fc00::/7      
	Link Local Address       fe80::/10 	
	Multicast address        ff00::/8
	Documentacion            2001:db8::/32
	
	Unicast, Anyacast, los otros
*/
		//String hex
		String ip1 = this.ip1.getText();
		String ip2 = this.ip2.getText();
		String ip3 = this.ip3.getText();
		String ip4 = this.ip4.getText();
		String ip5 = this.ip5.getText();
		String ip6 = this.ip6.getText();
		String ip7 = this.ip7.getText();
		String ip8 = this.ip8.getText();
		String prefix = this.prefix.getText();
		
		//ip y prefix en int decimal
		int ip1d = Integer.parseInt(ip1, 16);
		int ip2d = Integer.parseInt(ip2, 16);
		int ip3d = Integer.parseInt(ip3, 16);
		int ip4d = Integer.parseInt(ip4, 16);
		int ip5d = Integer.parseInt(ip5, 16);
		int ip6d = Integer.parseInt(ip6, 16);
		int ip7d = Integer.parseInt(ip7, 16);
		int ip8d = Integer.parseInt(ip8, 16);
		int prefixd = Integer.parseInt(prefix);
		
		//Identificacion del tipo de ipv6
	if (ip1d>65535 || ip2d>65535 || ip3d>65535 || ip4d>65535 || ip5d>65535 || ip6d>65535 || ip7d>65535 || ip8d>65535) {
		rA.setText("error");
		
	} else if (ip1d==0 && ip2d==0 && ip3d==0 && ip4d==0 && ip5d==0 && ip6d==0 && ip7d==0 && ip8d==0) {
		rA.setText("Unspecified Address");
		
	} else if (ip1d==0 && ip2d==0 && ip3d==0 && ip4d==0 && ip5d==0 && ip6d==0 && ip7d==0 && ip8d==1){
		rA.setText("Localhost");
		
	} else if (ip1d>=64512 && ip1d<=65023 && prefixd==7){
		rA.setText("ULA (private ip address)");
		
	} else if (ip1d>=65152  && ip1d<=65215 && prefixd==10){
		rA.setText("Link Local Address");
		
	} else if (ip1d>=65280 && prefixd==8){
		rA.setText("Multicast");
		
	} else if (ip1d==8193 && ip2d==3512 && prefixd==32){
		rA.setText("Documentacion Address");
		
	} else {
		rA.setText("Unicast");
	}
	}
}
