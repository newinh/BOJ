#include <stdio.h>

int main()
{
	int n;
	scanf("%d",&n);

	int a[n];
	int key;
	int j;
	for(int i = 0; i < n ; i++) {
		
		scanf("%d", &a[i]);

	}

	for(int i =1 ; i < n ; i ++){

		key = a[i];
		j = i-1;
		while( j >= 0 && key < a[j] ){
			a[j+1] = a[j];
			j--;
		}
		a[j+1] = key;

	}

	for(int i = 0 ; i < n ; i++) {
		printf("%d\n", a[i]);
	}
	
	return 0;
}
