import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
 
/**
 * @author HOON
 * @date   2016. 10. 10.
 * BOJ 1914 Hanoi Tower
 * using recursion 
 */
public class Main implements Cloneable{
     
    private static final BigInteger TWO = new BigInteger("2");
     
     
    static StringBuilder sb;
     
    static void printHanoi2(int n, int from, int to){
        if(n ==0)
            return;
        printHanoi2(n-1, from, 6-from-to);
        sb.append(from).append(" ").append(to).append("\n");
        printHanoi2(n-1, 6-from-to, to);
         
    }
     
    private static BigInteger computeMovingNumber(BigInteger n){
         
        if(n.equals(BigInteger.ONE)){
            return n;
        }
        else{
            n = computeMovingNumber(n.subtract(BigInteger.ONE));
            n = n.multiply(TWO);
            n = n.add(BigInteger.ONE);
             
            return n;
        }
         
    }
     
    public static void main(String[] args) throws IOException {
         
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
         
        OutputStreamWriter osw = new OutputStreamWriter(System.out);
        BufferedWriter bw = new BufferedWriter(osw);
         
        int N = Integer.parseInt(br.readLine());
         
        sb = new StringBuilder();
        BigInteger bi = new BigInteger(String.valueOf(N));
         
        if(N <= 20){
            printHanoi2(N, 1, 3);
            bw.write(computeMovingNumber(bi).toString());
            bw.newLine();
            bw.write(sb.toString());
        }else{
            bw.write(computeMovingNumber(bi).toString());
        }
         
        bw.flush();
    }
}