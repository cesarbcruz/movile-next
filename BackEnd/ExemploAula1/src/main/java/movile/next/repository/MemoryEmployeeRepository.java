package movile.next.repository;

import java.util.ArrayList;
import java.util.List;

import movile.next.model.Employee;

public class MemoryEmployeeRepository implements EmployeeRepository {
	
	void EmployeeRepository(){
		Employee employee = new Employee("cesar", "cesar@gmail.com", 22, 12);
		Employee employee2 = new Employee("jose", "cesar@gmail.com", 1, 12);
		Employee employee3 = new Employee("maria", "cesar@gmail.com", 2, 12);
		Employee employee4 = new Employee("paulo", "cesar@gmail.com", 3, 12);
		
		add(employee);
		add(employee2);
		add(employee3);
		add(employee4);
	}

	
	private List<Employee> employees = new ArrayList<>();
	
	@Override
	public List<Employee> findEmployeeBornOn(int day, int month) {
		List<Employee> employeesBornOn = new ArrayList<>();
		for(Employee employee : employees) {
			if(employee.bornOn(day, month)) {
				employeesBornOn.add(employee);
			}
		}

		return employeesBornOn;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);		
	}

}
