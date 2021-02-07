package swingPackages;

import java.awt.*;
import javax.swing.*;

public class SwingDemo {
	
	public void CreateJFrame(String title){
		JFrame jf = new JFrame(title);
		Container container = jf.getContentPane();
		JLabel jl = new JLabel("这是一个JFrame窗体");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		
		container.add(jl);
		container.setBackground(Color.white);
		jf.setVisible(true);
		jf.setSize(500, 500);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new SwingDemo().CreateJFrame("创建窗体");
	}

}
