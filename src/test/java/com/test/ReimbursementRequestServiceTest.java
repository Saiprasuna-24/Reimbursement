package com.test;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.Reimbursement.Entity.ReimbursementRequest;
import com.Reimbursement.Repository.ReimbursementRequestRepository;
import com.Reimbursement.Service.ReimbursementRequestService;

import com.Reimbursement.payload.reimbursementrequestDto;

@ExtendWith(MockitoExtension.class)
public class ReimbursementRequestServiceTest {
    
    @Mock
    private ReimbursementRequestRepository reimbursementRequestRepository;
    
    @Mock
    private ModelMapper modelMapper;
    
    @InjectMocks
    private ReimbursementRequestService reimbursementRequestService;
    
    private ReimbursementRequest reimbursementRequest;
    private reimbursementrequestDto reimbursementrequestDto;
    
    @BeforeEach
    void setUp() {
        reimbursementRequest = new ReimbursementRequest();
        reimbursementRequest.setId(1);
        reimbursementRequest.setTravelRequestId(1);
        reimbursementRequest.setInvoiceAmount(1000);
        reimbursementRequest.setStatus("Pending");
        
        reimbursementrequestDto = new reimbursementrequestDto();
        reimbursementrequestDto.setId(1);
        reimbursementrequestDto.setTravelRequestId(1);
        reimbursementrequestDto.setInvoiceAmount(1000);
        reimbursementrequestDto.setStatus("Pending");
    }
    
    @Test
    void testGetAllRequests() {
        List<ReimbursementRequest> reimbursementRequests = new ArrayList<>();
        reimbursementRequests.add(reimbursementRequest);
        
        List<reimbursementrequestDto> reimbursementrequestDtos = new ArrayList<>();
        reimbursementrequestDtos.add(reimbursementrequestDto);
        
        doReturn(reimbursementRequests).when(reimbursementRequestRepository).findAll();
        doReturn(reimbursementrequestDto).when(modelMapper).map(any(ReimbursementRequest.class), any());
        
        List<reimbursementrequestDto> result = reimbursementRequestService.getAllRequests();
        
        assertThat(result).isEqualTo(reimbursementrequestDtos);
    }
    
 
    @Test
    void testCreateArequest() {
        when(reimbursementRequestRepository.save(any())).thenReturn(null);
        when(modelMapper.map(any(reimbursementrequestDto.class), any())).thenReturn(reimbursementRequest);

        reimbursementRequestService.createArequest(reimbursementrequestDto);

        verify(reimbursementRequestRepository).save(any());
    }

    
    @Test
    void testGetAllRequestsByTravelRequestId() {
        List<ReimbursementRequest> reimbursementRequests = new ArrayList<>();
        reimbursementRequests.add(reimbursementRequest);
        
        List<reimbursementrequestDto> reimbursementrequestDtos = new ArrayList<>();
        reimbursementrequestDtos.add(reimbursementrequestDto);
        
        doReturn(reimbursementRequests).when(reimbursementRequestRepository).findByTravelRequestId(anyInt());
        doReturn(reimbursementrequestDto).when(modelMapper).map(any(ReimbursementRequest.class), any());
        
        List<reimbursementrequestDto> result = reimbursementRequestService.getAllRequestsByTravelRequestId(1);
        
        assertThat(result).isEqualTo(reimbursementrequestDtos);
    }
    /*  
   @Test
    void testGetRequestbyId() {
        doReturn(reimbursementRequest).when(reimbursementRequestRepository).findById(1);
        assertEquals(reimbursementrequestDto, reimbursementRequestService.getRequestbyId(1));
    }  
    
  
   
    @Test
    void testGetRequestbyId() {
        Optional<ReimbursementRequest> optionalReimbursementRequest = Optional.of(reimbursementRequest);
        doReturn(optionalReimbursementRequest).when(reimbursementRequestRepository).findById(1);
        assertEquals(reimbursementrequestDto, reimbursementRequestService.getRequestbyId(1));
    }
*/
   @Test
   void testGetRequestbyId() {
       doReturn(Optional.of(reimbursementRequest)).when(reimbursementRequestRepository).findById(1);
       assertEquals(reimbursementrequestDto, reimbursementRequestService.getRequestbyId(1));
   }
   
  

    @Test
    void testProcess() {
        reimbursementrequestDto.setStatus("Approved");
        Optional<ReimbursementRequest> optionalRequest = Optional.of(reimbursementRequest);
        doReturn(optionalRequest).when(reimbursementRequestRepository).findById(1);
        reimbursementRequestService.process(1, reimbursementrequestDto);
        assertEquals(reimbursementrequestDto.getStatus(), reimbursementRequest.getStatus());
    }

}
