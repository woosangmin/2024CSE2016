public class Course {
    private String courseName;
    private String courseCode;
    private Student[] students;
    private int maximumNumberOfStudents;
    private int currentStudents;


    public Course(String name, String code, int maxNum) {
        courseName = name;
        courseCode = code;
        maximumNumberOfStudents = maxNum;
        currentStudents = 0;
        students = new Student[maximumNumberOfStudents];
    }

    public boolean addStudent(Student s) {
        boolean result = false;
        if (currentStudents < maximumNumberOfStudents) {
            students[currentStudents] = s;
            currentStudents++;
            result = true;
        }

        return result;
    }

    public int getCurrentStudents() {
        return currentStudents;
    }

    public void printStudents() {
        for (int i = 0; i < currentStudents; i++) {
            Student s = students[i];
            System.out.println(s.getName() + ":" + s.getId());
        }
    }

    public void printInfo() {
        System.out.println("["+this.courseCode+"] " + this.courseName);
        System.out.println("total number of students : " + currentStudents);
    }
}
