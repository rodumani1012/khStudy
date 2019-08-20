package c0713.message2;

public class Message {
	//멤버변수
	private String message;
	//생성자
	public Message() {
		System.out.println("Constructor : Message()");
	}
	//생성자 2
	public Message(String message) {
		this.message = message;
		System.out.println("Constructor : Message(String message)");
	}
	//getter setter
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public void printInfo() {
		System.out.println("Message Information -------------------");
		System.out.println("Message = [" + message + "]");
		
	}
	
}
