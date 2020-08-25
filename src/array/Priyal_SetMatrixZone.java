package leetcode.array;

public class Priyal_SetMatrixZone {

	public static void main(String[] args)  
    { 
        int mat[ ][ ] = { {1,1,0},
        		  {1,1,1},
        		  {1,1,1}}; 
                      
                System.out.println("Matrix Intially"); 
                  Priyal_SetMatrixZone obj = new Priyal_SetMatrixZone();
                  
                  obj.setZeroe(mat);
                  System.out.println("Matrix after modification n"); 
                printMatrix(mat, 3, 3); 
      
    } 
//fail
//	linkedhashmap function interface.. extended ?? static.. static.. segmant.. listiterator.. abstract classs contructor.. singleton immutable class
// intefces mapping examples syntax.. ? annotations?? fetch lazy egar 
// scopes in spring, types, iuc, de injection, application context, instances?? mvc? 
// thread syn concurrency, runnable state? 
//	proxy object get or load
// adapter, facade, singleton, observer, creational - 4, behavioral or structural, builder, prototype, 	
	
	public void setZeroe(int[][] matrix) {
        
        int n=matrix.length; int m=matrix[0].length;
        boolean firstRow=false, firstCol=false;
        
        for(int i=0;i<n;i++){
       	 	if(matrix[i][0]==0){
                    matrix[i][0]=0;
                    firstRow=true;
                    break;
            }
       }
        
       for(int j=0;j<m;j++){
           
           if(matrix[0][j]==0){
               
                   matrix[0][j]=0;
                   firstCol=true;
                   break;
           }
       }
        for(int i=0;i<n;i++){    
            
            for(int j=0;j<m;j++){
                
                if(matrix[i][j]==0){
                    
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                } 
            }
        }
        printMatrix(matrix, n, m);
        for(int i=1;i<n;i++){    
            
            if(matrix[i][0]==0){
                
                for(int j=1;j<m;j++) {
                    matrix[i][j]=0;
                }
            }
           
        }
        printMatrix(matrix, n, m);
        for(int j=1;j<m;j++){
                
            if(matrix[0][j]==0){
                
                for(int i=1;i<n;i++){
                    matrix[i][j]=0;
                    
                }
            }
        }
        printMatrix(matrix, n, m);
        if(firstRow) {
        	for(int i=0;i<n;i++){
                matrix[i][0]=0;
        	}
        }
        
        printMatrix(matrix, n, m);
        if(firstCol) {
        	for(int j=0;j<m;j++){
                
                    matrix[0][j]=0;
            }
        }
    }
    
    public void setZeroes(int[][] matrix) {
        
        int n=matrix.length; int m=matrix[0].length;
        for(int i=0;i<n;i++){    
            
            for(int j=0;j<m;j++){
                
                if(matrix[i][j]==0){
                    
                    findzero(matrix,i,j);
                } 
            }
        }
    }
    
    public void findzero(int[][] matrix, int i, int j){
        
        int mi = i, mj=j;
        int n=matrix.length;
        while(--i>=0){
            
            if(matrix[i][j]==0){
                findzero(matrix,i,j);
            }else
                matrix[i][j]=0;
        }
        int m=matrix[0].length; 
        i=mi;
        while(++i<m){
            if(matrix[i][j]==0){
                findzero(matrix,i,j);
            }else
                matrix[i][j]=0;
        }
        
        while(--j>=0){
           if(matrix[mi][j]==0){
                findzero(matrix,mi,j);
            }else
                matrix[mi][j]=0;
        }
        j=mj;
         while(++j<n){
            if(matrix[mi][j]==0){
                findzero(matrix,mi,j);
            }else
                matrix[mi][j]=0;
        }
//       if(matrix[i][j]==0)
//           return;
    }
    
    public static void printMatrix(int mat[ ][ ], int R, int C) 
    { 
        int i, j; 
        for (i = 0; i < R; i++) 
        { 
            for (j = 0; j < C; j++) 
            { 
                System.out.print(mat[i][j]+ " "); 
            } 
            System.out.println(); 
        } 
    }
    
    public void setZeroesSpace(int[][] matrix) {
        
        int n=matrix.length; int m=matrix[0].length;
        
        int[] rows=new int[n];
        int[] cols=new int[m];
    
        for(int i=0;i<n;i++){    
            
            for(int j=0;j<m;j++){
                
                if(matrix[i][j]==0){
                    
                    rows[i]=1;
                    cols[j]=1;
                } 
            }
        }
        //n*m
        for(int i=0;i<n;i++){    
            
            if(rows[i]==1){
                
                for(int j=0;j<m;j++){
                    matrix[i][j]=0;
                }
            }
            
        }
        
        for(int j=0;j<m;j++){
                
            if(cols[j]==1){
                
                for(int i=0;i<n;i++){
                    matrix[i][j]=0;
                    
                }
            }
        }
        
    }
}