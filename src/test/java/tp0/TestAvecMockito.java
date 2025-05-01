package tp0;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MockitoIteratorSpyTest {
    @Test
    void testIteratorSpy() {
        // Liste réelle
        List<String> realList = Arrays.asList("Hello", "World");

        // Spy sur la liste réelle
        List<String> spyList = spy(realList);
        Iterator<String> iterator = spyList.iterator();

        // Vérification du comportement réel de l'iterator
        assertTrue(iterator.hasNext());
        assertEquals("Hello", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("World", iterator.next());
        assertFalse(iterator.hasNext());

        // Vérifier que next() a été appelé deux fois
        verify(iterator, times(2)).next();
    }
}
