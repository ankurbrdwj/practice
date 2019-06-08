package com.ankur.interview.hackerrank;

public class EditDistance {

	public EditDistance() {
		// TODO Auto-generated constructor stub
	}

/*************************************************************************
 *  Compilation:  javac EditDistance.java In.java
 *  Execution:    java EditDistance < example10.txt
 *  
 *  Reads in two strings from stdin and computes their edit distance.
 *
 *************************************************************************/
   static int COST_PER_MISMATCH =  1;
   static int COST_PER_GAP      =  2;
   static int UNINITIALIZED     = -1;
   static char ALIGNED   = '\\';
   static char GAP_IN_X  =  '-';
   static char GAP_IN_Y  =  '|';
   static char GAP       =  ' ';
   
   private int M;                  // length of first string
   private int N;                  // length of second string
   private char[] x;               // first string
   private char[] y;               // second string
   private int[][] opt;            // min cost of aligning x[i..M] with y[j..N]
   private char[][] sol;           // opt choice for aligning x[i] and y[j]

   public EditDistance(String s, String t) {
      M = s.length();
      N = t.length();
      s += '\0';
      t += '\0';
      x = s.toCharArray();
      y = t.toCharArray();
      opt = new int[M+1][N+1];
      sol = new char[M+1][N+1];

      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            opt[i][j] = UNINITIALIZED;
            sol[i][j] = '.';
         }
      }
   }

   /**************************************************************
    *  Print to stdout the optimal alignment of the two strings
    *  x[0..M] and y[0..N].
    **************************************************************/
    void printAlignment() {
       // compute edit distance if not already known
       System.out.println("Edit distance = " + solve(0, 0));
       printCharTable(sol);
       // print optimal alignment
       int i = 0, j = 0;
       while(i < M || j < N) {
          if (sol[i][j] == ALIGNED) {
             System.out.print(x[i] + " " + y[j] + "  ");
             if (x[i] != y[j]) System.out.println(COST_PER_MISMATCH);
             else System.out.println("0");
             i++;
             j++;
          }

          else if (sol[i][j] == GAP_IN_X) {
             System.out.println(GAP + " " + y[j] + "  " + COST_PER_GAP);
             j++;
          }

          else if (sol[i][j] == GAP_IN_Y) {
             System.out.println(x[i] + " " + GAP + "  " + COST_PER_GAP);
             i++;
          }
       }
      
    }


   private void printCharTable(char[][] opt) {
	// TODO Auto-generated method stub
	   for (int i = 0; i < opt.length; i++) {
			for (int j = 0; j < opt[i].length; j++) {
				System.out.printf("%5c ", opt[i][j]);
			}
			System.out.println();
		}
}

/**************************************************************
    *  Compute the edit distance of the two strings x[i..M] and
    *  y[j..N].
    **************************************************************/
    int solve(int i, int j) {
       // base cases
       if (i == M && j == N) { sol[i][j] = '.';       opt[i][j] = 0; }
       else if (i == M)      { sol[i][j] = GAP_IN_X;  opt[i][j] = COST_PER_GAP * (N - j); }
       else if (j == N)      { sol[i][j] = GAP_IN_Y;  opt[i][j] = COST_PER_GAP * (M - i); }

       // already computed
       if (opt[i][j] != UNINITIALIZED) return opt[i][j];

       // otherwise choose best of 3 options
       int option1 = solve(i+1, j+1);
       if (x[i] != y[j]) option1 += COST_PER_MISMATCH;

       int option2 = solve(i+1,   j) + COST_PER_GAP;
       int option3 = solve(i,   j+1) + COST_PER_GAP;

       opt[i][j] = Math.min(Math.min(option1, option2), option3);

       if      (option1 == opt[i][j]) sol[i][j] = ALIGNED;
       else if (option2 == opt[i][j]) sol[i][j] = GAP_IN_Y;
       else if (option3 == opt[i][j]) sol[i][j] = GAP_IN_X;

       
       return opt[i][j];
    }

    private static void printTable(int[][] opt) {
		// TODO Auto-generated method stub
		for (int i = 0; i < opt.length; i++) {
			for (int j = 0; j < opt[i].length; j++) {
				System.out.printf("%5d ", opt[i][j]);
			}
			System.out.println();
		}
    }

  /**************************************************************
   *  Test client.
   **************************************************************/
   public static void main(String[] args) {
      
      String s = "algorithm";
      String t = "altruistic";
      EditDistance ed = new EditDistance(s, t);
      ed.printAlignment();
      printTable(ed.opt);
   }




}
