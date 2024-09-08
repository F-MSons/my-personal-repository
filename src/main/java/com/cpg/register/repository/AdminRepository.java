package com.cpg.register.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cpg.register.model.Student;

@Repository
public interface AdminRepository extends CrudRepository<Student, Long>{

}
