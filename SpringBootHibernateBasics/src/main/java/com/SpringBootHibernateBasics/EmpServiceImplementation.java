package com.SpringBootHibernateBasics;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImplementation implements InterfaceEmpService{

	@Autowired
	private EmpRepo empRepository;
	
	
	@Override
	public List<Employee> findAllEmp() {
		
				List<Employee> empList = (List<Employee>) empRepository.findAll();
		
		return empList;
	}
	

	@Override
	public boolean empPresent(int userId) {
		// TODO Auto-generated method stub
		
		boolean exists= empRepository.existsById(userId);
		//System.out.println("exists?:" + exists);
		return exists;
		
	
		
	}
	

	@Override
	public Employee findEmpById(int userId) {
		
			Employee e =	empRepository.findById(userId).get();
			return e;
			}
	
	
	

	@Override
	public int addEmployee(Employee e) {
		
		boolean exists= empRepository.existsById(e.getId());
		System.out.println("exists?:" + exists);
		
		if(exists) {
			System.out.println("Not added in db");
			return 0;
			
		}
		else {
			System.out.println("added in db");
			empRepository.save(e);	
			return 1;
		}
		// if @GeneratedValue is used.
		//We get a new value auto generated(auto increment for mySql) 
		// 
			}

	@Override
	public void deleteEmployee(int id) {
		
		empRepository.deleteById(id);
		
	}


	@Override
	public List<Employee> findBySalary(int salaryMin,int salaryMax) {
			
		List<Employee> eList= empRepository.findBySalary(salaryMin,salaryMax);
		return eList;
	}


	@Override
	public List<Employee> findByIdRange(int idMin,int idMax) {
		
		List<Employee> eList= empRepository.findByIdRange(idMin,idMax);
		return eList;
	}


	@Override
	public void updateEmployee(Employee e) {
		
		empRepository.save(e);
		
		
		
		
	}



	
	
	

}
