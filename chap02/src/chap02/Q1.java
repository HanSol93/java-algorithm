package chap02;
import java.util.Random;
// 키와 사람수를 난수로 생성하여 최대값을 출력하는 프로그램을 작성하세요.

class Q1 {
	
	static int maxOf(int[] a) {
		int max = a[0];
		
		for(int i = 1; i < a.length; i++) {
			if(a[i] > max) {
				max = a[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		Random rand = new Random();
		
		// 사람 수는 1~10명중 랜덤 
		int num = rand.nextInt(10) + 1; 
		
		int[] height = new int[num];
		
		System.out.println("키 값은 아래와 같습니다.");
		
		for(int i = 0; i < num; i++) {
			// 100 ~ 199 까지의 수를 height에 대입 
			height[i] = 100 + rand.nextInt(100);

			System.out.println("height[" + i + "] : " + height[i]);
		}
		
		System.out.println("최댓값은 " + maxOf(height) + "입니다.");
		

	}

}
