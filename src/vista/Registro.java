package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txttelefono;
	private JTextField txtnick;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNewLabel.setBounds(34, 64, 61, 14);
		contentPane.add(lblNewLabel);
		
		txtnombre = new JTextField();
		txtnombre.setForeground(new Color(0, 0, 0));
		txtnombre.setBackground(new Color(255, 255, 204));
		txtnombre.setBounds(105, 61, 86, 20);
		contentPane.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 103, 61, 14);
		contentPane.add(lblNewLabel_1);
		
		txtapellido = new JTextField();
		txtapellido.setBackground(new Color(255, 255, 204));
		txtapellido.setBounds(105, 97, 86, 20);
		contentPane.add(txtapellido);
		txtapellido.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tel\u00E9fono:");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(224, 64, 68, 14);
		contentPane.add(lblNewLabel_2);
		
		txttelefono = new JTextField();
		txttelefono.setBackground(new Color(255, 255, 204));
		txttelefono.setBounds(302, 60, 96, 20);
		contentPane.add(txttelefono);
		txttelefono.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Nick:");
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(224, 103, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		txtnick = new JTextField();
		txtnick.setBackground(new Color(255, 255, 204));
		txtnick.setBounds(302, 100, 96, 20);
		contentPane.add(txtnick);
		txtnick.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contrase\u00F1a");
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(130, 146, 72, 14);
		contentPane.add(lblNewLabel_4);
		
		txtpass = new JPasswordField();
		txtpass.setBackground(new Color(255, 255, 204));
		txtpass.setBounds(211, 143, 86, 20);
		contentPane.add(txtpass);
		
		JLabel lblNewLabel_5 = new JLabel("REGISTRO");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		lblNewLabel_5.setBounds(161, 11, 105, 22);
		contentPane.add(lblNewLabel_5);
		
		JButton btnvolver = new JButton("Volver al Login");
		btnvolver.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		btnvolver.setBackground(new Color(0, 0, 0));
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login lg=new Login();
				lg.setVisible(true);
			}
		});
		btnvolver.setBounds(10, 227, 113, 23);
		contentPane.add(btnvolver);
		
		JButton btnregistrar = new JButton("Registrar");
		btnregistrar.setFont(new Font("Sitka Text", Font.PLAIN, 11));
		btnregistrar.setBackground(new Color(0, 0, 0));
		btnregistrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String nom;
				String ape;
				String telf;
				String nick; 
				String pass;
			    
				nom=txtnombre.getText();
				ape=txtapellido.getText();
				telf=txttelefono.getText();
				nick=txtnick.getText();
				pass=txtpass.getText();
				
				Connection cn=null;
				Conexion con=new Conexion();
				PreparedStatement pr=null;
				String queryString="insert into usuario (nombre,apellido,telefono,nick,contra) values (?,?,?,?,?)";
				
				try {
				cn= con.cadena_conexion();
				pr=cn.prepareStatement(queryString);
				pr.setString(1, nom);
				pr.setString(2, ape);
				pr.setString(3, telf);
				pr.setString(4, nick);
				pr.setString(5, pass);
				pr.executeUpdate();
				
				cn.close();
				pr.close();
				
				JOptionPane.showMessageDialog(btnregistrar, "Usuario registrado con exito");
				} catch (Exception e2) {
					
					e2.printStackTrace();
				JOptionPane.showMessageDialog(btnregistrar,"Hubo un error con la base de datos, intentelo nuevamente");
				}
					
			}
		});
		btnregistrar.setBounds(208, 189, 89, 23);
		contentPane.add(btnregistrar);
	}
}
