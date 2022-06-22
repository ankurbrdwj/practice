package com.ankur.interview.hackerrank;

import java.util.Stack;

public class BalancedParenthesis {

	public BalancedParenthesis() {
		// TODO Auto-generated constructor stub
		this.stack=new Stack();
		this.root=new Node();
	}
private Stack stack;
private Node root;
  
 
/* Returns 1 if character1 and character2 are matching left
   and right Parenthesis */
boolean isMatchingPair(char character1, char character2)
{
   if (character1 == '(' && character2 == ')')
     return true;
   else if (character1 == '{' && character2 == '}')
     return true;
   else if (character1 == '[' && character2 == ']')
     return true;
   else
     return false;
}
 
/*Return 1 if expression has balanced Parenthesis */
boolean areParenthesisBalanced(char exp[])
{
   int i = 0;
 
   /* Declare an empty character stack */
 //  struct sNode *stack = NULL;
 
   /* Traverse the given expression to check matching parenthesis */
   for(i=0;i<exp.length;i++)
   {
      /*If the exp[i] is a starting parenthesis then push it*/
      if (exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
        stack.push( exp[i]);
 
      /* If exp[i] is a ending parenthesis then pop from stack and 
          check if the popped parenthesis is a matching pair*/
      if (exp[i] == '}' || exp[i] == ')' || exp[i] == ']')
      {
             
          /*If we see an ending parenthesis without a pair then return false*/
         if (stack == null){
           return false; 
         }
         /* Pop the top element from stack, if it is not a pair 
            parenthesis of character then there is a mismatch.
            This happens for expressions like {(}) */
         Character newChar=(Character) stack.pop();
   	  System.out.println(this.stack.size());

          if ( !isMatchingPair(newChar,exp[i]) )
           return false;
      }
   }
    
   /* If there is something left in expression then there is a starting
      parenthesis without a closing parenthesis */
   if (stack.size() == 0)
     return true; /*balanced*/
   else
     return false;  /*not balanced*/
} 
 
/* UTILITY FUNCTIONS */
/*driver program to test above functions*/
public static void main(String... args)
{
	BalancedParenthesis bp=new BalancedParenthesis();
  char exp[] = {'[','{','(',')','}',']'};
  if (bp.areParenthesisBalanced(exp))
    System.out.println("\n Balanced ");
  else
    System.out.println("\n Not Balanced ");  
  
}    

}
