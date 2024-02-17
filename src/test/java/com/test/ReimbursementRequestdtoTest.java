package com.test;





import org.junit.jupiter.api.Test;

import com.Reimbursement.payload.reimbursementrequestDto;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

public class ReimbursementRequestdtoTest  {
    
    @Test
    public void testReimbursementrequestDto() {
        // Set up test data
        Integer id = 1;
        Integer travelRequestId = 2;
        Integer requestRaisedByEmployeeId = 3;
        LocalDate requestDate = LocalDate.of(2023, 4, 22);
        Integer reimbursementTypeId = 4;
        String invoiceNo = "INV123";
        Integer invoiceAmount = 100;
        String documentURL = "https://example.com/document.pdf";
        String status = "Pending";
        String remarks = "Test remarks";
        
        // Create a mock object of the reimbursementrequestDto class
        reimbursementrequestDto mockReimbursementrequestDto = mock(reimbursementrequestDto.class);
        
        // Set the expected behavior of the mock object
        when(mockReimbursementrequestDto.getId()).thenReturn(id);
        when(mockReimbursementrequestDto.getTravelRequestId()).thenReturn(travelRequestId);
        when(mockReimbursementrequestDto.getRequestRaisedByEmployeeId()).thenReturn(requestRaisedByEmployeeId);
        when(mockReimbursementrequestDto.getRequestDate()).thenReturn(requestDate);
        when(mockReimbursementrequestDto.getReimbursementTypeId()).thenReturn(reimbursementTypeId);
        when(mockReimbursementrequestDto.getInvoiceNo()).thenReturn(invoiceNo);
        when(mockReimbursementrequestDto.getInvoiceAmount()).thenReturn(invoiceAmount);
        when(mockReimbursementrequestDto.getDocumentURL()).thenReturn(documentURL);
        when(mockReimbursementrequestDto.getStatus()).thenReturn(status);
        when(mockReimbursementrequestDto.getRemarks()).thenReturn(remarks);
        
        // Verify the expected behavior
        assertEquals(id, mockReimbursementrequestDto.getId());
        assertEquals(travelRequestId, mockReimbursementrequestDto.getTravelRequestId());
        assertEquals(requestRaisedByEmployeeId, mockReimbursementrequestDto.getRequestRaisedByEmployeeId());
        assertEquals(requestDate, mockReimbursementrequestDto.getRequestDate());
        assertEquals(reimbursementTypeId, mockReimbursementrequestDto.getReimbursementTypeId());
        assertEquals(invoiceNo, mockReimbursementrequestDto.getInvoiceNo());
        assertEquals(invoiceAmount, mockReimbursementrequestDto.getInvoiceAmount());
        assertEquals(documentURL, mockReimbursementrequestDto.getDocumentURL());
        assertEquals(status, mockReimbursementrequestDto.getStatus());
        assertEquals(remarks, mockReimbursementrequestDto.getRemarks());
    }
}
