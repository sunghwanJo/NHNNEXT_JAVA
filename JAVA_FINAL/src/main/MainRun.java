package main;

import java.io.IOException;

import service.ArrivalManager;
import service.Counselor;
import service.Station;

public class MainRun {

	public static void main(String[] args) throws IOException, InterruptedException {
		Station station = new Station();
		Counselor counselor = new Counselor();
		ArrivalManager arrival_manager = ArrivalManager.getInstance();
		
		Thread[] ta = new Thread[Counselor.NUMBER_OF_COUNSELOR]; 
		Thread station_thread = new Thread(station);
		Thread arrival_manager_thread = new Thread(arrival_manager);
		
		station_thread.start();
		arrival_manager_thread.start();
		
		for(Thread t : ta){
			t = new Thread(counselor);
			t.start();
		}
	}

}
