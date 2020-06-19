package subproblems;

public class Priyal_Power {
	
	static int count=0;
	public static void main(String[] args) {

		double x = powerOpti(2,-7);
		
		System.out.println(x+" --> "+count);
	}

//O(logn) by storing the result		
//its very important to keep power as int; as others are not precise in calculations. we may end up doing 500 times more iterations.
	private static double powerOpti(float in, int p) {
		
		count++;
		if(p==0)
			return 1;
		
		double temp=powerOpti(in,p/2);
		
		if(p%2==0)
			return temp;
		else {
			if(p>0)
				return in*temp*temp;
			else 
				return temp*temp/in;//if we are dealing with negative exponent we need to divide .
		}
	}
	// divide n conquer approach TC : (2p+1)	
	private static long powerDQ(int in, int p) {
		count++;
		
		if(p==0)
			return 1;
		
		long t=powerDQ(in,p/2);
		if(p%2==0)
			return t*t;
		else
			return in*t*t;
	}

	
//recursive brute force TC : (p)
	private static long power(int in, int p) {
		
		count++;
		if(p==1)
			return in;
		
		return in*power(in,p-1);
	}
	
}
