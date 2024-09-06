package in.happy.response;

import lombok.Data;

@Data
public class Ticket {
	private Integer ticketNum;
	private String status;
	private Double coast;
	private String name;
	private String from;
	private String to;
	private String doj;
	private String trainNum;

}
