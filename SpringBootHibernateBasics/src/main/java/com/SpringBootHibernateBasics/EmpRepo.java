package com.SpringBootHibernateBasics;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends CrudRepository<Employee, Integer>{
	
	@Query(value = "select * from employee e where e.salary > ?1 and e.salary < ?2",nativeQuery = true) 
	  List<Employee> findBySalary(int salaryMin,int salaryMax);
	
	@Query(value = "select * from employee e where e.id > ?1 and e.id < ?2",nativeQuery = true) 
	  List<Employee> findByIdRange(int idMin,int idMax);
	
	

}
