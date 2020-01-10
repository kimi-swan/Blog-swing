package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Usuario;
import utils.Conexion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtnick;
	private JPasswordField txtpass;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nick:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel.setBounds(55, 88, 79, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a:");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(55, 134, 111, 14);
		contentPane.add(lblNewLabel_1);
		
		txtnick = new JTextField();
		txtnick.setBackground(new Color(255, 255, 255));
		txtnick.setBounds(176, 86, 146, 20);
		contentPane.add(txtnick);
		txtnick.setColumns(10);
		
		txtpass = new JPasswordField();
		txtpass.setBackground(new Color(255, 255, 255));
		txtpass.setBounds(176, 132, 146, 20);
		contentPane.add(txtpass);
		
		JButton btningresar = new JButton("Ingresar");
		btningresar.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btningresar.setBackground(Color.BLACK);
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String nick;
			String pass;
			String nombre="";
			String apellido="";
			String flag="";
		
			nick= txtnick.getText();
			pass= txtpass.getText();
		
			
			Connection con=null;
			
			Conexion cn=new Conexion();
			con=cn.cadena_conexion();
			
			PreparedStatement pr=null;
			ResultSet rs=null;
			PreparedStatement pr2=null;
			ResultSet rs2=null;
			String queryNombre= "Select nombre,apellido from usuario where nick=? and contra=?";
			String queryFlag= "Select COUNT(*) from usuario where nick=? and contra=?";
			
			try {
			pr=con.prepareStatement(queryFlag);
			pr.setString(1, nick);
			pr.setString(2, pass);
			
			rs=pr.executeQuery();
			while (rs.next()) {

				flag=rs.getString(1);
			}
			
			if (flag.equals("1")) {
				
				try {
					Usuario usu=new Usuario();
					pr2=con.prepareStatement(queryNombre);
					pr2.setString(1, nick);
					pr2.setString(2, pass);
					
					rs2=pr2.executeQuery();
					
					while (rs2.next()) {
					nombre=rs2.getString(1);
					apellido=rs2.getString(2);
					}
					usu.setNombre(nombre);
					usu.setApellido(apellido);
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}

				Panel pnl=new Panel();
				pnl.setVisible(true);
				
				JOptionPane.showMessageDialog(btningresar, "Correcto");
			}
			else {
				JOptionPane.showMessageDialog(btningresar, "Incorrecto");
				
			}
			
			pr.close();
			rs.close();
			pr2.close();
			rs2.close();
			con.close();
				
			} catch (Exception e2) {
			
				e2.printStackTrace();
				JOptionPane.showMessageDialog(btningresar,"Ups! Error en la base de datos");
			}
			
			
			}
		});
		btningresar.setBounds(158, 188, 111, 28);
		contentPane.add(btningresar);
		
		JButton btnNewButton_1 = new JButton("Ir a registrar");
		btnNewButton_1.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro rg=new Registro();
			rg.setVisible(true);
				
			}
			
			
		});
		btnNewButton_1.setBounds(303, 227, 121, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 27));
		lblNewLabel_2.setBounds(161, 21, 95, 28);
		contentPane.add(lblNewLabel_2);
	}
}
