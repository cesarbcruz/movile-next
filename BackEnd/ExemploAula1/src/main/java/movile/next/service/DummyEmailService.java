package movile.next.service;

import movile.next.model.Employee;

public class DummyEmailService implements EmailService {

	@Override
	public void send(Employee employee) {
		System.out.print("Email Enviado: "+employee.getNome());
	}

}
