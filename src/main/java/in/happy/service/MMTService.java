package in.happy.service;

import in.happy.request.Passenger;
import in.happy.response.Ticket;

public interface MMTService {
	
public Ticket bookTicket(Passenger passenger);

public Ticket getTicketByNum(Integer ticketInteger);


}
