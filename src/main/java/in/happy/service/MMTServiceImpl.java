package in.happy.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.happy.request.Passenger;
import in.happy.response.Ticket;

@Service
public class MMTServiceImpl implements MMTService {
	
	private String  BOOK_TICKET_URL="http://13.232.253.164.164:8080/ticket";
	private String  GET_TICKET_URL="http://13.232.253.164.164:8080/ticket/{ticketNum}";
	@Override
	public Ticket bookTicket(Passenger passenger) {
		WebClient webClient = WebClient.create();
		Ticket ticket = webClient.post()
		                     .uri(BOOK_TICKET_URL)
                       		.bodyValue(passenger)
                     		.retrieve()
                    		.bodyToMono(Ticket.class)
                    		.block();
		
		
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<Ticket> responseEntity = rt.postForEntity(BOOK_TICKET_URL, passenger, Ticket.class);
//		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

	@Override
	public Ticket getTicketByNum(Integer ticketNumber) {
		//get the object of webclient(impl class)
		WebClient webClient = WebClient.create();
		//send get request and map request to ticket obj
		Ticket ticket = webClient.get()
		           .uri(GET_TICKET_URL,ticketNumber)
		           .retrieve()
		           .bodyToMono(Ticket.class)
		           .block();//sync call=after request wait for response
		
//		RestTemplate rt = new RestTemplate();
//		ResponseEntity<Ticket> responseEntity = rt.getForEntity(BOOK_TICKET_URL, Ticket.class, ticketInteger);
//		Ticket ticket = responseEntity.getBody();
		return ticket;
	}

}
