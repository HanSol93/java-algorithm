package chap01;
import java.util.Scanner;
// 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력하는 프로그램을 작성하세요.

public class Q14 {

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		int n;
		
		do {
			System.out.print("사각형의 한 변의 수 : ");
			n = scnIn.nextInt();
		} while(n <= 0);
		
		for(int i = 0; i < n; i ++) {
			for(int y = 0; y < n; y ++) {
				System.out.print("*");
			}
		System.out.println();
		}

	}

}
