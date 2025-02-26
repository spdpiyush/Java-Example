package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapExample {

    public static void main(String[] args) {

        System.out.println(namesList());

        System.out.println(upperCaseNamesList());
    }

    /**
     * <p>
     *   we want all the names of Student from StudentDataBase and collect it in List.
     * </p>
     */
    public static List<String> namesList() {
        return StudentDataBase.getAllStudents().stream()
                // this Map converting type, taking Student as i/p and return String as output.
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    /**
     * <p>
     *     we want all the names of Student from StudentDataBase and collect it in List
     *     and performing uppercase operation on that.
     * </p>
     * @return
     */
    public static List<String> upperCaseNamesList() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                // this Map not converting the type, taking String (name) as input and return String as output
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
