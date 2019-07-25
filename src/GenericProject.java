// Harsh Devprakash Gupta, hgupta20@uic.edu, 650125174
// The project is about creating a generic class and implement stack and queue.
// In this simplified version, each data structure is a singly linked list. The stack is LIFO
// (last in first out) while the queue is FIFO (first in first out). Your implementation must be
//  generic as to allow for different types when each data structure object is instantiated.

public class GenericProject {
    public static void main(String[] args){
        System.out.println("Stack:");
        GenericStack<Integer> stack = new GenericStack(100);
        // check empty stack behaviour;
        /*stack.pop();
        stack.pop();
        stack.print();*/
        // push and pop the stack
        stack.push(200);        //push
        stack.push(300);
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.pop();                  //pop
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.push(400);
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.pop();
        stack.print();
        System.out.println("Length: " + stack.getLength());
        stack.print(); //example stack
        System.out.println("Length: " + stack.getLength());


        System.out.println();
        System.out.println("Queue:");
        GenericQueue<Integer> queue = new GenericQueue(100);
        // check empty queue behaviour;
        /*queue.dequeue();
        queue.dequeue();
        queue.print();*/

        // enqueue and dequeue the queue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(200);      //enqueue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(300);
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.dequeue();                // dequeue
        queue.print();
        System.out.println("Length: " + queue.getLength());
        queue.enqueue(400);
        queue.print();
        System.out.println("Length: " + queue.getLength());

    }

}
abstract class GenericList<I> {
    Node head;
    private int length;

    GenericList() {
    }

    public abstract void add(I var1);

    public void setLength(boolean var1) {
        if (var1) {
            ++this.length;
        } else {
            --this.length;
        }

    }

    public int getLength() {
        return this.length;
    }

    public I delete() {
        if (this.head == null) {
            return null;
        } else {
            Object var1 = this.head.data;
            this.head = this.head.next;
            return (I) var1;
        }
    }

    public void print() {
        if (this.head == null) {
            System.out.println("Empty List!");
        } else {
            for(GenericList.Node var1 = this.head; var1 != null; var1 = var1.next) {
                System.out.println(var1.data);
            }
        }

    }

    class Node<T> {
        T data;
        GenericList<I>.Node<T> next;

        Node() {
        }
    }
}
class GenericQueue<I> extends GenericList<I> {
    GenericQueue(I var1) {
        this.head = new Node();
        this.head.data = var1;
        this.setLength(true);
    }

    public void enqueue(I var1) {
        this.add(var1);
        this.setLength(true);
    }

    public I dequeue() {
        if (this.head != null) {
            this.setLength(false);
        }

        return this.delete();
    }

    public void add(I var1) {
        Node var2;
        if (this.head == null) {
            var2 = new Node();
            var2.data = var1;
            this.head = var2;
        } else {
            for(var2 = this.head; var2.next != null; var2 = var2.next) {
            }

            Node var3 = new Node();
            var3.data = var1;
            var2.next = var3;
        }

    }
}

class GenericStack<I> extends GenericList<I> {
    GenericStack(I var1) {
        this.head = new Node();
        this.head.data = var1;
        this.setLength(true);
    }

    public void push(I var1) {
        this.add(var1);
        this.setLength(true);
    }

    public I pop() {
        if (this.head != null) {
            this.setLength(false);
        }

        return this.delete();
    }

    public void add(I var1) {
        Node var2 = new Node();
        var2.data = var1;
        var2.next = this.head;
        this.head = var2;
    }
}