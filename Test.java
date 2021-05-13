package ;

import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		System.out.println("type your infix expression:");
		Scanner input = new Scanner(System.in);
		String x = input.next();
		Converter s = new Converter(x);
		String res = s.toPostFix();
		System.out.println("Converted to postfix:"+res);
		PostfixCalculator ss = new PostfixCalculator();
		Double answer = ss.calculate(res);
		System.out.println("answer is " + answer);
	
		input.close();
	}
}
