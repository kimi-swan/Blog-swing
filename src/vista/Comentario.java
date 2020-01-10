package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Comentario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Comentario frame = new Comentario();
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
	public Comentario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese su nuevo comentario:");
		lblNewLabel.setBounds(21, 26, 162, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea txacomentario = new JTextArea();
		txacomentario.setBounds(52, 51, 324, 136);
		contentPane.add(txacomentario);
		
		JButton btnvolver = new JButton("Volver al Panel");
		btnvolver.setBounds(21, 215, 110, 23);
		contentPane.add(btnvolver);
		
		JButton btnaceptar = new JButton("Aceptar");
		btnaceptar.setBounds(319, 215, 89, 23);
		contentPane.add(btnaceptar);
	}
}
