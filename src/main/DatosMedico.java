package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DatosMedico {
	private boolean validarMedico(String codMedico) {
		if((Integer.parseInt(codMedico)<1 || Integer.parseInt(codMedico)>100) || codMedico.equals(""))
			return true;
		return false;
	}
	
	public DatosMedico() {
		// Creamos Ventana
		JFrame registro = new JFrame();
		registro.setBounds(100, 100, 600, 360);
		registro.setLocationRelativeTo(null);
		registro.setVisible(true);
		registro.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/img_medico.jpg")));
		registro.setTitle("Centro M\u00E9dico Unlam");
		
		// Definimos Panel de la ventana
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 64, 81));
		
		// Definimos componentes
		JLabel titulo = new JLabel("Registro: Datos del M?dico");
		titulo.setBounds(50, 20, 400, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblCodMedico = new JLabel("C?digo del M?dico: ");
		JTextField textCodMedico = new JTextField();
		lblCodMedico.setBounds(50, 80, 150, 20);
		textCodMedico.setBounds(190, 80, 300, 20);
		lblCodMedico.setForeground(Color.WHITE);
		
		JLabel lblNombreMedico = new JLabel("Nombre del M?dico: ");
		JTextField textNombreMedico = new JTextField();
		lblNombreMedico.setBounds(50, 120, 150, 20);
		textNombreMedico.setBounds(190, 120, 300, 20);
		lblNombreMedico.setForeground(Color.WHITE);
		
		JLabel lblEspecialidad = new JLabel("Especialidad del M?dico:");
		JTextField textEspecialidad = new JTextField();
		lblEspecialidad.setBounds(50, 160, 150, 20);
		textEspecialidad.setBounds(190, 160, 300, 20);
		lblEspecialidad.setForeground(Color.WHITE);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Aceptar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acci?n del bot?n Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codMedico = textCodMedico.getText();
				String nombreMedico = textNombreMedico.getText();
				String especialidad = textEspecialidad.getText();
				
				if(validarMedico(codMedico)) {
					JOptionPane.showMessageDialog(null, "C?digo m?dico inv?lido", "Registro Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(nombreMedico.equals("")) {
						JOptionPane.showMessageDialog(null, "Nombre del m?dico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if(especialidad.equals("")) {
							JOptionPane.showMessageDialog(null, "Especialidad del m?dico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								DataOutputStream datomed = null;
								datomed = new DataOutputStream(new FileOutputStream("datomed.txt"));
								datomed.writeUTF(codMedico);
								datomed.writeUTF(nombreMedico);
								datomed.writeUTF(especialidad);
								datomed.close();
							} catch (IOException ioe) {
								JOptionPane.showMessageDialog(null, "Error interno de la aplicaci?n.", "Registro Error", JOptionPane.ERROR_MESSAGE);
							}
							registro.dispose();
						}
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton();
		btnCancelar.setText("Volver");
		btnCancelar.setBounds(180, 240, 100, 20);
		// Acci?n del bot?n Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro.dispose();
			}
		});
		
		
		// Agregamos componentes al panel
		panel.add(titulo, BorderLayout.NORTH);
		panel.add(lblCodMedico);
		panel.add(textCodMedico);
		panel.add(lblNombreMedico);
		panel.add(textNombreMedico);
		panel.add(lblEspecialidad);
		panel.add(textEspecialidad);
		panel.add(btnRegistrar);
		panel.add(btnCancelar);
		registro.setContentPane(panel);
	}
}
