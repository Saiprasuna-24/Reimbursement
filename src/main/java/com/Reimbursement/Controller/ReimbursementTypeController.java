package com.Reimbursement.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Reimbursement.Service.ReimbursementTypeService;
import com.Reimbursement.payload.reimbursementtypeDto;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reimbursements")
public class ReimbursementTypeController {
    @Autowired
    ReimbursementTypeService reimbursementTypeService;
    
    @GetMapping("/types")
    public ResponseEntity<List<reimbursementtypeDto>> getlisttype(){
        return new ResponseEntity<>
        (reimbursementTypeService.getallreimbursementtype(), HttpStatus.OK);
    }


}
