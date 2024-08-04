import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public String toString() {
        return "ID = " + studentID + ", Name = " + name + ", Age = " + age + ", Department = " + department;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

class StudentRecordSystem {
    private Student[] std;
    private int count = 0;

    public StudentRecordSystem(int size) {
        std = new Student[size];
    }

    public void addStudent(Student x) {
        if (count < std.length) {
            std[count] = x;
            count++;
        } else {
            System.out.println("Error");
        }
    }

    public Student getStudent(int ID) {
        for (int i = 0; i < count; i++) {
            if (std[i].getStudentID() == ID) {
                return std[i];
            }
        }
        return null;
    }

    public void displayAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(std[i]);
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentRecordSystem srs = new StudentRecordSystem(100);

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Get Student");
            System.out.println("3. Display All");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    Student x = new Student(); 
                    System.out.print("Enter Student ID: ");
                    x.setStudentID(sc.nextInt());
                    sc.nextLine(); 
                    System.out.print("Enter Name: ");
                    x.setName(sc.nextLine());
                    System.out.print("Enter Age: ");
                    x.setAge(sc.nextInt());
                    sc.nextLine(); 
                    System.out.print("Enter Department: ");
                    x.setDepartment(sc.nextLine());
                    srs.addStudent(x);
                    break;
                }
                case 2: {
                    System.out.print("Enter Student ID: ");
                    int ID = sc.nextInt();
                    Student student = srs.getStudent(ID);
                    if (student != null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                }
                case 3: {
                    srs.displayAll();
                    break;
                }
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}