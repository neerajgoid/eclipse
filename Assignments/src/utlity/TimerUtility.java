package utlity;

import java.util.Timer;
import java.util.TimerTask;

public class TimerUtility {

	public static void main(String[] args) {
	Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Timer ran after 3 second");
			}
		};
	timer.schedule(task, 3000);
		//TimerTask tt = new TimerTask() ;
		

	}

}
