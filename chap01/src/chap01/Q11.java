package chap01;
import java.util.Scanner;
// 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요.

class Q11 {

	public static void main(String[] args) {
		
		Scanner scnIn = new Scanner(System.in);
		
		int a;
		int count = 0;
		
		do {
			if(count > 0) {
				System.out.println("0보다 큰 수를 입력해주세요.");
				System.out.print("a의 값은?");
				a = scnIn.nextInt();
			} else {
				System.out.print("a의 값은?");
				a = scnIn.nextInt();
			}
			
			count ++;
			
		} while (a <= 0);
		
		count = 0;
		
		do {
			a = (a / 10);
			count ++;
		} while(a > 0);
		
		

		System.out.println("그 수는 " + count + "자리입니다.");
		

	}

}
