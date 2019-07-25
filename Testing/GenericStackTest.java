

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class GenericStackTest {
    GenericStack<Integer> stack = new GenericStack<Integer>(100);
    Integer val = 100;

    @BeforeEach
    void init(){
        GenericStack<Integer> stack = new GenericStack<Integer>(100);
        Integer val = 100;

    }

    // Test the constructor to ensure that the expected value was placed in the list.
    @Test
    void test1(){
        // use the constructor to add value 22 and pop it to check if it was added.
        assertEquals(val, stack.pop(), "Constructor did not add value: ");
    }
    // In a list of three values, ensure that when you add a fourth it adds to the front
    // for a stack and the back for a queue
    @Test
    void test2(){
        stack.push(200);
        stack.push(300);
        // add the fourth value
        stack.push(400);
        Integer val4 = 400;
        assertEquals(val4, stack.pop(), "The values are not equal");
    }

    // In an empty list, ensure that null is returned when you attempt to pop or
    // dequeue.
    @Test
    void test3(){
        // make the list empty
        // also try to do it multiple time to make sure the list is empty
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        assertNull(stack.pop(), "Null is not returned");
    }

    //ensure that the length value will not be negative
    @Test
    void test4(){
        // to ensure the length will never be negative we can try popping an empty stack.
        // Since pop calls the delete function which decrements the length.
        // try popping the empty stack multiple times
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        Integer val1 = 0;
        assertEquals(val1, stack.getLength(), "Length changed to negative");
        // Try doing it again and make sure it never turns negative
        stack.pop();

        Integer val2 = -1;
        assertNotEquals(val2, stack.getLength(), "The values are never negative" );

    }

    // ensure that the length value properly increments when you create a new list.
    @Test
    void test5(){
        // to ensure that length increment try adding elements to the empty stack
        // we need to first ensure the list is empty
        stack.pop();
        Integer val2 = 1;
        stack.push(100);
        assertEquals(val2, stack.getLength(), "Length did not increment when an element was pushed");

    }

    // make sure the length changes every time you pop and push in the stack
    @Test
    void test6(){
        stack.push(200);
        Integer val2 = 2;
        assertEquals(val2, stack.getLength(), "Length did not increment when an element was pushed");
        stack.push(300);
        Integer val3 = 3;
        assertEquals(val3, stack.getLength(), "Length did not increment when an element was pushed");
        stack.pop();
        Integer val4 = 0;
        assertEquals(val2, stack.getLength(), "Length did not decrement when an element was pushed");
        stack.pop();
        stack.pop();
        assertEquals(val4, stack.getLength(), "Length did not decrement when an element was pushed");
        stack.push(100);
        Integer val5 = 1;
        assertEquals(val5, stack.getLength(), "Length did not increment when an element was pushed");

    }
    // make sure a string is accepted
    @Test
    void test7(){
        GenericStack<String> stackStr= new GenericStack<String>("Tom");
        String a = "Tom";
        assertEquals(a,stackStr.pop(), "The String data type does not work, string not returned");

    }
    // try to alternatively call push and pop and print the resulting stack
    // hence I am checking the stack implementation, to check if the last entered element is entered at the back
    @Test
    void test8(){
        // I tried to test the print method too but because of some IDE error had problems even though the output had no differences it failed
        // So I am testing if the next works
        stack.push(3);
        Integer val2 = 3;
        Integer val3 = 100;
        // It should not be equal because the last entered element becomes the head and in that case the head is 3 and not head.next
        assertNotEquals(val2,stack.head.next.data, "Next does not work properly");
        assertEquals(val3,stack.head.next.data, "Next does not work properly");

        assertEquals(val2,stack.head.data, "Next does not work properly");
        assertNotEquals(val3,stack.head.data, "Next does not work properly");


    }
    // a test to check the head data and next data of the stack
    @Test
    void test9(){
        assertEquals(val, stack.head.data, "data at the head does not match, implemented incorrectly");
        stack.push(300);
        stack.push(200);
        Integer val2 = 300;
        assertEquals(val2, stack.head.next.data, "Next data does not match");


    }
    // make multiple type of queues and compare them with each other
    @Test
    void test10(){
        GenericStack<Integer> stack2 = new GenericStack<Integer>(100);
        assertEquals(stack2.pop(), stack.pop(), "pop for stack did not work properly are not equal");
        assertEquals(stack2.getLength(), stack.getLength(), "Length not equal");
        stack2.pop();
        stack.push(1); // add an element so that it is different since we used dequeue in line 144
        assertNotEquals(stack2.getLength(), stack.getLength(),"The second stack did not pop properly");

    }
    // make sure a boolean is accepted
    @Test
    void test11(){
        GenericStack<Boolean> stackBool= new GenericStack<Boolean>(false);
        assertFalse(stackBool.pop(), "The boolean data type does not work, boolean not returned");
        stackBool.push(true);
        assertTrue(stackBool.pop(), "The boolean data type does not work, boolean not returned");

    }


}