package demo;

public class Demo {

	public static void main(String[] args) {
		// 10,0,50,0,0,12,0
		int a[]= {10,0,50,0,0,12,0};
		int count=0;
		
			for(int j=0;j<a.length-1;j++) {
				if(a[j]==0) {
					for(int jj=j;jj<a.length-1;jj++) {
						a[jj]=a[jj+1];
					}
				}
			}
				
			for(int k=0;k<a.length;k++) {
				System.out.print(a[k]);
			}
		}
	}
