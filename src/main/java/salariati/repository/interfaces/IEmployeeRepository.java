package salariati.repository.interfaces;

import java.util.List;

import salariati.model.DidacticFunction;
import salariati.model.Employee;

public interface IEmployeeRepository {
	
	boolean addEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	boolean modifyEmployee(String cnp, DidacticFunction function);
	List<Employee> getEmployeeList();
	List<Employee> getEmployeeByCriteria(String criteria);

}
