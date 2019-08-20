package c0716.user;

public class Kart {
	private String name, color;
	private int speed, booster;
	
	public Kart() {
		
	}
	
	public Kart(String name, String color, int speed, int booster) {
		this.name = name;
		this.color = color;
		this.speed = speed;
		this.booster = booster;
	}
	
	public String getName() {
		return name;
	}
	public String getColor() {
		return color;
	}
	public int getSpeed() {
		return speed;
	}
	public int getBooster() {
		return booster;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setBooster(int booster) {
		this.booster = booster;
	}
	
	public void printInfo() {
		System.out.println("īƮ ����------------------------------------------------------");
		System.out.print("īƮ�ٵ�=[" + name + "]");
		System.out.print("\t����=[" + color + "]");
		System.out.print("\t�ӵ�=[" + speed + "]");
		System.out.println("\t\t�ν��ͽ���=[" + booster + "]");
		System.out.println("---------------------------------------------------------------");
	}
	
}
