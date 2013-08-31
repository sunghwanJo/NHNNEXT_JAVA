package service;

import java.util.ArrayList;

import customer.Customer;

public class ArrivalManager implements Runnable{
	private ArrayList<Customer> arrival_queue = new ArrayList<Customer>();
	private static ArrivalManager instance;
	
	public static ArrivalManager getInstance(){
		if(instance == null){
			instance = new ArrivalManager();
		}
		
		return instance;
	}
	
	public void run() {
		Customer customer;
		while(true){
		
			if(Counselor.counseling_manager.size()< Counselor.NUMBER_OF_COUNSELOR || true){
				customer=dequeue();
				if(customer != null){
					Counselor.enqueue(customer);
				}
			}
		}
	}
	
	public void enqueue(Customer arrival_customer){
		arrival_queue.add(arrival_customer);
	}
	
	public Customer dequeue(){
		Customer de_customer;
		if (!isEmpty()) {
			de_customer = arrival_queue.get(0);
			arrival_queue.remove(de_customer);

			return de_customer;
		}
		return null;
	}
	
	public int getSize(){
		return arrival_queue.size();
	}
	
	public boolean isEmpty(){
		if(getSize() == 0 )
			return true;
		return false;
	}

}
