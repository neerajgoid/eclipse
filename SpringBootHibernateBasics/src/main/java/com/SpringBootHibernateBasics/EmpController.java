package com.SpringBootHibernateBasics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmpController {
	
	@Autowired
	InterfaceEmpService empServiceInterface; // object of the interface

	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String jspView(ModelMap mm) {
		
		List<Employee> empList = empServiceInterface.findAllEmp(); //hardcoded value
		mm.addAttribute("EmployeeList", empList);
		return "hi";
		
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public String empList(ModelMap mm) {
		
		List<Employee> empList = empServiceInterface.findAllEmp(); 
		mm.addAttribute("EmployeeList", empList);
		return "hi";
		
	}

	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public String jspView1(ModelMap mm,@RequestParam("filters") String filterChoice,@RequestParam("minFilterValue") int min,@RequestParam("maxFilterValue") int max) {
		
		System.out.println("Filter value: "+ filterChoice);
		List<Employee> empList=null; // check this might give error****************
		if(filterChoice.equals("salary")) {
			empList = empServiceInterface.findBySalary(min,max); //hardcoded value
		}
		else if(filterChoice.equals("id")) {
			empList = empServiceInterface.findByIdRange(min,max); //hardcoded value
		}
		
		mm.addAttribute("EmployeeList", empList);
		return "hi";
	//	List<Employee> empList = empServiceInterface.findAllEmp();
	//	mm.addAttribute("EmployeeList", empList);
		
		
	//	return "filter"; check this******************************************8
		
	}	
	
	
//    @RequestMapping(value="/login", method = RequestMethod.GET)
//    public String showLoginPage(ModelMap model){
//        return "login";
//    }
//    
    
//    @RequestMapping(value="/login", method = RequestMethod.POST) 
//    // on the /login  and then if do POST something this method gets called
//    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
//
//        if(name.equalsIgnoreCase("root") && password.equalsIgnoreCase("root")) {
//        	   model.put("name", name);
//               model.put("password", password); // can remove these 2 lines actually
//               
//               return "redirect:/admin"; // goes to /admin url and with GET method 
//        }
//        else {
//            model.put("errorMessage", "Invalid Credentials");
//            return "login";
//        }
//      
//    }
    
    @RequestMapping(value="/admin", method = RequestMethod.GET)
    public String showAdminOptions(ModelMap model) {
    	return "welcome";
    }
  
//	@RequestMapping(value="/admin",method = RequestMethod.POST)
//	public String empList(ModelMap mm) {
//		
//		List<Employee> empList = empServiceInterface.findAllEmp();
//		mm.addAttribute("EmployeeList", empList);
//		return "hi";
//		
//	}    
    
    
    
//	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
//	public String userCheck(ModelMap mm, @PathVariable("userId") int userId) {
//		
//		Employee e = empServiceInterface.findEmpById(userId);
//		mm.addAttribute("EmployeeInfo",e);
//		return "userPage";
//		
//		
//		
//		
//	}
	
	@RequestMapping(value = "user/search", method = RequestMethod.POST)
	public String userSearch(ModelMap mm, @RequestParam("id") int userId) {
		
		boolean present = empServiceInterface.empPresent(userId);
		if(present) {
			Employee e = empServiceInterface.findEmpById(userId);
			mm.addAttribute("success","Employee Found");
			mm.addAttribute("EmployeeInfo",e);
		}
		
		else{
			mm.addAttribute("error", "Employee not found");
			
		}
	
		return "userPage";
	
	}
	
	
	@RequestMapping(value = "user/update", method = RequestMethod.POST)
	public String userUpdate(ModelMap mm, @RequestParam("id") int userId) {
		
		boolean present = empServiceInterface.empPresent(userId);
		if(present) {
			Employee e = empServiceInterface.findEmpById(userId);
			mm.addAttribute("success","Employee Found");
			mm.addAttribute("status",1);
			mm.addAttribute("EmployeeInfo",e);
		}
		
		else{
			mm.addAttribute("status",0);
			mm.addAttribute("error", "Employee not found");
			
		}
	
		return "userUpdate";
	
	}
	
	@RequestMapping(value="/user/update" , method = RequestMethod.GET) // done this as a get method
	//now for get method, data is shown in the URL
	public String updateUser(ModelMap mm, @RequestParam("id") int userId,@RequestParam("fname") String firstName,@RequestParam("lname") String lastName,@RequestParam("salary") int salary) {
		
		Employee e = new Employee();
		e.setId(userId);
		// only useful if @generated value is not used
		
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		
		empServiceInterface.updateEmployee(e);
		mm.addAttribute("successUpdate","Employee updated successfully");
		return "welcome";
		
//		int validate = empServiceInterface.addEmployee(e);
//		
//		System.out.println("valid:"+ validate);
//		
//		if(validate==0)
//		{
//			mm.addAttribute("errorInAdd", "User ID already exists");
//			//mm.put("error", "User ID already exists");
//	//		return "redirect:/admin";
//		return "welcome";
//		}
//		else {
//			mm.addAttribute("successInAdd","Employee added successfully");
//			return "welcome";
//			//return "redirect:/admin";
//		}	
			
		// if @GeneratedValue is used.
		//We get a new value auto generated(auto increment for mySql) 
		
		
	}
	
	
	@RequestMapping(value="/user/add" , method = RequestMethod.GET) // done this as a get method
	//now for get method, data is shown in the URL
	public String addUser(ModelMap mm, @RequestParam("id") int userId,@RequestParam("fname") String firstName,@RequestParam("lname") String lastName,@RequestParam("salary") int salary) {
		
		Employee e = new Employee();
		e.setId(userId);
		// only useful if @generated value is not used
		
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setSalary(salary);
		
		int validate = empServiceInterface.addEmployee(e);
		
		System.out.println("valid:"+ validate);
		
		if(validate==0)
		{
			mm.addAttribute("errorInAdd", "User ID already exists");
			//mm.put("error", "User ID already exists");
	//		return "redirect:/admin";
		return "welcome";
		}
		else {
			mm.addAttribute("successInAdd","Employee added successfully");
			return "welcome";
			//return "redirect:/admin";
		}	
			
		// if @GeneratedValue is used.
		//We get a new value auto generated(auto increment for mySql) 
		
		
	}
	
	
	@RequestMapping(value = "user/delete", method = RequestMethod.POST)
	public String userDelete(ModelMap mm, @RequestParam("id") int userId) {
		
		boolean present = empServiceInterface.empPresent(userId);
		if(present) {
			empServiceInterface.deleteEmployee(userId);
			mm.addAttribute("successInDelete","Employee record deleted");
		}
		else {
			mm.addAttribute("errorInDelete","Employee record not found");
		}

		return "welcome";
	
	}

}
