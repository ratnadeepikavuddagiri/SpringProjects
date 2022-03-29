package com.userdata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserDataReader {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File("C:\\Users\\Ratna Deepika\\git\\SpringProjects\\spring-filehandling\\src\\user_data.xml");
	    Scanner sc = new Scanner(file);
	    UserBean userBean = UserBean.getInstance();
	    while(sc.hasNext()) {
	    	String s = sc.nextLine();
	    	if(s.contains("<first_name>")) {
	    		userBean.setFirstName(sc.nextLine().trim());
	    	}
	    	if(s.contains("<last_name>")) {
	    		userBean.setLastName(sc.nextLine().trim());
	    	}
	    }
	    System.out.println(userBean);

	}

}
