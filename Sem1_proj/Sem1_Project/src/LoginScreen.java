
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;




public class LoginScreen implements ActionListener{
	
	private JButton login;
	private JButton register;
	private JTextField txt;
	private JPasswordField txt2;
	private String Txt;
	private Box b0;
	private Box b1;
	private JLabel Email;
	private JLabel password;
	private JPanel loginfields;
	private JPanel buttons;
	private Select_Hotel selhotel;
	JFrame frame;
	Container cp;

	public LoginScreen(Select_Hotel hotel) {
		frame = new JFrame();
		frame.setTitle("Login");
		
		cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		
		loginfields = new JPanel();
		loginfields.setBorder(BorderFactory.createTitledBorder("Enter Details Here:"));
		
		selhotel = hotel;
		
		b0 = new Box (BoxLayout.Y_AXIS);
		b1 = new Box (BoxLayout.Y_AXIS);
		
		login = new JButton("Login");
		login.addActionListener(this);
		
		register = new JButton("Register");
		register.addActionListener(this);
		
		txt = new JTextField(20);
		txt2 = new JPasswordField(20);
		
		Email = new JLabel("Email:");
		password = new JLabel("Password:");
		
		txt2.setEchoChar('*');
		
		b0.add(txt);
		b0.add(txt2);
		
		b1.add(Email);
		b1.add(password);
		
		loginfields.add(b1);
		loginfields.add(b0);
		
		buttons = new JPanel();
		buttons.add(login);
		buttons.add(register);
		
		
		cp.add(loginfields);
		cp.add(buttons);
		
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == login){	
			
			String name = txt.getText().toString();
			String password = txt2.getText().toString();
			
		
			if(name.equals("shanebar@live.ie") &&  password.equals("hello123")) {
			
				String Txt = "yes";
				selhotel.setTheText(Txt);//added
				frame.setVisible(false);
				
				
			} else
			{
				
				
				JOptionPane.showMessageDialog(null, "Details Incorrect! Please Try Again", "Warning",JOptionPane.WARNING_MESSAGE);
			
			}
			
		}
		
		if(e.getSource() == register){	
			
			
			
			
			JOptionPane.showMessageDialog(null, "Feature not available yet!", "Warning",JOptionPane.WARNING_MESSAGE);
			
			
		}
		
		
		
		
		
	}

	
	public void hide()
	{
		frame.setVisible(false);
	}
	
	public void show()
	{
		frame.setVisible(true);
	}

	
	
}

