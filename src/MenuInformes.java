import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuInformes {
	public MenuInformes() {
		// Creamos Ventana
		JFrame menuInformes = new JFrame();
		menuInformes.setBounds(100, 100, 600, 450);
		menuInformes.setLocationRelativeTo(null);
		menuInformes.setVisible(true);
		menuInformes.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/img_medico.jpg")));
		menuInformes.setTitle("Centro M\u00E9dico Unlam");
		
		// Definimos Panel de la ventana
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 64, 81));
		
		// Definimos componentes
		JLabel lblTitulo1 = new JLabel("CENTRO MÉDICO UNLAM");
		lblTitulo1.setBounds(140, 20, 400, 50);
		lblTitulo1.setForeground(Color.WHITE);
		lblTitulo1.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblTitulo2 = new JLabel("CONTROL DE PACIENTES - INFORMES");
		lblTitulo2.setBounds(65, 60, 500, 50);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setFont(new Font("Arial", Font.BOLD, 25));
		
		JButton btnListadoPacientes = new JButton();
		btnListadoPacientes.setBounds(170, 140, 250, 35);
		btnListadoPacientes.setText("Listado de Pacientes P/ Médico");
		// Acción del botón Listado de pacientes por médico
		btnListadoPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InformePacienteMedico();
			}
		});
		
		JButton btnEnfermedadesAtieneMedico = new JButton();
		btnEnfermedadesAtieneMedico.setBounds(170, 200, 250, 35);
		btnEnfermedadesAtieneMedico.setText("Enfermedades que Atiende C/ Médico");
		// Acción del botón Enfermedades que atiende cada médico
		btnEnfermedadesAtieneMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InformeEnfermedadesAtiendeMedico();
			}
		});
		
		JButton btnVolver = new JButton();
		btnVolver.setBounds(170, 260, 250, 35);
		btnVolver.setText("Volver");
		// Acción del botón Volver
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuInformes.dispose();
			}
		});
		
		// Agregamos componentes
		panel.add(lblTitulo1);
		panel.add(lblTitulo2);
		panel.add(btnListadoPacientes);
		panel.add(btnEnfermedadesAtieneMedico);
		panel.add(btnVolver);
		menuInformes.setContentPane(panel);
	}
}
