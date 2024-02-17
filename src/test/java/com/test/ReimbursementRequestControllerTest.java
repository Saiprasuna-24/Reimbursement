package com.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.Reimbursement.Controller.ReimbursementRequestController;
import com.Reimbursement.Service.ReimbursementRequestService;
import com.Reimbursement.payload.reimbursementrequestDto;


public class ReimbursementRequestControllerTest {

    private MockMvc mockMvc;
    
    @Mock
    private ReimbursementRequestService reimbursementRequestService;
    
    @InjectMocks
    private ReimbursementRequestController reimbursementRequestController;
    
    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(reimbursementRequestController).build();
    }
    
    @Test
    public void testGetAllRequests() throws Exception {
        // Arrange
        List<reimbursementrequestDto> expectedRequests = new ArrayList<>();
        reimbursementrequestDto request1 = new reimbursementrequestDto();
        reimbursementrequestDto request2 = new reimbursementrequestDto();
        expectedRequests.add(request1);
        expectedRequests.add(request2);
        when(reimbursementRequestService.getAllRequests()).thenReturn(expectedRequests);
        
        // Act and Assert
        mockMvc.perform(get("/api/reimbursements/requests"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists());
    }
    
   /* @Test
    public void testAddReimbursementRequest() throws Exception {
        // Arrange
        String message = "New Reimbursement request has been created.";
        reimbursementrequestDto request = new reimbursementrequestDto();
        when(reimbursementRequestService.createArequest(any(reimbursementrequestDto.class))).thenReturn(request);

        // Act
        ResponseEntity<?> response = mockMvc.perform(post("/api/reimbursements/add")
                .content(asJsonString(request))
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andReturn().getResponseEntity();

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        assertEquals("{\"message\": \"" + message + "\"}", response.getBody());
    }
  */
    
       
    

    
    @Test
    public void testGetAllRequestsBytravelRequestId() throws Exception {
        // Arrange
        Integer travelRequestId = 1;
        List<reimbursementrequestDto> expectedRequests = new ArrayList<>();
        reimbursementrequestDto request1 = new reimbursementrequestDto();
        reimbursementrequestDto request2 = new reimbursementrequestDto();
        expectedRequests.add(request1);
        expectedRequests.add(request2);
        when(reimbursementRequestService.getAllRequestsByTravelRequestId(travelRequestId)).thenReturn(expectedRequests);
        
        // Act and Assert
        mockMvc.perform(get("/api/reimbursements/{travelRequestId}/requests", travelRequestId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[1]").exists());
    }
    
    @Test
    public void testGetRequestbyId() throws Exception {
        // Arrange
        Integer id = 1;
        reimbursementrequestDto expectedRequest = new reimbursementrequestDto();
        when(reimbursementRequestService.getRequestbyId(id)).thenReturn(expectedRequest);
        
        // Act and Assert
        mockMvc.perform(get("/api/reimbursements/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }
    
/*  @Test
    public void testProcess() throws Exception {
    // Arrange
    Integer id = 1;
    reimbursementrequestDto requestDto = new reimbursementrequestDto();
    String jsonRequestDto = new ObjectMapper().writeValueAsString(requestDto);
    String message = "Reimbursement request status updated for id: " + id;
    ResponseEntity<String> expectedResponse = ResponseEntity.ok("{\"message\": \"" + message + "\"}");
    doNothing().when(reimbursementRequestService).process(id, requestDto);
 // Act and Assert
    mockMvc.perform(put("/api/reimbursements/{id}/process", id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonRequestDto))
            .andExpect(status().isOk())
            .andExpect(content().json(expectedResponse.getBody()));
    } 
    
  */

}
    
