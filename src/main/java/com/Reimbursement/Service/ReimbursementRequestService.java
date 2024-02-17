package com.Reimbursement.Service;


import java.util.ArrayList;
import java.util.List;
//import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.Reimbursement.Entity.ReimbursementRequest;
import com.Reimbursement.Repository.ReimbursementRequestRepository;
import com.Reimbursement.exception.ResourceNotfoundException;
import com.Reimbursement.payload.reimbursementrequestDto;


@Service
public class ReimbursementRequestService {
	   @Autowired
	   ReimbursementRequestRepository reimbursementRequestRepository;
	    @Autowired
	
	    ModelMapper modelMapper;
	   
	//all request    
	    public List<reimbursementrequestDto> getAllRequests() {
	        List<ReimbursementRequest> reimbursementRequests = reimbursementRequestRepository.findAll();
	        List<reimbursementrequestDto> reimbursementrequestDtos = new ArrayList<>();
	        for (ReimbursementRequest reimbursementRequest : reimbursementRequests) {
	            reimbursementrequestDto reimbursementrequestDto = modelMapper.map(reimbursementRequest, reimbursementrequestDto.class);
	            reimbursementrequestDtos.add(reimbursementrequestDto);
	        }
	        return reimbursementrequestDtos;
	    }
	    
	  // new request 
	   public void createArequest(reimbursementrequestDto reimbursementrequestDto){
	    	ReimbursementRequest reimbursementRequest= modelMapper.map(reimbursementrequestDto,ReimbursementRequest.class);
	    	reimbursementRequestRepository.save(reimbursementRequest); 
	    }

	   
     // returning using travel request id  
	   public List<reimbursementrequestDto> getAllRequestsByTravelRequestId(Integer travelRequestId) {
	        List<ReimbursementRequest> reimbursementRequests = reimbursementRequestRepository.findByTravelRequestId(travelRequestId);
	        return reimbursementRequests.stream()
	                .map(reimbursementRequest -> modelMapper.map(reimbursementRequest, reimbursementrequestDto.class))
	                .collect(Collectors.toList());
	    } 
	   
	   // get request by id
	   public reimbursementrequestDto getRequestbyId(Integer id){
	    	ReimbursementRequest reimbursementRequest=reimbursementRequestRepository.findById(id).orElseThrow(()-> new  ResourceNotfoundException("Category",id,"ID"));
	        return modelMapper.map(reimbursementRequest,reimbursementrequestDto.class);
	    }
	    //update the status
/*	 public void process(Integer id, reimbursementrequestDto reimbursementrequestDto1) throws RuntimeException {
	        ReimbursementRequest reimbursementRequest=reimbursementRequestRepository.findById(id).orElseThrow(()-> new  ResourceNotfoundException("Category",id,"ID"));
	       

	            
	             reimbursementRequest.setStatus(reimbursementrequestDto1.getStatus());

	            reimbursementRequestRepository.save(reimbursementRequest); } */
	   
	   public void process(Integer id, reimbursementrequestDto reimbursementrequestDto1) throws RuntimeException {
		    ReimbursementRequest reimbursementRequest = reimbursementRequestRepository.findById(id)
		            .orElseThrow(() -> new ResourceNotfoundException("Category", id, "ID"));

		    reimbursementRequest.setStatus(reimbursementrequestDto1.getStatus());

		    if (reimbursementrequestDto1.getStatus().equalsIgnoreCase("Rejected")) {
		        reimbursementRequest.setRemarks(reimbursementrequestDto1.getRemarks());
		    }

		    reimbursementRequestRepository.save(reimbursementRequest);
		}

	 

}