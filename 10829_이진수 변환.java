import java.util.Scanner;
 
public class Main {
     
 
     
    public static void main(String[] args)  {
         
         
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String s = "";
         
        while(n != 0){
            s += n%2;
            n /=2;
        }
        char[] a = s.toCharArray();
         
        for(int i = 0; i < a.length ; i++){
            System.out.print(a[a.length-1 - i]);
        }
 
    }
 
}