package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerManager {
	private ArrayList<Customer> customer_list = new ArrayList<Customer>();
	public ArrayList<Customer> customer_list_output;
	private static CustomerManager instance;
	private static String TAP="\t";
	
	private CustomerManager() throws IOException{
		
		File f = new File("customer_info.txt");
		getCustomerWithFile(f);
		
		customer_list_output = (ArrayList<Customer>) customer_list.clone();
		
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
	
	public void makeOutputFile() throws IOException{
		FileWriter fr = new FileWriter("output.txt");
		BufferedWriter outFile = new BufferedWriter(fr);
		String out_string;
		
		for (Customer customer : customer_list_output) {
			out_string = customer.id + TAP + customer.name + TAP+ customer.arrival_time
					+ TAP+ customer.ticket_time + TAP+ customer.start_station
					+ TAP+ customer.arrival_station + TAP+ customer.ticket_waiting_time
					+ TAP+ customer.ticketing_time + TAP+ customer.train_waiting_time
					+ TAP+ customer.train_start_time + TAP+ customer.train_arrival_time;
			
			System.out.println(out_string);
			outFile.write(out_string);
		}
		
				
		
	}
	
}
