package com.learn.streams_terminal;

import com.learn.data.Student;
import com.learn.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *     partitioningBy() collector is also a kind of groupingBy().
 *     partitioningBy() accepts a predicate as an input.
 *     Return type of Collector is going to be Map<K, V>
 *         the key of the return type is going to be Boolean.
 *     @apiNote  There are 2 different versions of partitioningBy().
 *     <ul>
 *         <li> partitioningBy(predicate)</li>
 *         <li>partitioningBy(predicate, downstream) : downstream could be any collector.</li>
 *     </ul>
 * </p>
 */
public class StreamsPartitioningByExample {

    public static void main(String[] args) {
        System.out.println("PartitioningBy with 1 Argument : " + partitioningByExample1());
        System.out.println("PartitioningBy with 2 Argument : " + partitioningByExample2());
    }

    /**
     * <p>
     *     O/P is going to be a Map<Boolean, List<T>>.
     *     so, whatever matches the predicate is going to be under true Key.
     *     and whatever doesn't match, going to be under false key
     * </p>
     * @return
     */
    public static Map<Boolean, List<Student>> partitioningByExample1() {
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.partitioningBy(student -> student.getGpa() >= 3.9));
    }

    /**
     * <p>
     *     2 argument version of partitioningBy()
     * </p>
     * @return
     */
    public static Map<Boolean, Long> partitioningByExample2() {
        Predicate<Student> gpaPredicate = (student) -> student.getGpa() >= 3.9;
        return StudentDataBase.getAllStudents()
                .stream()
                .collect(
                        Collectors.partitioningBy(gpaPredicate, Collectors.counting())
                );
    }
}
