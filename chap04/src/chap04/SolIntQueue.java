package chap04;

// 생성자 SolIntQueue : SolIntQueue 클래스 초기화 
// 인큐 메서드 enque : 인큐한 값 반환. 큐가 가득 찼으면 예외처리.
// 디큐 메서드 deque : 디큐한 값 반환. 큐가 비어있으면 예외처리.
// 피크 메서드 peek : 맨 앞의 데이터를 몰래 엿보는 메서드. que[front]의 값을 반환. 큐가 비어있으면 예외처리.
// 검색 메서드 indexOf : 사용자가 입력한 값이 큐에 저장되어 있는지 검색후 있으면 인덱스((i+front) % max)를 반환. 없으면 -1 반환.
// 삭제 메서드 clear : 큐의 모든 데이터 삭제.
// 최대용량 확인 메서드 capacity : 큐의 최대 용량을 반환.
// 데이터 수 확인 메서드 size : 큐의 데이터 수 반환.
// 빈 큐인지 확인 메서드 isEmpty : 큐가 비어있는지 확인하여 true/false 반환.
// 큐가 가득 찼는지 확인 메서드 isFull : 큐가 가득 찻는지 확인하여 true/false 반환.
// 모든 데이터 출력 메서드 dump : 큐의 모든 데이터를 프론트 -> 리어 순으로 출력. 큐가 비어있으면 예외처리.
// 검색 한 데이터가 큐 안에 몇번째 있는지 검색 메서드 search : 프런트에 있는경우 1로 함.

public class SolIntQueue {
	private int front; // 큐에 첫번째로 넣은 요소의 인덱스 (디큐 시 나갈 인덱스) 
	private int rear; // 큐에 마지막으로 넣은 요소의 인덱스 + 1 (인큐 시 넣을 인덱스)
	private int num; // 현재 큐의 데이터 갯수 : front와 rear의 값이 동일할때 꽉찬것인지 빈것인지 구분하기 위함.
	private int max; // 큐의 최대 용량 
	private int[] que; // 큐 본체용 배열  
	
	// 큐가 가득 찼을때 예외처리 
	public class OverflowIntQueueException extends RuntimeException {
		public OverflowIntQueueException() {
			System.out.println("큐의 용량이 가득찼어요!!!");
		}
	}
	
	// 큐가 비어있을때 예외처리 
	public class EmptyIntQueueException extends RuntimeException {
		public EmptyIntQueueException() {
			System.out.println("큐가 비어있어요!!!");
		}
	}
	
	// 생성자 SolIntQueue : SolIntQueue 클래스 초기화 
	public SolIntQueue(int capacity) {
		front = rear = num = 0;
		
		try {
			max = capacity;
			que = new int[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}
	
	// 인큐 메서드 enque : 인큐한 값 반환. 큐가 가득 찼으면 예외처리.
	public int enque(int a) throws OverflowIntQueueException {
		if(num >= max) {
			throw new OverflowIntQueueException();
		}
		
		que[rear] = a;
		rear ++;
		num ++;
		
		if(rear == max) { // rear와 max가 같으면 다음에 인큐시 rear는 없는 인덱스이기 때문에 0으로 초기화 해줘야함.
			rear = 0;
		}
		
		return a;
	}
	
	// 디큐 메서드 deque : 디큐한 값 반환. 큐가 비어있으면 예외처리.
	public int deque() throws EmptyIntQueueException {
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		int x = que[front];
		front++;
		num --;
		
		if(front == max) {
			front = 0;
		}
		
		return x;
	}
	
	// 피크 메서드 peek : 맨 앞의 데이터를 몰래 엿보는 메서드. que[front]의 값을 반환. 큐가 비어있으면 예외처리.
	public int peek() throws EmptyIntQueueException {
		if(num <= 0) {
			throw new EmptyIntQueueException();
		}
		
		return que[front];
	}
	
	// 검색 메서드 indexOf : 사용자가 입력한 값이 큐에 저장되어 있는지 검색후 있으면 인덱스((i+front) % max)를 반환. 없으면 -1 반환.
	public int indexOf(int a) {
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if(a == que[idx]) {
				return idx;
			}
		}
		return -1;
	}
	
	// 삭제 메서드 clear : 큐의 모든 데이터 삭제.
	public void clear() {
		front = rear = num = 0;
	}
	
	// 최대용량 확인 메서드 capacity : 큐의 최대 용량을 반환.
	public int capacity() {
		return max;
	}
	
	// 데이터 수 확인 메서드 size : 큐의 데이터 수 반환.
	public int size() {
		return num;
	}
	
	// 빈 큐인지 확인 메서드 isEmpty : 큐가 비어있는지 확인하여 true/false 반환.
	public boolean inEmpty() {
		return num <= 0;
	}
	
	// 큐가 가득 찼는지 확인 메서드 isFull : 큐가 가득 찻는지 확인하여 true/false 반환.
	public boolean isFull() {
		return num >= max;
	}
	
	// 모든 데이터 출력 메서드 dump : 큐의 모든 데이터를 프론트 -> 리어 순으로 출력. 큐가 비어있으면 예외처리.
	public void dump() {
		if(num <= 0) {
			System.out.println("큐가 비어있습니다.");
		}
		else {
			for(int i = 0; i < num; i ++) {
				System.out.print(que[(i+front) % max]);
			}
			System.out.println();
		}
	}
	
	// 검색 한 데이터가 큐 안에 몇번째 있는지 검색 메서드 search : 프런트에 있는경우 1로 함.
	public int search(int a) {
		for(int i = 0; i < num; i++) {
			int idx = (i + front) % max;
			if(a == que[idx]) {
				return i + 1;
			}
		}
		return -1;
	}
}
