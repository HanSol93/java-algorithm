package chap01;
import java.util.Scanner;
// a와 b를 입력하고 b-a를 출력하는 프로그램을 작성하세요.

class Q10 {

	public static void main(String[] args) {
	
		System.out.println("b - a를 출력합니다.");
		
		Scanner scnIn = new Scanner(System.in);
		
		int a = 0, b = 0, sum = 0, count = 0;
		
		do {
			if(count == 0) {
				System.out.print("a의 값 : ");
				a = scnIn.nextInt();
				
				System.out.print("b의 값 : ");
				b = scnIn.nextInt();
			} else {
				System.out.println("a보다 큰 값을 입력하세요!");
				
				System.out.print("b의 값 : ");
				b = scnIn.nextInt();
			}

			count++;
			
		} while (a >= b);
		
		System.out.println("b - a는 " + (b - a) + "입니다.");
		

	}

}
