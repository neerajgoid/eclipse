package com.SpringBootHibernateBasics;

import java.util.List;

public interface InterfaceEmpService {
	
	public List<Employee> findAllEmp();
	
	public boolean empPresent(int userId);
	public Employee findEmpById(int userIds);
	
	public int addEmployee(Employee e);
	
	public void deleteEmployee(int id);
	
	public List<Employee> findBySalary(int salaryMin,int salaryMax);
	
	public List<Employee> findByIdRange(int idMin,int idMax);
	
	public void updateEmployee(Employee e);

}
