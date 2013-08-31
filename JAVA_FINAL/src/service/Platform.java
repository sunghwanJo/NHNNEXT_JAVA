package service;

import java.util.ArrayList;

import customer.Customer;

public class Platform {
	ArrayList<Customer> waiting_manager = new ArrayList<Customer>();
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
		for(String station : station_info){
			stations.add(stations.size(), station);
		}
	}
	
	public static Platform getInstance() {
		if (instance == null) {
			instance = new Platform();
		}
	
		return instance;
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
				for(int k=0; k<n; j++){
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
