import java.util.*;

public class Main {
    
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        if(N < 60)
            System.out.println("F");
        else if(N < 70)
            System.out.println("D");
        else if(N < 80)
            System.out.println("C");
        else if(N < 90)
            System.out.println("B");
        else
            Sysetm.out.println("A");
        
    }
    
}