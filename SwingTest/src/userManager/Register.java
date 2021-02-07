package userManager;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textId;
	private JTextField textName;
	
	public Connection conn = null;
	private JPasswordField textPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u6CE8\u518C");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.BOLD, 30));
		label.setBounds(145, 10, 136, 47);
		contentPane.add(label);
		
		JLabel lbliD = new JLabel("\u7528\u6237I D\uFF1A");
		lbliD.setFont(new Font("宋体", Font.PLAIN, 14));
		lbliD.setBounds(84, 81, 63, 26);
		contentPane.add(lbliD);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(84, 127, 63, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(77, 185, 70, 26);
		contentPane.add(lblNewLabel_1);
		
		textId = new JTextField();
		textId.setBounds(178, 77, 155, 36);
		contentPane.add(textId);
		textId.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(178, 123, 155, 36);
		contentPane.add(textName);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userId = textId.getText();
				String userName = textName.getText();
				String userPwd = String.valueOf(textPwd.getPassword());
				//判断id格式
				boolean flag = false;
				if((userId.charAt(0))=='N'&&(userId.charAt(1))=='H'&&userId.length()==7){				
					for(int i=2;i<userId.length();i++){
						if((userId.charAt(i)>='0')&&(userId.charAt(i)<='9')){
							flag = true;
						}
						else{
							flag = false;
							break;
						}
					}
					if(!flag){
						JOptionPane.showMessageDialog(null, "ID格式不正确！", "Error", JOptionPane.ERROR_MESSAGE); 
					}
				}
				else{
					flag = false;
					JOptionPane.showMessageDialog(null, "ID格式不正确！", "Error", JOptionPane.ERROR_MESSAGE); 
				}
				if(flag){
					try {
						conn = Db.getConnection();
						String sql = "select * from javalogin where id=?";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, userId);
						ps.execute();
						ResultSet rs = ps.executeQuery(); 
						if(rs.next()){//判断ID是否存在
							JOptionPane.showMessageDialog(null, "该ID已存在", "Error", JOptionPane.ERROR_MESSAGE); 
						}
						else{
							String insertsql = "insert into javalogin(id,name,password)values(?,?,?)";
							ps = conn.prepareStatement(insertsql);
							//设置占位符对应的值
							ps.setString(1,userId);
							ps.setString(2,userName);
							ps.setString(3,userPwd);		
							ps.executeUpdate();
							System.out.println("数据插入成功");
							ps.close();		
							JOptionPane.showMessageDialog(null, "注册成功！");
						
							//打开登录页面
							Log login = new Log();
							login.setLocationRelativeTo(null);
							login.setVisible(true);
							
							//隐藏并关闭当前窗口
							setVisible(false);
							dispose();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		btnRegister.setFont(new Font("宋体", Font.PLAIN, 14));
		btnRegister.setBounds(165, 239, 86, 39);
		contentPane.add(btnRegister);
		
		JLabel lblNewLabel_2 = new JLabel("\u6CE8\uFF1A\u7528\u6237id\u5FC5\u662FNH+5\u4F4D\u6570\u5B57\uFF0C\u4E14\u552F\u4E00");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(123, 289, 230, 15);
		contentPane.add(lblNewLabel_2);
		
		textPwd = new JPasswordField();
		textPwd.setFont(new Font("宋体", Font.PLAIN, 14));
		textPwd.setBounds(178, 180, 155, 36);
		contentPane.add(textPwd);
	}

}
