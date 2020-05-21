package chap01;
//4개의 정숫값 가운데 최소값을 구하여 출력합니다.

public class Q3 {
	//a,b,c,d의 최소값을 구하여 반환합니다.
	
	static int min4(int a, int b, int c, int d) {
		int min = a;
		
		if(b < min)
			min = b;
		if(c < min)
			min = c;
		if(d < min)
			min = d;
		
		return min;
	}

	public static void main(String[] args) {
		
		System.out.println("min4(1,2,3,4) : " + min4(1,2,3,4));
		System.out.println("min4(4,3,2,1) : " + min4(4,3,2,1));
		System.out.println("min4(3,4,2,1) : " + min4(3,4,2,1));
		System.out.println("min4(2,3,1,4) : " + min4(2,3,1,4));
		System.out.println("min4(4,1,2,3) : " + min4(4,1,2,3));

	}

}
