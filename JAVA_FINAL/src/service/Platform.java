package service;

import java.io.IOException;
import java.util.ArrayList;

import customer.Customer;
import customer.CustomerManager;

public class Platform implements Runnable{
	ArrayList<Customer> waiting_manager = new ArrayList<Customer>();
	CustomerManager customer_manager = CustomerManager.getInstance();
	static final int VERTICES = 7;
	static final int INF = 1000;
	static final ArrayList<String> stations = new ArrayList<String>();
	static final String[] station_info = {"Seoul", "Chuncheon", "Kyungju", "Wonju", "Daejeon", 
		"Kwangju", "Asan"};
	
	int[][] weight = {
			{0, 16, INF, 22, 29, INF, 20},
			{16, 0, 31, 28, INF, INF, INF},	
			{INF, 31, 0, 32, 15, 18, INF},
			{22, 28, 32, 0, 23, INF, INF},
			{29, INF, 15, 23, 0, 12, 35},
			{INF, INF, 18, INF, 12, 0,25},
			{20, INF, INF, INF, 35, 25, 0}
		};
		int[][] time_map= new int[VERTICES][VERTICES];
			
	private static Platform instance;
	
	private Platform(){
		floyd(VERTICES);
	}
	
	public static Platform getInstance() {
		if (instance == null) {
			instance = new Platform();
		}
	
		return instance;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(5000);
				for(Customer c : waiting_manager){
					c.setTrain_waiting_time(Station.time - c.getTicketing_time());
					c.setTrain_start_time(Station.time);
					c.setTrain_arrival_time(Station.time + getTravelTime(c.getArrival_station(), c.getStart_station()));
					
					if(c == customer_manager.customer_list_output.get(customer_manager.customer_list_output.size()-1)){
						customer_manager.makeOutputFile();
						break;
					}
				}
				waiting_manager.clear();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public int getTravelTime(String start, String end){
		int travel_time, start_int, end_int;
		
		start_int = stations.indexOf(start);
		end_int = stations.indexOf(end);
		
		travel_time = time_map[start_int][end_int];
		
		return travel_time;
	}
	
	public void enqueueCustomer(Customer customer){
		waiting_manager.add(customer);
	}
	
	public int getSize(){
		return waiting_manager.size();
	}
	
	public Customer dequeueCustomer(Customer customer){
		Customer c;
		if(getSize()!=0){
			c=waiting_manager.get(0);
			waiting_manager.remove(c);
			return c;
		}
		
		return null;
	}
	
	public void floyd(int n){
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				for(int k=0; k<n; k++){
					if(weight[j][i]+weight[i][k] < weight[j][k]){
						time_map[j][k] =weight[j][i]+weight[i][k]; 
					}else{
						time_map[j][k] = weight[j][k];
					}
				}
			}
		}
	}	
	
}
