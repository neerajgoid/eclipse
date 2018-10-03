package treemapp;

public class TmEmployee implements Comparable<TmEmployee>{
	 /// need to run to code : 'TmSortingValue.java'
private	String name;
private	int salary;

	public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
	
	TmEmployee(String name,int salary)
	{
		this.name=name;
		this.salary=salary;
	}
	@Override
	public int compareTo(TmEmployee o) {
		if(o.getSalary() > this.getSalary())
			return 1;
		else if(o.getSalary() < this.getSalary())
			return -1;
		return 0;
	}
	
	
}
