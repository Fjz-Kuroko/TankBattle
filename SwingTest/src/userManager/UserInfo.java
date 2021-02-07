package userManager;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class UserInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textId = new JTextField();
	private JTextField textName = new JTextField();
	private JPasswordField textPwd = new JPasswordField();
	
	public Connection conn = null;

	public JTextField getTextId() {
		return textId;
	}
	public JTextField getTextName() {
		return textName;
	}
	public JPasswordField getTextPwd() {
		return textPwd;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInfo frame = new UserInfo();
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
	public UserInfo() {
		setTitle("\u7528\u6237\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblID = new JLabel("\u7528\u6237I D\uFF1A");
		lblID.setFont(new Font("宋体", Font.PLAIN, 14));
		lblID.setBounds(65, 66, 63, 23);
		contentPane.add(lblID);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(67, 110, 56, 23);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(65, 163, 70, 23);
		contentPane.add(label_1);
		
		//textId = new JTextField();
		textId.setToolTipText("");
		textId.setEditable(false);
		textId.setFont(new Font("宋体", Font.PLAIN, 14));
		textId.setBounds(168, 62, 148, 32);
		contentPane.add(textId);
		textId.setColumns(10);
		
		//textName = new JTextField();
		textName.setBounds(168, 106, 148, 32);
		contentPane.add(textName);
		textName.setColumns(10);
		
		//textPwd = new JPasswordField();
		textPwd.setBounds(168, 159, 148, 32);
		contentPane.add(textPwd);
		
		JButton btnUpdate = new JButton("\u66F4\u65B0");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textName.getText();
				String userpwd = String.valueOf(textPwd.getPassword());
				int option = JOptionPane.showConfirmDialog(null, "是否修改用户名和密码", "提示",JOptionPane.INFORMATION_MESSAGE);
				if(option == JOptionPane.YES_OPTION){
					try {
						conn = Db.getConnection();
						String updatesql = "update javalogin set name=?,password=? where id=?";
						PreparedStatement ps = conn.prepareStatement(updatesql);
						//设置占位符对应的值
						ps.setString(1,username);
						ps.setString(2,userpwd);
						//指定id
						ps.setString(3,textId.getText());					
						ps.executeUpdate();
						System.out.println("修改数据成功");
						ps.close();
						JOptionPane.showMessageDialog(null, "修改成功");
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, "未知错误！", "Error", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
					
				}
			}
		});
		btnUpdate.setBounds(155, 219, 84, 30);
		contentPane.add(btnUpdate);
	}
}
