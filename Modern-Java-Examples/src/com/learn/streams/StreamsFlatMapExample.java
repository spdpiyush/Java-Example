package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static void main(String[] args) {
        System.out.println(studentActivities());
    }

    /**
     * <p>
     *     we have to print all activities in a List.
     *     Using flatMap to Flatten the Stream.
     * </p>
     * @return
     */
    public static List<String> studentActivities() {

        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .collect(Collectors.toList());

    }
}
