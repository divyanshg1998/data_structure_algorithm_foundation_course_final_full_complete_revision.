
class rotate90{

    public static void main(String [] args){

        int[][] arr = { {1,2,3,4},
                        {5,6,7,8},
                        {9,10,11,12},
                        {13,14,15,16}};

               display(arr);
        fun( arr);
        display(arr);

        

    }
    static void display(int [][] arr){

        for( int[] ele : arr){
            for( int ele2 : ele){
                System.out.print(ele2 + " ");
            }
            System.out.println();
        }

        for( int ele : arr){
            System.out.print(ele + " ");
            
        }
    }

    static void fun( int[][] arr){

    // transpose        
    for ( int i = 0; i < arr.length; i++ ){
        for( int j = 0 ; j < arr[0].length; j++ ){
            if ( i < j){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    //row swap
    for( int i = 0 ; i < arr.length/2; i++ ){
        for( int j = 0 ; j < arr[0].length; j++ ){
            int temp = arr[i][j];
            arr[i][j] = arr[ arr.length - 1 - i][j] ;
            arr[ arr.length - 1 - i][j] = temp;
        }
    }

    }
}