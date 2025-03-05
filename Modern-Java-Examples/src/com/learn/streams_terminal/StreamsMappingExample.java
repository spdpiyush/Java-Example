package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 *     <code>mapping()</code> Collector applies a transformation function first and then
 *     collects the data in a collection ( could be any type of collection )
 *     it takes 2 input :
 *     First is the Function, which is a mapper and second is a downstream which represents
 *     a type of collection which we want the result to be collected.
 *
 * </p>
 */
public class StreamsMappingExample {

    public static void main(String[] args) {

        System.out.println("Student Name List : " + mapping1());

        System.out.println("Student Name Set : " + mapping2());

        System.out.println("Student Names for each Grade : " + gradeToStudentName());
    }

    /**
     * this is going to collect List of Students Name i.e type String
     * @return
     */
    public static List<String> mapping1() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toList()));
    }

    /**
     * this is going to collect Set of Students Name i.e type String
     * @return
     */
    public static Set<String> mapping2() {
        return StudentDataBase.getAllStudents().stream()
                .collect(Collectors.mapping(Student::getName, Collectors.toSet()));
    }

    /**
     * @apiNote
     *      The {@code mapping()} collectors are most useful when used in a
     *      multi-level reduction, such as downstream of a {@code groupingBy} or
     *       {@code partitioningBy}.  For example, given a stream of
     *       {@code Person}, to accumulate the set of last names in each city:
     *       <pre>{@code
     *       Map<City, Set<String>> lastNamesByCity
     *         = people.stream().collect(
     *           groupingBy(Person::getCity,
     *                      mapping(Person::getLastName,
     *                              toSet())));
     *       }</pre>
     */
    public static Map<Integer, List<String>> gradeToStudentName() {
        return StudentDataBase.getAllStudents().stream()
                .collect(
                        Collectors.groupingBy(Student::getGradeLevel,
                                Collectors.mapping(Student::getName, Collectors.toList())
                        )
                );
    }

}
