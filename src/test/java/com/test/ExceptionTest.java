package com.test;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Reimbursement.exception.ResourceNotfoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ExceptionTest {

    @InjectMocks
    private ResourceNotfoundException resourceNotfoundException;

    @Test
    public void testGetResouceName() {
        resourceNotfoundException = new ResourceNotfoundException("testResource", 123, "testFieldName");
        assertEquals("testResource", resourceNotfoundException.getResouceName());
    }

    @Test
    public void testGetFieldName() {
        resourceNotfoundException = new ResourceNotfoundException("testResource", 123, "testFieldName");
        assertEquals("testFieldName", resourceNotfoundException.getFieldName());
    }

    @Test
    public void testGetFieldValue() {
        resourceNotfoundException = new ResourceNotfoundException("testResource", 123, "testFieldName");
        assertEquals(123, resourceNotfoundException.getFieldValue());
    }

}
