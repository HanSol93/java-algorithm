package chap04;

// 생성자 Gstack : Gstack 클래스 초기화 
// 푸시 메서드 push : 배열의 맨 위에 데이터를 넣고 스택 배열을 반환.
// 팝 메서드 pop : 맨 위의 데이터를 return하고 배열의 length를 1개 줄임 
// 피크 메서드 peek : 맨 위의 데이터를 return 
// 검색 메서드 indexOf : 맨위부터 바닥순서로 검색한 데이터가 있는지 체크 후 있으면 해당 데이터의 index를 반환, 없으면 -1을 반환.
// 삭제 메서드 clear : 스택의 모든 요소를 삭제하는 메서드 
// 용량 확인 메서드 capacity : 스택의 용량 값 반환 
// 데이터 수 확인 메서드 size : 스택의 데이터 수(ptr) 값을 반환하는 메서드 
// 빈 스택 확인 메서드 isEmpty : 스택이 비어있는지 검사하는 메서드 
// 가득 찬 스택 확인 메서드 isFull : 스택이 가득 찻는지 확인하는 메서드 
// 모든것을 표시하는 메서드 dump : 스택안에 쌓아올린 모든 데이터를 바닥에서 맨위 순서로 표시하는 메서드


public class Gstack {
	private int max; // 스택의 총 용량 
	private int ptr; // 스택 포인터 : stk배열의 현재 index를 가르킨다.
	private int[] stk; // 스택이 쌓일 배열 
	
	// 스택 배열용량이 꽉 찻을때 예외처리 
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			System.out.println("스택에 용량이 부족합니다!");
		}
	}
	
	// 빈 스택에 값을 요청했을때 예외처리 
	public class EmptyInStackException extends RuntimeException {
		public EmptyInStackException() {
			System.out.println("스택이 비었습니다!");
		}
	}
	
	// 생성자 
	public Gstack (int capacity) {
		ptr = 0; // 처음 시작할땐 배열의 length가 0 이므로 ptr는 0으로 초기화 한다.
		max = capacity; // 사용자가 입력한 값을 스택의 용량을 설정할 max 변수에 대입한다. 
		
		try{
			stk =  new int[max]; // max 만큼의 length를 가진 int 형식의 배열을 stk 변수가 참조하도록 한다.
		} catch(OutOfMemoryError e) { // 메모리를 초과할경우 
			max = 0; // max 변수를 0으로 초기화한다.
		}
	}
	
	public int push(int a) throws OverflowIntStackException {
		if(ptr >= max) {
			throw new OverflowIntStackException();
		}
		
		return stk[ptr++] = a;
	}
	
	public int pop() throws EmptyInStackException {
		if(ptr <= 0) {
			throw new EmptyInStackException();
		}
		
		return stk[--ptr];
	}
	
	public int peek() throws EmptyInStackException {
		if(ptr >= max) {
			throw new OverflowIntStackException();
		}
		
		return stk[ptr - 1];
	}
}
