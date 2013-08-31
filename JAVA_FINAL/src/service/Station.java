package service;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import customer.Customer;
import customer.CustomerManager;

public class Station implements Runnable{
	static int time = 0;
	Timer timer = new Timer();
	StationTimer station_timer = new StationTimer();
	CustomerManager customer_manager = CustomerManager.getInstance();
	ArrivalManager arrival_manager = ArrivalManager.getInstance();
	
	public Station(){
		timer.scheduleAtFixedRate(station_timer, new Date(), 1000);
	}

	public void run() {
		addCustomerToArrivalManager();
	}
	
	public void addCustomerToArrivalManager(){ 
		Customer customer;
		while(!customer_manager.isEmpty()){
			if(time >= customer_manager.checkArrivalTime()){
				customer = customer_manager.dequeueCustomer();
				arrival_manager.enqueue(customer);
				//System.out.println(time + "] to ArrivalManager" + customer.getId());
			}
		}
	}
		
	public int getTime(){
		return time;
	}

}

class StationTimer extends TimerTask{
	public void run() {
		Station.time++;
	}
}