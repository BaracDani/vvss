package salariati.model;

import salariati.exception.EmployeeException;
import salariati.validator.EmployeeValidator;

public class Employee {

    /**
     * The first name of the employee
     */
    private String firstName;

    /**
     * The last name of the employee
     */
    private String lastName;

    /**
     * The age of the employee
     */
    private String age;

    /**
     * The unique id of the employee
     */
    private String cnp;

    /**
     * The didactic function of the employee inside the university
     */
    private DidacticFunction function;

    /**
     * The salary of the employee
     */
    private String salary;

    /**
     * Default constructor for employee
     */
    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.age = "";
        this.cnp = "";
        this.function = DidacticFunction.ASISTENT;
        this.salary = "";
    }

    /**
     * Constructor with fields for employee
     */
    public Employee(String firstname, String lastName, String age, String cnp, DidacticFunction function, String salary) {
        this.firstName = firstname;
        this.lastName = lastName;
        this.age = age;
        this.cnp = cnp;
        this.function = function;
        this.salary = salary;
    }

    /**
     * Getter for the employee last name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for the employee last name
     *
     * @param firstName the last name to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for the employee last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for the employee last name
     *
     * @param lastName the last name to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for the employee age
     */
    public String getAge() {
        return age;
    }

    /**
     * Setter for the employee age
     *
     * @param age the last name to be set
     */
    public void setAge(String age) {
        this.age  = age;
    }


    /**
     * Getter for the employee CNP
     */
    public String getCnp() {
        return cnp;
    }

    /**
     * Setter for the employee CNP
     *
     * @param cnp the CNP to be set
     */
    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    /**
     * Getter for the employee didactic function
     */
    public DidacticFunction getFunction() {
        return function;
    }

    /**
     * Setter for the employee function
     *
     * @param function the function to be set
     */
    public void setFunction(DidacticFunction function) {
        this.function = function;
    }

    /**
     * Getter for the employee salary
     */
    public String getSalary() {
        return salary;
    }

    /**
     * Setter for the salary
     *
     * @param salary the salary to be set
     */
    public void setSalary(String salary) {
        this.salary = salary;
    }

    /**
     * toString function for employee
     */
    @Override
    public String toString() {
        String employee = "";

        employee += firstName + ";";
        employee += lastName + ";";
        employee += age + ";";
        employee += cnp + ";";
        employee += function.toString() + ";";
        employee += salary;

        return employee;
    }

    /**
     * equals function for employee
     */
    public boolean equals(Employee comparableEmployee) {
        boolean hasSameFirstName = this.firstName.equals(comparableEmployee.getFirstName()),
                hasSameLastName = this.lastName.equals(comparableEmployee.getLastName()),
                hasSameAge = this.age.equals(comparableEmployee.getAge()),
                hasSameCNP = this.cnp.equals(comparableEmployee.getCnp()),
                hasSameFunction = this.function.equals(comparableEmployee.getFunction()),
                hasSameSalary = this.salary.equals(comparableEmployee.getSalary());
        return hasSameFirstName && hasSameLastName && hasSameAge && hasSameCNP && hasSameFunction && hasSameSalary;
    }

    /**
     * Returns the Employee after parsing the given line
     *
     * @param _employee the employee given as String from the input file
     * @param line      the current line in the file
     * @return if the given line is valid returns the corresponding Employee
     * @throws EmployeeException
     */
    public static Employee getEmployeeFromString(String _employee, int line) throws EmployeeException {
        Employee employee = new Employee();

        String[] attributes = _employee.split("[;]");

        if (attributes.length != 6) {
            throw new EmployeeException("Invalid line at: " + line);
        } else {
            EmployeeValidator validator = new EmployeeValidator();
            employee.setFirstName(attributes[0]);
            employee.setLastName(attributes[1]);
            employee.setAge(attributes[2]);
            employee.setCnp(attributes[3]);

            if (attributes[4].equals("ASISTENT"))
                employee.setFunction(DidacticFunction.ASISTENT);
            if (attributes[4].equals("LECTURER"))
                employee.setFunction(DidacticFunction.LECTURER);
            if (attributes[4].equals("TEACHER"))
                employee.setFunction(DidacticFunction.TEACHER);
            if (attributes[4].equals("CONFERENTIAR"))
                employee.setFunction(DidacticFunction.CONFERENTIAR);

            employee.setSalary(attributes[5]);

            if (!validator.isValid(employee)) {
                throw new EmployeeException("Invalid line at: " + line);
            }
        }

        return employee;
    }

}
