package com.Reimbursement.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.Reimbursement.Service.ReimbursementRequestService;
import com.Reimbursement.payload.reimbursementrequestDto;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reimbursements")
public class ReimbursementRequestController {
	
	@Autowired
	ReimbursementRequestService reimbursementRequestService;
	
/*	@GetMapping("/home")
	public String home() {
		return "welcome all";
	} 
    }*/
	
	//To view all the records
	@GetMapping("/requests")
    public ResponseEntity<List<reimbursementrequestDto>> getAllRequests() {
        List<reimbursementrequestDto> reimbursementRequests = reimbursementRequestService.getAllRequests();
        return ResponseEntity.ok(reimbursementRequests);
    }
	
	
	 @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	    public ResponseEntity<?> addReimbursementRequest(@RequestBody reimbursementrequestDto reimbursementRequestDto) throws Exception {
	        // Call the service to create a reimbursement request
	        reimbursementRequestService.createArequest(reimbursementRequestDto);

	        // Create a response JSON object with the message
	        String message = "New Reimbursement request has been created.";
	        return ResponseEntity.status(HttpStatus.CREATED)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body("{\"message\": \"" + message + "\"}");
	    }
	   @GetMapping("/{travelRequestId}/requests")
	    public ResponseEntity<List<reimbursementrequestDto>> getAllRequestsBytravelRequestId(@PathVariable Integer travelRequestId) {
	        List<reimbursementrequestDto> reimbursementRequests = reimbursementRequestService.getAllRequestsByTravelRequestId(travelRequestId);
	        return ResponseEntity.ok(reimbursementRequests);
	    }
	    
	   
	   
	   @GetMapping("/{id}")
	    public ResponseEntity<reimbursementrequestDto> getRequestbyId(@PathVariable Integer id){
	        return new ResponseEntity<>(reimbursementRequestService.getRequestbyId(id),HttpStatus.OK);
	    }

	    
	    @CrossOrigin(origins = "http://localhost:4200")
	/*    @PutMapping("/{id}/process")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> process(@PathVariable(name = "id") Integer id,
	                                          @RequestBody reimbursementrequestDto reimbursementRequestDto1) {
	        // Call the service to process the reimbursement request
	        reimbursementRequestService.process(id, reimbursementRequestDto1);

	        // Create a response JSON object with the updated status message
	        String message = "Reimbursement request status updated for id: " + id;
	        return ResponseEntity.ok("{\"message\": \"" + message + "\"}");
	    }
	 */
	    @PutMapping("/{id}/process")
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> process(@PathVariable(name = "id") Integer id,
	                                          @RequestBody reimbursementrequestDto reimbursementrequestDto1) {
	        // Check if the new status is "rejected" and if it is, add the remarks to the DTO object
	        if (reimbursementrequestDto1.getStatus().equalsIgnoreCase("rejected")) {
	            reimbursementrequestDto1.setRemarks("Rejected due to " + reimbursementrequestDto1.getRemarks());
	        }

	        // Call the service to process the reimbursement request
	        reimbursementRequestService.process(id, reimbursementrequestDto1);

	        // Create a response JSON object with the updated status message
	        String message = "Reimbursement request status updated for id: " + id;
	        return ResponseEntity.ok("{\"message\": \"" + message + "\"}");
	    }


 
}
	    
 


