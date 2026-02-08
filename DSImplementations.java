import java.util.*;

public class DSImplementations {

    //-----------------------------------------------------------------------------------------
    //                                  SHARED LINKED LIST NODE
    //-----------------------------------------------------------------------------------------
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }

    //-----------------------------------------------------------------------------------------
    //                                  1. STACK USING ARRAY
    //-----------------------------------------------------------------------------------------
    static class ArrayStack {
        int[] arr;
        int top;
        int capacity;

        ArrayStack(int size) {
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        /*
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         */
        public void push(int x) {
            if (top == capacity - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            arr[++top] = x;
        }

        /*
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         */
        public int pop() {
            if (top == -1) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return arr[top--];
        }

        public int peek() {
            if (top == -1) return -1;
            return arr[top];
        }
    }

    //-----------------------------------------------------------------------------------------
    //                                  2. QUEUE USING ARRAY (Circular)
    //-----------------------------------------------------------------------------------------
    static class ArrayQueue {
        int[] arr;
        int front, rear, size, capacity;

        ArrayQueue(int cap) {
            capacity = cap;
            arr = new int[capacity];
            front = 0;
            size = 0;
            rear = capacity - 1; 
        }

        /*
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         */
        public void enqueue(int item) {
            if (size == capacity) {
                System.out.println("Queue is Full");
                return;
            }
            rear = (rear + 1) % capacity;
            arr[rear] = item;
            size++;
        }

        /*
         * Time Complexity: O(1)
         * Space Complexity: O(1)
         */
        public int dequeue() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int item = arr[front];
            front = (front + 1) % capacity;
            size--;
            return item;
        }
    }

    //-----------------------------------------------------------------------------------------
    //                                  3. STACK USING LINKED LIST
    //-----------------------------------------------------------------------------------------
    static class LLStack {
        Node head;

        /*
         * Time Complexity: O(1) (Insert at Head)
         * Space Complexity: O(1)
         */
        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        /*
         * Time Complexity: O(1) (Delete at Head)
         * Space Complexity: O(1)
         */
        public int pop() {
            if (head == null) return -1;
            int res = head.data;
            head = head.next;
            return res;
        }
        
        public int peek() {
            if (head == null) return -1;
            return head.data;
        }
    }

    //-----------------------------------------------------------------------------------------
    //                                  4. QUEUE USING LINKED LIST
    //-----------------------------------------------------------------------------------------
    static class LLQueue {
        Node front, rear;

        /*
         * Time Complexity: O(1) (Insert at Tail)
         * Space Complexity: O(1)
         */
        public void enqueue(int data) {
            Node newNode = new Node(data);
            if (rear == null) {
                front = rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
        }

        /*
         * Time Complexity: O(1) (Delete at Head)
         * Space Complexity: O(1)
         */
        public int dequeue() {
            if (front == null) return -1;
            int res = front.data;
            front = front.next;
            if (front == null) rear = null;
            return res;
        }
    }

    //-----------------------------------------------------------------------------------------
    //                                  5. STACK USING TWO QUEUES
    //-----------------------------------------------------------------------------------------
    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        /*
         * Time Complexity: O(n) (Expensive Push)
         * - Move all q1 to q2, add new item to q1, move all q2 back to q1.
         * Space Complexity: O(1) auxiliary
         */
        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        /*
         * Time Complexity: O(1)
         */
        public int pop() {
            if (q1.isEmpty()) return -1;
            return q1.remove();
        }
    }

    //-----------------------------------------------------------------------------------------
    //                       6. QUEUE USING TWO STACKS (OPTIMIZED)
    //-----------------------------------------------------------------------------------------
    static class QueueTwoStacksOpt {
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        /*
         * Time Complexity: O(1)
         */
        public void enqueue(int x) {
            input.push(x);
        }

        /*
         * Time Complexity: Amortized O(1)
         * - Worst Case: O(n) (Only when output stack is empty).
         * - Average Case: O(1).
         */
        public int dequeue() {
            if (output.isEmpty()) {
                if (input.isEmpty()) {
                    System.out.println("Queue is Empty");
                    return -1;
                }
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.pop();
        }
    }

    //-----------------------------------------------------------------------------------------
    //                       7. QUEUE USING ONE STACK (RECURSIVE)
    //-----------------------------------------------------------------------------------------
    static class QueueOneStack {
        Stack<Integer> stack = new Stack<>();

        /*
         * Time Complexity: O(1)
         */
        public void enqueue(int x) {
            stack.push(x);
        }

        /*
         * Time Complexity: O(n)
         * Space Complexity: O(n) (Recursion Stack)
         */
        public int dequeue() {
            if (stack.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            // Base Case: If only one element, it's the front
            if (stack.size() == 1) {
                return stack.pop();
            }

            // Recursive Step: Pop top, ask recursion to find bottom
            int top = stack.pop();
            int result = dequeue();

            // Push top back
            stack.push(top);

            return result;
        }
    }

    //-----------------------------------------------------------------------------------------
    //                                        MAIN DRIVER
    //-----------------------------------------------------------------------------------------
    public static void main(String[] args) {
        System.out.println("--- 1. Array Stack ---");
        ArrayStack as = new ArrayStack(5);
        as.push(10); as.push(20);
        System.out.println(as.pop()); 

        System.out.println("\n--- 2. Array Queue ---");
        ArrayQueue aq = new ArrayQueue(5);
        aq.enqueue(10); aq.enqueue(20);
        System.out.println(aq.dequeue()); 

        System.out.println("\n--- 3. LL Stack ---");
        LLStack lls = new LLStack();
        lls.push(10); lls.push(20);
        System.out.println(lls.pop()); 

        System.out.println("\n--- 4. LL Queue ---");
        LLQueue llq = new LLQueue();
        llq.enqueue(10); llq.enqueue(20);
        System.out.println(llq.dequeue()); 

        System.out.println("\n--- 5. Stack using Queues ---");
        StackUsingQueues suq = new StackUsingQueues();
        suq.push(10); suq.push(20);
        System.out.println(suq.pop()); 

        System.out.println("\n--- 6. Queue using 2 Stacks (Opt) ---");
        QueueTwoStacksOpt q2 = new QueueTwoStacksOpt();
        q2.enqueue(10); q2.enqueue(20); q2.enqueue(30);
        System.out.println(q2.dequeue()); // 10
        System.out.println(q2.dequeue()); // 20

        System.out.println("\n--- 7. Queue using 1 Stack (Rec) ---");
        QueueOneStack q1 = new QueueOneStack();
        q1.enqueue(10); q1.enqueue(20);
        System.out.println(q1.dequeue()); // 10
    }
}