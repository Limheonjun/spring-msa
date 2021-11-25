package com.emgc.divisionservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.emgc.divisionservice.domain.Number2;

@Repository
public interface Number2Repository extends ReactiveCrudRepository<Number2, Long> {
}
