package org.tyaa.solid;

import org.tyaa.solid.d.IntegerSort;
import org.tyaa.solid.d.Student;
import org.tyaa.solid.d.UniSort;
import org.tyaa.solid.l.OrderStockAndPackValidator;
import org.tyaa.solid.o.OrderProcessorWithPreAndPostProcessing;
import org.tyaa.solid.s.OrderProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
* What is Clean Code
*
* Easily readable,
* self-documented,
* minimum of comments,
* fully covered by tests,
* performing one task,
* with the processing of all errors,
* without repetition,
* in the same style
* */

public class Main {

    public static void main(String[] args) throws Exception {
        // S
        // Single Responsibility Principle
        // Divide the module into several separate ones,
        // each of which will perform one single function
        // new OrderProcessor().process(new Order());
        // O
        // Open Closed Principle
        // If you need to perform some actions before processing the order
        // and after sending a confirmation letter -
        // instead of changing the OrderProcessor class itself,
        // you will expand it
        // new OrderProcessorWithPreAndPostProcessing().process(new Order());
        // L
        // Liskov’s Substitution Principle
        // Objects in the program can be replaced by their descendants
        // without fundamentally changing the behavior of the program
        // (example with a violation:
        // the object of the parent class did not throw exceptions,
        // but the child can throw out)
        // new OrderStockAndPackValidator().isValid(new Order());
        // I
        // Interface Segregation Principle
        // (split interfaces or create adapters)
        // new org.tyaa.solid.i.OrderProcessor().process(new Order());
        // D
        // Dependency Inversion Principle
        // (pass resources by references using interface types)
        /* new org.tyaa.solid.d.OrderProcessor().process(
                new Order(),
                o -> System.out.println(o + " order processed (option 2)")
                );
        new org.tyaa.solid.d.OrderProcessor().process(
                new Order(),
                o -> System.out.println(o + " order processed (option 1)")
        ); */

        // Class Person: id, name, age (3 objects with different values of fields) -> List
        // hello, world, ! -> List
        // 1, 56, -4, 0, 10 -> List

        // Bubble Sort

        /* List<Integer> integers =
                new ArrayList<>();
        integers.add(1);
        integers.add(-23);
        integers.add(56);
        integers.add(-4);
        integers.add(0);
        integers.add(-22);
        integers.add(10); */

        /* integers.forEach(System.out::println);
        IntegerSort.sort(integers);
        System.out.println("Sorted List:");
        integers.forEach(System.out::println); */

        // Let's make sort method universal!
        // (Can apply to List of any elements - Integer, Double, String, Custom Types, etc.)
        // - add second argument: sort(ArrayList list, ICompareRule rule)

        /* integers.forEach(System.out::println);
        UniSort.sort(
                integers,
                (o1, o2) -> (Integer)o2 - (Integer)o1
        );
        System.out.println("Sorted List:");
        integers.forEach(System.out::println); */

        List<String> strings =
                new ArrayList<>();
        strings.add("John");
        strings.add("Bill");
        strings.add("Vasilii");
        strings.add("Maria");
        strings.add("Yurii");
        strings.add("Fedor");
        strings.add("Hidejuki");

        strings.forEach(System.out::println);
        UniSort.sort(
                strings,
                (o1, o2) -> ((String)o1).compareTo((String)o2)
        );
        System.out.println("Sorted List:");
        strings.forEach(System.out::println);

        // System.out.println((int)(Math.random() * (76 + 1)) + 16);

        List<Student> students =
            strings.stream()
                .map(s -> new Student(
                        s,
                        "...",
                        (int)(Math.random() * (44 + 1) + 16),
                        (Math.random() * (19 + 1)) + 7))
                .collect(Collectors.toList());

        students.forEach(System.out::println);
        UniSort.sort(
            students,
            (o1, o2) -> ((Student)o1).age - ((Student)o2).age
        );
        System.out.println("Sorted List:");
        students.forEach(System.out::println);

        // TODO apply quickSort
        students.forEach(System.out::println);
        UniSort.quickSort(
                students,
                (o1, o2) -> ((Student)o1).age - ((Student)o2).age
        );
        System.out.println("Sorted List:");
        students.forEach(System.out::println);
    }
}
