// write header if necessary

import java.util.Scanner;
import java.util.Arrays;

public class Review {
	public static void main(String[] args){
		
//		System.out.println("Please input a length");
//		Scanner input = new Scanner(System.in);
//		int length = input.nextInt();
	// R7.3		
		int[] a = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 1; i < 10; i++) { a[i] = a[i - 1]; }
		System.out.println(Arrays.toString(a));
		
		int[] b = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 9; i > 0; i--) { b[i] = b[i - 1]; }
		System.out.println(Arrays.toString(b));

		int[] c = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 0; i < 9; i++) { c[i] = c[i + 1]; }
		System.out.println(Arrays.toString(c));

		int[] d = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 8; i >= 0; i--) { d[i] = d[i + 1]; }
		System.out.println(Arrays.toString(d));

		int[] e = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 1; i < 10; i++) {e[i] = e[i] + e[i - 1]; }
		System.out.println(Arrays.toString(e));
		
		int[] f = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for(int i=1;i<10;i=i+2){f[i]=0;}
		System.out.println(Arrays.toString(f));
		
		int[] g = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 0; i < 5; i++) { g[i + 5] = g[i]; }
		System.out.println(Arrays.toString(g));
		
		int[] h = { 1, 2, 3, 4, 5, 4, 3, 2, 1, 0 };
		for (int i = 1; i < 5; i++) { h[i] = h[9 - i]; }
		System.out.println(Arrays.toString(h));
		
	// R7.5	
		int[] values = {-1,2,3,4,21,6,7,8,9,10};
		
		int max = values[0];
		int min = values[0];
		for(int element: values){
			if (element > max){
				max = element;
			}
			if (element < min){
				min = element;
			}
		}
		System.out.println("Max: "+ max + "  Min: "+ min);
		
	// R7.22 (needs to be pseudocode)
		int[] newValues = {1,1,2,2,2,2,2,2,3,3,3,3,4,5,6,6,6,6,6,6,6};
		
		int maxRun = 0;
		int previous = newValues[0];
		int counter = 1;
		for (int i=1; i < newValues.length; i++) {
			if (newValues[i] == previous){
				counter++;
			}
			else{
				counter = 1;
			}
			previous = newValues[i];
			
			if (counter > maxRun){
				maxRun = counter;
			}
		}
		System.out.println("Max Run: " + maxRun);
		
	// R7.24
//		use the minimum value algorithm on the y-coordinate array
//		set that value equal to Ymin
//		use the maximum value algorithm on the y-coordinate array
//		set that value equal to Ymax
//		execute the same two algorithms on the x-coordinate array
//		set the values to Xmin and Xmax respectively
//		 the four coordinates that make up the smallest enclosing rectangle
//			are as follows (Xmin,Ymax), (Xmax,Ymax), (Xmin,Ymin), (Xmax,Ymin)
		
	// R7.33
		//true
		//true
		//false
		//true
		//false
		// false
		
	}
}
