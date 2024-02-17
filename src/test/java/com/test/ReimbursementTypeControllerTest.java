package com.test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Reimbursement.Controller.ReimbursementTypeController;
import com.Reimbursement.Service.ReimbursementTypeService;
import com.Reimbursement.payload.reimbursementtypeDto;

public class ReimbursementTypeControllerTest {

	@Mock
    private ReimbursementTypeService reimbursementTypeService;

    @InjectMocks
    private ReimbursementTypeController reimbursementTypeController;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetlisttype() {
    	List<reimbursementtypeDto> typeList = new ArrayList<>();
        typeList.add(new reimbursementtypeDto());
        typeList.add(new reimbursementtypeDto());

        when(reimbursementTypeService.getallreimbursementtype()).thenReturn(typeList);

        ResponseEntity<List<reimbursementtypeDto>> response = reimbursementTypeController.getlisttype();

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(typeList, response.getBody());
    }
}
