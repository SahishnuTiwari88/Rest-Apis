package com;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    	 ConfigurableApplicationContext app=new ClassPathXmlApplicationContext("beanConfig.xml");
         
         StudentDao dao=(StudentDao) app.getBean("StudentDAO");
          dao.addStudents();
          dao.getAllDetails();
          dao.getDetails(7);
          
    }
}
