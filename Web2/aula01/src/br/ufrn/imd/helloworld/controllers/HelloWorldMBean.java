package br.ufrn.imd.helloworld.controllers;

import java.util.Random;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloWorldMBean {
	
	public String getWorld() {
		return "Hello World JSF!";
	}
	
	public int getSorteio() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}

}
