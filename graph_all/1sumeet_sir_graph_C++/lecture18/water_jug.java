import java.util.*;

public class water_jug{

    static class wj {
        int j1; int j2; String psf; 
            wj(int j1, int j2, String psf){
                this.j1=j1;
                this.j2=j2;
                this.psf=psf;
            }
    }

    static void fun(int j1, int j2, boolean[][] vis){

        ArrayDeque<wj> q= new ArrayDeque<>();
        wj j=new wj(0,0, "");
        q.add(j);

        while(q.size()>0){

            wj rem= q.getFirst();
            q.removeFirst();
            
            if(rem.j2 == 4 )
                System.out.println(rem.str);
                break;
            }

            if( vis[rem.j1][rem.j2] == true){
                continue;
            }
            vis[rem.j1][rem.j2] = true;

            if(rem.j1 < j1 && vis[j1][rem.j2]==false){
                wj nj= new wj(j1, rem.j2, rem.str+"f3" , ctr+1);
                q.addLast(nj);
                vis[j1][rem.j2]=true;
            }

            if(rem.j2 < j2 && vis[rem.j1][j2]==false){
                wj nj= new wj(rem.j1, j2, rem.str+"f5" , ctr+1);
                q.addLast(nj);
                vis[rem.j1][j2]=true;    
            }


            if(rem.j2>0 && vis[rem.j1][0]== false){
                wj nj= new wj(rem.j1, 0, rem.str+"e5" , ctr+1);
                q.addLast(nj);
                vis[rem.j1][0]=true;
            }

            if(rem.j1>0 && vis[0][rem.j2] == false){
                wj nj= new wj( 0 , rem.j2 , rem.str+"e3" , ctr+1);
                q.addLast(nj);
                vis[0][rem.j2] = true;
            }

            if(rem.j1>0 && rem.j2<j2 && vis[rem.j1][rem.j2] == false){
                
                vis[rem.j1][rem.j2] = true;

                int space = j2 - q.j2;
                if( rem.j1 > space ){ 
                    wj nj= new wj<>(rem.j1 - space,j2,rem.psf +"sj1j2 ");
                    q.addLast(nj);           
                    }

                    if( rem.j1 <= space ){ 
                        wj nj= new wj<>(0,rem.j2+rem.j1,rem.psf +"sj1j2 ");
                        q.addLast(nj);           
                        }    
            }


            if(rem.j1<j1 && rem.j2>0 && vis[rem.j1][rem.j2] == false){
                
                vis[rem.j1][rem.j2] = true;

                int space = j1 - rem.j1;
                if( space < rem.j2  ){ 
                    wj nj= new wj<>(j1,rem.j2 - space ,rem.psf +"sj2j1 ");
                    q.addLast(nj);           
                    }

                    if( space > rem.j2 ){ 
                        wj nj= new wj<>( rem.j2+ rem.j1 , 0,rem.psf +"sj2j1 ");
                        q.addLast(nj);           
                        }    
            }
        }
    
    public static void main(String[] args){

     fun(3,5,new boolean[3+1][5+1]);       


    }


}