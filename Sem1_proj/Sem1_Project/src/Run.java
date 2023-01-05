public class Run {

	public static void main(String[] args) {
		
		
		
		
		
		
		
		reservationviewer resview = new reservationviewer();
		
		informationpage info = new informationpage(resview);
		chat_box chatbox = new chat_box(info);
		
		
		Select_Hotel hotel = new Select_Hotel(chatbox);
		chat_box_response chatboxresponse = new chat_box_response(hotel);
		LoginScreen login = new LoginScreen(hotel);
		
		
		
		resview.hide();
		info.hide();
		hotel.hide();
		chatbox.hide();
		chatboxresponse.hide();
		
		
		
		
		chatbox.passchatboxresponse(chatboxresponse);
		chatboxresponse.passchatbox(chatbox);
		
		resview.passhotel(hotel);
		hotel.passresview(resview);
	}

}
