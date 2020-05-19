package stack;

import java.util.Stack;

public class MaxStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> maxStack = new Stack<Integer>();

    public void push(int x) {

        if(stack.size() == 0) {
            stack.add(x);
            maxStack.add(x);
        } else {
            stack.add(x);
            int peek = maxStack.peek();
            if(peek > x) {
                maxStack.add(peek);
            } else{
                maxStack.add(x);
            }
        }
        System.out.println(stack);
    }

    public int pop() {
        maxStack.pop();
        System.out.println("pop " + maxStack);
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int popMax() {
        Stack<Integer> tmpStack = new Stack<Integer>();
        // Stack<Integer> tmpMaxStack = new Stack<Integer>();
        int max = maxStack.peek();
        while(stack.size() > 0) {
            if(stack.peek() != max) {
                tmpStack.add(stack.pop());
                maxStack.pop();
            } else {
                stack.pop();
                maxStack.pop();
                break;
            }
        }
//        if(maxStack.size() == 0) {
//            this.push();
//        }
//        int newMax = maxStack.peek();
        for(int i = 0; i < tmpStack.size() + 1; i++) {
            this.push(tmpStack.pop());
        }
        System.out.println("max " + max + stack);
        return max;
    }

    public int peekMax() {
        System.out.println(maxStack.peek());
        return maxStack.peek();
    }

    public void printMaxStack() {
        System.out.println(maxStack);
    }

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(6);
        stack.push(2);
        stack.push(4);
        stack.printMaxStack();
//        stack.top();// -> 5
        stack.popMax();// -> 5
        stack.printMaxStack();
        stack.popMax();// -> 5
        stack.printMaxStack();
//        stack.top();// -> 1
//        stack.peekMax();// -> 5
//        stack.pop();// -> 1
//        stack.top();// -> 5
    }
}
//
//        [leetcode]716. Max Stack 最大栈
//        Design a max stack that supports push, pop, top, peekMax and popMax.
//
//
//
//        push(x) -- Push element x onto stack.
//        pop() -- Remove the element on top of the stack and return it.
//        top() -- Get the element on the top.
//        peekMax() -- Retrieve the maximum element in the stack.
//        popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
//
//
//        Example 1:
//
//        MaxStack stack = new MaxStack();
//        stack.push(5);
//        stack.push(1);
//        stack.push(5);
//        stack.top(); -> 5
//        stack.popMax(); -> 5
//        stack.top(); -> 1
//        stack.peekMax(); -> 5
//        stack.pop(); -> 1
//        stack.top(); -> 5
//
//
//        Note:
//
//        -1e7 <= x <= 1e7
//        Number of operations won't exceed 10000.
//        The last four operations won't be called when stack is empty.
