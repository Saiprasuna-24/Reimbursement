package com.test;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Reimbursement.payload.reimbursementtypeDto;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ReimbursementTypedtoTest  {

    @InjectMocks
    private reimbursementtypeDto reimbursementTypeDto;

    @Test
    public void testGettersAndSetters() {
        reimbursementTypeDto.setId(1);
        assertEquals(1, reimbursementTypeDto.getId());
        
        reimbursementTypeDto.setType("Food and Water");
        assertEquals("Food and Water", reimbursementTypeDto.getType());
    }
}


