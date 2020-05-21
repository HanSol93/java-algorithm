package chap01;
import java.util.Scanner;
// 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래 메서드를 작성하세요.

class Q9 {
	
	static int sumof(int a, int b) {
		int min = a;
		int max = b;
		
		int sum = 0; // 합 
		
		if(b <= min) {
			min = b;
			max = a;
		}
		
		for(int i = min; i <= max; i++) {
			sum += i;
		}
		
		return sum;
	}

	public static void main(String[] args) {
		
	System.out.println("정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환합니다.");
		
		Scanner scnIn = new Scanner(System.in);
		
		System.out.println("정수 a의 값은?");
		
		int a = scnIn.nextInt();
		
		System.out.println("정수 b의 값은?");
		
		int b = scnIn.nextInt();
		
		System.out.println("sumof(a,b) : " + sumof(a,b));

	}

}
