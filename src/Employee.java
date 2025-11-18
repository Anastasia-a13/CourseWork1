public class Employee {
    private final int id;
    private final String fullName;
    private int department;
    private int salary;
    private static int nextId = 1;

    public Employee(String fullName, int department, int salary) {
        this.id = nextId++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return this.salary == employee.salary;
    }

    @Override
    public String toString() {
        return "Сотрудник: " + this.fullName + " Отдел: " + this.department + ". Зарплата: " + this.salary;
    }

    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ", Зарплата: " + salary);
    }

}