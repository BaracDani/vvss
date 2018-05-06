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
        String cnp = "1234567891234";
        employeeRepository = new EmployeeRepositoryImpl("c.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(cnp, DidacticFunction.TEACHER);
        Employee e = controller.getEmployeesList().get(0);
        assertTrue(DidacticFunction.TEACHER.equals(e.getFunction()));
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
        String cnp = "1234567115555";
        employeeRepository = new EmployeeRepositoryImpl("d.txt");
        controller = new EmployeeController(employeeRepository);
        controller.modifyEmployee(cnp, DidacticFunction.ASISTENT);
        Employee e = controller.getEmployeesList().get(3);
        assertTrue(DidacticFunction.LECTURER.equals(e.getFunction()));
    }


}
