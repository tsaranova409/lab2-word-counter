package ua.kpi.comsys.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class WordCounterTest {

    private WordCounter counter;

    @BeforeEach
    void setUp() {
        counter = new WordCounter();
    }

    // Tests for countWords()

    @Test
    void testCountWordsWithRegularText() {
        List<String> lines = List.of(
                "Java is great",
                "Java is popular"
        );

        Map<String, Integer> result = counter.countWords(lines);

        assertEquals(2, result.get("java"));
        assertEquals(2, result.get("is"));
        assertEquals(1, result.get("great"));
        assertEquals(1, result.get("popular"));
        assertEquals(4, result.size());
    }

    @Test
    void testCountWordsIgnoresCase() {
        List<String> lines = List.of(
                "HELLO hello Hello"
        );

        Map<String, Integer> result = counter.countWords(lines);

        assertEquals(3, result.get("hello"));
        assertEquals(1, result.size());
    }

    @Test
    void testCountWordsWithNumbers() {
        List<String> lines = List.of(
                "Java123 123 Java123"
        );

        Map<String, Integer> result = counter.countWords(lines);

        assertEquals(2, result.get("java123"));
        assertEquals(1, result.get("123"));
    }

    @Test
    void testCountWordsWithSpecialCharacters() {
        List<String> lines = List.of(
                "Hello, world! Java... Java?"
        );

        Map<String, Integer> result = counter.countWords(lines);

        assertEquals(1, result.get("hello"));
        assertEquals(1, result.get("world"));
        assertEquals(2, result.get("java"));
        assertEquals(3, result.size());
    }

    @Test
    void testCountWordsWithEmptyList() {
        Map<String, Integer> result =
                counter.countWords(List.of());

        assertTrue(result.isEmpty());
    }

    @Test
    void testCountWordsWithEmptyStrings() {
        List<String> lines = List.of(
                "", "   ", "!!!"
        );

        Map<String, Integer> result = counter.countWords(lines);

        assertTrue(result.isEmpty());
    }

    @Test
    void testCountWordsWithNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> counter.countWords(null)
        );
    }

    // Tests for getUniqueWords()

    @Test
    void testGetUniqueWordsWithRegularText() {
        List<String> lines = List.of(
                "Java Python Java",
                "HTML Python CSS"
        );

        Set<String> result = counter.getUniqueWords(lines);

        assertEquals(
                Set.of("java", "python", "html", "css"),
                result
        );
    }

    @Test
    void testGetUniqueWordsIgnoresCase() {
        List<String> lines = List.of(
                "JAVA Java java"
        );

        Set<String> result = counter.getUniqueWords(lines);

        assertEquals(Set.of("java"), result);
    }

    @Test
    void testGetUniqueWordsWithNumbers() {
        List<String> lines = List.of(
                "Test123 123 Test123"
        );

        Set<String> result = counter.getUniqueWords(lines);

        assertEquals(Set.of("test123", "123"), result);
    }

    @Test
    void testGetUniqueWordsWithSpecialCharacters() {
        List<String> lines = List.of(
                "Hello, world! Hello?"
        );

        Set<String> result = counter.getUniqueWords(lines);

        assertEquals(Set.of("hello", "world"), result);
    }

    @Test
    void testGetUniqueWordsWithEmptyList() {
        Set<String> result =
                counter.getUniqueWords(List.of());

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetUniqueWordsWithEmptyStrings() {
        List<String> lines = List.of(
                "", "   ", "!!!"
        );

        Set<String> result = counter.getUniqueWords(lines);

        assertTrue(result.isEmpty());
    }

    @Test
    void testGetUniqueWordsWithNull() {
        assertThrows(
                IllegalArgumentException.class,
                () -> counter.getUniqueWords(null)
        );
    }


    @Test
    void testCountWordsWithNullLine() {
        List<String> lines = new ArrayList<>();
        lines.add("Java Java");
        lines.add(null);
        lines.add("Python");

        Map<String, Integer> result = counter.countWords(lines);

        assertEquals(2, result.get("java"));
        assertEquals(1, result.get("python"));
        assertEquals(2, result.size());
    }

    @Test
    void testUniqueWordsWithNullLine() {
        List<String> lines = new ArrayList<>();
        lines.add("Java Python");
        lines.add(null);
        lines.add("Java");

        Set<String> result = counter.getUniqueWords(lines);

        assertEquals(Set.of("java", "python"), result);
    }
}
