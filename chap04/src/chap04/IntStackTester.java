package chap04;
import java.util.Scanner;

class IntStackTester {

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		IntStack s = new IntStack(3); // 최대 10개를 푸시할 수 있는 스택 
		
		while (true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 푸시   (2)팝   (3)피크   " +
							 "(4) 덤프   (0)종료 : ");
			
			int menu = scnIn.nextInt();
			if(menu == 0) break;
			
			int x;
			switch (menu) {
			
				case 1: // 푸시 
					System.out.print("데이터 : ");
					x = scnIn.nextInt();
					
					try {
						s.push(x);
					} catch (IntStack.OverflowIntStackException e) {}
					
					break;
					
				case 2: // 팝 
					try {
						System.out.println("제거 된 데이터 : " + s.pop());
					} catch (IntStack.EmptyInStackException e) {}
					
					break;
					
				case 3: // 피크
					try {
						x = s.peek();
						System.out.println("맨 위에 있는 데이터는 " + x + "입니다.");
					} catch (IntStack.EmptyInStackException e) {}
					
					break;
					
				case 4: // 덤프
					s.dump();
					break;
					
			}
		}

	}

}
