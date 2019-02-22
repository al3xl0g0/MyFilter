package com.couptrap.spring.springcouptrap;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.couptrap.spring.springcouptrap.root.AppConfig;
//import com.couptrap.spring.springcouptrap.root.beans.Bean;
import com.couptrap.spring.springcouptrap.root.beans.bean;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
      AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
      
      bean b = ctx.getBean(bean.class);
      b.Msg("Hello from ALEX");
      
      b = ctx.getBean(bean.class);
      
      ctx.close();
      
      
    }
}
