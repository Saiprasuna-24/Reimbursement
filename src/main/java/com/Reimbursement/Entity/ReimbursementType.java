package com.Reimbursement.Entity;

import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ReimbursementType")
public class ReimbursementType {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    //private String value;
	    private String type;
	    private Integer minValue;
	    private Integer maxValue;

	}

