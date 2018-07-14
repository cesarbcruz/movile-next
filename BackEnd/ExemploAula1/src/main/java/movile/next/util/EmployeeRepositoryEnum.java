package movile.next.util;

import movile.next.repository.FileEmployeeRepository;
import movile.next.repository.MemoryEmployeeRepository;


public enum EmployeeRepositoryEnum {
	
	FILE(1, FileEmployeeRepository.class),
	MEMORY(2, MemoryEmployeeRepository.class);
	
	private int tipo;
	private Class implementacao;
	
	private EmployeeRepositoryEnum(int tipo, Class implementacao) {
		this.tipo = tipo;
		this.implementacao = implementacao;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public Class getImplementacao() {
		return implementacao;
	}
	
	public static Class get(int tipo) {
		for(EmployeeRepositoryEnum e : EmployeeRepositoryEnum.values()) {
			if(e.getTipo() == tipo) {
				return e.getImplementacao();
			}
		}
		return null;

	}

}
