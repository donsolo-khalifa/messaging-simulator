package challenge;

public class Message {
	private String text;
	private String receipient;
	private int id;

	public Message(String text, String receipient, int id) {
		this.text = text;
		this.receipient = receipient;
		this.id = id;
	}

	public void getDetails() {
		System.out.println("text: "+ this.getText()+"\n reciepient: "+this.getReceipient()+"\n\n id: "+this.getId());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReceipient() {
		return receipient;
	}

	public void setReceipient(String receipient) {
		this.receipient = receipient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
