package com.Reimbursement.Service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reimbursement.Entity.ReimbursementType;
import com.Reimbursement.Repository.ReimbursementTypeRepo;
import com.Reimbursement.payload.reimbursementtypeDto;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ReimbursementTypeService {
	 @Autowired
	 ReimbursementTypeRepo reimbursementTypeRepo;
	    @Autowired
	    
	    ModelMapper modelMapper;
	    public List<reimbursementtypeDto> getallreimbursementtype(){
	        List<ReimbursementType> reimbursementTypeList= reimbursementTypeRepo.findAll();
	        return reimbursementTypeList.stream().map(request -> modelMapper.map(request, reimbursementtypeDto.class)).collect(Collectors.toList());
	    }
}
