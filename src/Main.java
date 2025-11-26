public class Main {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иванов А.Д.", 3, 320),
                new Employee("Петрова М.С.", 1, 320),
                new Employee("Сидоров В.И.", 5, 410),
                new Employee("Козлова А.В.", 2, 240),
                new Employee("Морозов Д.Н.", 4, 380),
                new Employee("Волкова Е.П.", 1, 260),
                new Employee("Фёдоров А.М.", 3, 350),
                new Employee("Николаева И.А.", 2, 220),
                new Employee("Карпов С.В.", 5, 440),
                new Employee("Орлова О.Б.", 4, 310),
                new Employee("Беляев М.Ю.", 1, 190)
        };
        EmployeeBook employeeBook = new EmployeeBook();
        for (Employee employee : employees) {
            boolean added = employeeBook.addEmployee(employee);
            System.out.println("Сотрудник " + employee.getFullName() + " добавлен: " + added);
        }
        System.out.println("\nСписок всех сотрудников");
        employeeBook.printAllEmployees();
        System.out.println("\nСредняя зарплата");
        System.out.println(employeeBook.calculateAverageSalary());
        System.out.println("\nНалоги PROPORTIONAL");
        employeeBook.printTaxes("PROPORTIONAL");
        System.out.println("\nНалоги PROGRESSIVE");
        employeeBook.printTaxes("PROGRESSIVE");
        System.out.println("\nИндексация зарплат отдела №5 на 10%");
        employeeBook.indexSalaries(5, 10);
        employeeBook.printEmployeesByDepartment(5);
        System.out.println("\nПоиск сотрудника в отделе №2 с зарплатой выше 225");
        employeeBook.findFirstEmployeeBySalary(2, 225);
        System.out.println("\nПоиск 5 сотрудников с зарплатой ниже 300");
        employeeBook.findEmployeesBySalary(300, 5);
        System.out.println("\nЕсть ли сотрудник с зарплатой 260");
        Employee test = new Employee("Пример", 1, 260);
        System.out.println("Сотрудник с зарплатой 260: " + employeeBook.containsEmployee(test));
        System.out.println("\nПоиск сотрудника по ID");
        Employee foundEmployee = employeeBook.getEmployeeById(6);
        if (foundEmployee != null) {
            System.out.println("Найден сотрудник: " + foundEmployee);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}