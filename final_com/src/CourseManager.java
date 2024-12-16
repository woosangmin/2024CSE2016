import java.io.BufferedReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class CourseManager {
    private Course course;
    private Student[] students;
    private int[] scores;
    private int count;

    public CourseManager(Course c, Student[] s) {
        course = c;
        students = s;
        count = 0;
        scores = new int[course.getCurrentStudents()];
    }

    public void controllerWithReader(java.io.Reader reader) {
        BufferedReader keyboard = new BufferedReader(reader);
        boolean result; int i;
        while (true) {
            try {
                result = false;
                System.out.println("name,score 순서대로 입력하세요.");
                String s = keyboard.readLine();
                StringTokenizer tokenizer = new StringTokenizer(s, ",");
                if (tokenizer.countTokens() == 1) tokenizer = new StringTokenizer(s, "|");
                String name = tokenizer.nextToken().trim();
                if ("q".equals(name) || "Q".equals(name)) {
                    break;
                }
                int score = Integer.parseInt(tokenizer.nextToken().trim());
                for (i = 0; i < course.getCurrentStudents(); i++) {
                    if (students[i].getName().equals(name) && scores[i] == 0) {
                        if (score <= 100 && score >= 0) {
                            scores[i] = score;
                            count++;
                            result = true;
                            System.out.println("입력한 학생은 " + (count) + "명입니다.");
                            System.out.println("남은 학생은 " + (scores.length - count) + "명입니다.");
                            break;
                        } else {
                            System.out.println("invalid score!");
                            result = true;
                            break;
                        }
                    } else if (students[i].getName().equals(name) && scores[i] != 0) {
                        System.out.println("점수가 이미 입력되었습니다.");
                        break; }
                }
                if (!result && i == course.getCurrentStudents()) System.out.println("unknown student!");
                if (count == scores.length) break;
            } catch (NoSuchElementException e) {
                System.out.println("unknown student!");
                e.printStackTrace();
                // ERROR!
            } catch (IOException ex) {
                System.out.println("No such file");
                ex.printStackTrace();
            } catch (NumberFormatException ea) {
                System.out.println("Can not parse to int");
                ea.printStackTrace();
            }
        }
        printScores();
    }

    public void printScores() {
        for (int i = 0 ; i < scores.length ; i++) {
            for (int j = i + 1 ; j < scores.length ; j++) {
                if (scores[i] < scores[j]) {
                    int temp = scores[i];
                    scores[i] = scores[j];
                    scores[j] = temp;
                    Student n_student = students[i];
                    students[i] = students[j];
                    students[j] = n_student;
                }
            }
        }
        for (int i = 0 ; i < scores.length ; i++) {
            System.out.println(students[i].getName() + "의 점수는 " + scores[i] + "입니다.");
        }
    }
}
