package customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerManager {
	private ArrayList<Customer> customer_list = new ArrayList<Customer>();
	private static CustomerManager instance;
	
	private CustomerManager() throws IOException{
		
		File f = new File("customer_info.txt");
		getCustomerWithFile(f);
		
	}
	
	public static CustomerManager getInstance(){
		if(instance == null){
			try {
				instance = new CustomerManager();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return instance;
	}
	
	public int getCustomerWithFile(File customer_file) throws IOException{
		FileReader fr = new FileReader(customer_file);
		BufferedReader inFile = new BufferedReader(fr);
		String customer_info_string;
		String[] str_array;
		
		while( (customer_info_string = inFile.readLine()) != null){
			str_array = customer_info_string.split("\t");
			Customer customer = Customer.createCustomer(Integer.parseInt(str_array[0]), str_array[1], Integer.parseInt(str_array[2]), 
					Integer.parseInt(str_array[3]), str_array[4], str_array[5]);
			enqueueCustomer(customer);
			
		}
		
		return 0;
	}
	
	public int getSize(){
		return customer_list.size();
	}
	
	public int checkArrivalTime(){
		return customer_list.get(0).arrival_time;
	}
	
	public Customer dequeueCustomer(){
		Customer return_customer;
		
		if(isEmpty())
			return (Customer)null;
		
		return_customer = customer_list.get(0);
		customer_list.remove(0);
		
		return return_customer;
	}
	
	private int enqueueCustomer(Customer push_customer){
		customer_list.add(push_customer);
		
		return 0;
	}
	
	public boolean isEmpty(){
		if(getSize() == 0)
			return true;
		return false;
	}
	
}
