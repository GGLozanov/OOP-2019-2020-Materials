package current;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String newString = "awd";
        List<String> strings = Arrays.asList("wd", "dwa", "addd");
        List<String> filteredStrings = strings.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());

        List<Integer> number = new ArrayList<Integer>(); // implemented by arrays
        List<Integer> otherNumber = new LinkedList<Integer>();


        number.add(2);
        number.add(3);
        otherNumber.add(2);
        otherNumber.add(3);

        System.out.println("================");
        System.out.println(number == otherNumber); // comparison by reference (always false)
        System.out.println(number.equals(otherNumber)); // content is the same (always true)
        System.out.println("================");

        Virus v1 = new Virus();
        Virus v2 = new Virus();

        v1.name = "COVID-18";
        v2.name = "Trump";

        System.out.println("================");
        System.out.println(v1 == v1); // comparison by reference
        System.out.println(v1 == v2); // comparsion by value for primitives; comparison for reference otherwise
        System.out.println(v1.equals(v2)); // comparison for attributes equality
        System.out.println("================");

        Main.printList(number);

        Set<Virus> set = new HashSet<>();
        set.add(v1);
        set.add(v2);

        Set<Virus> viruses2 = new TreeSet<>();

        Map<Virus, Virus> virusMap = new LinkedHashMap<>();
        virusMap.put(new Virus(), v1);

        System.out.println(virusMap.get(new Virus())); // compares hashCode of empty objects ==> returns true since names are equal

        number.forEach(System.out::println);

        set.forEach(System.out::println);

        virusMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

        // printList(virusMap.entrySet());
        // printList(set);
    }

    static void printList(Iterable list) {
        // iterator - helper class for collections
        // used for iterating elements over collection
        // interface iterator is always the same
        // list.forEach(System.out::println);

        Iterator<Integer> it = list.iterator(); // analogous to collection.begin() in C++
        while(it.hasNext()) {
            System.out.println(it.next()); // changes the iterator location
        }
    }
}
