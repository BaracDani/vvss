package salariati.repository.implementations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import salariati.exception.EmployeeException;

import salariati.model.DidacticFunction;
import salariati.model.Employee;

import salariati.repository.interfaces.IEmployeeRepository;
import salariati.validator.EmployeeValidator;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    private String employeeFileName = "employees.txt";
    private EmployeeValidator employeeValidator = new EmployeeValidator();


    public EmployeeRepositoryImpl(){
    }
    public EmployeeRepositoryImpl(String file){
        this.employeeFileName = file;
    }
    @Override
    public boolean addEmployee(Employee employee) {
        if (employeeValidator.isValid(employee)) {
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(employeeFileName, true));
                bw.write(employee.toString());
                bw.newLine();
                bw.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void deleteEmployee(Employee employee) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean modifyEmployee(String cnp, DidacticFunction function) {
        List<Employee> rez = getEmployeeList();
        BufferedWriter bw = null;
        boolean hasUpdated=false;
        try {
            bw = new BufferedWriter(new FileWriter(employeeFileName, false));
            for (Employee emp : rez) {
                if (emp.getCnp().equals(cnp)) {
                    emp.setFunction(function);
                    hasUpdated = true;
                }

                bw.write(emp.toString());
                bw.newLine();
            }

            bw.close();
            return hasUpdated;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<Employee>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(employeeFileName));
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                try {
                    Employee employee = Employee.getEmployeeFromString(line, counter);
                    employeeList.add(employee);
                } catch (EmployeeException ex) {
                    System.err.println("Error while reading: " + ex.toString());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error while reading: " + e);
        } catch (IOException e) {
            System.err.println("Error while reading: " + e);
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    System.err.println("Error while closing the file: " + e);
                }
        }

        return employeeList;
    }


    @Override
    public List<Employee> getEmployeeByCriteria(String criteria) {
        List<Employee> employeeList = new ArrayList<Employee>();

        return employeeList;
    }

}
