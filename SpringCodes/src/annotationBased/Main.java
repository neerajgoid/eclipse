package annotationBased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext aac = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		SayHi sh = (SayHi) aac.getBean("sayhi");
		sh.sayHello("Neeraj");
		
	}

}
