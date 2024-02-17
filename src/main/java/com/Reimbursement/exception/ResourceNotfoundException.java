package com.Reimbursement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResourceNotfoundException extends RuntimeException {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resouceName;
	    private String fieldName;
	    private Integer fieldValue;
	    public ResourceNotfoundException(String resourceName,Integer fieldValue,String fieldName)
	    {
	        super(String.format("%s not found with %s : '%s'", resourceName,fieldName,fieldValue));
	        this.resouceName=resourceName;
	        this.fieldName=fieldName;
	        this.fieldValue=fieldValue;
	    }

	    public String getResouceName() {
	        return resouceName;
	    }

	    public String getFieldName() {
	        return fieldName;
	    }

	    public Integer getFieldValue() {
	        return fieldValue;
	    }
}
