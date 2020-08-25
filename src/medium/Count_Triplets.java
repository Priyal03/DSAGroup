package hackerrank.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Count_Triplets {

	
	static long countTriplets(List<Long> arr, long r) {

        int size=arr.size(),i=0;
        long trip=0;
        while(i<size-2){
            long a = arr.get(i);
           // long d=a*r;
            for(int j=i+1;j<size-1;j++){
                if(arr.get(j)==(a*r)){
                   // d=d*r;
                    for(int k=j+1;k<size;k++){
                        if(arr.get(k)==(a*r*r))
                        	
                            trip++;
                    }
                }
            } 
            i++;
        }
        return trip;
    }

	public static void main(String[] args) {
		
		long[] a= {1,2,2,4};
		
		//Arrays.stream(a).boxed().collect(Collectors.toList());
		long x =countTriplets(Arrays.stream(a).boxed().collect(Collectors.toList()), 2);
		
		System.out.println(x);
	}
}
