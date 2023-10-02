/**
 * 
 */
package reflection;

/**
 * @author Alex Martinez 
 *
 */

// Reflection: https://docs.oracle.com/javase/tutorial/reflect/class/

// Demonstration of Reflection

// Given an object o, we want to know what class corresponds to o, the inheritance chain for o
// and the list of methods of the class

// Complete the code

import java.lang.reflect.Method;

import circle.ColoredCircle;

public class Reflection {

	/**
	 * Print the class corresponding to the object
	 * @param o the object
	 */
	public void correspondingClass(Object o) {
		if (o == null)
			throw new IllegalArgumentException("Object passesd is null");

		System.out.println("Inspecting class: " + o.getClass().getName());
	}

	/**
	 * Print the chain of super classes of the object 
	 * Format of the output:
	 * Inheritance chain:
	 * Cn inherits from Cn-1 inherits ... inherits from java.lang.Object
	 * @param o the object
	 */
	public void inheritanceChain(Object o) {
		if (o == null)
			throw new IllegalArgumentException("Object passesd is null");

		// TODO To complete
		// You need to use the EXACT format of the output
		// Hint: Use the method getSuperClass()
		
		// Start with the provided object's class
		Class currentClass = o.getClass();

	    System.out.println("Inheritance chain:");
	    
	    while (currentClass != null) {
	        System.out.print(currentClass.getSimpleName());

	        // Finding if there is a super class above where we are each iteration
	        Class superClass = currentClass.getSuperclass();
	        if (superClass != null) {
	            System.out.print(" class inherits from the class: ");
	            System.out.print(superClass.getSimpleName());
	            System.out.println("\n");
	        }

	        // If its not the highest class we output that there is more
	        if (!currentClass.equals(Object.class)) {
	            System.out.print("The ");
	        }

	        currentClass = superClass;
	    }

	    // Adding the final class that the original class inherits from
	    System.out.println(" class inherits from java.lang.Object");
	    System.out.println("\n");
	}
	
	/**
	 * Print the list of methods of the object
	 * @param o an object
	 */
	public void listMethods(Object o) {
		if (o == null)
			throw new IllegalArgumentException("Object passesd is null");

		Method[] m = o.getClass().getMethods();

		// List of methods
		// TODO To complete
		// Print each method on one line
		// Use this EXACT format
		
		for (Method method: m) {
			System.out.println(method);
		}
		System.out.println("\n");
		
	}

	/**
	 * Constructor
	 */
	public Reflection() {
	}

	/**
	 * Demonstration
	 * @param args
	 */
	public static void main(String[] args) {

		Reflection r = new Reflection();		
		
		// Demonstration of the methods on an objet of type String
		// TODO To complete
		String hello = "This is a reflection";
		r.correspondingClass(hello);
		r.inheritanceChain(hello);
		r.listMethods(hello);
		
		// Demonstration of the methods on an objet of type ColoredCircle
		// TODO To complete	
		ColoredCircle circle = new ColoredCircle();
//		circle.centerX = 6.0;
//		circle.centerY = 6.0;
//		circle.radius = 3;
		r.correspondingClass(circle);
		r.inheritanceChain(circle);
		r.listMethods(circle);

	}

}
