package com.emgc.multiplyservice.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.emgc.multiplyservice.domain.Number;

@Repository
public interface NumberRepository extends ReactiveCrudRepository<Number, Long> {
}
