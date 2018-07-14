package movile.next.model;

public class Employee {
	private String nome;
	private String email;
	private int dayOfBirth;
	private int monthOfBirth;
	
	public Employee(String nome, String email, int dayOfBirth, int monthOfBirth) {
		super();
		this.nome = nome;
		this.email = email;
		this.dayOfBirth = dayOfBirth;
		this.monthOfBirth = monthOfBirth;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDayOfBirth() {
		return dayOfBirth;
	}
	public void setDayOfBirth(int dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}
	public int getMonthOfBirth() {
		return monthOfBirth;
	}
	public void setMonthOfBirth(int monthOfBirth) {
		this.monthOfBirth = monthOfBirth;
	}
	
	public boolean bornOn(int day, int month) {
		return this.dayOfBirth == day && this.monthOfBirth == month;
	}
}
