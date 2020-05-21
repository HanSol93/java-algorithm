package chap01;
import java.util.Scanner;
// 1,2,..., n의 합을 구합니다. 

 class SumWhile {

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		
		System.out.println("1부터 n까지의 합을 구합니다.");
		System.out.print("n의 값 : ");
		int n = scnIn.nextInt();
		
		int sum = 0; // 합 
		int i = 1;
		
		while(i <= n) {
			sum += i;
			i++;
		}
		
		System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
		
		// Q6
		System.out.println("i의 값은 : " + i + "입니다.");
	}

}
