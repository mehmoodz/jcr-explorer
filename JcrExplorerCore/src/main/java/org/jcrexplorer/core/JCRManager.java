package org.jcrexplorer.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JCRManager extends AbstractJCRManager{
	
	
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
 
		 		
		JCRManager manager=(JCRManager)context.getBean("jcrManager");
		manager.login("anonymousId",null);
		
	}


}
