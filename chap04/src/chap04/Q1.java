package chap04;
import java.util.Scanner;
// 클래스 IntStack의 모든 메서드를 사용하는 프로그램을 작성하세요. 


class Q1 {

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		IntStack s = new IntStack(10); // max 길이가 10인 스택을 생성 
		
		while (true) {
		
			System.out.println("현재 데이터 수 : " + s.size() +" / "+ s.capacity());
			System.out.print("(1) 푸시   (2) 팝   (3) 피크   " +
							"(4) 덤프   (5) 검색  (6) 삭제   "+
							"(7) 용량이 가득 찻나요?  (8) 비어있나요?   " + 
							"(0) 종료 : ");
				
			int menu = scnIn.nextInt();
			
			if(menu <= 0) {
				break;
			}
		
			int x;
			
			switch (menu){
			
				case 1:
					System.out.println("데이터 : ");
					x = scnIn.nextInt();
					
					try {
						s.push(x);
						
					} catch (IntStack.OverflowIntStackException e) {}
					
					break;
					
				case 2: 
					try {
						
						System.out.println("pop 된 데이터 : " + s.pop());
						s.pop();
						
					} catch(IntStack.EmptyInStackException e) {}
					
					break;
					
				case 3:
					try {
						
						System.out.println("맨 위에 데이터 : " + s.peek());
						
					} catch(IntStack.EmptyInStackException e) {}
					
					break;
					
				case 4:
					s.dump();
					
					break;
					
				case 5:
					System.out.println("찾을 데이터 : ");
					x = scnIn.nextInt();
					
					try {
						if(s.indexOf(x) <= -1) {
							System.out.println("해당 데이터가 없습니다.");
						} 
						else {
							System.out.println("해당 데이터의 인덱스 : " + s.indexOf(x));
						}
						
					} catch (IntStack.OverflowIntStackException e) {}
					
					break;
					
				case 6:
					s.clear();
					break;
					
				case 7:
					if(s.isFull()) {
						System.out.println("가득 찻습니다.");
					}
					else {
						System.out.println("가득 차지 않았습니다.");
					}
					break;
					
				case 8:
					if(s.isEmpty()) {
						System.out.println("비어있습니다.");
					}
					else {
						System.out.println("비어있지 않습니다.");
					}
					break;
			}
		}

	}

}
