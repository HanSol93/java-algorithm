package chap02;

import java.util.Scanner;

class Q9 {
	
	// 각 달의 일수 
	static int[][] mdays = {
			{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
			{31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	};
	
	// 서기 year년은 윤년인가? (윤년 : 1 / 평년 : 0) 
	static int isLeap(int year) {
		return ( year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) ? 1 : 0;
	}
	
	// 서기 y년 m월 d일의 그 해 결과 일 수를 구함 
	static int dayOfYear(int y, int m, int d) {
		int counter = 1;
		
		while(counter < m) {
			
			d += mdays[isLeap(y)][counter - 1];
			
			counter++;
		}
		
		return d;
	}
	
	// 서기 y년 m월 d일의 그 해 남은 일 수를 구함 
	static int leftDayOfYear(int y, int m, int d) {
		int counter = 1;
		int allDays = 0; // 모든 날짜의 갯수
		
		for(int i = 1; i <= 12; i ++) { // 남은 일수를 구하기위해 전체 일수를 구합니다.
			allDays += mdays[isLeap(y)][i - 1];
		}
			
		while(counter < m) {
			d += mdays[isLeap(y)][counter - 1];
			
			counter++;
		}
			
		return allDays - d; // 남은 일
	}

	public static void main(String[] args) {
		
		Scanner scnIn = new Scanner(System.in);
		int retry;
		
		System.out.println("그 해 경과 일수를 구합니다.");
		
		do {
			System.out.print("년 : "); int year = scnIn.nextInt(); // 년
			System.out.print("월 : "); int month = scnIn.nextInt(); // 월 
			System.out.print("일 : "); int day = scnIn.nextInt(); // 일 
			
			System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));
			
			System.out.printf("그 해에는 %d일 남았습니다.\n", leftDayOfYear(year, month, day));
			
			System.out.print("한 번 더 할까요? (1.예 / 0.아니오) : ");
			
			retry = scnIn.nextInt();
			
		} while(retry == 1);
		
	}
}
