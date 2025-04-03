package teclado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Teclado extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Random rand = new Random();


	char[] abecedarioMinusculas = { 
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
			'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	JLabel[] labels = new JLabel[abecedarioMinusculas.length];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teclado frame = new Teclado();
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
	public Teclado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 702, 562);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 64));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 2, 0, 0));

		addKeyListener(this);

		JLabel lblNewLabel = new JLabel("Esperando:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);

		JLabel label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(3, 9, 0, 0));


		// con un for creamos todos los labels
		for (int i = 0; i < abecedarioMinusculas.length; i++) {
			//convertimos los char en  string
			labels[i] = new JLabel(String.valueOf(abecedarioMinusculas[i]));
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			labels[i].setOpaque(true);
			labels[i].setBackground(new Color(192, 192, 192));
			Border bordes = new LineBorder(Color.black, 1);
			labels[i].setBorder(bordes);
			panel_1.add(labels[i]);
		}

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 64, 64));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Espacio");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Borrando");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		panel_2.add(lblNewLabel_2);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}	

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Código de tecla presionada: " + e.getKeyCode());
		System.out.println("Código de tecla presionada: " + e.getKeyChar());

		//recibimos el numero de la tecla seleccionada
		int letraNumero = e.getKeyCode();

		// lo combertimos a char y le sumamos 32 para que se minusculas siempre dara un numero 
		// en minusculas
		char letraMinuscula = (char) (letraNumero + 32);

		// se crean los colores de RGB
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		Color randomColor = new Color(r, g, b);

		// hacemos un for para recorrer todo
		for (int i = 0; i < abecedarioMinusculas.length; i++) {
			if (abecedarioMinusculas[i] == letraMinuscula) {
				labels[i].setBackground(randomColor);
			} else
				labels[i].setBackground(new Color(192, 192, 192));

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
