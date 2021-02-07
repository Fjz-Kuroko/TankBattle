package swingPackages;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class JSQ extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9190094393863886675L;//Ī������
	private JPanel contentPane;
	private JTextField textField;
	
	//����������
	private Calculate calculate;
	//�����û������ʽ��
	private String Formula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSQ frame = new JSQ();
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
	public JSQ() {
		setTitle("\u7B80\u5355\u8BA1\u7B97\u5668");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 459);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//�ı���
		textField = new JTextField();
		textField.setFont(new Font("����", Font.BOLD, 20));
		textField.setToolTipText("");
		textField.setEditable(false);
		textField.setBounds(37, 51, 247, 44);
		contentPane.add(textField);
		textField.setColumns(10);

		
		//����1
		JButton btn1 = new JButton("1");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = textField.getText();
				textField.setText(str+"1");
			}
		});
		btn1.setFont(new Font("����", Font.BOLD, 14));
		btn1.setBounds(37, 188, 44, 44);
		contentPane.add(btn1);
		
		//����2
		JButton btn2 = new JButton("2");
		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"2");
			}
		});
		btn2.setFont(new Font("����", Font.BOLD, 14));
		btn2.setBounds(104, 188, 44, 44);
		contentPane.add(btn2);
		
		//����3
		JButton btn3 = new JButton("3");
		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"3");
			}
		});
		btn3.setFont(new Font("����", Font.BOLD, 14));
		btn3.setBounds(169, 188, 44, 44);
		contentPane.add(btn3);
		
		//����4
		JButton btn4 = new JButton("4");
		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"4");
			}
		});
		btn4.setFont(new Font("����", Font.BOLD, 14));
		btn4.setBounds(37, 242, 44, 44);
		contentPane.add(btn4);
		
		//����5
		JButton btn5 = new JButton("5");
		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"5");
			}
		});
		btn5.setFont(new Font("����", Font.BOLD, 14));
		btn5.setBounds(104, 242, 44, 44);
		contentPane.add(btn5);
		
		//����6
		JButton btn6 = new JButton("6");
		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"6");
			}
		});
		btn6.setFont(new Font("����", Font.BOLD, 14));
		btn6.setBounds(169, 242, 44, 44);
		contentPane.add(btn6);
		
		//����7
		JButton btn7 = new JButton("7");
		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"7");
			}
		});
		btn7.setFont(new Font("����", Font.BOLD, 14));
		btn7.setBounds(37, 296, 44, 44);
		contentPane.add(btn7);
		
		//����8
		JButton btn8 = new JButton("8");
		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"8");
			}
		});
		btn8.setFont(new Font("����", Font.BOLD, 14));
		btn8.setBounds(104, 296, 44, 44);
		contentPane.add(btn8);
		
		//����9
		JButton btn9 = new JButton("9");
		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"9");
			}
		});
		btn9.setFont(new Font("����", Font.BOLD, 14));
		btn9.setBounds(169, 296, 44, 44);
		contentPane.add(btn9);
		
		//����0
		JButton btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"0");
			}
		});
		btn0.setFont(new Font("����", Font.BOLD, 14));
		btn0.setBounds(37, 350, 44, 44);
		contentPane.add(btn0);
		
		//С���㰴ť
		JButton btnDot = new JButton(".");
		btnDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+".");
			}
		});
		btnDot.setFont(new Font("����", Font.BOLD, 14));
		btnDot.setBounds(104, 350, 44, 44);
		contentPane.add(btnDot);
		
		//�Ⱥš�=����ť
		JButton btnEqual = new JButton("=");
		btnEqual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				str = str+"=";
				Formula = str;
				calculate = new Calculate(Formula);
				double rs = calculate.calculation();
				textField.setText(str+" "+rs);
			}
		});
		btnEqual.setFont(new Font("����", Font.BOLD, 14));
		btnEqual.setBounds(169, 350, 44, 44);
		contentPane.add(btnEqual);
		
		//�Ӻš�+����ť
		JButton btnPlus = new JButton("+");
		btnPlus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"+");
			}
		});
		btnPlus.setFont(new Font("����", Font.BOLD, 14));
		btnPlus.setBounds(238, 188, 44, 44);
		contentPane.add(btnPlus);
		
		//���š�-����ť
		JButton btnMinus = new JButton("-");
		btnMinus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"-");
			}
		});
		btnMinus.setFont(new Font("����", Font.BOLD, 14));
		btnMinus.setBounds(238, 242, 44, 44);
		contentPane.add(btnMinus);
		
		//�˺š�*����ť
		JButton btnX = new JButton("*");
		btnX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"*");
			}
		});
		btnX.setFont(new Font("����", Font.BOLD, 14));
		btnX.setBounds(238, 296, 44, 44);
		contentPane.add(btnX);
		
		//���š�/����ť
		JButton btnDivision = new JButton("/");
		btnDivision.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"/");
			}
		});
		btnDivision.setFont(new Font("����", Font.BOLD, 14));
		btnDivision.setBounds(238, 350, 44, 44);
		contentPane.add(btnDivision);		
		
		//�����š�(����ť
		JButton btnLBra = new JButton("(");
		btnLBra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+"(");
			}
		});
		btnLBra.setFont(new Font("����", Font.BOLD, 14));
		btnLBra.setBounds(37, 134, 44, 44);
		contentPane.add(btnLBra);
		
		//�����š�)����ť
		JButton btnRBra = new JButton(")");
		btnRBra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = textField.getText();
				textField.setText(str+")");
			}
		});
		btnRBra.setFont(new Font("����", Font.BOLD, 14));
		btnRBra.setBounds(104, 134, 44, 44);
		contentPane.add(btnRBra);
		
		//ɾ����<---����ť
		JButton btnDel = new JButton("<--");
		btnDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String str = textField.getText();
				if(str.length()>0){
					str = str.substring(0, str.length()-1);
				}
				textField.setText(str);
			}
		});
		btnDel.setFont(new Font("����", Font.BOLD, 14));
		btnDel.setBounds(158, 134, 70, 44);
		contentPane.add(btnDel);
		
		//������C����ť
		JButton btnC = new JButton("C");
		btnC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textField.setText("");
			}
		});
		btnC.setFont(new Font("����", Font.BOLD, 14));
		btnC.setBounds(238, 134, 44, 44);
		contentPane.add(btnC);
	}
}
