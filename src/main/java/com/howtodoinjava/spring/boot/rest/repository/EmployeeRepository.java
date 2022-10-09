package com.howtodoinjava.spring.boot.rest.repository;

import org.springframework.stereotype.Repository;

import com.howtodoinjava.spring.boot.rest.core.sqljpa.entity.AbstractJpaRepository;
import com.howtodoinjava.spring.boot.rest.entity.EmployeeEntity;
 
 
@Repository
public interface EmployeeRepository extends AbstractJpaRepository<EmployeeEntity,Long>  {

}
