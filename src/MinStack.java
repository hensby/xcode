import java.util.Arrays;
import java.util.LinkedList;

public class MinStack {
    class Node {
        int value;
        int min;
        // Node next;
        Node(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    LinkedList<Node> stack = new LinkedList<>();
    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.addFirst(new Node(x, x));
        } else {
            stack.addFirst(new Node(x, Math.min(x, stack.peek().min)));
        }
        for(Node node: stack)
            System.out.print(node.value + " " + node.min + " ");
        System.out.println("  ");
    }

    public void pop() {
        stack.poll();
        for(Node node: stack)
            System.out.print(node.value + " " + node.min + " ");
        System.out.println("  ");
    }

    public int top() {
        if(stack.peek() != null)
            return stack.peek().value;
        return -1;
    }

    public int getMin() {
        if(stack.peek() != null)
            return stack.peek().min;
        return -1;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
    }

}
