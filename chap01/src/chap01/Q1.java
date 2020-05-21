package chap01;
//4개의 정숫값 가운데 최댓값을 구하여 출력합니다.

public class Q1 {
	//a,b,c,d의 최댓값을 구하여 반환합니다.
	
	static int max4(int a, int b, int c, int d) {
		int max = a;
				
		if(b > max)
			max = b;
		if(c > max)
			max = c;
		if(d > max)
			max = d;
		
		return max;	
	}

	public static void main(String[] args) {
		
		System.out.println("max4(1,2,3,4)" + max4(1,2,3,4));
		System.out.println("max4(4,3,2,1)" + max4(1,2,3,4));
		System.out.println("max4(3,4,1,2)" + max4(1,2,3,4));
		System.out.println("max4(4,2,3,4)" + max4(1,2,3,4));

	}

}
