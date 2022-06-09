import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InformeEnfermedadesAtiendeMedico {
	JTextArea textResultado;
	JTextField textCodMedico;
	
	public InformeEnfermedadesAtiendeMedico() {
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
		JLabel titulo = new JLabel("Informes: Enfermedades que atiende el medico");
		titulo.setBounds(50, 20, 450, 50);
		titulo.setForeground(Color.WHITE);
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblCodMedico = new JLabel("Codigo Medico a Consultar: ");
		textCodMedico = new JTextField();
		lblCodMedico.setBounds(50, 80, 200, 20);
		textCodMedico.setBounds(210, 80, 350, 20);
		lblCodMedico.setForeground(Color.WHITE);
		
		JLabel lblResultado = new JLabel("Resultado consulta:");
		 textResultado = new JTextArea();
		lblResultado.setBounds(50, 120, 150, 20);
		textResultado.setBounds(210, 120, 350, 100);
		lblResultado.setForeground(Color.WHITE);
		textResultado.enable(false);
		textResultado.setForeground(Color.WHITE);
		textResultado.setBackground(new Color(32, 64, 81));
		
		JButton btnRegistrar = new JButton();
		btnRegistrar.setText("Consultar");
		btnRegistrar.setBounds(50, 240, 100, 20);
		// Acción del botón Registrar
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listarEnfermedadesAtiendeMedico();
				/*
				 * String codtem = textCodMedico.getText(); String codm = ""; String nomm = "";
				 * String espm = ""; String codp = ""; String codme = ""; String enfp = ""; int
				 * sw = 0; int sw1 = 0; String texto = ""; textResultado.setText(texto);
				 * 
				 * if(codtem.equals("")) { mensajeError("Codigo Medico sin ingresar",
				 * "Consulta Error"); }else { try { DataInputStream datomed = null; datomed =
				 * new DataInputStream(new FileInputStream("datomed.txt"));
				 * 
				 * sw1 = 1; while (sw1 != 0) {
				 * 
				 * try { codm = datomed.readUTF(); nomm = datomed.readUTF(); espm =
				 * datomed.readUTF(); }catch (IOException ex) { sw1=0; }
				 * 
				 * if (codm.equals(codtem) && sw1 != 0) // compara el codigo digitado // con el
				 * codigo del medico de la // tabla "datomed" { texto += "El medico " + nomm +
				 * " trata las siguientes enfermedades:" + "\n"; textResultado.setText(texto);
				 * 
				 * DataInputStream situpac = null; situpac = new DataInputStream(new
				 * FileInputStream("situpac.txt"));
				 * 
				 * sw = 1; while (sw != 0) { try { codp = situpac.readUTF(); codme =
				 * situpac.readUTF(); enfp = situpac.readUTF();
				 * 
				 * if (codtem.equals(codme)) // compara el codigo del medico // de la tabla
				 * "datomed" // con el codigo del medico en la // tabla "situpac"
				 * 
				 * { texto += ">>>> " + enfp + "\n"; textResultado.setText(texto); } } catch
				 * (EOFException ex) { sw = 0; } } } } } catch (IOException ioe) {
				 * mensajeError("Error interno de la aplicacion.", "Consulta Error"); }
				 * if(texto.equals("")) { mensajeAviso("No hay datos para mostrar", "Consulta");
				 * } }
				 */
			}
		});
		
		JButton btnCancelar = new JButton();
		btnCancelar.setText("Regresar");
		btnCancelar.setBounds(180, 240, 100, 20);
		// Acción del botón Regresar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registro.dispose();
			}
		});
		
		
		// Agregamos componentes al panel
		panel.add(titulo, BorderLayout.NORTH);
		panel.add(lblCodMedico);
		panel.add(textCodMedico);
		panel.add(lblResultado);
		panel.add(textResultado);
		panel.add(btnRegistrar);
		panel.add(btnCancelar);
		registro.setContentPane(panel);
	}
	
	public void listarEnfermedadesAtiendeMedico() {
		String codtem = textCodMedico.getText();
		String codm = "";
		String nomm = "";
		String espm = "";
		String codp = "";
		String codme = "";
		String enfp = "";
		int sw = 0;
		int sw1 = 0;
		String texto = "";
		textResultado.setText(texto);
		
		if(codtem.equals("")) {
			mensajeError("Codigo Medico sin ingresar", "Consulta Error");
		}else {
			try {
				DataInputStream datomed = null;
				datomed = new DataInputStream(new FileInputStream("datomed.txt"));
				
				sw1 = 1;
				while (sw1 != 0) {

					try {
						codm = datomed.readUTF();
						nomm = datomed.readUTF();
						espm = datomed.readUTF();
					}catch (IOException ex) {
						sw1=0;
					}

					if (codm.equals(codtem) && sw1 != 0) // compara el codigo digitado
												// con el codigo del medico de la
												// tabla "datomed"
					{
						texto += "El medico " + nomm + " trata las siguientes enfermedades:" + "\n";
						textResultado.setText(texto);
						
						DataInputStream situpac = null;
						situpac = new DataInputStream(new FileInputStream("situpac.txt"));

						sw = 1;
						while (sw != 0) {
							try {
								codp = situpac.readUTF();
								codme = situpac.readUTF();
								enfp = situpac.readUTF();

								if (codtem.equals(codme)) // compara el codigo del medico
															// de la tabla "datomed"
															// con el codigo del medico en la
															// tabla "situpac"

								{
									texto += ">>>> " + enfp + "\n";
									textResultado.setText(texto);
								}
							} catch (EOFException ex) {
								sw = 0;
							}
						}
					}
				}
			} catch (IOException ioe) {
				mensajeError("Error interno de la aplicacion.", "Consulta Error");
			}
			if(texto.equals("")) {
				mensajeAviso("No hay datos para mostrar", "Consulta");
			}
		}
	}
	
	public void mensajeError(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensajeAviso(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
}
