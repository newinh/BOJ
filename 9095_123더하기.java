import java.util.*;
import java.io.*;
 
class Main{
     
    static int count ;
     
    static int go(int N){
         
        one(N, 1);
        one(N, 2);
        one(N, 3);
         
        return count;
    }
     
    static void one(int N, int now){
         
         
        if(now == N){
             
            count ++;
             
            return ;
        }
        if(now > N){
            return ;
        }
             
        one(N, now+1);
        one(N, now+2);
        one(N, now+3);
         
    }
    
     
    public static void main(String args[]){
         
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for(int i = 0 ; i < T ; i ++){
             
            count = 0;
            System.out.println( go(sc.nextInt() ) );
        }
         
    }
}
