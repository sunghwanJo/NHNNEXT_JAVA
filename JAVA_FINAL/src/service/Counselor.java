package service;

import java.util.ArrayList;

import customer.Customer;

public class Counselor implements Runnable {
	public static final int NUMBER_OF_COUNSELOR = 3;

	public static ArrayList<Customer> counseling_manager = new ArrayList<Customer>();
	ArrivalManager arrival_manager = ArrivalManager.getInstance();
	Platform platform = Platform.getInstance();

	public void run() {
		Customer c;
		while (true) {
			
			synchronized (this) {
				c = dequeueCustomer();
			}
			if (c != null) {
				try {
					ticketing(c);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void ticketing(Customer customer) throws InterruptedException{
		int ticketing_time = customer.getTicket_time();
		int arrival_time = customer.getArrival_time();
		
		customer.setTicket_waiting_time(Station.time - arrival_time);
		Thread.sleep(ticketing_time * 10);
		customer.setTicketing_time(Station.time);
		
		platform.enqueueCustomer(customer);
	}
	
	public static int getSize(){
		return counseling_manager.size();
	}
	public boolean isEmpty(){
		if(getSize() == 0)
			return true;
		return false;
	}
	
	public Customer dequeueCustomer(){
		Customer customer;
		if(!isEmpty()){
			customer = counseling_manager.get(0);
			counseling_manager.remove(customer);
		
			return customer;
		}
		return null;	
	}

	public static void enqueue(Customer customer) {
		counseling_manager.add(customer);
	}	

}
