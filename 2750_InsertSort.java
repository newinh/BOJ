import java.util.Scanner;

public class Main {
	
	static class SelectionSort{
		
		int [] a;
		int n ;
		
		private SelectionSort(int n){
			this.n = n;
			a = new int[n];
		}
		
		private void init(Scanner sc){
			
			for(int i = 0; i < n ; i ++){
				a[i] = sc.nextInt();
			}
		}
		
		private int pick(int i){
			return a[i];
		}
		
		private void doSort(int i, int n) {
			
			
			if( n < a[i-1] ){
				int tmp;
				tmp = a[i-1];
				a[i-1] = n;
				a[i] = tmp;
				
				if(i > 1)
				doSort(i-1, n);
			}
			
		}
		
		private void print(){
			for(int i = 0 ; i < a.length; i++)
				System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		 
		 SelectionSort selectionSort = new SelectionSort(sc.nextInt());
		 selectionSort.init(sc);
		 
		 for(int i =1; i < selectionSort.a.length ; i++ ){
			 
			 selectionSort.doSort(i, selectionSort.pick(i) );
		 }
		 selectionSort.print();

	}

}