package linkedIn;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class TestRunner {

	public static void main(String[] args) throws InterruptedException, Exception {
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		System.out.println(dt);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		System.out.println(formatter.format(dt));  

		
	
		Util.getChromeDriver();
		Navigate.LoadLinkedin();
		Navigate.Searchfriends();
		Navigate.findtotal();
		//Util.killProcess();
	}

}
