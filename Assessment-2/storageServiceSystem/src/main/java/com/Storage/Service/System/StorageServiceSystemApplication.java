package com.Storage.Service.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class StorageServiceSystemApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StorageServiceSystemApplication.class, args);
		StorageService storageService = context.getBean(StorageService.class);
		storageService.storeFile("file1.txt");

		StorageService storageService2 = context.getBean(CloudStorageService.class);
		storageService2.storeFile("file2.pdf");

		StorageService storageService3 = context.getBean(LocalStorageService.class);
		storageService3.storeFile("file3.csv");
		
		((ConfigurableApplicationContext)context).close();

	}

}
