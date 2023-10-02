/**
 * 
 */
package mystack;

/**
 * @author Alex Martinez 
 *
 */

// Stack using generics

// Complete the provided code

public class MyStack<T> {

	private class MyNode<T1> {
		T1 val;
		MyNode<T1> next;

		MyNode(T1 v, MyNode<T1> n) {
			val = v;
			next = n;
		}
	}

	private MyNode<T> theStack = null;

	/**
	 * 
	 */
	public MyStack() {
	}

	public T pop() {
		// TODO To complete
		if (theStack == null) {
			System.out.print("The Stack is Empty!");
			return null;
		}
		T popped = theStack.val;
		theStack = theStack.next;
		return popped;
	}

	public void push(T v) {
		// TODO To complete
		MyNode<T> newNode = new MyNode<T>(v,theStack);
		theStack = newNode;
	}
	
	public boolean isEmpty() {
		return theStack == null;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO To complete
		// Create a stack of Integer
		MyStack<Integer> IntegerStack = new MyStack<Integer>();
		// Push 1 and 2
		IntegerStack.push(1);
		IntegerStack.push(2);
		
		// Pop
		int popped = IntegerStack.pop();
		// Push 5
		IntegerStack.push(5);
		
		// TODO To complete
		// Create a stack of Person
		MyStack<Person> PersonStack= new MyStack<Person>();
		// Push a person p1 with your name
		Person me = new Person("Alex", "Martinez");
		PersonStack.push(me);
		// Push a person p2 with my name
		Person you = new Person("Professor","Scharff");
		PersonStack.push(you);
		
		
		//Testing both types of stacks to make sure they are working as intended
		
		//Testing Int Stack
		System.out.println("Integer Stack");
		while(!IntegerStack.isEmpty()) {
			int popInt = IntegerStack.pop();
			System.out.println("Int popped: " + popInt);
		}
		
		//Testing Person Stack
		System.out.println("Person Stack");
		while(!PersonStack.isEmpty()) {
			Person popPerson = PersonStack.pop();
			System.out.println("Person popped: " + popPerson.getFname() + " " + popPerson.getLname());
		}
		
	}

}
