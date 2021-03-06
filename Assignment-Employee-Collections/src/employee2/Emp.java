package employee2;

public class Emp {

	
String name;
private int id;
private int age;
private int salary;

		public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public int getAge() {
	return age;
}

public void setAge(int age) {
	this.age = age;
}

public int getSalary() {
	return salary;
}

public void setSalary(int salary) {
	this.salary = salary;
}

		Emp(int id,String name,int age,int salary)
		{
			this.id =id;
			this.name=name;
			this.age= age;
			this.salary=salary;
		}
		
	/*	@Override
		public int hashCode()
		{
		 int hash=0;
		     hash = hash  + id.hashCode();
		     hash = hash  +  name.hashCode();
		     return hash;
		}
		*/
		@Override
		public int hashCode() { //can automatically generate hashcode and equals function (Source-> generate )
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			//int x=1;
			//x =x + id.hashCode();  //cannot have hashcode for primitive datatypes coz You cannot invoke methods on primitive types.
			
			
			return result;
		} 

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Emp other = (Emp) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	
}
