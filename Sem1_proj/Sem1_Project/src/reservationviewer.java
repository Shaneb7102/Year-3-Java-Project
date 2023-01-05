import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;




public class reservationviewer implements ActionListener{
	
	DefaultTableModel model;
	JTable myTable;
	JFrame frame;
	Container cp;
	JScrollPane scroll;
	JPanel Title;
	JLabel title;
	JButton NewRes;
	JButton Exit;
	private Select_Hotel selhotel;
	JPanel buttons;

	public reservationviewer() {
		frame = new JFrame();
		frame.setTitle("ScreenA");
		
		cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
	
		
		
		Title = new JPanel();
		title = new JLabel("Current Reservations:");
		Title.add(title);
		
		NewRes = new JButton("Make new Reservation");
		NewRes.addActionListener(this);
		Exit = new JButton("Exit Application");
		Exit.addActionListener(this);
		
		
		
		model = new DefaultTableModel(); 
		myTable = new JTable(model);
		
		
		model.addColumn("First Name"); 
		model.addColumn("Last name");
		model.addColumn("Email");
		model.addColumn("Hotel");
		model.addColumn("Number of rooms");
		model.addColumn("Cost");
		
		buttons = new JPanel();
		buttons.add(NewRes);
		buttons.add(Exit);
		
		
		scroll = new JScrollPane(myTable);
		
		
		
		cp.add(Title, BorderLayout.NORTH);
		cp.add(scroll,BorderLayout.CENTER);
		cp.add(buttons, BorderLayout.SOUTH);
		
		
		
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		if(e.getSource() == NewRes)
		{ 
		String Txt = "yes";
		selhotel.setTheText(Txt);//added
		frame.setVisible(false);
		}
		
		if(e.getSource() == Exit)
		{ 
			System.exit(0);
		}
	}
	
	
	
	
	
	
	
	
	public void setTheText(String msg)
	{
		if (msg.equals("yes")) {
			frame.setVisible(true);
			JOptionPane.showMessageDialog(null, "Thank you for booking with us! Check your email for details regarding your reservation!", "Plain",JOptionPane.PLAIN_MESSAGE);
			}
			
	}
	
	public void createres(String fname, String lname, String email, String hotel, String numrooms, String Cost)
	{

		model.addRow(new Object[]{fname, lname, email, hotel, numrooms, Cost});
		
	}
	
	public void passhotel(Select_Hotel hotel)
	{
		selhotel = hotel;
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