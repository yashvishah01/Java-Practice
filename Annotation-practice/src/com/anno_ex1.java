package com;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Target(value = { ElementType.METHOD , ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
@interface RequestMapping{
	String url();
}


class container{
	public void proccess(String url)  {
		Class<?> clazz;
		try {
			clazz = Class.forName("com.Usercon");
			Object instance = clazz.newInstance();
			
			Method[] methods = clazz.getMethods();
			for(Method method: methods) {
				RequestMapping rm = method.getAnnotation(RequestMapping.class);
						if(rm!=null) {
							String givenurl = rm.url();
							if(url.equals(givenurl)) {
								method.invoke(instance, new Object[] {});
							}
						}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}

		
	}
}

class Usercon{
	@RequestMapping(url = "user/login")
	public void doLogin() {
		System.out.println("login");
	}
}
public class anno_ex1 {
	public static void main(String [] args) {
		container c = new container();
		c.proccess("user/login");
	}
}
