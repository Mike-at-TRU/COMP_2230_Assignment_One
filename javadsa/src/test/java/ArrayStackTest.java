import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.digiteched.javadsa.ArrayStack;
import com.digiteched.javadsa.interfaces.IStack;

public class ArrayStackTest {
    @Test
    public void itShouldBeEmptyInitially(){
        // Arrange 
        IStack<String> testStack = new ArrayStack<String>(String.class);

        // Act 
        int size = testStack.size();

        // Assert
        assertEquals(0,size);
    }

    @Test
    public void itShouldPushAFirstItem(){
        // Arrange
        IStack<String> testStack = new ArrayStack<String>(String.class);

        String firstItem = "Hello World";

        // Act
        testStack.push(firstItem);


        // Assert
        assertEquals(1,testStack.size());
    }

    @Test
    public void itShouldPopUntilEmpty(){
        String first = "first one";

        String second = "second one";

        String third = "third one";

        IStack<String> testStack = new ArrayStack<String>(String.class);

        testStack.push(first);
        testStack.push(second);
        testStack.push(third);

        String firstOut = testStack.pop();

        assertEquals(firstOut, third);
        assertEquals(testStack.size(), 2);

        String secondOut = testStack.pop();

        assertEquals(secondOut, second);
        assertEquals(testStack.size(), 1);

        String thirdOut = testStack.pop();

        assertEquals(thirdOut, first);
        assertEquals(testStack.size(),  0);
    }

    // TODO test behaviour when `pop` is called on an empty stack

    @Test
    public void itShouldGrow(){
        ArrayStack<String> testStack = new ArrayStack<String>(String.class);

        final int NUMBER_OF_ITEMS_TO_ADD = 1000;

        for(int i = 0; i<NUMBER_OF_ITEMS_TO_ADD; i++){
            testStack.push(String.valueOf(i));
        }

        assertEquals(testStack.size(), NUMBER_OF_ITEMS_TO_ADD);
    }
}
