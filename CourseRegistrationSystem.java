
// Class name: Course
public class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
    }

    // Getters and setters
    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        enrolledStudents++;
    }

    public void removeStudent() {
        enrolledStudents--;
    }
}

// Class name: Student
import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentID;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // Getters and setters
    public int getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getEnrolledStudents() < course.getCapacity()) {
            registeredCourses.add(course);
            course.enrollStudent();
        } else {
            System.out.println("Course " + course.getTitle() + " is already full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.removeStudent();
        } else {
            System.out.println("You are not registered in course " + course.getTitle());
        }
    }
}

// Main program
import java.util.List;

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        // Create courses
        Course javaCourse = new Course("CS101", "Java Programming", "Introduction to Java programming language", 30);
        Course webCourse = new Course("CS102", "Web Development", "Introduction to web development", 25);

        // Create students
        Student student1 = new Student(1, "John");
        Student student2 = new Student(2, "Alice");

        // Register students in courses
        student1.registerCourse(javaCourse);
        student1.registerCourse(webCourse);
        student2.registerCourse(javaCourse);

        // Display registered courses for each student
        displayRegisteredCourses(student1);
        displayRegisteredCourses(student2);

        // Drop a course for a student
        student1.dropCourse(webCourse);
        displayRegisteredCourses(student1);
    }

    public static void displayRegisteredCourses(Student student) {
        List<Course> registeredCourses = student.getRegisteredCourses();
        System.out.println("Registered courses for " + student.getName() + ":");
        for (Course course : registeredCourses) {
            System.out.println(course.getTitle());
        }
        System.out.println();
    }
}
