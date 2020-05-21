package chap02;
// 배열 b의 모든 요소를 배열 a에 복사하는 메서드 copy를 작성하세요.

class Q4 {
	
	static void copy(int[] a, int[] b) {
		
		a = new int[b.length];
		
		for(int i = 0; i < b.length; i ++) {
			a[i] = b[i];
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
		
		System.out.print("복사된 a = [");
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
		
		int[] b = new int[] {5,3,4,6,2};
		
		copy(a, b);
	}

}
