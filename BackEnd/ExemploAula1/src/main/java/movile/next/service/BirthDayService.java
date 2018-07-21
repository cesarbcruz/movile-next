package movile.next.service;

import movile.next.model.Employee;
import movile.next.repository.EmployeeRepository;

import java.util.List;


public class BirthDayService {
	
	private EmailService emailService;
	private EmployeeRepository employeeRepository;
	
	public BirthDayService(EmployeeRepository employeeRepository, EmailService emailService) {
		this.emailService = emailService;
		this.employeeRepository = employeeRepository;
	}
	
	public void sendGreentingsToEmployeesBornOnly(int day, int month) {
		List<Employee> employees = employeeRepository.findEmployeeBornOn(day, month);
		for(Employee e : employees) {
			emailService.send(e);
		}
	}

}
