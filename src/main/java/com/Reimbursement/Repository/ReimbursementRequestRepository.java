package com.Reimbursement.Repository;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Reimbursement.Entity.ReimbursementRequest;

public interface ReimbursementRequestRepository extends JpaRepository<ReimbursementRequest, Integer>
{
	//Optional<ReimbursementRequest> findById(Long id);
	 List<ReimbursementRequest> findByTravelRequestId(Integer travelRequestId);
//	 List<ReimbursementRequest> findById(Integer id);
}
