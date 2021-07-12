package stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class MaxStack1 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> maxStack = new Stack<>();

    public void push(int x) {
        int tmpMax = maxStack.isEmpty()? x: Math.max(maxStack.peek(), x);
        stack.push(x);
        maxStack.push(tmpMax);
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> tmpStack = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.peek();
            if (cur < max) {
                tmpStack.add(cur);
                stack.pop();
                maxStack.pop();
            } else {
                stack.pop();
                maxStack.pop();
                while (!tmpStack.isEmpty()) {
                    this.push(tmpStack.pop());
                }
                break;
            }
        }
        return max;
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public void printMaxStack() {
        System.out.println(stack);
        System.out.println(maxStack);
    }



    public static void main(String[] args) {
        MaxStack1 stack = new MaxStack1();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(6);
        stack.push(2);
        stack.push(4);
        stack.printMaxStack();

        System.out.println(stack.pop()); // -> 4
        stack.printMaxStack();

        System.out.println(stack.top());// -> 2
        stack.printMaxStack();

        System.out.println(stack.peekMax()); // -> 6

        stack.printMaxStack();

        System.out.println(stack.popMax());// -> 6

        stack.printMaxStack();

        System.out.println(stack.peekMax());
        stack.printMaxStack();
        System.out.println(stack.popMax());// -> 5
        stack.printMaxStack();
        System.out.println(stack.top());// -> 1
        System.out.println(stack.peekMax());// -> 5

        stack.printMaxStack();

        System.out.println(stack.pop());// -> 1
        stack.printMaxStack();

        System.out.println(stack.top());// -> 5
        stack.printMaxStack();

    }
}
//
//        [leetcode]716. Max Stack 最大栈
//        Design a max stack that supports push, pop, top, peekMax and popMax.
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
