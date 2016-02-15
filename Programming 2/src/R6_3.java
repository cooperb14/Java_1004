
public class R6_3 {
	
	public static void main(String[] args){
		
		System.out.println("aaaaaaaaaaaaaaaaaaaa");
		int i = 0;
		int j = 10;
		int n = 0;
		System.out.println("i = 0, j = 10, n = 0");
		while (i < j) { 
			i++;
			j--;
			n++;
			System.out.println(i+" , "+j+" , "+n);
		}
		
		
		System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
		i = 0;
		j = 0;
		n = 0;
		System.out.println("i = 0, j = 0, n = 0");
		while (i < 10) { 
			i++; 
			n = n + i + j;
			j++;
			System.out.println(i+" , "+j+" , "+n);
		}
		
		
		System.out.println("ccccccccccccccccccccccc");
		i = 10;
		j = 0;
		n = 0;
		System.out.println("i = 10, j = 0, n = 0");
		while (i > 0) { 
			i--;
			j++;
			n = n + i - j; 
			System.out.println(i+" , "+j+" , "+n);
		}
		
		
		System.out.println("dddddddddddddddddddddddd");
		System.out.println("Book's loop has an error");

//		i = 0;
//		j = 10;
//		n = 0;
//		System.out.println("i = 0, j = 10, n = 0");
//		while (i != j) { 
//			i = i + 2;
//			j = j - 2;
//			n++;
//			System.out.println(i+" , "+j+" , "+n);
//		}
//		
	}
}
