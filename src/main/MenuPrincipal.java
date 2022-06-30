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

public class MenuPrincipal {
	public MenuPrincipal() {
		// Creamos Ventana
		JFrame menuPrincipal = new JFrame();
		menuPrincipal.setBounds(100, 100, 600, 400);
		menuPrincipal.setLocationRelativeTo(null);
		menuPrincipal.setVisible(true);
		menuPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/img_medico.jpg")));
		menuPrincipal.setTitle("Centro M\u00E9dico Unlam");
		
		// Definimos Panel de la ventana
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(32, 64, 81));
		
		// Definimos componentes
		JLabel lblTitulo1 = new JLabel("CENTRO MÉDICO UNLAM");
		lblTitulo1.setBounds(140, 20, 400, 50);
		lblTitulo1.setForeground(Color.WHITE);
		lblTitulo1.setFont(new Font("Arial", Font.BOLD, 25));
		
		JLabel lblTitulo2 = new JLabel("MESA DE ADMISIÓN");
		lblTitulo2.setBounds(195, 60, 400, 50);
		lblTitulo2.setForeground(Color.WHITE);
		lblTitulo2.setFont(new Font("Arial", Font.BOLD, 22));
		
		JButton btnIngresoDatos = new JButton();
		btnIngresoDatos.setBounds(200, 140, 200, 35);
		btnIngresoDatos.setText("Ingreso de Datos");
		// Acción del botón Ingreso datos
		btnIngresoDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuIngresoDatos menuIngresoDatos = new MenuIngresoDatos();
				menuPrincipal.dispose();
			}
		});
		
		JButton btnInformes = new JButton();
		btnInformes.setBounds(200, 200, 200, 35);
		btnInformes.setText("Informes");
		// Acción del botón Informes
		btnInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuInformes menuInformes = new MenuInformes();
				menuPrincipal.dispose();
			}
		});
		
		JButton btnSalir = new JButton();
		btnSalir.setBounds(200, 260, 200, 35);
		btnSalir.setText("Salir");
		// Acción del botón Salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPrincipal.dispose();
			}
		});
		
		// Agregamos componentes
		panel.add(lblTitulo1);
		panel.add(lblTitulo2);
		panel.add(btnIngresoDatos);
		panel.add(btnInformes);
		panel.add(btnSalir);
		menuPrincipal.setContentPane(panel);
	}
}
