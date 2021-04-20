package com.springbatch.demo;


import com.springbatch.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.ServiceLoader;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired(required = false)
	private ApplicationContext appContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String ...args) throws Exception{
		String[] names = appContext.getBeanDefinitionNames();
		Arrays.sort(names);
		ServiceLoader<TestService> serviceLoader = ServiceLoader.load(TestService.class);
		for (TestService testService : serviceLoader) {
			testService.sel();
		}
	}
}
