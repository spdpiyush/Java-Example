package com.learn.streams;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExample {

    public static void main(String[] args) {
        System.out.println(studentActivities());
        System.out.println(uniqueStudentActivities());
        System.out.println(studentActivitiesCount());
        System.out.println(studentActivitiesInSortedOrder());
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

    /**
     * <p>
     *     we want unique set of activities that all students are participating
     *     use distinct() : Perform Unique operation. ( similar to SQL Queries )
     * </p>
     */
    public static List<String> uniqueStudentActivities() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * <p>
     *     Get count of all activities from StudentDataBase.
     *     count() : gives total number of elements in that Stream.
     * </p>
     * @return
     */
    public static long studentActivitiesCount() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();
    }

    /**
     * <p>
     *     we want Student activities in Sorted Order.
     *     sorted() :
     *     we can also pass Custom Comparator as argument to it.
     * </p>
     * @return
     */
    public static List<String> studentActivitiesInSortedOrder() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
