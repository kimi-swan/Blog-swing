package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import beans.Usuario;

import javax.swing.JLabel;

public class Panel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel frame = new Panel();
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
	public Panel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblbienvenido = new JLabel("New label");
		contentPane.add(lblbienvenido, BorderLayout.NORTH);
		
		
		String nombre;
		String apellido;
		
		Usuario usu=new Usuario();
		
		nombre=usu.getNombre();
		apellido=usu.getApellido();
		
		lblbienvenido.setText("Bienvenido " + nombre +" "+ apellido);
		
		
		
	}

}
