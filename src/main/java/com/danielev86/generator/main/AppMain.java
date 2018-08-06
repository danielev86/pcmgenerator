package com.danielev86.generator.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import com.danielev86.generator.cyclistgenerator.CyclistGeneratorService;

@ComponentScan("com.danielev86")
@PropertySource("classpath:pcmgenerator_messages.properties")
public class AppMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppMain.class);
		CyclistGeneratorService cyclistService = ctx.getBean(CyclistGeneratorService.class);
		
		try {
			cyclistService.queryCyclistUpdateGenerator(args[0], args[1], args[2]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
