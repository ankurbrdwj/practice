Greedy Algorithm Approach

Overview

A greedy algorithm is a problem-solving approach that makes a sequence of choices, each of which looks best at the moment. The algorithm builds up a solution piece by piece, always choosing the next piece that offers the most immediate benefit, without reconsidering earlier choices.

This approach works well when the problem exhibits the greedy-choice property (a globally optimal solution can be arrived at by choosing a local optimum) and optimal substructure (an optimal solution to the problem can be constructed from optimal solutions of its subproblems).

Key Characteristics
1.	Greedy-choice property: Decisions made at each step are locally optimal.
2.	Optimal substructure: The problem can be broken down into smaller problems that can be solved independently.

When to Use
•	Problems with a clear, objective measure of “optimal” (e.g., minimal cost, maximal value).
•	Problems with constraints that ensure a greedy solution is also globally optimal.

Steps in a Greedy Algorithm
1.	Selection: Choose the best option based on the current situation.
2.	Feasibility: Ensure the choice satisfies problem constraints.
3.  Solution Building: Add the choice to the solution set.
4.	Repeat: Continue until the problem is solved.

Examples

Example 1: Activity Selection Problem

Problem: Schedule the maximum number of activities in a single meeting room.
Approach:
1.	Sort activities by their end times.
2.	Pick the activity that ends earliest and is compatible with the previously selected activities.

Code:
```java
List<Activity> activities = ...; // List of activities with start and end times
activities.sort(Comparator.comparingInt(Activity::getEnd));
List<Activity> selected = new ArrayList<>();
int lastEnd = 0;
for (Activity activity : activities) {
    if (activity.start >= lastEnd) {
        selected.add(activity);
        lastEnd = activity.end;
    }
}
System.out.println("Selected activities: " + selected);
```
Example 2: Fractional Knapsack Problem
Problem: Maximize total value in a knapsack of fixed capacity by taking fractions of items.
Approach:
1.	Calculate value/weight ratio for each item.
2.	Sort items by this ratio in descending order.
3.	Take as much of each item as possible, starting from the highest ratio.
4. Code:
```java
List<Item> items = ...; // List of items with weight and value
items.sort((a, b) -> Double.compare(b.value / b.weight, a.value / a.weight));
double capacity = 50.0, totalValue = 0.0;
for (Item item : items) {
    if (capacity >= item.weight) {
        totalValue += item.value;
        capacity -= item.weight;
    } else {
        totalValue += item.value * (capacity / item.weight);
        break;
    }
}
System.out.println("Maximum value: " + totalValue);
```
Example 3: Huffman Coding
Problem: Compress data by encoding characters with variable-length binary strings based on frequency.
Approach: Use a priority queue to build a tree where frequent characters are closer to the root.

Code:
```java
src/main/java/com/ankur/interview/practice/greedy/HuffmanEncoding.java
```
Limitations
•	Greedy algorithms do not always yield the globally optimal solution.
•	They require the problem to satisfy specific properties (greedy-choice and optimal substructure).
•	Backtracking or dynamic programming might be necessary for more complex scenarios.
