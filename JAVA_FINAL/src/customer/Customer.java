package customer;

public class Customer {
	int id;
	String name;
	int arrival_time;
	int ticket_time;
	String start_station;
	String arrival_station;
	
	int ticket_waiting_time;
	int ticketing_time;
	
	int train_waiting_time;
	int train_start_time;
	int train_arrival_time; // train_start_time + 걸리는시간 
	
	
	
	public int getTicket_waiting_time() {
		return ticket_waiting_time;
	}

	public void setTicket_waiting_time(int ticket_waiting_time) {
		this.ticket_waiting_time = ticket_waiting_time;
	}

	public int getTicketing_time() {
		return ticketing_time;
	}
	
	private Customer(){}
	
	private Customer(int id, String name, int arrival_time, int ticket_time, 
			String start_station, String arrival_station){
		this.id = id;
		this.name = name;
		this.arrival_time = arrival_time;
		this.arrival_station = arrival_station;
		this.ticket_time = ticket_time;
	}
	
	public static Customer createCustomer(int id, String name, int arrival_time, int ticket_time, 
			String start_station, String arrival_station){
		
		Customer c = new Customer(id, name, arrival_time, ticket_time, 
				start_station, arrival_station);
			
		return c;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(int arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getTicket_time() {
		return ticket_time;
	}

	public void setTicket_time(int ticket_time) {
		this.ticket_time = ticket_time;
	}

	public String getStart_station() {
		return start_station;
	}

	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}

	public String getArrival_station() {
		return arrival_station;
	}

	public void setArrival_station(String arrival_station) {
		this.arrival_station = arrival_station;
	}
	
	public void setTicketing_time(int time) {
		this.ticketing_time = time;		
	}

	public int getTrain_waiting_time() {
		return train_waiting_time;
	}

	public void setTrain_waiting_time(int train_waiting_time) {
		this.train_waiting_time = train_waiting_time;
	}

	public int getTrain_start_time() {
		return train_start_time;
	}

	public void setTrain_start_time(int train_start_time) {
		this.train_start_time = train_start_time;
	}

	public int getTrain_arrival_time() {
		return train_arrival_time;
	}

	public void setTrain_arrival_time(int train_arrival_time) {
		this.train_arrival_time = train_arrival_time;
	}
	

}
