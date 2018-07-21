package movile.next.service;

import movile.next.model.Employee;

public class DummyEmailService implements EmailService {

	@Override
	public void send(Employee employee) {
		System.out.println("Email Enviado: "+employee.toString());
	}

}
