package chap04;
// int형 스택 

public class IntStack {
	
	private int max; // 스택 용량 
	private int ptr; // 스택 포인터 : 스택에 쌓여있는 데이터 수 
	private int[] stk; // 스택 본체 
	
	// 실행 시 예외 : 스택이 비어있음
	public class EmptyInStackException extends RuntimeException {
		public EmptyInStackException() {
			System.out.println("스택이 비어 있습니다.");
		}
	}
	
	// 실행 시 예외 : 스택이 가득 
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			System.out.println("스택이 가득 찻습니다.");
		}
	}
	
	// 생성자 
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max];
		} catch(OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 스택에 x를 푸시 
	public int push(int x) throws OverflowIntStackException {
		if(ptr >= max) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x;
	}
	
	// 스택에서 데이터를 팝 (정상에 있는 데이터를 꺼냄) 
	public int pop() throws EmptyInStackException {
		if(ptr <= 0) {
			throw new EmptyInStackException();
		}
		return stk[--ptr];
	}
	
	// 스택에서 데이터를 픽 (정상에 있는 데이터를 들여다봄) 
	public int peek() throws EmptyInStackException {
		if(ptr <= 0) {
			throw new EmptyInStackException();
		}
		return stk[ptr - 1];
	}
	
	// 스택에서 a를 찾아 인덱스를 반환 (인덱스가 없으면 -1을 반환) 
	public int indexOf(int a) throws EmptyInStackException {
		if(ptr <= 0) {
			throw new EmptyInStackException();
		}
		 
		// 정상쪽에서 선형검색 
		for(int i = ptr - 1; i >= 0; i--) {
			if(stk[i] == a) {
				
				// 검색 성공 
				return i;
			}
		}
		
		// 검색 실패 
		return -1;
	}
	
	// 스택에서 모든 요소를 삭제 
	public void clear() {
		ptr = 0;
	}
	
	// 스택의 용량을 확인 
	public int capacity() {
		return max;
	}
	
	// 스택의 데이터 수를 확인 
	public int size() {
		return ptr;
	}
	
	// 스택이 비어있는지 검사하는 메서드 
	public boolean isEmpty() {
		return ptr <= 0;
	}
		
	// 스택이 가득 찻는지 검사하는 메서드 
	public boolean isFull() {
		return ptr >= max;
	}
	
	// 스택 안에 있는 모든 데이터 표시 -> 바닥에서부터 출력 
	public void dump() {
		if(ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		} else {
			for(int i = 0; i < ptr; i++) {
				System.out.println(stk[i]);
			}
			System.out.println();
		}
	}
}
