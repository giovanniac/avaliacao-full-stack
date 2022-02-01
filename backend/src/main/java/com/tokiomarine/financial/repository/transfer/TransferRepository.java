package com.tokiomarine.financial.repository.transfer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tokiomarine.financial.model.Transfer;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {


}
