package chap02;

class PrimeNumber1 {

	public static void main(String[] args) {
		
		int counter = 0;
		
		for(int n = 2; n <= 1000; n ++) {
			
			int i;
			
			for(i = 2; i < n; i ++) {
				
				counter ++;
				
				if(n % i == 0) { // 나머지가 없으면 소수가 아님 
					break; // 더이상 반복하지 않음 
				}
			}
			
			if(n == i) { 
				System.out.println(n); // 마지막까지 나누어 떨어지지 않음 
			}
		}
		
		System.out.println("나눗셈을 수행한 횟수 : " + counter);

	}

}
