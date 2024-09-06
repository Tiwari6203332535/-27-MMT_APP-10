package in.happy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.happy.request.Passenger;
import in.happy.response.Ticket;

@Service
public class MMTServiceImpl implements MMTService {
	
	private String  BOOK_TICKET_URL="http://13.232.253.164.164:8080/ticket";
	private String  GET_TICKET_URL="http://13.232.253.164.164:8080/ticket/{ticketNum}";
	@Override
	public Ticket bookTicket(Passenger passenger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketInteger) {
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(BOOK_TICKET_URL, Ticket.class, ticketInteger);
		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

}
