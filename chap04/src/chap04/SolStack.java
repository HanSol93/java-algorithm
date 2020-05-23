package chap04;

// 생성자 SolStack : SolStack 클래스 초기화 
// 푸시 메서드 push : 배열의 맨 위에 데이터를 넣고 스택 배열을 반환.
// 팝 메서드 pop : 맨 위의 데이터를 return하고 배열의 length를 1개 줄임 
// 피크 메서드 peek : 맨 위의 데이터를 return 
// 검색 메서드 indexOf : 맨위부터 바닥순서로 검색한 데이터가 있는지 체크 후 있으면 해당 데이터의 index를 반환, 없으면 -1을 반환.
// 삭제 메서드 clear : 스택의 모든 요소를 삭제하는 메서드 
// 용량 확인 메서드 capacity : 스택의 용량 값 반환 
// 데이터 수 확인 메서드 size : 스택의 데이터 수(ptr) 값을 반환하는 메서드 
// 빈 스택 확인 메서드 isEmpty : 스택이 비어있는지 검사하는 메서드 
// 가득 찬 스택 확인 메서드 isFull : 스택이 가득 찼는지 확인하는 메서드 
// 모든것을 표시하는 메서드 dump : 스택안에 쌓아올린 모든 데이터를 바닥에서 맨위 순서로 표시하는 메서드


public class SolStack {
	private int max; // 스택의 총 용량 
	private int ptr; // 스택 포인터 : stk배열의 현재 index를 가르킨다.
	private int[] stk; // 스택이 쌓일 배열 
	
	// 스택 배열용량이 꽉 찼을때 예외처리 
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			System.out.println("스택에 용량이 부족합니다!!!!!");
		}
	}
	
	// 빈 스택에 값을 요청했을때 예외처리 
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			System.out.println("스택이 비었습니다!!!!!");
		}
	}
	
	// 생성자 
	public SolStack (int capacity) {
		ptr = 0; // 처음 시작할땐 stk 배열의 length가 0 이므로 ptr는 0으로 초기화.
		max = capacity; // 사용자가 입력한 값을 스택의 용량을 설정할 max 변수에 대입. 
		
		try{
			stk =  new int[max]; // max 만큼의 length를 가진 int 형식의 배열을 stk 변수가 참조.
		} catch(OutOfMemoryError e) { // 메모리를 초과할경우 
			max = 0; // max 변수를 0으로 초기화.
		}
	}
	
	// 푸시 메서드 push : 배열의 맨 위에 데이터를 넣고 스택 배열을 반환.
	public int push(int a) throws OverflowIntStackException {
		if(ptr >= max) { // 스택 포인터가 스택의 총 용량보다 크거나 같으면 용량이 가득 찬것이므로 예외처리 
			throw new OverflowIntStackException();
		}
		
		return stk[ptr++] = a; // 현재 스택포인트 위치에 데이터를 넣은 후 스택포인트를 1 증가. 
	}
	
	// 팝 메서드 pop : 맨 위의 데이터를 return하고 배열의 length를 1개 줄임 
	public int pop() throws EmptyIntStackException {
		if(ptr <= 0) { // 스택 포인터가 0보다 작거나 같으면 빈 스택 이므로 예외처리 
			throw new EmptyIntStackException();
		}
		
		return stk[--ptr]; // 현재 스택포인트를 1개 빼고 그 위치의 데이터를 반환. 
	}
	
	// 피크 메서드 peek : 맨 위의 데이터를 return 
	public int peek() throws EmptyIntStackException {
		if(ptr <= 0) { // 스택 포인터가 0보다 작거나 같으면 빈 스택 이므로 예외처리
			throw new EmptyIntStackException();
		}
		
		return stk[ptr - 1]; // 맨 위 데이터를 반환. ( stk[ptr]은 비어있다 : push 후 ptr을 1개 늘리기 때문 )
	}
	
	// 검색 메서드 indexOf : 맨위부터 바닥순서로 검색한 데이터가 있는지 체크 후 있으면 해당 데이터의 index를 반환, 없으면 -1을 반환.
	public int indexOf(int a) throws EmptyIntStackException {
		if(ptr <= 0) { // 스택 포인터가 0보다 작거나 같으면 빈 스택 이므로 예외처리
			throw new EmptyIntStackException();
		}
		
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == a) {
				return i; // 스택의 맨 위부터 하나씩 같은 값이 있는지 검색하여 있으면 해당 index를 반환. 
			}
		}
		
		return -1; // 검색값이 스택에 없으면 -1을 반환.
	}
	
	// 삭제 메서드 clear : 스택의 모든 요소를 삭제하는 메서드 
	public void clear() {
		ptr = 0;
	}
	
	// 용량 확인 메서드 capacity : 스택의 용량 값 반환 
	public int capacity() {
		return max;
	}
	
	// 데이터 수 확인 메서드 size : 스택의 데이터 수(ptr) 값을 반환하는 메서드 
	public int size() {
		return ptr;
	}
	
	// 빈 스택 확인 메서드 isEmpty : 스택이 비어있는지 검사하는 메서드 
	public boolean isEmpty() {
		return ptr <= 0;
	}
	
	// 가득 찬 스택 확인 메서드 isFull : 스택이 가득 찼는지 확인하는 메서드 
	public boolean isFull() {
		return ptr >= max;
	}
	
	// 모든것을 표시하는 메서드 dump : 스택안에 쌓아올린 모든 데이터를 바닥에서 맨위 순서로 표시하는 메서드
	public void dump() {
		if(ptr <= 0) {
			System.out.println("빈 스택입니다.");
		}
		else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i]);
			}
		}
	}
}