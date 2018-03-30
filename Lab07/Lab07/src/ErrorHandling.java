import java.util.Random;

public class ErrorHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ErrorHandling eh = new ErrorHandling();
		Random rd = new Random();
		int num = rd.nextInt(2);
		try {
			num = eh.naturalNum(num);
			System.out.println("자연수 : " + num);
		} catch (notNaturalNumber nnn) {
			System.out.println("성공! num : " + num);
		} catch (Exception e) {
			System.out.println("실패;");
		} finally {
			System.out.println("try, catch, finally, throw, throws");
			System.out.println("5개의 키워드가 모두 들어가 있는 Hint와는 다른 프로그램");
		}
	}

	public int naturalNum(int num) throws notNaturalNumber {
		if (num > 0) {
			return num;
		} else {
			throw new notNaturalNumber();
		}
	}
}
