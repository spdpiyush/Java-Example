package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *    groupingBy(): grouping elements according to a
 *    classification function, and returning the results in a {@code Map<K, V>}
 *
 * @apiNote  There are 3 different versions of groupingBy().
 *      <ul>
 *          <li> groupingBy(classifier) : basically what is a classification value that needs to be applied to stream input.</li>
 *          <li> groupingBy(classifier, downstream) : downstream is another collector of any type </li>
 *          <li> groupingBy(classifier, supplier, downstream) : supplier which is used to override the default map factory</li>
 *      </ul>
 *
 * </p>
 * grouping elements according to a
 * classification function, and returning the results in a {@code Map}
 */
public class StreamsGroupingByExample {

    public static void main(String[] args) {

        System.out.println("Student grouped based on Gender : " + groupingByExample1());
        System.out.println("Student grouped based on PASS/FAIL : " + groupingByExample2());
    }

    /**
     * <p>
     *     Group the Student Based on their Gender
     * </p>
     */
    public static Map<String, List<Student>> groupingByExample1() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender));
    }


    /**
     * <p>
     *     grouping Student by using a customized implementation (i.e. based on PASS ond FAIL )
     * </p>
     * @return
     */
    public static Map<String, List<Student>> groupingByExample2() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "PASS" : "FAIL"));
    }
}
