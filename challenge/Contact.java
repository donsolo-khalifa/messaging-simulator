package challenge;

public class Contact {
	private String name;
	private String number;

	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}
	void getDetails() {
		System.out.println("name: "+this.getName()+"\n number: "+ this.getNumber());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
