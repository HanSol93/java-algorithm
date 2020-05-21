package chap01;
import java.util.Scanner;
// 가우스 덧셈이라는 방법을 이용하여 1부터 n까지의 정수 합을 구하는 프로그램을 작성하세요.

class Q8 {

	public static void main(String[] args) {
		
		Scanner scnIn = new Scanner(System.in);
		
		System.out.println("n의 값은?");
		int n = scnIn.nextInt();
		
		int sum = (1 + n) * (n / 2) + (n % 2 == 1 ? (1 + n) / 2 : 0); // 합
		
		System.out.println("1부터 n까지 정수의 합 : " + sum);

	}

}
