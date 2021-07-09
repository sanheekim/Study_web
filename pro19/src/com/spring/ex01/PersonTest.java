package com.spring.ex01;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person = (PersonService)factory.getBean("personService");
		// PersonService person = new PersonServiceImpl();
		// 더 이상 자바코드에서 객체를 직접 생성하지 않아도 됨. xml로 스프링 의존주입 하기 때문.
		// (com.spring.ex01은 xml이고 com.spring.ex02는 생성자로 함.)
		person.sayHello();
	}
}
