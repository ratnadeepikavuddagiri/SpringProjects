
public class MyBean {
	String firstName;
	String lastName;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static MyBean getInstance() {
		return new MyBean();
	}
	@Override
	public String toString() {
		return "MyBean [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
