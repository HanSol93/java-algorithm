package chap01;

public class Multi99Table {

	public static void main(String[] args) {
		
		System.out.println("-----곱셈표-----");
		
		for (int i = 1; i <= 9; i++) {
			for(int y = 1; y <= 9; y++) {
				System.out.printf("%3d", i*y);
			}
			System.out.println();
		}

	}

}
