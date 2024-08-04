
import java.util.Scanner;

class Student3 {
    private int id;
    private String Name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

class Grade3 {
    private int studentId;
    private int courseid;
    private char Grade;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public char getGrade() {
        return Grade;
    }

    public void setGrade(char grade) {
        Grade = grade;
    }
}

class GradingSystem3 {
    private Student3[] students;
    private Grade3[] grades;
    private int[] courseCredits;
    private int studentCount;
    private int gradeCount;

    public GradingSystem3(int numStudents, int numCourses) {
        students = new Student3[numStudents];
        grades = new Grade3[numStudents * numCourses];
        courseCredits = new int[numCourses];
        studentCount = 0;
        gradeCount = 0;
    }

    public void addStudent(Student3 stud) {
        if (studentCount < students.length) {
            students[studentCount] = stud;
            studentCount++;
        } else {
            System.out.println("Cannot add more students.");
        }
    }

    public void addGrade(Grade3 grade) {
        if (gradeCount < grades.length) {
            grades[gradeCount] = grade;
            gradeCount++;
        } else {
            System.out.println("Cannot add more grades.");
        }
    }

    public void addCourseCredits(int courseId, int credit) {
        if (courseId < courseCredits.length) {
            courseCredits[courseId] = credit;
        } else {
            System.out.println("Invalid course ID.");
        }
    }

    public double calculateGPA(int studentID) {
        int totalPoints = 0;
        int totalCredits = 0;

        for (int i = 0; i < gradeCount; i++) {
            if (grades[i].getStudentId() == studentID) {
                int courseId = grades[i].getCourseid();
                int credit = courseCredits[courseId];
                totalPoints += gradeToPoints(grades[i].getGrade()) * credit;
                totalCredits += credit;
            }
        }

        if (totalCredits == 0 ) {
            return 0;
        }else{
            return (double) totalPoints / totalCredits;
        }

    }

    private int gradeToPoints(char grade) {
        switch (grade) {
            case 'A':
                return 4;
            case 'B':
                return 3;
            case 'C':
                return 2;
            case 'D':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }
}

public class MGTM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradingSystem3 gs = new GradingSystem3(100, 10); 

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. Add Course Credits");
            System.out.println("4. Calculate GPA");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student3 student = new Student3();
                    System.out.print("Enter Student ID: ");
                    student.setId(sc.nextInt());
                    sc.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    student.setName(sc.nextLine());
                    gs.addStudent(student);
                    break;
                case 2:
                    Grade3 grade = new Grade3();
                    System.out.print("Enter Student ID: ");
                    grade.setStudentId(sc.nextInt());
                    System.out.print("Enter Course ID: ");
                    grade.setCourseid(sc.nextInt());
                    System.out.print("Enter Grade (A/B/C/D/F): ");
                    grade.setGrade(sc.next().charAt(0));
                    gs.addGrade(grade);
                    break;
                case 3:
                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    System.out.print("Enter Course Credits: ");
                    int credits = sc.nextInt();
                    gs.addCourseCredits(courseId, credits);
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    double gpa = gs.calculateGPA(studentID);
                    System.out.println("GPA of student " + studentID + " is: " + gpa);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
