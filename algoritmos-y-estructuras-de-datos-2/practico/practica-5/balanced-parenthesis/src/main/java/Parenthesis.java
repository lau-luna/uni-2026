import stack.LinkedStack;

public class Parenthesis {
  private LinkedStack<Character> stack;

  public Parenthesis() {
    stack = new LinkedStack<>();
  }

  public boolean isBalanced(String sequence) {
    for (int i = 0; i < sequence.length(); i++) {
      char s = sequence.charAt(i);
      switch (s) {
        case '[', '(':
          stack.push(s);
          break;
        
        case ')':
          if (stack.top() == '(')
            stack.pop();
          break;
        
        case ']':
          if (stack.top() == '[')
            stack.pop();
          break;

        default:
          break;
      }
    }

    return stack.size() == 0;
  }
}
