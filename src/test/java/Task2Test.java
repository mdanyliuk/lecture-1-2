import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

class Task2Test {

    Task2 task;

    @BeforeEach
    void setUp() {
        task = new Task2();
    }

    @Test
    void getTopHashTags() {
        List<String> list = new ArrayList<>();
        list.add("A #map cannot contain duplicate keys; each #key can #map to at most one #value");
        list.add("This #interface takes the place of the Dictionary #class");
        list.add("The #order of a #map is defined as the #order in which the iterators on the map's #collection views return their elements");
        list.add("Some #map implementations, like the TreeMap #class make specific guarantees as to their #order others, like the HashMap #class do not");
        list.add("Attempting to insert an ineligible #key or #value throws an unchecked #exception typically NullPointerException or ClassCastException");
        list.add("This implementation provides all of the optional #map operations, and permits null values and the null #key");
        list.add("This #class makes no guarantees as to the #order of the #map in particular, it does not guarantee that the #order will remain constant over time");

        Map<String, Integer> map = task.getTopHashTags(list);

        assertThat(map).containsExactlyInAnyOrderEntriesOf(Map.of(
                "#map", 5, "#key", 3, "#class", 3, "#order", 3, "#value", 2
        ));
    }

    @Test
    void nullParameterShouldThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> task.getTopHashTags(null));
        assertEquals("Parameter must be not null", exception.getMessage());
    }

    @Test
    void emptyListShouldReturnEmptyMap() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = task.getTopHashTags(list);

        assertThat(map).isEmpty();
    }
}