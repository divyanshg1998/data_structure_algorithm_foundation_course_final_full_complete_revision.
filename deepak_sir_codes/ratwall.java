class ratwall{

    public static void main(String[] args)
{
int[][] arr=
    {{0, 0, 1, 0, 0}
    ,{1, 0, 0, 0, 0}
    ,{0, 0, 0, 0, 0}
    ,{1, 0, 1, 0, 0}
};    


    int i = 0, j = 0, dir = 0;
   
    while( true){
    
    dir = dir + arr[i][j];
    dir = dir % 4;

    if ( dir == 0){
        j++;
      }else if( dir == 1 ){
        i++;
    }else if( dir == 2){
        j--;
    }else{
        i--;
    }
    
    if( i<0 || i >= arr.length || j <0 || j >= arr[0].length){
        break;
    }
    }

    System.out.println( i + " " + j);

}
}