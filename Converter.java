
package ;
import java.util.*;

public class Converter{
	public ArrayStack<String> as = new ArrayStack<>();
	public String ginput;
	public String result="";
	
	public Converter(String in) {
		ginput = in;
		
	}
	
	private static List<String> parsed(char[] input) {
	List<String> parsed = new ArrayList<String>();
	   for (int i = 0; i < input.length; ++i) {
	       char c = input[i];
	       if (Character.isDigit(c)) {
	           String number = input[i] + "";
	           for (int j = i + 1; j < input.length; ++j) {
	               if (Character.isDigit(input[j])) {
	                   number += input[j];
	                   i = j;
	               } else {
	                   break;
	               }
	           }
	           parsed.add(number);
	       } else if (c == '*' || c == '/' || 
	                  c == '+' || c == '^' || 
	                  c == '-' || c == '(' || c == ')') {
	           parsed.add(c + "");
	       }
	   }
	return parsed;
	}
	public String toPostFix() {
		char[] inp = new char[ginput.length()];
		for (int i=0;i<ginput.length();i++) {
			inp[i] = ginput.charAt(i);
		}
		List<String> parsed = parsed(inp);
	    for (int i = 0; i<parsed.size(); i++) {
	    	String c = parsed.get(i);
	        if (c.matches("[0-9]*")) 
	        	result = result+(c)+" "; 
	        else if(c.equals(("("))) {
	        	as.push(c);
	        }
	        else if(c.equals("+") ||c.equals("-") || c.equals("/")
	          || c.equals("*")||c.equals("^")) {
	        	if (as.size()!=0) {
	        		while(as.size()!=0 && !as.top().equals("(") && precedence(as.top())>=precedence(c)) {
	        			result = result + as.pop()+" ";
	        		}
	        	}
	        	as.push(c);
	        }
	        else if (c.equals(")")) {
	        	while(as.size()!=0) {
	        		if(!as.top().equals("(")) {
	        			result = result+as.pop()+" ";
	        		}else {
	        			as.pop();
	        			break;
	        		}   
	        	}
	        }  
	     }
	       while(as.size() != 0) {
	        result = result + as.pop()+" ";
	       }
	       return result;
		    
  
	}
	public int precedence(String c) {
		int priority;
		if ((c.equals("+")) || (c.equals("-"))) {
			priority = 1;
		}
		else if ((c.equals("*")) || (c.equals("/"))) {
			priority = 2;
		}
		else {
			priority = 3;
		}
		return priority;
	}
}
