package chap01;
// n이 7이면 '1 + 2 + 3 + 4 + 5 + 6 + 7 = 28'로 출력하는 프로그램을 작성하세요. 

class Q7 {

	public static void main(String[] args) {
		
		int n = 7;
		
		int sum = 0; // 합
	
		
		for(int i = 1; i <= n; i++) {
			
			sum += i;
			
			if(i <= 6) {
				System.out.print(i + " + ");
			} else {
				System.out.print(i);
			}
		}
		

		System.out.print(" = " + sum);
		
	}

}
