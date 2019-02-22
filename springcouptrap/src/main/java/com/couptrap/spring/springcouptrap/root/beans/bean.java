package com.couptrap.spring.springcouptrap.root.beans;

//import org.springframework.
import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class bean {
	
	private Map<String, String> people;
	public bean(){
		this.people = new HashMap<String, String>();
	}
	@PostConstruct
	public void init() {
		this.people.put("ID1", "name1");
		this.people.put("ID2", "name2");
		this.people.put("ID2", "name3");
		System.out.println("Init function !!!");
	}
	
	public void Msg(String msg) {
		System.out.println("Hello form" + msg);
	}
	@PreDestroy
	public void destory() {
		
		this.people.clear();
		System.out.println("Destroy");
	}
}
