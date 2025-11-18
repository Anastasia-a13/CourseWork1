public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public void printAllEmployees() {
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    public double calculateAverageSalary() {
        int sum = 0;
        int count = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                sum += emp.getSalary();
                count++;
            }
        }
        if (count > 0) {
            return (double) sum / count;
        } else {
            return 0;
        }
    }

    public void printTaxes(String taxType) {
        for (Employee emp : employees) {
            if (emp == null) continue;
            int salary = emp.getSalary();
            double taxRate = 0;
            switch (taxType) {
                case "PROPORTIONAL":
                    taxRate = 0.13;
                    break;
                case "PROGRESSIVE":
                    if (salary < 150) {
                        taxRate = 0.13;
                    } else if (salary < 350) {
                        taxRate = 0.17;
                    } else {
                        taxRate = 0.21;
                    }
                    break;
                default:
                    System.out.println("Такого типа налога не существует" + taxType);
            }
            double tax = salary * taxRate;
            System.out.printf("Сотрудник: %s, Налог (%s): %.2f%n", emp.getFullName(), taxType, tax);
        }
    }

    public void indexSalaries(int department, double percent) {
        double coefficient = 1 + percent / 100.0;
        for (Employee emp : employees) {
            if (emp == null) continue;
            if (emp.getDepartment() != department) continue;
            emp.setSalary((int) (emp.getSalary() * coefficient));
        }
    }

    public void findFirstEmployeeBySalary(int department, int wage) {
        for (Employee emp : employees) {
            if (emp == null) {
                continue;
            }
            if (emp.getDepartment() == department && emp.getSalary() > wage) {
                System.out.println("Найден сотрудник ID: " + emp.getId());
                emp.printShortInfo();
            }
        }
    }

    public void findEmployeesBySalary(int wage, int employeeNumber) {
        int counter = 0;
        int i = 0;
        while (i < employees.length && counter < employeeNumber) {
            Employee emp = employees[i];
            if (emp != null && emp.getSalary() < wage) {
                emp.printShortInfo();
                counter++;
            }
            i++;
        }
    }

    public boolean containsEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp != null && emp.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    public void printEmployeesByDepartment(int department) {
        System.out.println("Сотрудники отдела №" + department);
        for (Employee emp : employees) {
            if (emp != null && emp.getDepartment() == department) {
                System.out.println(emp);
            }
        }
    }
}