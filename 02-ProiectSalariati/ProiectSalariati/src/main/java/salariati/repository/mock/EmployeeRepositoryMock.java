package salariati.repository.mock;

import java.util.ArrayList;
import java.util.List;

import salariati.model.DidacticFunction;

import salariati.model.Employee;
import salariati.repository.interfaces.IEmployeeRepository;
import salariati.validator.EmployeeValidator;

public class EmployeeRepositoryMock implements IEmployeeRepository {

    private List<Employee> employeeList;
    private EmployeeValidator employeeValidator;

    public EmployeeRepositoryMock() {

        employeeValidator = new EmployeeValidator();
        employeeList = new ArrayList<Employee>();

        Employee Ionel = new Employee("FirstName", "Pacuraru", "45", "1234567890876", DidacticFunction.ASISTENT, "2500");
        Employee Mihai = new Employee("FirstName", "Dumitrescu", "45", "1234567890876", DidacticFunction.LECTURER, "2500");
        Employee Ionela = new Employee("FirstName", "Ionescu", "45", "1234567890876", DidacticFunction.LECTURER, "2500");
        Employee Mihaela = new Employee("FirstName", "Pacuraru", "45", "1234567890876", DidacticFunction.ASISTENT, "2500");
        Employee Vasile = new Employee("FirstName", "Georgescu", "45", "1234567890876", DidacticFunction.TEACHER, "2500");
        Employee Marin = new Employee("FirstName", "Puscas", "45", "1234567890876", DidacticFunction.TEACHER, "2500");

        employeeList.add(Ionel);
        employeeList.add(Mihai);
        employeeList.add(Ionela);
        employeeList.add(Mihaela);
        employeeList.add(Vasile);
        employeeList.add(Marin);
    }

    @Override
    public boolean addEmployee(Employee employee) {
        if (employeeValidator.isValid(employee)) {
            employeeList.add(employee);
            return true;
        }
        return false;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean modifyEmployee(String cnp, DidacticFunction function) {
        return false;
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeeByCriteria(String criteria) {
        // TODO Auto-generated method stub
        return null;
    }

}
