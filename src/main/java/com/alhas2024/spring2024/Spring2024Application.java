package com.alhas2024.spring2024;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring2024Application {
	public static void main(String[] args) {
		var ctx=SpringApplication.run(Spring2024Application.class, args);

        MyFirstService mysfirsMyFirstService=ctx.getBean(MyFirstService.class);
        System.out.println( mysfirsMyFirstService.toTellingStory());
	}
}
