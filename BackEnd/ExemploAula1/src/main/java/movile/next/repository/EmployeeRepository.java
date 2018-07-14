package movile.next.repository;

import java.util.List;

import movile.next.model.Employee;

public interface EmployeeRepository {
	List<Employee> findEmployeeBornOn(int day, int month);
	void add(Employee employee);
}
