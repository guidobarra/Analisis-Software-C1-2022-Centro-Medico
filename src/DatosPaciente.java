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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DatosPaciente {
	public DatosPaciente() {
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
		JLabel titulo = new JLabel("Registro: Datos del Paciente");
		titulo.setBounds(50, 20, 400, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblCodPaciente = new JLabel("Código del Paciente: ");
		JTextField textCodPaciente = new JTextField();
		lblCodPaciente.setBounds(50, 80, 150, 20);
		textCodPaciente.setBounds(190, 80, 300, 20);
		lblCodPaciente.setForeground(Color.WHITE);
		
		JLabel lblNombrePaciente = new JLabel("Nombre Paciente: ");
		JTextField textNombrePaciente = new JTextField();
		lblNombrePaciente.setBounds(50, 120, 150, 20);
		textNombrePaciente.setBounds(190, 120, 300, 20);
		lblNombrePaciente.setForeground(Color.WHITE);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Registrar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acción del botón Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codPaciente = textCodPaciente.getText();
				String nombrePaciente = textNombrePaciente.getText();
				
				if(codPaciente.equals("")) {
					JOptionPane.showMessageDialog(null, "Código paciente sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(nombrePaciente.equals("")) {
						JOptionPane.showMessageDialog(null, "Nombre paciente sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
					}else {
						try {
							DataOutputStream datopac = null;
							datopac = new DataOutputStream(new FileOutputStream("datopac.txt"));
							datopac.writeUTF(codPaciente);
							datopac.writeUTF(nombrePaciente);
							datopac.close();
						} catch (IOException ioe) {
							JOptionPane.showMessageDialog(null, "Error interno de la aplicación.", "Registro Error", JOptionPane.ERROR_MESSAGE);
						}
						registro.dispose();
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
		panel.add(lblCodPaciente);
		panel.add(textCodPaciente);
		panel.add(lblNombrePaciente);
		panel.add(textNombrePaciente);
		panel.add(btnRegistrar);
		panel.add(btnCancelar);
		registro.setContentPane(panel);
	}
}
