import java.util.Scanner;

class Courses {
    private int courseid;
    private String coursename;
    private int credit;

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String toString() {
        return "Course ID: " + courseid + " Course Name: " + coursename + " Credit: " + credit;
    }
}

class Enroll {
    private int[][] studentCourse;
    private int[] count;

    public Enroll(int numStudents, int numCourses) {
        studentCourse = new int[numStudents][numCourses];
        count = new int[numStudents];
    }

    public void enroll(int studentID, int courseid) {
        if (count[studentID] < studentCourse[studentID].length) {
            studentCourse[studentID][count[studentID]] = courseid;
            count[studentID]++;
            System.out.println("Student " + studentID + " enrolled in course " + courseid);
        } else {
            System.out.println("Student " + studentID + " cannot enroll in more courses.");
        }
    }

    public void drop(int studentID, int courseid) {
        boolean found = false;
        for (int i = 0; i < count[studentID]; i++) {
            if (studentCourse[studentID][i] == courseid) {
                studentCourse[studentID][i] = studentCourse[studentID][count[studentID] - 1];
                count[studentID]--;
                found = true;
                System.out.println("Student " + studentID + " dropped course " + courseid);
                break;
            }
        }
        if (!found) {
            System.out.println("Course " + courseid + " not found for student " + studentID);
        }
    }

    public void getEnrolmentCourse(int studentID, Courses[] courseCatalog) {
        System.out.println("Courses enrolled by student " + studentID + ":");
        for (int i = 0; i < count[studentID]; i++) {
            int courseid = studentCourse[studentID][i];
            for (Courses course : courseCatalog) {
                if (course.getCourseid() == courseid) {
                    System.out.println(course);
                    break;
                }
            }
        }
    }
}

public class CourseEnrollment {
    private static Courses[] courseCatalog;
    private static Enroll enrollment;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of courses: ");
        int numCourses = sc.nextInt();
        courseCatalog = new Courses[numCourses];

        for (int i = 0; i < numCourses; i++) {
            courseCatalog[i] = new Courses();
            System.out.print("Enter Course ID: ");
            courseCatalog[i].setCourseid(sc.nextInt());
            sc.nextLine();
            System.out.print("Enter Course Name: ");
            courseCatalog[i].setCoursename(sc.nextLine());
            System.out.print("Enter Course Credit: ");
            courseCatalog[i].setCredit(sc.nextInt());
        }

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        enrollment = new Enroll(numStudents, numCourses);

        while (true) {
            System.out.println("1. Enroll Student");
            System.out.println("2. Drop Course");
            System.out.println("3. Get Enrolled Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    int courseid = sc.nextInt();
                    enrollment.enroll(studentID, courseid);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    System.out.print("Enter Course ID: ");
                    courseid = sc.nextInt();
                    enrollment.drop(studentID, courseid);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentID = sc.nextInt();
                    enrollment.getEnrolmentCourse(studentID, courseCatalog);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
