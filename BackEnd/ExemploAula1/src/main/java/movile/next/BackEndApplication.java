package movile.next;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import movile.next.repository.EmployeeRepository;
import movile.next.service.BirthDayService;
import movile.next.service.DummyEmailService;
import movile.next.service.EmployeeRepositoryFactory;

@SpringBootApplication
public class BackEndApplication {

	private static int tipoInterfaceRepository;
	
	public static void main(String[] args) throws NumberFormatException, InstantiationException, IllegalAccessException {
		SpringApplication.run(BackEndApplication.class, args);

		EmployeeRepository employeeRepository = EmployeeRepositoryFactory.obterImplementacao(tipoInterfaceRepository);

		if(employeeRepository == null) {
			throw new IllegalArgumentException("O tipo implementação repositório não foi parametrizado.\n+Valores válidos [1,2]");
		}

		BirthDayService service = new BirthDayService(employeeRepository, new DummyEmailService());

		service.sendGreentingsToEmployeesBornOnly(22, 12);
	}

	@Value("${movile.next.tipo-interface-repository}")
	public void setTipoInterfaceRepository(int param) {
		this.tipoInterfaceRepository = param;
	}
}
