package swingPackages;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Demo1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2852436712455994245L;

	public class KeyListen implements KeyListener {

		public KeyListen() {
			System.out.println("按");
		}

		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("按键"+e.getExtendedKeyCode());

		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按键按下"+e.getExtendedKeyCode());

		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("按键松开"+e.getExtendedKeyCode());

		}

	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo1 frame = new Demo1();
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
	public Demo1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.addKeyListener(new KeyListen());
	}
}
