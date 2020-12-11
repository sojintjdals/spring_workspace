package hans.testBoard;

public class SwitchTest {

	public static void main(String[] args) {
		int i = 33;
		
		switch (i % 2) {
		case 0:
			System.out.println(i + "는(은) 짝수");
			break;
		case 1:
			System.out.println(i + "는(은) 홀수");
			break;
		}
	}

}
