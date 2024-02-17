package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.Reimbursement.Entity.ReimbursementRequest;
import com.Reimbursement.Entity.ReimbursementType;
public class ReimbursementRequestEntityTest {
	private ReimbursementRequest reimbursementRequest;

	@BeforeEach
	public void setUp() {
		reimbursementRequest = new ReimbursementRequest();
		reimbursementRequest.setId(1);
		reimbursementRequest.setTravelRequestId(2);
		reimbursementRequest.setInvoiceAmount(1000);
		reimbursementRequest.setRequestRaisedByEmployeeId(3);
		reimbursementRequest.setInvoiceNo("INV-001");
		reimbursementRequest.setInvoiceDate(new Date(System.currentTimeMillis()));
		reimbursementRequest.setDocumentURL("https://example.com/document");
		reimbursementRequest.setStatus("New");
		reimbursementRequest.setRemarks("Sample Remarks");
		reimbursementRequest.setRequestDate(LocalDate.now());
		
		ReimbursementType reimbursementType = mock(ReimbursementType.class);
		when(reimbursementType.getId()).thenReturn(1);
		when(reimbursementType.getType()).thenReturn("Travel");
		reimbursementRequest.setReimbursementType(reimbursementType);
	}

	@Test
	public void testGettersAndSetters() {
		assertEquals(1, reimbursementRequest.getId());
		assertEquals(2, reimbursementRequest.getTravelRequestId());
		assertEquals(1000, reimbursementRequest.getInvoiceAmount());
		assertEquals(3, reimbursementRequest.getRequestRaisedByEmployeeId());
		assertEquals("INV-001", reimbursementRequest.getInvoiceNo());
		assertEquals(new Date(System.currentTimeMillis()), reimbursementRequest.getInvoiceDate());
		assertEquals("https://example.com/document", reimbursementRequest.getDocumentURL());
		assertEquals("New", reimbursementRequest.getStatus());
		assertEquals("Sample Remarks", reimbursementRequest.getRemarks());
		assertEquals(LocalDate.now(), reimbursementRequest.getRequestDate());
		assertEquals(1, reimbursementRequest.getReimbursementType().getId());
		assertEquals("Travel", reimbursementRequest.getReimbursementType().getType());
	}


}
