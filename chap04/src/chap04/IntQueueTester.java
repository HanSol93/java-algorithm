package chap04;
import java.util.Scanner;
// int형 큐의 사용 

class IntQueueTester {

	public static void main(String[] args) {
		Scanner scnIn = new Scanner(System.in);
		IntQueue s = new IntQueue(64); // 최대 64개를 인큐할 수 있는 큐 
		
		while(true) {
			System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
			System.out.print("(1) 인큐   (2) 디큐   (3) 피크   (4) 덤프   (0) 종료");
			
			int menu = scnIn.nextInt();
			
			if(menu == 0) {
				break;
			}
			
			int x;
			
			switch(menu) {
			
				case 1:
					System.out.println("데이터 : "); // 인큐 
					x = scnIn.nextInt();
					
					try {
						s.enque(x);
					} catch (IntQueue.OverflowIntQueueException e) {
						System.out.println("큐가 가득 찼습니다.");
					}
					
					break;
					
				case 2:
					try {
						x = s.deque();
						System.out.println("디큐 한 데이터는 " + x + "입니다.");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어있습니다.");
					}
					
					break;
					
				case 3:
					try {
						x = s.peek();
						System.out.println("피크 한 데이터는 " + x + "입니다.");
					} catch (IntQueue.EmptyIntQueueException e) {
						System.out.println("큐가 비어있습니다.");
					}
					
					break;
					
				case 4:
					s.dump();
					
					break;
				
			}
		}

	}

}
