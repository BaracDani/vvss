package salariati.view;

import salariati.controller.EmployeeController;
import salariati.model.DidacticFunction;
import salariati.model.Employee;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Barac on 3/17/2018.
 */
public class EmployeeUI {

    public EmployeeController employeeController;

    public EmployeeUI(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void run() {
        showMenu();
    }

    private String input(String mesaj) {
        Scanner input = new Scanner(System.in);
        System.out.print(mesaj);
        return input.nextLine();
    }

    private void showMenu() {

        String cmd = "";
        boolean isRunning = true;

        while (isRunning) {
            printCommands();

            cmd = input("Enter command: ");
            System.out.println();

            switch (cmd.charAt(0)) {
                case '1':
                    createEmployee();
                    break;
                case '2':
                    modifyEmployee();
                    break;
                case '3':
                    showEmployeesOrdered();
                    break;
                case '4':
                    showEmployees();
                    break;
                case '0':
                    System.out.println("Bye");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid command!");
                    break;
            }
            System.out.println("\n--------------");

            if (cmd.equals("0") || !isRunning)
                break;
        }
    }

    public void printCommands() {
        System.out.println("1. Add employee");
        System.out.println("2. Modify didactic function of employee");
        System.out.println("3. Show employees ordered by salary and age");
        System.out.println("4. Show employees list");
        System.out.println("0. Exit");
    }


    private void createEmployee() {
        String firstName = input("First name = ");
        String lastName = input("Last name = ");
        String age = input("Age = ");
        String cnp = input("CNP = ");
        String function = input("Didactic Function = ");
        String salary = input("SALARY = ");
        DidacticFunction df;

        if (function.equals("ASISTENT"))
            df = DidacticFunction.ASISTENT;
        else if (function.equals("LECTURER"))
            df = DidacticFunction.LECTURER;
        else if (function.equals("TEACHER"))
            df = DidacticFunction.TEACHER;
        else if (function.equals("CONFERENTIAR"))
            df = DidacticFunction.CONFERENTIAR;
        else {
            System.out.println("Invalid didactic function \n");
            return;
        }

        Employee emp = new Employee(firstName, lastName, age, cnp, df, salary);
        if(employeeController.addEmployee(emp)) {
            System.out.println("Employee " + emp.getFirstName() + " created");
        } else {
            System.out.println("Invalid employee");
        }

    }

    private void modifyEmployee() {
        String cnp = input("Employee CNP to be modified = ");
        String function = input("Didactic Function = ");
        DidacticFunction df;

        if (function.equals("ASISTENT"))
            df = DidacticFunction.ASISTENT;
        else if (function.equals("LECTURER"))
            df = DidacticFunction.LECTURER;
        else if (function.equals("TEACHER"))
            df = DidacticFunction.TEACHER;
        else if (function.equals("CONFERENTIAR"))
            df = DidacticFunction.CONFERENTIAR;
        else {
            System.out.println("Invalid didactic function \n");
            return;
        }
        if(employeeController.modifyEmployee(cnp, df)) {
            System.out.println("Employee " + cnp + " updated");
        } else {
            System.out.println("Invalid employee cnp");
        }


    }

    private void showEmployeesOrdered() {
        for (Employee _employee : employeeController.getEmployeesSortedList())
            System.out.println(_employee.toString());
        System.out.println("-----------------------------------------");
    }

    private void showEmployees() {
        for (Employee _employee : employeeController.getEmployeesList())
            System.out.println(_employee.toString());
        System.out.println("-----------------------------------------");
    }
}
