package com.Reimbursement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Reimbursement.Entity.ReimbursementType;

public interface ReimbursementTypeRepo extends JpaRepository<ReimbursementType,Integer> {

}
