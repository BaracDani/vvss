package salariati.test;

import org.junit.Before;
import org.junit.Test;
import salariati.controller.EmployeeController;
import salariati.model.DidacticFunction;
import salariati.model.Employee;
import salariati.repository.implementations.EmployeeRepositoryImpl;
import salariati.repository.interfaces.IEmployeeRepository;
import salariati.repository.mock.EmployeeRepositoryMock;
import salariati.validator.EmployeeValidator;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ModifyEmployeeTest {

    private IEmployeeRepository employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepositoryImpl();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }
    @Test
    public void testModify0() {
        String cnp = "";
        employeeRepository = new EmployeeRepositoryImpl("b.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(null, null);
        assertTrue(controller.getEmployeesList().size() == 0);
    }
    @Test
    public void testModify2() {
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
    @Test
    public void testModify3() {
        String cnp = "1234511111111";
        employeeRepository = new EmployeeRepositoryImpl("a.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(cnp, DidacticFunction.TEACHER);
        Employee e = controller.getEmployeesList().get(0);
        Employee e1 = controller.getEmployeesList().get(1);
        assertTrue(DidacticFunction.ASISTENT.equals(e.getFunction()));
        assertTrue(DidacticFunction.ASISTENT.equals(e1.getFunction()));
    }

    @Test
    public void testModify4() {
        String cnp = "1234567894444";
        employeeRepository = new EmployeeRepositoryImpl("d.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(cnp, DidacticFunction.LECTURER);
        Employee e = controller.getEmployeesList().get(2);
        assertTrue(DidacticFunction.LECTURER.equals(e.getFunction()));
    }

    @Test
    public void testModify5() {
        String cnp = "1234567895555";
        employeeRepository = new EmployeeRepositoryImpl("d.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(cnp, DidacticFunction.LECTURER);
        Employee e = controller.getEmployeesList().get(3);
        assertTrue(DidacticFunction.LECTURER.equals(e.getFunction()));
    }

    @Test
    public void testModify6() {

        employeeRepository = new EmployeeRepositoryMock();
        controller = new EmployeeController(employeeRepository);

        controller.modifyEmployee("3333444441234", DidacticFunction.LECTURER);
        Employee e = controller.getEmployeesList().get(0);
        assertTrue(DidacticFunction.ASISTENT.equals(e.getFunction()));
    }


}
