package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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

        System.out.println("Two Level Grouping : " + twoLevelGrouping1());
        System.out.println("Two Level Grouping " + twoLevelGrouping2());

        System.out.println("Three Argument Grouping By : " + threeArgumentGroupingByExample());
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

    /**
     * <p>
     *     Here, we are performing 2 Level grouping.
     *     First Grouping is at the Grade Level.
     *     Second Grouping is at  a customized implementation (i.e. based on PASS ond FAIL ) on GPA.
     * </p>
     */
    public static Map<Integer, Map<String, List<Student>>> twoLevelGrouping1() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "PASS" : "FAIL")));
    }


    /**
     * <p>
     *     internally this grouping by invokes this
     *     @code groupingBy(classifier, HashMap::new, downstream)
     *     here new HashMap is passed as a supplier,
     *     so output of groupingBy(classifier, downstream) is always going to be HashMap.
     * </p>
     */
    public static Map<Integer, Integer> twoLevelGrouping2() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGradeLevel,
                        Collectors.summingInt(Student::getNoteBooks)));
    }

    /**
     * <p>
     *
     *     groupingBy(classifier, supplier, downstream)
     *          - classifier : determines the key.
     *          - supplier : determines the output type collection
     *          - downstream : what is the value that is going to generate.
     *
     *     for LinkedHashMap<K, V>
     *          Key - Gender
     *          Value - Set<Student>
     *
     * </p>
     * Key - Name
     *
     * @return
     */
    public static LinkedHashMap<String, Set<Student>> threeArgumentGroupingByExample() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.groupingBy(Student::getGender,
                        LinkedHashMap::new,
                        Collectors.toSet()));
    }
}
