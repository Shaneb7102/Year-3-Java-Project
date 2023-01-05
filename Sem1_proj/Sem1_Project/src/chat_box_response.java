import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class chat_box_response implements ActionListener{
	
	private JButton jButton;
	private JTextField txt;
	private chat_box mycb; //added
	private Select_Hotel selhotel;
	private JFrame frame;

	public chat_box_response(Select_Hotel hotel) {
		frame = new JFrame();
		frame.setTitle("ScreenB");
		
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		
		
		selhotel = hotel;
		
		jButton = new JButton("SEND");
		jButton.addActionListener(this);
		
		txt = new JTextField(20);
		
		
		cp.add(jButton);
		cp.add(txt);
		
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jButton)
		{
			mycb.setTheText(txt.getText());//added
		}
		
	}
	
	//added this method
	public void setTheText(String msg)
	{
		txt.setText(msg);
	}
	
	//added this method
	public void passchatbox(chat_box chatbox)
	{
		mycb = chatbox;
	}
	
	
	
	public void Hotelconfirmation(String msg)
	{
		String HCR = "How many Rooms would you like to book? (Submit number of rooms up to 10) (Each room is 50 euros and fits 2 people.) \n";
		if (msg.equals("Y")) {
			mycb.HotelconfirmationR(HCR);
		
		}
		if (msg.equals("N")) {
			
			
			
			String Txt = "yes";
			selhotel.setTheText(Txt);//added
			String Txt2 = "no";
			mycb.setTheText(Txt2);//added
			
		
		}
		
	}
	
	public void Numrooms(String msg)
	{
		int Number_of_rooms = Integer.parseInt(msg);
		
		int total_Cost = (Number_of_rooms * 50);
		
		mycb.NumroomsR(total_Cost);
		
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

