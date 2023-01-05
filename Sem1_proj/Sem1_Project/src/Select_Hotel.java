
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Select_Hotel implements ActionListener{
	
	JLabel title;
	JFrame frame;
	Container cp;
	JPanel Title;
	Box b1;
	JButton Next;
	Font f ;
	CardLayout Hotels;
	JPanel hotelspanel;
	JPanel Raddison;
	JPanel Sheraton;
	JPanel princewales;
	JPanel button;
	JButton name1;
	JButton name2;
	JButton name3;
	JLabel p1;
	JLabel p2;
	JLabel p3;
	JLabel add1;
	JLabel add2;
	JLabel add3;
	JLabel rating1;
	ImageIcon raddison;
	JLabel rating2;
	ImageIcon sheraton;
	JLabel rating3;
	ImageIcon POW;
	String Txt;
	Box b2;
	Box b3;
	Box b4;
	private chat_box mycb;
	private reservationviewer myres;
	
	
	public Select_Hotel(chat_box chatbox) {
		frame = new JFrame();
		frame.setTitle("Select Hotel");
		
		cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		
		Hotels = new CardLayout();
		hotelspanel = new JPanel();
		hotelspanel.setLayout(Hotels);
		
		mycb = chatbox;
		
		b2 = new Box(BoxLayout.Y_AXIS);
		b3 = new Box(BoxLayout.Y_AXIS);
		b4 = new Box(BoxLayout.Y_AXIS);
		
		
		
		Raddison = new JPanel();
		name1 = new JButton("Raddison Blu Hotel");
		rating1 = new JLabel("4/5 Stars!");
		add1 = new JLabel("Northgate St, Athlone, Co. Westmeath");
		b2.add(name1);
		b2.add(rating1);
		b2.add(add1);
		Raddison.add(b2);
		raddison = new ImageIcon("raddisonblu.jpg");
		p1 = new JLabel(raddison);
		Raddison.add(p1);
		
		Sheraton = new JPanel();
		name2 = new JButton("Sheraton Hotel");
		rating2 = new JLabel("4.5/5 Stars!");
		add2 = new JLabel("Gleeson St, Athlone, Co. Westmeath");
		b3.add(name2);
		b3.add(rating2);
		b3.add(add2);
		Sheraton.add(b3);
		sheraton = new ImageIcon("sheraton_athlone_hotel.jpg");
		p2 = new JLabel(sheraton);
		Sheraton.add(p2);
		
		princewales = new JPanel();
		name3 = new JButton("Prince of Wales Hotel");
		rating3 = new JLabel("5/5 Stars!");
		add3 = new JLabel("Church St, Athlone, Co. Westmeath");
		b4.add(name3);
		b4.add(rating3);
		b4.add(add3);
		princewales.add(b4);
		POW = new ImageIcon("princewales.jpg");
		p3 = new JLabel(POW);
		princewales.add(p3);
		
		f = new Font("TimesRoman", Font.BOLD,40);
		
		Title = new JPanel();
		
		
		
		title = new JLabel("Select Hotel");
		title.setFont(f);
		
		Title.add(title);
		
		name1.addActionListener(this);
		name2.addActionListener(this);
		name3.addActionListener(this);
		
		button = new JPanel();
		
		
		Next = new JButton("Next");
		Next.addActionListener(this);
		
		button.add(Next);
		
		
		hotelspanel.add(Raddison);
		hotelspanel.add(Sheraton);
		hotelspanel.add(princewales);
		
		
		
		cp.add(Title, BorderLayout.NORTH);
		cp.add(hotelspanel, BorderLayout.CENTER );
		cp.add(button, BorderLayout.SOUTH);
		
		
		
		frame.setSize(1000, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == Next)
		{
			Hotels.next(hotelspanel);
		}
		
		if(e.getSource() == name1)
		{
			String hotel = "Raddison Blu";
			String Txt = "yes";
			mycb.setTheText(Txt);//added
			mycb.hotelname(hotel);//added
			
			frame.setVisible(false);
			
		}
		
		if(e.getSource() == name2)
		{
			String hotel = "Sheraton";
			String Txt = "yes";
			mycb.setTheText(Txt);//added
			mycb.hotelname(hotel);//added
			
			frame.setVisible(false);
		}
		
		if(e.getSource() == name3)
		{
			String hotel = "Prince of Wales";
			String Txt = "yes";
			mycb.setTheText(Txt);//added
			mycb.hotelname(hotel);//added
			
			frame.setVisible(false);
		}
		
		
	}
	
	
	
	public void setTheText(String msg)
	{
		if (msg.equals("yes")) {
		frame.setVisible(true);
		}
		
	}
	
	
	public void passresview(reservationviewer resview)
	{
		myres = resview;
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

