package salariati.controller;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import salariati.model.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.interfaces.IEmployeeRepository;

public class EmployeeController {

    private IEmployeeRepository employeeRepository;

    public EmployeeController(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public boolean addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public List<Employee> getEmployeesList() {
        return employeeRepository.getEmployeeList();
    }

    public boolean modifyEmployee(String cnp, DidacticFunction function) {
       return employeeRepository.modifyEmployee(cnp, function);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepository.deleteEmployee(employee);
    }


    public List<Employee> getEmployeesSortedList() {

        List<Employee> result = getEmployeesList();
        if (result.size() == 0) {
            return result;
        }
        Collections.sort(result, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getSalary().equals(e2.getSalary())) {
                    return Integer.parseInt(e1.getAge()) > Integer.parseInt(e2.getAge()) ? 1 : -1;
                }
                return Integer.parseInt(e1.getSalary()) > Integer.parseInt(e2.getSalary()) ? -1 : 1;
            }
        });

        return result;
    }

}
