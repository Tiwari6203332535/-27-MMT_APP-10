package in.happy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.happy.request.Passenger;
import in.happy.response.Ticket;
import in.happy.service.MMTService;

@Controller
public class MMTController {
	@Autowired
	private MMTService service;
	@GetMapping("/get-ticket")
	public String getTicket(@RequestParam Integer ticketNum, Model model) {
		Ticket ticketByNum = service.getTicketByNum(ticketNum);
		model.addAttribute("ticket", ticketByNum);
		return "ticket-Form";
	}
	
	@GetMapping("/ticket")
	public String getTicketForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "ticket-Form";
	}
	
	@PostMapping("/book-ticket")
	public String bookTicket(@ModelAttribute("passenger") Passenger passenger , Model model) {
		System.out.println(passenger);
		Ticket ticket =service.bookTicket(passenger);
		model.addAttribute("msg", "Your Ticket Booked with Id:"+ticket.getTicketNum());
		
		return "index";
		
	}
	@GetMapping("/")
	 public String loadform(Model model) {
		 model.addAttribute("passenger", new Passenger());
		 return "index"; 
	 }
	
	

}
