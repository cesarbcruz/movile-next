package movile.next.service;

import movile.next.repository.EmployeeRepository;
import movile.next.util.EmployeeRepositoryEnum;

public class EmployeeRepositoryFactory {
	
	private EmployeeRepositoryFactory() {	
	}
	
	public static EmployeeRepository obterImplementacao(int tipoImplementacaoRepository) throws InstantiationException, IllegalAccessException {
		return (EmployeeRepository) EmployeeRepositoryEnum.get(tipoImplementacaoRepository).newInstance();
	}
	
}
