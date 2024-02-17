package com.test;

import org.junit.jupiter.api.Test;
import com.Reimbursement.Entity.ReimbursementType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReimbursementTypeEntityTest {

	 @Test
	    public void testGettersAndSetters() {
	        // Arrange
	        ReimbursementType reimbursementType = new ReimbursementType();
	        reimbursementType.setId(1);
	        reimbursementType.setType("Food and Water");
	        reimbursementType.setMinValue(1000);
	        reimbursementType.setMaxValue(1500);

	        // Act
	        Integer id = reimbursementType.getId();
	        String type = reimbursementType.getType();
	        Integer minValue = reimbursementType.getMinValue();
	        Integer maxValue = reimbursementType.getMaxValue();

	        // Assert
	        assertEquals(1, id);
	        assertEquals("Food and Water", type);
	        assertEquals(1000, minValue);
	        assertEquals(1500, maxValue);
	    }
	}

