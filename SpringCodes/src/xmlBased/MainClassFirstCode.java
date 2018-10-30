package xmlBased;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClassFirstCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloMsg obj = (HelloMsg) context.getBean("helloMsg");
		obj.getMsg();
	

	}

}
