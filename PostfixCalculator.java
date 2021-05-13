package ;

public class PostfixCalculator {
	private double res;
	
	public double calculate(String input){
		ArrayStack<Double> obj = new ArrayStack<>();
		String[]inputs = input.split(" ");
		return calculator(obj,inputs);
	}
	public double calculator(ArrayStack<Double> stack, String[] input) {
		double x, x2;
		for(int i = 0; i< input.length; i++) {
			if (input[i].equals("+")|| input[i].equals("-") ||input[i].equals("*") ||input[i].equals("/") ||input[i].equals("^")){
				x2 = stack.pop();
				x = stack.pop();
				switch(input[i]) {
					case "+": {
						this.res = x + x2;
						break;
					}
					case "-": {
						this.res = x - x2;
						break;
					}
					case "*": {
						this.res = x * x2;
						break;
					}
					case "/": {
						this.res = x / x2;
						break;
					}
					case "^": {
						this.res = Math.pow(x, x2);
						break;
					}
				}
				stack.push(this.res);
			} else {
				stack.push(Double.parseDouble(input[i]));
			}
		}
		
		
		
		return stack.pop();
	}
}
