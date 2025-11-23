package com.ankur.interview.practice.strings;

/*
/Implement the computeJoinPoint method
The user wants to implement the computeJoinPoint(int s1, int s2) method in a programming language (likely C, C++, Java, or Python given the imports) to find the joining point of two sequences. The sequence rule is that a number is followed by the number plus the sum of its digits.
Step 1: Define a helper function to calculate the sum of digits
A helper function is needed to calculate the sum of digits of a given integer.
Step 2: Generate the sequences
Generate the sequences starting from s1 and s2 simultaneously until a common number is found. A set or hash map can be used to store the numbers encountered in one sequence to efficiently check for the presence of a number from the other sequence.
Step 3: Iterate and check for the join point
Iterate through the sequences, adding each generated number to a set. In each step, check if the newly generated number from one sequence is already in the set of the other sequence. The first common number found is the join point.
Step 4: Return the join point
Once the common number is found, return it as the result of the function.
Answer:
The user is looking for the implementation of a function that determines the join point of two number sequences, where each subsequent number is the previous number plus the sum of its digits. This is a procedural homework problem requiring a solution in code.
Learn more

Task

Implement the function:

int computeJoinPoint(int s1, int s2)

where:
	•	s1 = starting number of the first sequence
	•	s2 = starting number of the second sequence
	•	Both sequences are guaranteed to meet, and the join point is < 20,000,000

Return
Sequence(471): 471 → 483 → 498 → 507 → 519 → 534 → ...
Sequence(480): 480 → 492 → 507 → 519 → 534 → ...
                         ↑
                     Join Point

Both sequences reach 519, which is the join point.
Return the first number where both sequences become equal.

⸻

Rules
	•	You must generate each sequence using:
next = n + sum_of_digits(n)
	•	The two sequences may grow at different speeds.
	•	They eventually converge at a join point.

⸻

Example

Input:

471 480

Output:

519
⸻

Additional Test Scenarios
	•	s1 < s2
	•	s1 > s2
	•	Immediate join (e.g., s1 == s2)
	•	Large join point (but < 20M)
	•	Asymmetric growth sequences

⸻

If you want, I can now provide:

✅ The optimal O(k) solution
✅ The safest version (without storing sequences)
✅ A test suite
Just tell me what you need.
 */
public class JointPoint {
    public static int computeJoinPoint(int s1, int s2) {
        StringBuilder sb1= new StringBuilder().append(s1);
        StringBuilder sb2 = new StringBuilder().append(s2);
        while (s1 != s2) {
            if (s1 < s2) {
                s1 = next(s1);
                sb1.append(" --> ").append(s1);
            } else {
                s2 = next(s2);
                sb2.append(" --> ").append(s2);
            }
        }
        System.out.println(sb1);
        System.out.println(sb2);
        return s1;
    }

    private static int next(int num) {
        int tmp = num;
        int sum = 0;
        while (tmp > 0) {
            sum += tmp % 10;
            tmp=tmp/10;
        }
        return num + sum;
    }
}
