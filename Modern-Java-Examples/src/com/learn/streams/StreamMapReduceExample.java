package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;



public class StreamMapReduceExample {

    public static void main(String[] args) {

        System.out.println("Total Notebooks : " + totalNotebooks());
        System.out.println("Total Notebooks with GradeLevel Greater than Equal to 3 : " + totalNotebooksWithFilter());

    }

    /**
     * <p>
     *     Total number of notebooks that each and every student has.
     *     i.e. Sum of each notebooks student have.
     * </p>
     */
    private static int totalNotebooks() {
        //Stream<Student> --> Stream<Integer>
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
    }

    /**
     * <p>
     *     Total number of notebooks for student gradeLevel >= 3
     * </p>
     * @return
     */
    private static int totalNotebooksWithFilter() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGradeLevel() >= 3)
                .map(Student::getNoteBooks)
                .reduce(0, Integer::sum);
    }
}
