package chap01;
// 위쪽과 왼쪽에 곱하는 수가 있는 곱셈표를 출력하는 프로그램을 작성하세요.

public class Q12 {

	public static void main(String[] args) {
		
		for(int i = 1; i <= 9; i ++) {
			
			if(i == 1) {
				System.out.print("    |");
				
				for(int x = 1; x <= 9; x ++) {
					System.out.printf("%3d", x);
				}
				
				System.out.println();
				System.out.println("----+----------------------------");
			}
			
			for(int y = 1; y <= 9; y ++) {	
				
				if(y == 1 ) {
					System.out.printf("%3d", i * y);
					System.out.print(" |");
				}
				
				System.out.printf("%3d", i * y);
				
			}
			
			System.out.println();
		}

	}

}
