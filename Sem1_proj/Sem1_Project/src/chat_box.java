import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class chat_box implements ActionListener{
	
	private JButton jButton;
	private JButton next;
	private JTextField txt;
	private JTextArea jta1;
	private JPanel txtbtn;
	private chat_box_response mycbr; //added
	private informationpage myinfo;  //added
	private JFrame frame;
	String hotelname;
	int flag = 0;
	
	public chat_box(informationpage info) {
		frame = new JFrame();
		frame.setTitle("ScreenA");
		
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		
		myinfo = info;
		
		jButton = new JButton("SEND");
		jButton.addActionListener(this);
		
		txt = new JTextField(20);
		
		jta1 = new JTextArea();

		txtbtn = new JPanel();
		
		next = new JButton("Next");
		
		txtbtn.add(jButton);
		txtbtn.add(txt);
		txtbtn.add(next);
		
		next.setVisible(false);
		
		jButton.addActionListener(this);
		
		next.addActionListener(this);
		
		cp.add(jta1, BorderLayout.CENTER);
		cp.add(txtbtn, BorderLayout.SOUTH);
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jButton)
		{ 
			if(txt.getText().equals("Y") || (txt.getText().equals("N")))  {
				
				mycbr.Hotelconfirmation(txt.getText());//added
				txt.setText("");
				
			} else if(Integer.parseInt(txt.getText().toString()) <=10) {
				mycbr.Numrooms(txt.getText());//added
				myinfo.addtowindow2(txt.getText().toString());
				txt.setText("");
				next.setVisible(true);
				jButton.setVisible(false);
				txt.setVisible(false);
				flag++;
				
			}
		}
		
		

		if(e.getSource() == next)
		{ 
			String Txt = "yes";
			myinfo.setTheText(Txt);//added
			frame.setVisible(false);
			jta1.setText("");
			next.setVisible(false);
			jButton.setVisible(true);
			txt.setVisible(true);
			
		}
		
	}
	
	//added this method
	public void setTheText(String msg)
	{
		if (msg.equals("yes")) {
			frame.setVisible(true);
			}
		if (msg.equals("no")) {
			frame.setVisible(false);
			jta1.setText("");
			}
			
	}
	
	
	
	
	
	
	
	
	
	//added this method
	public void passchatboxresponse(chat_box_response chatboxresponse)
	{
		mycbr = chatboxresponse;
	}
	
	
	
	
	public void hotelname(String name)
	{
		jta1.append("You would like to book a room in the " + name + " ? (Y/N) \n");
		this.hotelname = name;
		
	}
	
	
	
	
	public void HotelconfirmationR(String msg)
	{
		jta1.append(msg);
		myinfo.addtowindow1(hotelname);			
	}
			
	
	
	public void NumroomsR(int cost)
	{
		String Cost = Integer.toString(cost);
		jta1.append("Your total cost is " + Cost + ". Press next to proceed to the next process.");
		
		myinfo.addtowindow3(Cost);
					
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