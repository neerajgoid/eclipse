package annotationBased;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
@Configuration
public class AnnotationConfig {
	
	@Bean
	(name="sayhi")
	@Description
	("Sample COde")
	public SayHi getSayHi() { // why do we need this method?
		return new SayHi();
	}
	
	/*
	 * The @Bean annotation tells Spring that a method annotated with
	 *  @Bean will return an object that should be registered as a
	 *   bean in the Spring application context. 
	 */
	
	//@Bean annotated method which returns a new instance of this class.( this is Java-based configuration).
	
	
	

}
