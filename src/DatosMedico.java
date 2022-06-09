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
		JLabel titulo = new JLabel("Registro: Datos del Medico");
		titulo.setBounds(50, 20, 400, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblCodMedico = new JLabel("Codigo del Medico: ");
		JTextField textCodMedico = new JTextField();
		lblCodMedico.setBounds(50, 80, 150, 20);
		textCodMedico.setBounds(210, 80, 300, 20);
		lblCodMedico.setForeground(Color.WHITE);
		
		JLabel lblNombreMedico = new JLabel("Nombre del Medico: ");
		JTextField textNombreMedico = new JTextField();
		lblNombreMedico.setBounds(50, 120, 150, 20);
		textNombreMedico.setBounds(210, 120, 300, 20);
		lblNombreMedico.setForeground(Color.WHITE);
		
		JLabel lblEspecialidad = new JLabel("Especialidad del Medico:");
		JTextField textEspecialidad = new JTextField();
		lblEspecialidad.setBounds(50, 160, 150, 20);
		textEspecialidad.setBounds(210, 160, 300, 20);
		lblEspecialidad.setForeground(Color.WHITE);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Registrar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acción del botón Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codMedico = textCodMedico.getText();
				String nombreMedico = textNombreMedico.getText();
				String especialidad = textEspecialidad.getText();
				
				if(codMedico.equals("")) {
					JOptionPane.showMessageDialog(null, "Codigo medico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(nombreMedico.equals("")) {
						JOptionPane.showMessageDialog(null, "Nombre del medico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if(especialidad.equals("")) {
							JOptionPane.showMessageDialog(null, "Especialidad del medico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								DataOutputStream datomed = null;
								datomed = new DataOutputStream(new FileOutputStream("datomed.txt", true));
								datomed.writeUTF(codMedico);
								datomed.writeUTF(nombreMedico);
								datomed.writeUTF(especialidad);
								datomed.close();
							} catch (IOException ioe) {
								JOptionPane.showMessageDialog(null, "Error interno de la aplicacion.", "Registro Error", JOptionPane.ERROR_MESSAGE);
							}
							registro.dispose();
						}
					}
				}
			}
		});
		
		JButton btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(180, 240, 100, 20);
		// Acción del botón Cancelar
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
