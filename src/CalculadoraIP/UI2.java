package CalculadoraIP;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Database.DB;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UI2 {

	private JPanel panel = new JPanel();
	DB db = DB.getInstances();
			
	
	
	/**
	 * Create the panel.
	 */
	public UI2() {
		

		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ricardo Muchacho ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(376, 359, 124, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Registro de Operaciones");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(139, 13, 221, 19);
		panel.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 42, 411, 271);
		panel.add(scrollPane);
		
		db.dbStatement("select *from ip");
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setText(db.resultString);
		
		JButton btnNewButton = new JButton("Regresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI ui = new UI();
				UI.frame.setContentPane(ui.getJPanel());
				UI.frame.revalidate();
			}
		});
		btnNewButton.setBounds(201, 326, 97, 25);
		panel.add(btnNewButton);

	}
	
	public JPanel getJPanel() {
		return panel;
	}
}
