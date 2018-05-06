package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.model.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeRepositoryImpl;
import salariati.repository.interfaces.IEmployeeRepository;
import salariati.repository.mock.EmployeeRepositoryMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TopDownTest {

    private IEmployeeRepository employeeRepository;
    private EmployeeController controller;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepositoryImpl();
        controller = new EmployeeController(employeeRepository);
    }
    @Test
    public void test1() {
        employeeRepository = new EmployeeRepositoryMock();
        controller = new EmployeeController(employeeRepository);
        Employee newEmployee = new Employee("Andrei", "Pop", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));

    }
    @Test
    public void test2() {
        employeeRepository = new EmployeeRepositoryMock();
        controller = new EmployeeController(employeeRepository);
        Employee newEmployee = new Employee("Andrei", "Pop", "22", "3333444441234", DidacticFunction.TEACHER, "9999");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));

        controller.modifyEmployee("3333444441234", DidacticFunction.LECTURER);
        Employee e = controller.getEmployeesList().get(controller.getEmployeesList().size()-1);
        assertEquals("Pop", e.getLastName());
        assertEquals(DidacticFunction.LECTURER, e.getFunction());

    }
    @Test
    public void test3() {
        employeeRepository = new EmployeeRepositoryMock();
        controller = new EmployeeController(employeeRepository);
        Employee newEmployee = new Employee("Andrei", "Pop", "22", "3333444441234", DidacticFunction.TEACHER, "9999");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));

        assertTrue(controller.getEmployeesSortedList().get(0).getLastName().equals("Pop"));

        controller.modifyEmployee("3333444441234", DidacticFunction.LECTURER);
        Employee e = controller.getEmployeesList().get(0);
        assertEquals("Pop", e.getLastName());
        assertEquals(DidacticFunction.LECTURER, e.getFunction());

    }

}
