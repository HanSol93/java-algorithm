package chap02;
import java.util.Scanner;
// 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성하세요.

class Q3 {
	
	static int sumOf(int[] a) {
		int sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		
		System.out.print("a[]의 요솟값 : ");
		int num = scnIn.nextInt();
		
		int[] a = new int[num];
		
		for(int i = 0; i < a.length; i++) {
			System.out.print("a[" + i + "]의 값 : ");
			a[i] = scnIn.nextInt();
		}
		

		System.out.print("a[");
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i < a.length -1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		
		System.out.println();
		
		System.out.println("총 합 : " + sumOf(a));
		
		

	}

}
