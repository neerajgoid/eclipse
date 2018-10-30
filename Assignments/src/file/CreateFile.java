package file;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateFile {
	static List<Employee> employees = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		createObjEmployee();
		Path myDirectory = Paths.get("output/employee.csv"); // Assignments/output
		boolean dirExists = Files.exists(myDirectory);

		if (dirExists) {
			System.out.println("Directory: " + myDirectory.toAbsolutePath() + " already exists");
		} else {
			Files.createDirectories(myDirectory.getParent()); // create a directory - output // these 2 lines combined to create a file inside a directory
			Files.createFile(myDirectory); // creates a file - employee.csv
		}
		
			
//		Path myPath = Paths.get("abc.csv");
//		if (Files.exists(myPath)) {
//			System.out.println("File: " + myPath.toAbsolutePath() + " already exists");
//		} else {
//			Files.createFile(myPath);
//		}
//		
		FileWriter fw = new FileWriter(myDirectory.toFile());
		insertIntoCsv(fw);
		
		
	}
	
	public static void createObjEmployee(){
		Scanner scanner = new Scanner(System.in);
		int i=0;
		
		while(i<2) {
		
		System.out.println("Enter your Id");
		int id = scanner.nextInt();
		
		System.out.println("Enter your first Name");
		String firstName = scanner.next();
		
		System.out.println("Enter your last Name");
		String lastName = scanner.next();
		
		System.out.println("Enter your age");
		int age = scanner.nextInt();
		
		 Employee e = new Employee(age, id, firstName, lastName);
		 employees.add(e);
		 i++;
		}
		
		
		
		
	}
	
	public static void insertIntoCsv(FileWriter fw) throws IOException {
		
		 String fileHeader = "id,firstName,lastName,age";
		 
		 fw.append(fileHeader);
		 fw.write(System.lineSeparator());
		 
		 
		for(Employee e: employees) {
//			fw.append(String.valueOf(e.id));      // works with append and write. both are the same almost
//			fw.append(",");						// append works with char sequence. write works with String			
//			
//			fw.append(e.firstName);
//			fw.append(",");
//			
//			fw.append(e.lastName);
//			fw.append(",");
//			
//			fw.append(String.valueOf(e.age));
//			fw.append(",");
//			fw.append("\n");
			
			fw.write(String.valueOf(e.id));
			fw.write(",");
			
			fw.write(e.firstName);
			fw.write(",");
			
			fw.write(e.lastName);
			fw.write(",");
			
			fw.write(String.valueOf(e.age));
		//	fw.write(",");
		//	fw.write("\n");
			 fw.write(System.lineSeparator());
		}
		System.out.println("CSV created successfully");
		fw.flush();
		fw.close();
	}

}
