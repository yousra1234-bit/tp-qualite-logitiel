package tp0;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testPushAndPop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        Assertions.assertEquals(20, stack.pop()); // Dernier élément ajouté = premier retiré
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertTrue(stack.isEmpty()); // Après deux pops, la pile doit être vide
    }

    @Test
    void testPeek() {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        Assertions.assertEquals("World", stack.peek()); // Peek ne doit pas retirer l'élément
        Assertions.assertEquals(2, stack.size()); // La taille doit rester inchangée
    }

    @Test
    void testIsEmpty() {
        Stack<Double> stack = new Stack<>();
        Assertions.assertTrue(stack.isEmpty());
        stack.push(3.14);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void testPopThrowsExceptionOnEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(RuntimeException.class, stack::pop);
    }

    @Test
    void testPeekThrowsExceptionOnEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(RuntimeException.class, stack::peek);
    }
}
