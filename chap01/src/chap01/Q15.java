package chap01;
import java.util.Scanner;
// 직각 이등변 삼각형을 출력하는 메서드를 작성하세요.

public class Q15 {
	
	static void triangleLB(int n) {
		for(int i = 1; i <= n; i++) {
			for(int y = 1; y <= i; y ++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	static void triangleLU(int n) {
		for(int i = n; i >= 1; i--) {
			for(int y = i; y >= 1; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	

	public static void main(String[] args) {
		
		Scanner scnInt = new Scanner(System.in);
		
		int n;
		
		do {
			System.out.print("몇 단 삼각형입니까?");
			n = scnInt.nextInt();
			
		} while (n <= 0);
		
//		triangleLB(n);
		triangleLU(n);

	}

}
