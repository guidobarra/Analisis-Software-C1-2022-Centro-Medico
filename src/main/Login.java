package main;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;


public class Login extends JFrame {

	private JPanel contentPane;
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		// Se define Lista con usuarios autorizados a operar
		
		//Usuario usuarioDefault = new Usuario("sergio".toLowerCase(), "1234", "sergio@mail.com");
		//usuarios.add(usuarioDefault);
		
		// Se setean prámetros de la ventana de Login
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/img_medico.jpg")));
		setTitle("Centro M\u00E9dico Unlam");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		setLocationRelativeTo(null);
		
		// Se genera y se setea parámetros del panel 1
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(32, 64, 81));
		
		// Se define titulo principal
		JLabel textoBienvenida = new JLabel("Bienvenido al Centro Médico Unlam");
		textoBienvenida.setBounds(125, 25, 400, 50);
		textoBienvenida.setForeground(Color.WHITE);
		textoBienvenida.setFont(new Font("Arial", Font.BOLD, 20));
		contentPane.add(textoBienvenida, BorderLayout.NORTH);
		
		//Agregamos componentes al panel del Login
		JPanel loginPane = new JPanel();
		loginPane.setLayout(null);
		loginPane.setBounds(125, 125, 350, 300);
		loginPane.setBackground(new Color(202, 232, 213));
		
		// Componente de imagen Login
		JLabel imagen = new JLabel();
		imagen.setVerticalAlignment(SwingConstants.BOTTOM);
		imagen.setIcon(new ImageIcon(Login.class.getResource("/img/img_login.jpg")));
		imagen.setText("Sin Imagen");
		imagen.setBounds(111, 11, 158, 139);
		loginPane.add(imagen);
		
		// Datos del usuario
		JLabel userLabel = new JLabel("Usuario        :");
		userLabel.setBounds(10, 175, 100, 20);
		loginPane.add(userLabel);
		
		JTextField userTextField = new JTextField();
		userTextField.setBounds(100, 175, 200, 20);
		userTextField.setBorder(null);
		loginPane.add(userTextField);
		
		// Datos de la contraseña
		JLabel passwordLabel = new JLabel("Contraseña :");
		passwordLabel.setBounds(10, 215, 100, 20);
		loginPane.add(passwordLabel);
		
		JPasswordField passwordTextField = new JPasswordField();
		passwordTextField.setBounds(100, 215, 200, 20);
		passwordTextField.setBorder(null);
		loginPane.add(passwordTextField);
		
		// Botón Ingresar
		JButton btnIngresar = new JButton();
		// Acción botón Ingresar
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtenemos los datos de los Text Fields
				String usuarioIngresado = userTextField.getText();
				String passwordIngresado = passwordTextField.getText();
				boolean loginOk = false;
				
				// Bucamos que exista en Lisa el usuario y contraseña ingresada
				for (Usuario usuario : usuarios) {
					if(usuarioIngresado.equals(usuario.getUser()) && passwordIngresado.equals(usuario.getPassword())) {
						loginOk = true;
					}
				}
				
				// Resultado de la validación del login
				if(loginOk) {
					// Generamos Menú Principal
					MenuPrincipal menuPrinciapl = new MenuPrincipal();
					dispose();
				}else {
					// Mostramos mensaje de error en Login
					JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña incorrecto", "Login Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnIngresar.setText("Ingresar");
		btnIngresar.setBounds(23, 259, 131, 30);
		loginPane.add(btnIngresar);
		
		contentPane.add(loginPane, BorderLayout.CENTER);
		
		// Definimos botón Registrarse
		JButton btnRegistrarse = new JButton("Registrarse");
		// Acción del botón Registrarse
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Generamos pantalla para Registrar usuario en el sistema
				Registro registro = new Registro();
			}
		});
		btnRegistrarse.setBounds(176, 259, 124, 30);
		loginPane.add(btnRegistrarse);
		setContentPane(contentPane);
	}
	
	public static void altaUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
}
