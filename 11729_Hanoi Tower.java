import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
/**
 * @author HOON
 * @date   2016. 10. 10.
 * BOJ 1914 Hanoi Tower
 * using recursion 
 * try enum
 */
public class Main implements Cloneable{
     
	 /*

	 Enum 쓰니까 오래걸린당 'ㅁ'

    enum Column {
        ONE(1), TWO(2), THREE(3);
        int index;
        Column(int n){
            index = n;
        }
        int getIndex(){
            return index;
        }
    }
     
    private static void printHanoi(int n, Column from, Column to, Column rest, BufferedWriter bw) throws IOException{
 
        if(n==1){
            bw.write(String.valueOf(from.index) + " " + String.valueOf(to.index));
            bw.newLine();
        }else{
            printHanoi(n-1, from, rest, to, bw);
            bw.write(String.valueOf(from.index) + " " + String.valueOf(to.index));
            bw.newLine();
            printHanoi(n-1, rest, to, from, bw);
        }
         
    }
	*/
     
    static StringBuilder sb;
    static void printHanoi2(int n, int from, int to){
        if(n ==0)
            return;
        printHanoi2(n-1, from, 6-from-to);
        sb.append(from).append(" ").append(to).append("\n");
        printHanoi2(n-1, 6-from-to, to);
         
    }
     
    private static int computeMovingNumber(int n){
         
        if(n == 1){
            return n;
        }
        else{
             
            return (2*computeMovingNumber(n-1)) + 1;
        }
         
    }
     
    public static void main(String[] args) throws IOException {
         
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
         
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
         
        int N = Integer.parseInt(br.readLine());
         
        sb = new StringBuilder();
        printHanoi2(N, 1, 3);
        bw.write(String.valueOf(computeMovingNumber(N)));
        bw.newLine();
        bw.write(sb.toString());
         
//      if(N <= 20){
//          
//          
//          printHanoi(N, Column.ONE, Column.THREE, Column.TWO, bw);
//      }else{
//          bw.write(String.valueOf(computeMovingNumber(N)));
//      }
         
        bw.flush();
    }
}