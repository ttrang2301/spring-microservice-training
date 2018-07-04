package com.brownfield.pss.baggage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brownfield.pss.baggage.entity.BaggageRecord;

public interface BaggageRepository extends JpaRepository<BaggageRecord, Long> {

	List<BaggageRecord> findByCheckinId(int checkinId);

}
