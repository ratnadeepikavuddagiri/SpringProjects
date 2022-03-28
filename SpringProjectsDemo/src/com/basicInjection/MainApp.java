package com.basicInjection;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		context.start();
		Foo foo =context.getBean("foo",Foo.class);
		Bar bar = (Bar) context.getBean("bar");
		bar.setFoo(foo);
		bar.processFooName();
		System.out.println(bar);
		
	}

}
