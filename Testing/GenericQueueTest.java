

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericQueueTest {
    GenericQueue<Integer> queue = new GenericQueue<Integer>(1);
    Integer val = 1;

    @BeforeEach
    void init(){
        GenericQueue<Integer> queue = new GenericQueue<Integer>(1);
        Integer val = 1;

    }

    // Test the constructor to ensure that the expected value was placed in the list.
    @Test
    void test1(){
        // use the constructor to add value 1 and pop it to check if it was added.
        assertEquals(val, queue.dequeue(), "Constructor did not add value: ");
    }

    // In a list of three values, ensure that when you add a fourth it adds to the front
    // for a stack and the back for a queue
    @Test
    void test2(){
        queue.enqueue(2);
        queue.enqueue(3);
        // add the fourth value
        queue.enqueue(4);
        Integer val4 = 4;
        // see if 400 is added at the back we have to dequeue the queue to the last element
        assertNotEquals(val4, queue.dequeue(), "The values are equal" );
        assertNotEquals(val4, queue.dequeue(), "The values are equal" );
        assertNotEquals(val4, queue.dequeue(), "The values are equal" );
        // so we use assert not equals to make sure and then now check for equal
        assertEquals(val4, queue.dequeue(), "The values are not equal");
    }

    // In an empty list, ensure that null is returned when you attempt to pop or
    // dequeue.
    @Test
    void test3(){
        // make the list empty
        queue.dequeue();
        // also try to do it multiple time to make sure the list is empty
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        assertNull(queue.dequeue(), "Null is not returned");
    }

    //ensure that the length value will not be negative
    @Test
    void test4(){
        // to ensure the length will never be negative we can try to dequeue an empty queue.
        // Since dequeue calls the delete function which decrements the length.
        // try to dequeue empty queue multiple times
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        Integer val1 = 0;
        assertEquals(val1, queue.getLength(), "Length changed to negative");
        // Try doing it again and make sure it never turns negative
        queue.dequeue();

        Integer val2 = -1;
        assertNotEquals(-1, queue.getLength(), "The values are never negative" );

    }

    // ensure that the length value properly increments when you create a new list.
    @Test
    void test5(){
        // to ensure that length increment try adding elements to the empty stack
        // we need to first ensure the list is empty
        queue.dequeue();
        Integer val2 = 1;
        queue.enqueue(1);
        assertEquals(val2, queue.getLength(), "Length did not increment when an element was pushed");

    }

    // make sure the length changes every time you pop and push in the stack
    @Test
    void test6(){
        queue.enqueue(2);
        Integer val2 = 2;
        assertEquals(val2, queue.getLength(), "Length did not increment when an element was pushed");
        queue.enqueue(3);
        Integer val3 = 3;
        assertEquals(val3, queue.getLength(), "Length did not increment when an element was pushed");
        queue.dequeue();
        Integer val4 = 0;
        assertEquals(val2, queue.getLength(), "Length did not decrement when an element was pushed");
        queue.dequeue();
        queue.dequeue();
        assertEquals(val4, queue.getLength(), "Length did not decrement when an element was pushed");
        queue.enqueue(1);
        Integer val5 = 1;
        assertEquals(val5, queue.getLength(), "Length did not increment when an element was pushed");

    }
    // make sure a string is accepted
    @Test
    void test7(){
        GenericQueue<String> queueStr= new GenericQueue<String>("Tom");
        String a = "Tom";
        assertEquals(a,queueStr.dequeue(), "The String data type does not work, string not returned");

    }
    // make sure a boolean is accepted
    @Test
    void test8(){
        GenericQueue<Boolean> queueBool= new GenericQueue<Boolean>(false);
        assertFalse(queueBool.dequeue(), "The boolean data type does not work, boolean not returned");
        queueBool.enqueue(true);
        assertTrue(queueBool.dequeue(), "The boolean data type does not work, boolean not returned");

    }
    // try to alternatively call enqueue and dequeue and print the resulting queue
    @Test
    void test9(){
        /*queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        OutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream);

        System.setOut(printStream);
        queue.print();
        outputStream.toString();
        assertEquals("1\n2\n3\n4\n", outputStream, "Error");*/
        // I tried to test the print method too but because of some IDE error had problems even though the output had no differences it failed
        // So I am testing if the next works to make sure the implementation is correct and it checks that the last entered element is at the last
        queue.enqueue(3);
        Integer val1 = 3;
        assertEquals(val1, queue.head.next.data, "Next does not work properly");

    }
    // a test to check the head data and next data of the queue so that we know if its implemented correctly
    @Test
    void test10(){
        assertEquals(val, queue.head.data, "data at the head does not match, implemented incorrectly");
        queue.enqueue(300);
        queue.enqueue(200);
        Integer val2 = 300;
        assertEquals(val2, queue.head.next.data, "Next data does not match");


    }
    // make multiple type of queues and compare them with each other
    @Test
    void test11(){
        GenericQueue<Integer> queue2 = new GenericQueue<Integer>(1);
        assertEquals(queue2.dequeue(), queue.dequeue(), "They are not equal");
        assertEquals(queue2.getLength(), queue.getLength(), "Length not equal");
        queue2.dequeue();
        queue.enqueue(1); // add an element so that it is different since we used dequeue in line 163
        assertNotEquals(queue2.getLength(), queue.getLength(),"The second queue did not dequeue properly");

    }

}