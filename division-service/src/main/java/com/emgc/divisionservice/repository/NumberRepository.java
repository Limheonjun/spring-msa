package com.emgc.divisionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.emgc.divisionservice.domain.Number;

@Repository
public interface NumberRepository extends ReactiveCrudRepository<Number, Long> {
}
