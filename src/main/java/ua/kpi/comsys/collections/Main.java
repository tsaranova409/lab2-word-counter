package ua.kpi.comsys.collections;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        WordCounter counter = new WordCounter();

        List<String> text = List.of(
                "Java is great! Java is popular.",
                "I like JAVA and Python.",
                "Python 123, Java 123!"
        );

        System.out.println("Word counts:");
        System.out.println(counter.countWords(text));

        System.out.println("\nUnique words:");
        System.out.println(counter.getUniqueWords(text));

        System.out.println("\nEmpty input:");
        System.out.println(counter.countWords(List.of()));

        System.out.println("\nNull input:");
        try {
            counter.countWords(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
