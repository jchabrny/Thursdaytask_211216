import Student.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        int[] zahlen = new int[]{9, 1, 8, 2, 7, 3, 6, 4, 5};
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));


        int[] zahlenSortiert = Arrays.stream(zahlen).sorted().toArray();
        int zahlenAddiert = Arrays.stream(zahlen).sum();
        int zahlenMultipliziert = Arrays.stream(zahlen).reduce(1, (a, b) -> a * b);

        // List<Person> hundredClub = new ArrayList<>();

        List<Person> hundredClub = people.stream().filter(person -> person.billions >= 100)
                .collect(Collectors.toList());

      /*  for (Person p : people) {
            if (p.billions >= 100) {
                hundredClub.add(p);
            }
        } */

        hundredClub.forEach(person -> System.out.println(person.name));
        System.out.println(Arrays.toString(zahlenSortiert));
        System.out.println(zahlenAddiert);
        System.out.println(zahlenMultipliziert);



        String path = "/Users/jchab/Desktop/neuefische_Bootcamp/students.csv";
        String line = "";
        boolean item;
        List<String> textdatei = new ArrayList<>();


        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {

                textdatei.add(line);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

       textdatei = textdatei
               .stream()
               .filter(Predicate.not(String::isEmpty))
               .skip(1)
               .distinct()
               //.map( -> new Student())
               .toList();
        System.out.println(textdatei);
    }
}