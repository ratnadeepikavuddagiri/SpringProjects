package com.helpers;

import java.util.List;

import com.models.Worker;

public class WorkerHelper {
	public static void printAllWorkers(List<Worker> workers) {
		for(Worker worker: workers) {
			System.out.println("ID: " + worker.getWorkerId());
			System.out.println("FIRSTNAME: " + worker.getFirstName());
			System.out.println("LASTNAME: " + worker.getLastName());
			System.out.println("SALARY: " + worker.getSalary());
			System.out.println("JOINING DATE: " + worker.getJoiningDate());
			System.out.println("E-MAIL: " + worker.getEmail());
			System.out.println("DEPARTMENT: " + worker.getDepartment());
			System.out.println();
		}
	}
}
