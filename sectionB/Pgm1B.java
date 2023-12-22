class Employee {
    char[] Name, Address;
    int Age, Salary, PhoneNumber;
    public Employee(char[] Name, int Age, int PhoneNumber, char[] Address, int Salary) {
        this.Name = Name;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.Salary = Salary;
    }

    final public void printSalary() {
        System.out.println("Salary: " + this.Salary);
    }
    public void printDetails() {
        System.out.print("Name: ");
        Employee.printItem(Name);
        System.out.println("Age: " + Age);
        System.out.println("Phone: " + PhoneNumber);
        System.out.print("Address: ");
        Employee.printItem(Address);
        this.printSalary();
    }

    static void printItem(char[] item) {
        for(int i = 0; item[i] != '\0'; i++) {
            System.out.print(item[i]);
        }
        System.out.println();
    }
}

class Officer extends Employee {
    char[] specialization, department;

    public Officer(char[] Name, int Age, int PhoneNumber, char[] Address, int Salary, char[] specialization, char[] department) {
        super(Name, Age, PhoneNumber, Address, Salary);
        this.specialization = specialization;
        this.department = department;
    }
    public void printDetails() {
        super.printDetails();
        System.out.print("Specialization: ");
        Employee.printItem(specialization);
        System.out.print("Department: ");
        Employee.printItem(department);
    }
}

class Manager extends Employee {
    char[] specialization, department;

    public Manager(char[] Name, int Age, int PhoneNumber, char[] Address, int Salary, char[] specialization, char[] department) {
        super(Name, Age, PhoneNumber, Address, Salary);
        this.specialization = specialization;
        this.department = department;
    }

    public void printDetails() {
        super.printDetails();
        System.out.print("Specialization: ");
        Employee.printItem(specialization);
        System.out.print("Department: ");
        Employee.printItem(department);
    }
}

public class Pgm1B {
    public static void main(String[] args) {
        char[] officeName = {'H', 'a', 'm', '\0'},
                officeAddress = {'H', 'o', 'm', 'e', '\0'},
                officeSpec = {'L', 'e', 'a', 'd', '\0'},
                officeDept = {'H', 'R', '\0'},
                managerName = {'S', 'a', 'm', '\0'},
                mangerAddress = {'W', 'o', 'r', 'k', '\0'},
                managerSpec = {'T', 'e', 's', 't', '\0'},
                managerDept = {'D', 'e', 'v', '\0'};


        Officer officer1 = new Officer(officeName, 32, 874827, officeAddress, 456728, officeSpec, officeDept);
        Manager manager1 = new Manager(managerName, 40, 8489209, mangerAddress, 838883, managerSpec, managerDept);

        officer1.printDetails();
        manager1.printDetails();
    }
}
