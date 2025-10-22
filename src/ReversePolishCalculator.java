// Version: 20200917
// Handin done by:
//   <202407171> <Tobias Granild>
//   <202408036> <Kasper Frost>
//   <202408288> <Kristian Rasmussen>
// Contributions:
//   <name 1> <contribution>
//   <name 2> <contribution>
//   <name 3> <contribution>

import java.io.*;
import java.util.*;
public class ReversePolishCalculator {
    // Add any private fields you might need here
    private Deque<Integer> stack;

    public ReversePolishCalculator() {
        stack = new ArrayDeque<>();
    }

    public void push(int n) {
        stack.push(n);
    }

    public void plus() {
        if (stack.size() < 2){
            throw new IllegalStateException("Not enough values in stack");
        }
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a + b);
    }

    public void minus() {
        if (stack.size() < 2){
            throw new IllegalStateException("Not enough values in stack");
        }
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a - b);
    }

    public void times() {
        if (stack.size() < 2){
            throw new IllegalStateException("Not enough values in stack");
        }
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a * b);
    }

    public int read() {
        // Implement your code here to read the top element from the stack (without removing it)
        if (stack.isEmpty()){
            throw new IllegalStateException("Stack is empty");
        }
        return stack.peek();
    }
}