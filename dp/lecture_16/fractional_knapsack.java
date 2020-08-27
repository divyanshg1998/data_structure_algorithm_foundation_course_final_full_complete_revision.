import java.util.*;

class fractional_knapsack{

    public static class pair implements Comparable<pair>{

        double wt;
        double price;

        pair(double wt, double price){
            this.wt = wt;
            this.price = price;
        }
        public int compareTo( pair other){
            double r1 = this.wt/this.price;
            double r2 = other.wt/other.price;
    
            // cant return double
            // but for descending 
            if( r1>r2){
                return 1;
            }
            else if( r1 < r2)
                return -1;
            else
                return 0;
        } 
    

    }

   public static double fun( int num, pair[] p)
    {
        double val = 0;

        for( int i = 0; i < p.length ; i++){
            if(num >= p[i].wt ){
                val += p[i].price;
                System.out.println(p[i].price);
                num = num - (int)(p[i].wt); 
            }
            else {
                double val1 = (p[i].price
                                /p[i].wt) * (p[i].wt - num);
                val += val1;
                System.out.println(val1);
                return val;
            }
        }
        return -1;
    }
    

    public static void main(String[] args)
    {
        int[][] weights=
                    {{1,3,4,5},
                    {10,40,50,70}};            	
        int bag=8;		
    
        pair[] p = new pair[weights[0].length];

        for( int i = 0 ; i < p.length; i++){
            p[i] = new pair(weights[0][i],
                        weights[1][i]);
        }

        Arrays.sort(p);

        System.out.println(fun(8, p)) ;




    }
}