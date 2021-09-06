package dropboxOA;

// Java Program to implement the above approach
import java.util.*;
public class StudentSoln
{
    // Stores the history of all
    // the queries that have been
    // processed on the document
    static Stack<Character> Undo = new Stack<Character>();

    // Stores the elements
    // of REDO query
    static Stack<Character> Redo = new Stack<Character>();

    // Function to perform
    // "WRITE X" operation
    static void WRITE(Stack<Character> Undo, char X)
    {

        // Push an element to
        // the top of stack
        Undo.push(X);
    }

    // Function to perform
    // "UNDO" operation
    static void UNDO(Stack<Character> Undo, Stack<Character> Redo)
    {

        // Stores top element
        // of the stack
        char X = (char)Undo.peek();

        // Erase top element
        // of the stack
        Undo.pop();

        // Push an element to
        // the top of stack
        Redo.push(X);
    }

    // Function to perform
    // "REDO" operation
    static void REDO(Stack<Character> Undo, Stack<Character> Redo)
    {

        // Stores the top element
        // of the stack
        char X = (char)Redo.peek();

        // Erase the top element
        // of the stack
        Redo.pop();

        // Push an element to
        // the top of the stack
        Undo.push(X);
    }

    // Function to perform
    // "READ" operation
    static void READ(Stack<Character> Undo)
    {

        // Store elements of stack
        // in reverse order
        Stack<Character> revOrder = new Stack<Character>();

        // Traverse Undo stack
        while (Undo.size() > 0)
        {

            // Push an element to
            // the top of stack
            revOrder.push(Undo.peek());

            // Erase top element
            // of stack
            Undo.pop();
        }

        while (revOrder.size() > 0)
        {

            // Print the top element
            // of the stack
            System.out.print(revOrder.peek());
            Undo.push(revOrder.peek());

            // Erase the top element
            // of the stack
            revOrder.pop();
        }

        System.out.print(" ");
    }

    // Function to perform the
    // queries on the document
    static void QUERY(String[] Q)
    {
        // Stores total count
        // of queries
        int N = Q.length;

        // Traverse all the query
        for (int i = 0; i < N; i++)
        {
            if(Q[i] == "UNDO")
            {
                UNDO(Undo, Redo);
            }
            else if(Q[i] == "REDO")
            {
                REDO(Undo, Redo);
            }
            else if(Q[i] == "READ")
            {
                READ(Undo);
            }
            else
            {
                WRITE(Undo, Q[i].charAt(6));
            }
        }
    }

    public static void main(String[] args) {
        String[] Q = { "WRITE A", "WRITE B", "WRITE C", "UNDO", "READ", "REDO", "READ" };
        QUERY(Q);
    }
}