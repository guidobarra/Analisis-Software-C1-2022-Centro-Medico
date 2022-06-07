import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registro {
	public Registro() {
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
		JLabel titulo = new JLabel("Registro: Ingrese sus datos");
		titulo.setBounds(50, 20, 400, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		JTextField textUsuario = new JTextField();
		lblUsuario.setBounds(50, 80, 100, 20);
		textUsuario.setBounds(170, 80, 300, 20);
		lblUsuario.setForeground(Color.WHITE);
		
		JLabel lblContraseña = new JLabel("Contraseña: ");
		JPasswordField textContraseña = new JPasswordField();
		lblContraseña.setBounds(50, 120, 100, 20);
		textContraseña.setBounds(170, 120, 300, 20);
		lblContraseña.setForeground(Color.WHITE);
		
		JLabel lblContraseñaR = new JLabel("Repita Contraseña:");
		JPasswordField textContraseñaR = new JPasswordField();
		lblContraseñaR.setBounds(50, 160, 120, 20);
		textContraseñaR.setBounds(170, 160, 300, 20);
		lblContraseñaR.setForeground(Color.WHITE);
		
		JLabel lblMail = new JLabel("Mail: ");
		JTextField textMail = new JTextField();
		lblMail.setBounds(50, 200, 100, 20);
		textMail.setBounds(170, 200, 300, 20);
		lblMail.setForeground(Color.WHITE);
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Registrar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acción del botón Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = textUsuario.getText();
				String contraseña = textContraseña.getText();
				String contraseñaR = textContraseñaR.getText();
				String mail = textMail.getText();
				
				if(usuario.equals("")) {
					JOptionPane.showMessageDialog(null, "Usuario sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if(contraseña.equals("")) {
						JOptionPane.showMessageDialog(null, "Contraseña sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
					}else {
						if(!contraseña.equals(contraseñaR)) {
							JOptionPane.showMessageDialog(null, "Contraseñas no coinciden", "Registro Error", JOptionPane.ERROR_MESSAGE);
						}else {
							if(mail.equals("")) {
								JOptionPane.showMessageDialog(null, "Mail sin informar", "Registro Error", JOptionPane.ERROR_MESSAGE);
							}else {
								Login.altaUsuario(new Usuario(usuario, contraseña, mail));
								registro.dispose();
							}
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
		panel.add(lblUsuario);
		panel.add(textUsuario);
		panel.add(lblContraseña);
		panel.add(textContraseña);
		panel.add(lblContraseñaR);
		panel.add(textContraseñaR);
		panel.add(lblMail);
		panel.add(textMail);
		panel.add(btnRegistrar);
		panel.add(btnCancelar);
		registro.setContentPane(panel);
	}
	
}
