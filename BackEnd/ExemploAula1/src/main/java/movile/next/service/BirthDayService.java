package movile.next.service;

import java.util.List;

import org.springframework.stereotype.Service;

import movile.next.model.Employee;
import movile.next.repository.EmployeeRepository;


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
