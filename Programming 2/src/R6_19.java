public class R6_19 {
	
	public static void main(String[] args){

	System.out.println("aaaaaaaaaaaaaaaaaaaa");
	int n = 1;
	System.out.println("n = 1, i = uninitialized");
	for (int i = 2; i<5; i++){
		n = n + i;
		System.out.println(n+" , "+i);
	}
	System.out.println("Final n: "+ n);
	
	System.out.println("bbbbbbbbbbbbbbbbbbbbbb");
	
	// x is n
	int i;
	double x = 1/2;
	System.out.println("n = 0.5, i = null");
	for (i = 2;i <= 5; i++) {
		x = x + 1.0/i;
		System.out.println(x+" , "+i);
	}
	System.out.println("Final i: "+ i);
	
	System.out.println("ccccccccccccccccccccccc");
	
	// j is x
	// k is i
	double j = 1; 
	double y = 1;
	int k = 0;
	System.out.println("x = 1, y = 1, i = 0");
	do {
	y = y / 2;
	j = j + y;
	k++;
	System.out.println(j+" , "+y+" , "+k);
	}
	while (j < 1.8); 
	System.out.println("Final i: "+ k);
		
	System.out.println("dddddddddddddddddddddddd");
	
	// x is t
	// y is v
	// i is p
	double t = 1;
	double v = 1;
	int p = 0;
	System.out.println("x = 1, y = 1, i = 0");
	while (v >= 1.5) {
	t = t / 2;
	v = t + v; 
	p++;
	System.out.println(t+" , "+v+" , "+p);
	}
	System.out.println("Final i: "+ p);
	
	
	
	}
}
