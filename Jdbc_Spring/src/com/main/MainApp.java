package com.main;
import java.sql.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpers.WorkerHelper;
import com.models.Worker;
import com.services.WorkerJdbcTemplate;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Worker.xml");
		
		WorkerJdbcTemplate workerJdbcTemplate =  (WorkerJdbcTemplate) context.getBean("workerJdbcTemplate");
		
		System.out.println("************** Records Creation **************");
		workerJdbcTemplate.create(9,"Deepika","Vuddagiri",20000,Date.valueOf("2022-03-29"),"Admin","deepika@gmail.com");
		workerJdbcTemplate.create(10,"Jhansi","Pothuru",30000,Date.valueOf("2022-03-20"),"HR","jhansi@gmail.com");
		System.out.println("************** Records Updation **************");
		workerJdbcTemplate.update(9, 50000);
		System.out.println("************** Retrieving 1 record **************");
		System.out.println(workerJdbcTemplate.getWorkerById(9));
		System.out.println();
		System.out.println("************** Records Deletion **************");
		workerJdbcTemplate.delete(10);
		System.out.println("************** Displaying Worker Records **************");
		List<Worker> workers = workerJdbcTemplate.getAllWorkers(); 
		WorkerHelper.printAllWorkers(workers);
	}

}
