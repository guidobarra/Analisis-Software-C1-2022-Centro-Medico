package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuIngresoDatos {
	public MenuIngresoDatos() {
		// Creamos Ventana
		JFrame menuIngresoDatos = new JFrame();
		menuIngresoDatos.setBounds(100, 100, 600, 450);
		menuIngresoDatos.setLocationRelativeTo(null);
		menuIngresoDatos.setVisible(true);
		menuIngresoDatos.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/img_medico.jpg")));
		menuIngresoDatos.setTitle("Centro M\u00E9dico Unlam");
		
		// Definimos Panel de la ventana
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 64, 81));
		
		// Definimos componentes
		JLabel lblTitulo1 = new JLabel("CENTRO MÉDICO UNLAM");
		lblTitulo1.setBounds(140, 20, 400, 50);
		lblTitulo1.setForeground(Color.WHITE);
		lblTitulo1.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblTitulo2 = new JLabel("INGRESO DE DATOS");
		lblTitulo2.setBounds(175, 60, 400, 50);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setFont(new Font("Arial", Font.BOLD, 25));
		
		JButton btnDatosPaciente = new JButton();
		btnDatosPaciente.setBounds(200, 140, 200, 35);
		btnDatosPaciente.setText("Datos del Paciente");
		// Acción del botón Ingreso datos del paciente
		btnDatosPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosPaciente datosPaciente = new DatosPaciente();
			}
		});
		
		JButton btnSituacionPaciente = new JButton();
		btnSituacionPaciente.setBounds(200, 200, 200, 35);
		btnSituacionPaciente.setText("Situación del Paciente");
		// Acción del botón ingreso situación del paciente
		btnSituacionPaciente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresoSituacionPaciente isp = new IngresoSituacionPaciente();
			}
		});
		
		JButton btnDatosMedico = new JButton();
		btnDatosMedico.setBounds(200, 260, 200, 35);
		btnDatosMedico.setText("Datos del Médico");
		// Acción del botón Ingreso datos del médico
		btnDatosMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosMedico dm = new DatosMedico();
			}
		});
		
		JButton btnVolver = new JButton();
		btnVolver.setBounds(200, 320, 200, 35);
		btnVolver.setText("Volver");
		// Acción del botón Volver
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal menuPrincipal = new MenuPrincipal();
				menuIngresoDatos.dispose();
			}
		});
		
		// Agregamos componentes
		panel.add(lblTitulo1);
		panel.add(lblTitulo2);
		panel.add(btnDatosPaciente);
		panel.add(btnSituacionPaciente);
		panel.add(btnDatosMedico);
		panel.add(btnVolver);
		menuIngresoDatos.setContentPane(panel);
	}
}
