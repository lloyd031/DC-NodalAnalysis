

public class Matrix {
	double mat[][]; double constants[];
	double res[];
	 int n;
	public Matrix(double mat[][], double constants[]) {
		// TODO Auto-generated method stub
	
       n=constants.length;
       this.mat=new double[n][n];
       this.constants=new double[n];
       for(int i =0;i<n;i++)
	   {
    	   for(int j =0;j<n;j++)
    	   {
    		   this.mat[i][j]=mat[i][j];
    	   }
    	   this.constants[i]=constants[i];
	   }
       double tempmat[]=new double[n];
       double tempconst=0;
       this.res=new double[n];
       for(int i=0; i<n; i++)
       {
    	 
    	 for(int j=i; j<n; j++)
    	 {
    		
    		if(j==i)
    		{
    			double pivot=mat[i][i];
    			for(int k=0; k<n; k++)
    			{
    				mat[j][k]/=pivot;
    				tempmat[k]=mat[j][k];
    			}
    			constants[j]/=pivot;
				tempconst=constants[j];
    		}else
    		{
    			double pivot=mat[j][i];
    			for(int k=0; k<n; k++)
    			{
    				mat[j][k]+=pivot*tempmat[k]*-1;
    			}
    			constants[j]+=pivot*tempconst*-1;
    		}
    	 }
    	
       }
       res[n-1]=constants[n-1];
       for(int i=n-1; i>=0; i--)
       {
    	   if(i!=n-1)
    	   {
    		   for(int j=0; j<n; j++)
        	   {
        		 constants[i]-=res[j]*mat[i][j];
        	   }
    		   res[i]=constants[i];
    	   } 
		   
       }
       for(int i=0;i<n; i++)
       {
    	   System.out.print (res[i]+" , ");
       }
       System.out.println();
       /*if(j==i)
    			 {
    				 mat[j][k]/=pivot;
    				 tempmat[k]=mat[j][k];
    				 
    			 }else
    			 {
    				 mat[j][k]+=tempmat[k]*-1*mat[j][i];
    				 constants[k]+=tempconst*-1*mat[j][i];
    			 }
    			 
    			 */
       for(int i=0; i<n; i++)
       {
    	   for(int j=0; j<n; j++)
    	   {
    		   System.out.print(mat[i][j] +" ");
    	   }
    	   System.out.println(" = "+constants[i]);
       }
       
	}
	
	double[] getResult()
	{
		return this.res;
	}
	public void reset()
	{
		
				mat=null;
			    constants=null;
		 
	}
    
}
