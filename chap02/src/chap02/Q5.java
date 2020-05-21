package chap02;
// 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 recopy를 작성하세요. 

class Q5 {
	
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}
	
	static void recopy(int[] a, int[] b) {
		a = new int[b.length];
		
		for(int i = 0; i < a.length; i ++) { 
			a[i] = b[i];
		}
		
		for(int i = 0; i < a.length/2; i ++) { 
			swap(a, i, a.length - i - 1);
		}
		
		System.out.print("원본 b = [");
		for(int i = 0; i < b.length; i++ ) {
			System.out.print(b[i]);
			if(i < a.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
		
		System.out.println();
		
		System.out.print("역순으로 복사된 a = [");
		for(int i = 0; i < a.length; i++ ) {
			System.out.print(a[i]);
			if(i < a.length - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}

	public static void main(String[] args) {
		
		int[] a = new int[0];
		int[] b = new int[] {1,2,3,4,5};
		
		recopy(a, b);
		
	}

}
