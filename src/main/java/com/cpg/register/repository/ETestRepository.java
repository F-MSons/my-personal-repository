package com.cpg.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpg.register.model.Etest;

@Repository
public interface ETestRepository extends CrudRepository<Etest, Long>{

}
