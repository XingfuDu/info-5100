import java. util. *;
public class reverseString { 

    public static String reverse(String s) {
	if(s == null) {
	    return null;
	}
	
	String output = "";
	Stack<Character> stack1 = new Stack<>();
	Stack<String> stack2 = new Stack<>();

	for (int i = 0; i<s.length(); i++) {
	    if(stack1.isEmpty() && s.charAt(i) == ' ')  {
		continue;
	    }
	    if(!stack1.isEmpty() && s.charAt(i) == ' ') {
		String word = "";
		while(!stack1.isEmpty()) {
		    word = stack1.pop() + word;
		}
		stack2.push(word);
		continue;
	    }
	    stack1.push(s.charAt(i));  
	}
	while(!stack2.isEmpty()) {
	    output += stack2.pop() + " ";
	}
	return output.substring(0,output.length()-1);
    }

    public static void main(String[] args) {
	String input = " the  sky is   blue  ";
	String output = reverseString.reverse(input);
	System.out.println("the input is: (" + input + ")");
	System.out.println("the output is: (" + output + ")");
    }
}