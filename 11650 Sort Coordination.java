import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
 
/**
 * @author HOON
 * @date   2016. 10. 14.
 * BOJ 11650 sort Coordination
 */
public class Main {
     
    static class co {
         
        int x;
        int y;
         
         
        co(int x, int y){
            this.x = x;
            this.y = y;
        }
 
    }
     
    static class myComparator implements Comparator<co>{
 
        @Override
        public int compare(co o1, co o2) {
            if(o1.x < o2.x)
                return -1;
            else if(o1.x > o2.x)
                return 1;
            else{
                 
                if(o1.y < o2.y)
                    return -1;
                else if(o1.y > o2.y)
                    return 1;
            }
 
            return 0;
        }
         
    }
     
    public static void main(String[] args) throws IOException{
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
         
        Comparator<co> my = new myComparator();
        PriorityQueue<co> queue = new PriorityQueue<co>(my);
         
        int N = sc.nextInt();
         
        int x;
        int y;
         
        for(int i = 0 ; i < N ; i++){
            x = sc.nextInt();
            y = sc.nextInt();
            queue.add(new co(x,y));
        }
         
        co c;
         
        for(int i = 0 ; i < N ; i++){
            c = queue.poll();
             
            x = c.x;
            y = c.y;
             
            bw.write(String.valueOf(x) + " " + String.valueOf(y));
            bw.newLine();
        }
        bw.flush();
         
         
    }
     
}