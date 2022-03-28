import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FileReader {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("C:\\Users\\Ratna Deepika\\SpringProjects\\spring-filehandling\\src\\data.txt");
	    Scanner sc = new Scanner(file);
	    MyBean myBean = MyBean.getInstance();
	    myBean.setFirstName(sc.nextLine());
	    myBean.setLastName(sc.nextLine());
	    System.out.println(myBean);

	}

}
