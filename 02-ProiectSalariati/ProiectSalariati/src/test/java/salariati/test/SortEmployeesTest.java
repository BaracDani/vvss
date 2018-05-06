package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.exception.EmployeeException;
import salariati.model.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeRepositoryImpl;
import salariati.repository.interfaces.IEmployeeRepository;
import salariati.validator.EmployeeValidator;

import static org.junit.Assert.assertTrue;

public class SortEmployeesTest {

    private IEmployeeRepository employeeRepository;
    private EmployeeController controller;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepositoryImpl();
        controller = new EmployeeController(employeeRepository);
    }
    @Test
    public void testSort1() {
        employeeRepository = new EmployeeRepositoryImpl("sort1.txt");
        controller = new EmployeeController(employeeRepository);
        assertTrue(controller.getEmployeesSortedList().size() == 4);
        assertTrue(controller.getEmployeesSortedList().get(0).getLastName().equals("CCC"));
        assertTrue(controller.getEmployeesSortedList().get(1).getLastName().equals("DDD"));
    }
    @Test
    public void testSort2() {
        employeeRepository = new EmployeeRepositoryImpl("sort2.txt");
        controller = new EmployeeController(employeeRepository);
        assertTrue(controller.getEmployeesSortedList().size() == 0);
    }


}
