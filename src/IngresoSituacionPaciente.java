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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IngresoSituacionPaciente {
	public IngresoSituacionPaciente() {
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
		JLabel titulo = new JLabel("Registro: Situacion del Paciente");
		titulo.setBounds(50, 20, 400, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblCodPaciente = new JLabel("Codigo del Paciente: ");
		JTextField textCodPaciente = new JTextField();
		lblCodPaciente.setBounds(50, 80, 150, 20);
		textCodPaciente.setBounds(190, 80, 300, 20);
		lblCodPaciente.setForeground(Color.WHITE);
		
		JLabel lblCodMedico = new JLabel("Codigo del Medico: ");
		JTextField textCodMedico = new JTextField();
		lblCodMedico.setBounds(50, 120, 150, 20);
		textCodMedico.setBounds(190, 120, 300, 20);
		lblCodMedico.setForeground(Color.WHITE);
		
		JLabel lblDiagnostico = new JLabel("Diagnostico del Medico:");
		JTextArea textDiagnostico = new JTextArea();
		lblDiagnostico.setBounds(50, 160, 150, 20);
		textDiagnostico.setBounds(190, 160, 300, 70);
		lblDiagnostico.setForeground(Color.WHITE);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Registrar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acción del botón Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codPaciente = textCodPaciente.getText();
				String codMedico = textCodMedico.getText();
				String diagnostico = textDiagnostico.getText();
				
				if(codPaciente.equals("")) {
					JOptionPane.showMessageDialog(null, "Codigo paciente sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(codMedico.equals("")) {
						JOptionPane.showMessageDialog(null, "Codigo medico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if(diagnostico.equals("")) {
							JOptionPane.showMessageDialog(null, "Diagnostico sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								DataOutputStream situpac = null;
								situpac = new DataOutputStream(new FileOutputStream("situpac.txt", true));
								situpac.writeUTF(codPaciente);
								situpac.writeUTF(codMedico);
								situpac.writeUTF(diagnostico);
								situpac.close();
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
		panel.add(lblCodPaciente);
		panel.add(textCodPaciente);
		panel.add(lblCodMedico);
		panel.add(textCodMedico);
		panel.add(lblDiagnostico);
		panel.add(textDiagnostico);
		panel.add(btnRegistrar);
		panel.add(btnCancelar);
		registro.setContentPane(panel);
	}
}
