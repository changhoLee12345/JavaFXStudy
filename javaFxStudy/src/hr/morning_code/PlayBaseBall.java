package hr.morning_code;

import java.util.Scanner;

public class PlayBaseBall {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int[] cAry = new int[3];
		int[] iAry = new int[3];

		for (int i = 0; i < cAry.length;) {
			int temp = (int) (Math.random() * 9) + 1;
			if (i == 0) {

			} else if (i == 1) {
				if (cAry[0] == temp) {
					continue;
				}
			} else if (i == 2) {
				if (cAry[0] == temp || cAry[1] == temp)
					continue;
			}
			cAry[i] = temp;
			i++;
		}
		for (int i = 0; i < 3; i++) {
			System.out.print(cAry[i] + " ");
		}

		System.out.println();
//		while (true) {
//			for (int i = 0; i < 3; i++) {
//				System.out.println(i + "번째 값을 입력하세요.");
//				iAry[i] = scn.nextInt();
//			}
//			int strike = 0, ball = 0;
//			for (int i = 0; i < 3; i++) {
//				for (int j = 0; j < 3; j++) {
//					if (cAry[i] == iAry[j]) {
//						if (i == j)
//							strike++;
//						else
//							ball++;
//					}
//				}
//			}
//			System.out.println("Strike: " + strike + ", Ball: " + ball);
//			if (strike == 3)
//				break;
//		}
		System.out.println("end of prog.");
	}
}
