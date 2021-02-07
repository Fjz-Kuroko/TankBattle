package userManager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class Log extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;///?????
	private JPanel contentPane;
	private JTextField nameText;
	private JPasswordField pwdText;
	
	
	public Connection conn = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Log frame = new Log();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Log() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		nameLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		nameLabel.setBounds(91, 58, 64, 26);
		contentPane.add(nameLabel);
		
		JLabel passwordLabel = new JLabel("\u5BC6 \u7801\uFF1A");
		passwordLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		passwordLabel.setBounds(91, 108, 54, 15);
		contentPane.add(passwordLabel);
		
		nameText = new JTextField();
		nameText.setFont(new Font("宋体", Font.PLAIN, 14));
		nameText.setBounds(179, 60, 142, 21);
		contentPane.add(nameText);
		nameText.setColumns(10);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = nameText.getText();
				String pwd = String.valueOf(pwdText.getPassword());
				try {
					conn = Db.getConnection();
					String sql = "select * from javalogin where name=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, userName);
					ps.execute();
					ResultSet rs = ps.executeQuery(); 
					if(rs.next()){
						if(pwd.equals(rs.getString(3))){
							System.out.println("登陆成功");
							UserInfo userInfo = new UserInfo();
							userInfo.setLocationRelativeTo(null);
							userInfo.setVisible(true);
							userInfo.getTextId().setText(rs.getString(1));
							userInfo.getTextName().setText(rs.getString(2));
							userInfo.getTextPwd().setText(rs.getString(3));
							//隐藏并关闭当前窗口
							setVisible(false);
							dispose();
						}
						else{
							JOptionPane.showMessageDialog(null, "用户密码错误", "Error", JOptionPane.ERROR_MESSAGE); 
						}
					}
					else{
						int option = JOptionPane.showConfirmDialog(null, "该用户不存在，你想要注册此用户吗？", "提示",JOptionPane.INFORMATION_MESSAGE);
						if(option == JOptionPane.YES_OPTION){
							Register register = new Register();
							register.setLocationRelativeTo(null);
							register.setVisible(true);
						}
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "未知错误！", "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		});
		btnLogin.setFont(new Font("宋体", Font.PLAIN, 14));
		btnLogin.setBounds(99, 169, 79, 38);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nameText.setText("");
				pwdText.setText("");
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 14));
		btnCancel.setBounds(253, 169, 79, 38);
		contentPane.add(btnCancel);
		
		pwdText = new JPasswordField();
		pwdText.setBounds(179, 105, 142, 21);
		contentPane.add(pwdText);
	}
}
