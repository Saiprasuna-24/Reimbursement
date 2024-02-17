package com.Reimbursement.payload;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class reimbursementrequestDto {
	private Integer Id;
	private Integer travelRequestId;
	private Integer requestRaisedByEmployeeId;
	private LocalDate requestDate=LocalDate.now();
	private Integer reimbursementTypeId;
	private String invoiceNo;
	private Date invoiceDate;
	private Integer invoiceAmount;
	private String documentURL;
	//private Date requestProcessedOn;
	//private Integer requestProcessedByEmployeeId;
	private String status;
	private String remarks;
}
