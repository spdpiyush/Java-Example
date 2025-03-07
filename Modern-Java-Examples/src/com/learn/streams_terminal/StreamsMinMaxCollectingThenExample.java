package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class StreamsMinMaxCollectingThenExample {

    public static void main(String[] args) {

        System.out.println("Max Student with Optional" + optionalStudentWithMaximumGpa());
        System.out.println("Max Student without Optional" + studentWithMaximumGpa());

        System.out.println("Student with Least GPA in each Grade : " + studentWithMinimumGpa());

    }

    /**
     * <p>
     *     Calculate top Gpa Student in each Grade.
     *     Here value is wrapped inside the Optional,
     *     but we can avoid this by using CollectingAndThen
     * </p>
     */
    public static Map<Integer, Optional<Student>> optionalStudentWithMaximumGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                                maxBy(Comparator.comparing(Student::getGpa))));
    }

    /**
     * <p>
     *    collectingAndThen() : is going to get the Student if available and then assign that as an value.
     * </p>
     * @return
     */
    public static Map<Integer, Student> studentWithMaximumGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)
                        )
                );
    }


    /**
     * <p>
     *     Calculate Least Gpa Student in each Grade.
     * </p>
     * @return
     */
    public static Map<Integer, Student> studentWithMinimumGpa() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        groupingBy(Student::getGradeLevel,
                        collectingAndThen(
                                minBy(Comparator.comparing(Student::getGpa)),
                                Optional::get)
                        )
                );
    }
}
