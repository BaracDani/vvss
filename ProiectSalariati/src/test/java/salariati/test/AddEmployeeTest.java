package salariati.test;

import static org.junit.Assert.*;

import com.sun.deploy.util.StringUtils;
import salariati.model.Employee;

import org.junit.Before;
import org.junit.Test;

import salariati.repository.interfaces.IEmployeeRepository;
import salariati.repository.mock.EmployeeRepositoryMock;
import salariati.validator.EmployeeValidator;
import salariati.controller.EmployeeController;
import salariati.model.DidacticFunction;

import java.util.Arrays;

public class AddEmployeeTest {

    private IEmployeeRepository employeeRepository;
    private EmployeeController controller;
    private EmployeeValidator employeeValidator;

    @Before
    public void setUp() {
        employeeRepository = new EmployeeRepositoryMock();
        controller = new EmployeeController(employeeRepository);
        employeeValidator = new EmployeeValidator();
    }

    @Test
    public void testRepositoryMock() {
        assertFalse(controller.getEmployeesList().isEmpty());
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testAddNewEmployee() {
        Employee newEmployee = new Employee("ValidFirstName", "ValidLastName", "33", "1910509055057", DidacticFunction.ASISTENT, "3000");
        assertTrue(employeeValidator.isValid(newEmployee));
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));
    }

    @Test
    public void testCase1() {
        Employee newEmployee = new Employee("Andrei", "Pop", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
        assertTrue(newEmployee.equals(controller.getEmployeesList().get(controller.getEmployeesList().size() - 1)));

    }

    @Test
    public void testCase2() {
        Employee newEmployee = new Employee("", "Pop", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }

    @Test
    public void testCase3() {
        Employee newEmployee = new Employee("Andrei", "Pop", "211a", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }
    @Test
    public void testCase4() {
        Employee newEmployee = new Employee("Andrei", "Pop", "11", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }
    @Test
    public void testCase5() {
        Employee newEmployee = new Employee("M", "Barac", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }
    @Test
    public void testCase6() {
        char[] chars=new char[255];
        Arrays.fill(chars,'M');
        String firstname=new String(chars);
        Employee newEmployee = new Employee(firstname, "Barac", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
    }
    @Test
    public void testCase7() {
        char[] chars=new char[254];
        Arrays.fill(chars,'M');
        String firstname=new String(chars);
        Employee newEmployee = new Employee(firstname, "Barac", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());

    }
    @Test
    public void testCase8() {
        Employee newEmployee = new Employee("Daniel", "", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }
    @Test
    public void testCase9() {
        Employee newEmployee = new Employee("Daniel", "B", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(6, controller.getEmployeesList().size());
    }
    @Test
    public void testCase10() {

        char[] chars=new char[255];
        Arrays.fill(chars,'B');
        String firstname=new String(chars);
        Employee newEmployee = new Employee("Daniel", "Pop", "22", "1234567891234", DidacticFunction.TEACHER, "2222");
        controller.addEmployee(newEmployee);
        assertEquals(7, controller.getEmployeesList().size());
    }


}
