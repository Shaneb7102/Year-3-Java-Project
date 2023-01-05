import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class informationpage implements ActionListener{
	
	private JButton jButton;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JLabel fname;
	private JLabel sname;
	private JLabel email;
	private Box b0;
	private Box b1;
	private JPanel loginfields;
	private JPanel buttons;
	private JFrame frame;
	private JTextArea tadd;
	private reservationviewer myres;  //added
	private Container cp;
	String hotelname;
	String finalcost;
	String numrooms;
	

	public informationpage(reservationviewer resviewer) {
		frame = new JFrame();
		frame.setTitle("ScreenA");
		
		cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		
		myres = resviewer;
		
		loginfields = new JPanel();
		loginfields.setBorder(BorderFactory.createTitledBorder("Enter Reservation Details:"));
		

		txt1 = new JTextField(20);
		txt2 = new JTextField(20);
		txt3 = new JTextField(20);
		
		fname = new JLabel("First name");
		sname = new JLabel("Last name");
		email = new JLabel("Email");
		
		b0 = new Box(BoxLayout.Y_AXIS);
		b1 = new Box(BoxLayout.Y_AXIS);
		
		jButton = new JButton("Submit");
		jButton.addActionListener(this);
		
		b0.add(txt1);
		b0.add(txt2);
		b0.add(txt3);
		
		b1.add(fname);
		b1.add(sname);
		b1.add(email);
		
		loginfields.add(b1);
		loginfields.add(b0);
		
		buttons = new JPanel();
		buttons.add(jButton);
		
		
		tadd = new JTextArea();
        tadd.setFont(new Font("Arial", Font.PLAIN, 15));
        tadd.setSize(500, 500);
        tadd.setLocation(200, 300);
        tadd.setLineWrap(true);
		
		
		cp.add(loginfields);
		cp.add(buttons);
		cp.add(tadd);
		
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	
	public void setTheText(String msg)
	{
		if (msg.equals("yes")) {
			frame.setVisible(true);
			}
			
	}
	
	
	
	public void addtowindow1(String Hotel)
	{
		tadd.append("Hotel Name:" + Hotel + "\n");
		this.hotelname = Hotel;
	}
	
	public void addtowindow2(String numrooms)
	{
		tadd.append("Number of Rooms:" + numrooms + "\n");
		this.numrooms = numrooms;
	}
	
	public void addtowindow3(String cost)
	{
		tadd.append("Total Cost:" + cost + "\n");
		this.finalcost = cost;
	}
	
	
	public void hide()
	{
		frame.setVisible(false);
	}
	
	public void show()
	{
		frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == jButton)
		{ 
			myres.createres(txt1.getText().toString(), txt2.getText().toString(), txt3.getText().toString(),hotelname, numrooms, finalcost );
			String Txt = "yes";
			myres.setTheText(Txt);//added
			txt1.setText("");
			txt2.setText("");
			txt3.setText("");
			tadd.setText("");
			frame.setVisible(false);
			
			
			
			
		}
	}
	
	
	
	
	
	
	
}