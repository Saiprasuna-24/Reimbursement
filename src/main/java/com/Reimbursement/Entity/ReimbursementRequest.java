package com.Reimbursement.Entity;


import java.sql.Date;
import java.time.LocalDate;

//import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="ReimbursementRequest")
public class ReimbursementRequest {
	 @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	//@NotNull(message = "Employee ID cannot be null")
	
	private Integer Id;
	
	 @NotNull 
	private Integer travelRequestId;
	private Integer invoiceAmount;
	private Integer requestRaisedByEmployeeId;
	
	@NotNull
	private String invoiceNo;
	
	private Date invoiceDate;
	
	private String documentURL;	
	
	//private Date requestProcessedOn;
	
	//private Integer requestProcessedByemployeeId;
	

	@Pattern(regexp= "^(New|Accepted|Rejected)$", message = "Invalid status")
	private String status;
	
	
	
	private String remarks;

	
	    @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="reimbursement_type_id",referencedColumnName = "id")
	    ReimbursementType reimbursementType;
	
	  //@Column(name = "RequestDate")
		//private LocalDateTime requestDate;
		private LocalDate requestDate=LocalDate.now();
		 
}
