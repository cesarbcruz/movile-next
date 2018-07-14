package movile.next.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import movile.next.model.Employee;

public class FileEmployeeRepository implements EmployeeRepository{
	
	public FileEmployeeRepository() throws IOException {
		loadFromFile("employee.txt");
	}

	private List<Employee> employees = new ArrayList<>();
	
	@Override
	public List<Employee> findEmployeeBornOn(int day, int month) {
		return employees;
	}

	@Override
	public void add(Employee employee) {
		employees.add(employee);		
	}
	
	public void loadFromFile(String fileLocation) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileLocation));
		String line;
		while((line = br.readLine()) != null) {
			String [] prop = line.split(",");
			String nome = prop[0];
			String email = prop[1];
			int dayOfBirth = Integer.parseInt(prop[2].trim());
			int monthOfBirth = Integer.parseInt(prop[3].trim());
			employees.add(new Employee(nome, email, dayOfBirth, monthOfBirth));
		}
		br.close();
	}

}
