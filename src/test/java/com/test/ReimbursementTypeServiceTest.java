package com.test;


import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.Reimbursement.Entity.ReimbursementType;
import com.Reimbursement.Repository.ReimbursementTypeRepo;
import com.Reimbursement.Service.ReimbursementTypeService;
import com.Reimbursement.payload.reimbursementtypeDto;

@ExtendWith(MockitoExtension.class)
public class ReimbursementTypeServiceTest {

	@Mock
	private ReimbursementTypeRepo reimbursementTypeRepo;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ReimbursementTypeService reimbursementTypeService;

	@Test
	public void testGetAllReimbursementType() {
		// Given
		ReimbursementType reimbursementType1 = new ReimbursementType();
		reimbursementType1.setId(1);
		reimbursementType1.setType("Type 1");

		ReimbursementType reimbursementType2 = new ReimbursementType();
		reimbursementType2.setId(2);
		reimbursementType2.setType("Type 2");

		List<ReimbursementType> reimbursementTypeList = Arrays.asList(reimbursementType1, reimbursementType2);

		when(reimbursementTypeRepo.findAll()).thenReturn(reimbursementTypeList);

		reimbursementtypeDto reimbursementtypeDto1 = new reimbursementtypeDto();
		reimbursementtypeDto1.setId(1);
		reimbursementtypeDto1.setType("Type 1");

		reimbursementtypeDto reimbursementtypeDto2 = new reimbursementtypeDto();
		reimbursementtypeDto2.setId(2);
		reimbursementtypeDto2.setType("Type 2");

		List<reimbursementtypeDto> expectedDtos = Arrays.asList(reimbursementtypeDto1, reimbursementtypeDto2);

		when(modelMapper.map(reimbursementType1, reimbursementtypeDto.class)).thenReturn(reimbursementtypeDto1);
		when(modelMapper.map(reimbursementType2, reimbursementtypeDto.class)).thenReturn(reimbursementtypeDto2);

		// When
		List<reimbursementtypeDto> actualDtos = reimbursementTypeService.getallreimbursementtype();

		// Then
		assertNotNull(actualDtos);
		assertEquals(expectedDtos.size(), actualDtos.size());
		assertEquals(expectedDtos.get(0).getId(), actualDtos.get(0).getId());
		assertEquals(expectedDtos.get(0).getType(), actualDtos.get(0).getType());
		assertEquals(expectedDtos.get(1).getId(), actualDtos.get(1).getId());
		assertEquals(expectedDtos.get(1).getType(), actualDtos.get(1).getType());
	}
}
