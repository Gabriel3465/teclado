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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Teclado extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Random rand = new Random();
	JLabel label;
	JLabel lblNewLabel;
	JLabel lblNewLabel_3;
	
	int randomNum;
	Timer timer;
	
	// aqui se guarda la palabra que esta escribiendo
	String palabraCompletar = "";
	
	//se guardan las palabras
	ArrayList<String> palabras = new ArrayList<String>(); 
	
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
		
		palabras.add("como");
		palabras.add("pastel");
		palabras.add("casa");
		palabras.add("navidad");
		palabras.add("mes");
		palabras.add("diente");
		palabras.add("casa");
		palabras.add("perro");
		palabras.add("libro");
		palabras.add("sol");
		palabras.add("agua");
		palabras.add("flor");
		palabras.add("mesa");
		palabras.add("luz");
		palabras.add("tiempo");
		palabras.add("voz");
		palabras.add("correr");
		palabras.add("saltar");
		palabras.add("leer");
		palabras.add("escribir");
		palabras.add("dormir");
		palabras.add("grande");
		palabras.add("pequeño");
		palabras.add("rápido");
		palabras.add("feliz");
		palabras.add("claro");
		

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 64));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(2, 2, 0, 0));

		addKeyListener(this);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel);
		
		lblNewLabel_3 = new JLabel("0:0");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel.add(lblNewLabel_3);

		label = new JLabel("0");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(label);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel_4);

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
		
	    randomNum = rand.nextInt((palabras.size()) + 1);
		label.setText(palabras.get(randomNum));
		
	    timer = new Timer(100, taskPerfomer);
	}
	
	
	private int seg = 1;

	
	// temporizador
	ActionListener taskPerfomer = new ActionListener() {
		@Override
	public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] split_string = lblNewLabel_3.getText().split(":");
			int mil = Integer.parseInt(split_string[1]);
			mil += 1;

			if (mil >= 10) {
				seg++;
				mil = 1;
			}
			
			lblNewLabel_3.setText(seg+":"+mil+"");
		}
		
	};
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}	
	


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
				
		timer.start();
		
		// se crean los colores de RGB
		float r = rand.nextFloat();
		float g = rand.nextFloat();
		float b = rand.nextFloat();
		
		//convertimos las letras a minisculas
	    char letraMinuscula = Character.toLowerCase(e.getKeyChar()); // Convertir a minúscula

	    //declaramos el color creado por los ramdom
		Color randomColor = new Color(r, g, b);
		
		//se guardan las letras presionadas
		palabraCompletar = palabraCompletar+e.getKeyChar();
		lblNewLabel.setText(""+palabraCompletar);

		// hacemos un for para recorrer todo
		for (int i = 0; i < abecedarioMinusculas.length; i++) {
			if (abecedarioMinusculas[i] == letraMinuscula) {
				labels[i].setBackground(randomColor);
			} else
				labels[i].setBackground(new Color(192, 192, 192));
		}
		
		// Comparamos la palabra que se muestra con la que esta que esta escribiendo
		if (palabras.get(randomNum).equals(palabraCompletar)) {
			timer.stop();
			int opcion = JOptionPane.showOptionDialog(null, "Se acabo", "Fin del Juego", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE, null, new String[] { "Reiniciar", "Salir" }, "Reiniciar");
			if (opcion == JOptionPane.YES_OPTION) {
				// volvemos a hacer le ramdom para las palabras
				randomNum = rand.nextInt((palabras.size()) + 1);
				label.setText(palabras.get(randomNum));

				// vaciamos donde se guarda la palabra que esta escribiendo
				palabraCompletar = "";
				lblNewLabel.setText("");

				// reiniciamos el tiempo
				seg = 0;
				lblNewLabel_3.setText("0:0");
				
				// pones los colores por defecto
				for (int i = 0; i < abecedarioMinusculas.length; i++) {
					labels[i].setBackground(new Color(192, 192, 192));
				}

			} else {
				System.exit(0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
