# Algorithmic Patterns — Java Practice Repo

A catalog of all patterns covered, grouped by category. Use this as a study guide and pattern recognition reference.
*Algorithm steps verified against actual source files.*

---

## LeetCode Core 8 Patterns (2,000+ problems coverage)

> Based on "Mastering LeetCode Interview Patterns" — these 8 patterns cover the Blind 75/150 and most popular interview problems.

### 1. Two-Pointer — `O(n)` · ~244 problems
Use two indices moving inward, outward, or at different speeds on sorted/partitioned arrays. Look for: sorted arrays, pairs/triplets, in-place partitioning.

| Problem | File | Approach |
|---|---|---|
| Two Sum (sorted) | [`TwoNumberSum`](src/main/java/com/ankur/interview/practice/arrays/TwoNumberSum.java) | sort + left/right pointers |
| 3Sum | [`ThreeNumberSum`](src/main/java/com/ankur/interview/practice/arrays/ThreeNumberSum.java) | sort + fix one + two pointers |
| Container With Most Water | [`ContainWater`](src/main/java/com/ankur/interview/practice/arrays/ContainWater.java) | move shorter-side pointer inward |
| Move Zeroes | [`MoveZeros`](src/main/java/com/ankur/interview/practice/arrays/MoveZeros.java) | write-pointer + scan |
| Smallest Difference Pair | [`SmallestDifference`](src/main/java/com/ankur/interview/practice/arrays/SmallestDifference.java) | sort both, advance smaller |

---

### 2. Sliding Window — `O(n)` · ~167 problems
Maintain a window over an array; expand right, shrink left to meet a constraint. Fixed size: track entering/leaving elements. Dynamic: expand until violated, shrink until satisfied.

| Problem | File | Approach |
|---|---|---|
| Max Average Subarray (fixed k) | [`MaxAverageSubarray`](src/main/java/com/ankur/interview/practice/arrays/MaxAverageSubarray.java) | fixed-size window sum |
| Longest Substring No Repeat | [`LongestNonDupe`](src/main/java/com/ankur/interview/practice/strings/LongestNonDupe.java) | char→last-index map, advance start |
| Minimum Window Substring | [`SlidingWindowMin`](src/main/java/com/ankur/interview/practice/arrays/SlidingWindowMin.java) | expand until satisfied, shrink left |
| Max Sum Subarray Size K | [`SlidingWindow`](src/main/java/com/ankur/interview/practice/arrays/SlidingWindow.java) | add entering, subtract leaving |
| Longest Repeating K Chars | [`LongestRepeatingKCharacters`](src/main/java/com/ankur/interview/practice/strings/LongestRepeatingKCharacters.java) | divide & conquer on invalid chars |

---

### 3. Modified Binary Search — `O(log n)` · ~256 problems
Binary search on answer space or rotated/sorted variants. Key insight: when the answer is a number in a range, binary search that range instead of the input.

| Problem | File | Approach |
|---|---|---|
| Search Rotated Sorted Array | [`SearchRotatedArray`](src/main/java/com/ankur/interview/practice/arrays/SearchRotatedArray.java) | identify sorted half, check if target in it |
| Find Min in Rotated Array | [`SearchRotatedArray#findMin`](src/main/java/com/ankur/interview/practice/arrays/SearchRotatedArray.java) | binary search, pull toward unsorted side |
| Koko Eating Bananas | [`KokoEatingBananas`](src/main/java/com/ankur/interview/practice/arrays/KokoEatingBananas.java) | search on speed [1, maxPile] |
| Capacity to Ship Packages | [`ShipPackages`](src/main/java/com/ankur/interview/practice/arrays/ShipPackages.java) | search on capacity [maxWeight, totalWeight] |
| Binary Search (basic) | [`BinarySearch`](src/main/java/com/ankur/interview/practice/arrays/BinarySearch.java) | lo/hi/mid with correct bounds |

---

### 4. HashMaps & HashSets — `O(n)` · ~400 problems
Trade space for time: O(1) lookup for complements, frequency, grouping. Most common use: checking duplicates, counting frequencies, quick membership tests.

| Problem | File | Approach |
|---|---|---|
| Two Sum | [`LeetTwoSum`](src/main/java/com/ankur/interview/practice/arrays/LeetTwoSum.java) | single-pass map: check target-num |
| Group Anagrams | [`GroupAnagrams`](src/main/java/com/ankur/interview/practice/strings/GroupAnagrams.java) | sorted string as canonical key |
| Majority Element | [`MajorityArrayElement`](src/main/java/com/ankur/interview/practice/arrays/MajorityArrayElement.java) | Boyer-Moore vote algorithm |
| Longest Consecutive Sequence | [`LongestConsecutiveSequence`](src/main/java/com/ankur/interview/practice/graphs/LongestConsecutiveSequence.java) | HashSet, only start at sequence head |
| Zero-Sum Subarrays | [`ZeroSumSubArrays`](src/main/java/com/ankur/interview/practice/arrays/ZeroSumSubArrays.java) | prefix sum + HashSet |

---

### 5. Prefix Sum & Monotonic Stack — `O(n)`
Prefix sums for instant range queries; combine with hashmap for subarray-sum-equals-k in O(n). Monotonic stack maintains increasing/decreasing order to find next-greater/smaller in one pass.

| Problem | File | Approach |
|---|---|---|
| Pivot Index | [`PivotIndex`](src/main/java/com/ankur/interview/practice/arrays/PivotIndex.java) | total - leftSum - nums[i] == leftSum |
| Subarray Sum Equals K | [`SubarraySumEqualsK`](src/main/java/com/ankur/interview/practice/arrays/SubarraySumEqualsK.java) | prefix sum + frequency map, look up sum-k |
| Range Sum Query | [`RangeSumQuery`](src/main/java/com/ankur/interview/practice/arrays/RangeSumQuery.java) | prefix[r+1] - prefix[l] |
| Next Greater Element (circular) | [`NextGreaterElement`](src/main/java/com/ankur/interview/practice/stacks/NextGreaterElement.java) | monotonic decreasing stack, 2-pass |
| Trap Rain Water | [`TrapRainWater`](src/main/java/com/ankur/interview/hackerrank/TrapRainWater.java) | prefix max arrays left/right |

---

### 6. BFS & DFS — `O(V + E)`
BFS (queue, level-by-level) for shortest path / minimum steps. DFS (stack/recursion) for exhaustive search, cycle detection, and exploring all paths. Rule of thumb: shortest path → BFS; all possibilities / cycle detection → DFS.

| Problem | File | Approach |
|---|---|---|
| Number of Islands | [`NumberOfIslands`](src/main/java/com/ankur/interview/practice/graphs/NumberOfIslands.java) | DFS flood fill, mark visited in-place |
| Course Schedule | [`CourseSchedule`](src/main/java/com/ankur/interview/practice/graphs/CourseSchedule.java) | DFS 3-color cycle detection |
| Word Ladder | [`WordLadder`](src/main/java/com/ankur/interview/practice/graphs/WordLadder.java) | BFS, try all 1-letter mutations |
| BFS (general) | [`BreadthFirstSearch`](src/main/java/com/ankur/interview/practice/graphs/BreadthFirstSearch.java) | queue, level-by-level |
| DFS (general) | [`DepthFirstSearch`](src/main/java/com/ankur/interview/practice/graphs/DepthFirstSearch.java) | recursive, visit children |
| Topological Sort | [`TopologicalSort`](src/main/java/com/ankur/interview/practice/graphs/TopologicalSort.java) | DFS post-order push to stack |
| Remove Islands | [`RemoveIsland`](src/main/java/com/ankur/interview/practice/graphs/RemoveIsland.java) | DFS from borders, then zero non-border |

---

### 7. Memoization / Dynamic Programming — `O(n)` to `O(n²)` · ~376 problems
Break into overlapping subproblems; store results to avoid recomputation. Visualize the recursion tree: if the same state is computed multiple times, memoize it.

| Problem | File | Approach |
|---|---|---|
| Climbing Stairs | [`ClimbingStairs`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/ClimbingStairs.java) | dp[i]=dp[i-1]+dp[i-2] |
| Coin Change (min coins) | [`CoinChange`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/CoinChange.java) | 1-D dp, bottom-up |
| Longest Common Subsequence | [`LongestStringSubsequence`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/LongestStringSubsequence.java) | 2-D dp table |
| House Robber | [`HouseRubber`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/HouseRubber.java) | dp[i]=max(dp[i-1], dp[i-2]+nums[i]) |
| House Robber II (circular) | [`HouseRobber2`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/HouseRobber2.java) | two runs excluding first/last |
| Max Product Subarray | [`MaximumProductSubarray`](src/main/java/com/ankur/interview/practice/arrays/MaximumProductSubarray.java) | track max AND min (negatives flip) |
| Product Except Self | [`ProductOfArrayExceptItself`](src/main/java/com/ankur/interview/practice/arrays/ProductOfArrayExceptItself.java) | prefix product pass + suffix pass |
| Word Break | [`WordBreak`](src/main/java/com/ankur/interview/practice/dyanamicprogramming/WordBreak.java) | 1-D dp with dictionary lookup |

---

### 8. Heap / Priority Queue — `O(n log k)` · ~156 problems
Efficiently maintain the k largest/smallest elements dynamically. O(1) access to min/max, O(log n) insert/remove. Strategy: maintain heap of size k; for k-largest use min-heap (discard smaller than top).

| Problem | File | Approach |
|---|---|---|
| Last Stone Weight | [`LastStoneWeight`](src/main/java/com/ankur/interview/practice/heaps/LastStoneWeight.java) | max heap, smash top two |
| Kth Largest Element | [`KthLargestElement`](src/main/java/com/ankur/interview/practice/heaps/KthLargestElement.java) | min heap of size k |
| Top K Frequent Elements | [`TopKFrequentElements`](src/main/java/com/ankur/interview/practice/heaps/TopKFrequentElements.java) | freq map + min heap; or bucket sort O(n) |
| Continuous Median | [`Median`](src/main/java/com/ankur/interview/practice/heaps/Median.java) | two heaps (max lower half, min upper half) |
| K-Sorted Array | [`KSortedArray`](src/main/java/com/ankur/interview/practice/heaps/KSortedArray.java) | min heap of size k+1 |
| Merge K Sorted Lists | [`MergeSortedLists`](src/main/java/com/ankur/interview/practice/heaps/MergeSortedLists.java) | min heap with (value, list, index) |

---

### Greedy (Bonus Pattern — often combined with the 8 above)
Local optimal choices lead to the global optimum — often combined with sorting, two pointers, heaps, or binary search. Not a standalone pattern but a recurring theme across many problems.

| Problem | File | Approach |
|---|---|---|
| Jump Game | [`JumpingClouds`](src/main/java/com/ankur/interview/practice/arrays/JumpingClouds.java) | greedy look-ahead, prefer 2-step |
| Task Assignment | [`AssignTasks`](src/main/java/com/ankur/interview/practice/greedy/AssignTasks.java) | sort, pair min with max |
| Job Scheduling | [`FreelancingProfit`](src/main/java/com/ankur/interview/practice/greedy/FreelancingProfit.java) | sort by pay desc, place at latest slot |
| Similar Word Pattern | [`SimilarWordPattern`](src/main/java/com/ankur/interview/practice/strings/SimilarWordPattern.java) | encode each char as first-occurrence index |

---

---

## Arrays

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Two Sum | `TwoNumberSum`, `LeetTwoSum` | `TwoNumberSum`: sort array, left=0 right=end — if sum<target move left right, if sum>target move right left. `LeetTwoSum`: single pass HashMap — store element, check if (target-element) already in map |
| Three Sum | `ThreeNumberSum` | Sort array; for each i run two pointers from i+1 and end; if sum==target record and advance both; if less move left, if greater move right |
| Four Sum | `FourNumSum` | Build HashMap of all two-element sums with their index pairs; for each new pair compute complement and look it up — O(n²) space, avoids 4-pointer nesting |
| Binary Search | `BinarySearch` | Two variants: (1) compute mid once (buggy for all cases); (2) correct: l<=r loop, mid=l+(r-l)/2, adjust lo or hi based on comparison |
| Search Rotated Array | `SearchRotatedArray` | *(stub — not implemented)* |
| Find Min in Rotated Array | `FindMinRotatedArray` | *(stub — not implemented)* |
| Sliding Window (max sum) | `SlidingWindow` | Add element entering window, subtract element leaving; update max when window reaches size k |
| Min Window Substring | `SlidingWindowMin` | Expand right until all required chars satisfied (frequency maps); shrink left while still satisfied, tracking minimum window |
| Container With Most Water | `ContainWater` | *(stub — not implemented)* |
| Product Except Self | `ProductOfArrayExceptItself` | *(stub — not implemented)* |
| Merge Intervals | `MergeInterval` | Sort by start; if current.start <= last.end extend last.end = max(last.end, current.end); else append |
| Calendar Matching | `CalendarMatching` | Convert times to minutes; merge each person's busy intervals with two-pointer merge; walk merged lists finding gaps >= duration within shared bounds; convert back |
| Median of Two Sorted Arrays | `MedianSortedArrays` | Binary search on smaller array for partition index; validate l1<=r2 && l2<=r1; return avg of boundary elements for even total, inner boundary for odd |
| Smallest Difference Pair | `SmallestDifference` | Sort both arrays; pointer x on arr1 starts at 0, pointer y on arr2 starts at 0; advance pointer of smaller value; track minimum absolute difference |
| Majority Element | `MajorityArrayElement` | Boyer-Moore: maintain candidate and count, increment if same, decrement if different, reset when count hits 0. Also: bit-by-bit — for each of 32 bits count how many numbers have it set; if >n/2 include in answer |
| Move Elements to End | `MoveToEnd` | Two pointers; left finds element to move, right finds swap position from end; if right is also the target value, decrement right without swapping |
| Missing Number | `ReturnMissingNumber` | Expected sum = n*(n+1)/2, subtract actual sum to find missing total; splits array by average to identify which specific numbers from each half are missing |
| Zero-Sum Subarrays | `ZeroSumSubArrays` | Running prefix sum; if same sum seen before in HashSet a zero-sum subarray exists between those two indices; add each sum to set |
| Longest Subarray with Sum | `LongestSubarrayWithSum` | Sliding window: expand right pointer accumulating sum; when sum exceeds target shrink from left; when sum equals target update max length |
| Maximum Product Subarray | `MaximumProductSubarray` | *(stub — not implemented)* |
| Best Sightseeing Pair | `BestSightseeingPair` | *(stub — not implemented)* |
| Array Rotation | `ArrayRotate` | Multiple approaches; reversal: reverse [0,d-1], reverse [d,n-1], reverse entire array; also modular index copy (i+mod)%n |
| Spiral Matrix | `PrintSpiralMatrix` | Maintain top/bottom/left/right boundaries; traverse right→down→left→up shrinking each boundary after each pass |
| Skyline Problem | `SkyPainting` | Deque of active heights; when height increases push and increment stroke count; when decreases pop all larger values; when matches top skip (continuous stroke). `Skyline`: sum of drops between consecutive elements + final height |
| Zigzag / Diagonal Traversal | `ZigZagTraversal` | Direction toggle flag; move diagonally down-right until boundary, move along edge, move diagonally up-right until boundary, repeat |
| Duplicate Detection | `Duplicate` | Use element's absolute value as array index; negate value at that index on visit; if already negative that index is the duplicate |
| Pairs with Difference K | `ElementsWithDifferenceOfK`, `NumbersWithDiffK` | `ElementsWithDifferenceOfK`: HashMap frequency — if k=0 count C(freq,2) pairs; if k>0 check if value+k exists. `NumbersWithDiffK`: sort then two-pointer — advance left if diff>k, right if diff<k |
| Merge K Sorted Arrays | `MergeKSortedArrays` | *(stub — not implemented)* |
| Jump Game | `JumpingClouds` | Greedy look-ahead: try to jump 2 steps if next position is safe, otherwise jump 1 step; count jumps to reach end |
| Trap Rain Water | `WaterFall` | 2D water distribution simulation: for each cell in row above with water check cell below; if blocked split water to nearest non-blocked left and right neighbours in current row |
| Top K Closest Numbers | `TopKClosestNumbers` | Two pointers at both ends of sorted array; compare absolute distances from target; advance pointer with larger distance until k elements remain |
| Tournament Winner | `TournamentWinner` | HashMap of team→score; for each result determine winner from pair using result index (0 or 1); add 3 points; iterate map to find max score |
| Sorted Squared Array | `SortedSquaredArray` | Two pointers at start and end; square larger absolute value, place at current back of result; converge pointers inward |

---

## Strings

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Group Anagrams | `GroupAnagrams` | Sort each string's characters to get canonical key; group originals in HashMap under that key |
| Longest Palindromic Substring | `LongestPalindrome` | Manacher's: insert delimiter chars between each character; use mirror symmetry and right-boundary tracking to skip recomputation; expand only when needed; O(n) |
| Longest Substring No Repeat | `LongestNonDupe` | Two approaches: (1) brute force — for each start expand right until duplicate found; (2) HashMap of char→last-seen-index; update start = max(start, lastSeen+1) on duplicate; track max window |
| Find All Anagram Indices | `AnagramIndexes` | Build frequency array for pattern; slide window of pattern length over string decrementing on enter and incrementing on leave; when all frequencies zero record index |
| Rabin-Karp String Search | `RabinKarpSearch` | *(stub — not implemented)* |
| Unique Characters | `UniqueChars` | Single integer as 26-bit bitmask; for each char compute position=(c-'a'); if bit already set (AND check) → duplicate; set bit with OR |
| Permutation Is Palindrome | `PermutationPalindrome` | Toggle membership: for each char remove from list if present, add if absent; valid palindrome permutation if list has 0 or 1 elements at end |
| One Edit Away | `OneEditAway` | XOR each character pair across minimum length; count mismatches; returns true if ≤1 mismatch (note: length-difference cases not fully handled) |
| All Permutations | `StringPermutations`, `PermuteString` | `StringPermutations`: recursive frequency map — try each unique char (if count>0), decrement, recurse, increment back. `PermuteString`: bitwise — for each bitmask 0..2^n-1 uppercase characters whose bit is set |
| Reverse Words | `WordReverse`, `ReverseWords`, `ReverseSentences` | `WordReverse`: stack each character, reverse word on space/end. `ReverseWords`: split into list, two-pointer swap from ends, rejoin. `ReverseSentences`: push each word to stack reversed char by char, pop to rebuild |
| Integer to English | `IntegerToEnglish` | *(stub — not implemented)* |
| First Non-Repeating Char | `FirstNonRepeating` | LinkedHashMap preserving insertion order; count frequency per character position; iterate map returning first entry with count==1 |
| Longest Substring K Repeating | `LongestRepeatingKCharacters` | Divide & conquer: count all char frequencies; find any char with frequency<k (it can't be in any valid substring); split string on that char; recurse on each part; return max length |
| Run-Length Encoding | `RunLengthEncoding` | Group consecutive identical chars; if run count>9 split into chunks of 9 plus remainder; append count then char for each chunk |
| Valid IP Address | `ValidIP` | Three nested loops trying all splits into 4 parts of 1–3 chars each; validate each part converts to int 0–255 with no leading zeros; collect valid IPs |
| Pattern Underscorify | `Underscorify` | Find all match indices with indexOf loop advancing start; collapse overlapping intervals; rebuild string inserting underscores at interval boundaries |
| Balanced Brackets | `BalancedString` | Brute force: try all even-length substrings; for each check balance by pushing opens and popping for closes using a stack |
| Semordnilap Detection | `Semiornilap` | *(stub — not implemented)* |
| Palindrome Check | `Palindrome` | Convert to char array; left and right pointers converge; return false on first mismatch |

---

## Binary Trees

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Level-Order (BFS) | `LevelOrderTraversal`, `TreeBFS` | `LevelOrderTraversal`: builds tree from array using complete binary tree indexing (left=2i+1, right=2i+2), not a traversal. `TreeBFS`: *(stub)* |
| Invert Tree | `InvertBinaryTree` | Swap left and right child pointers at current node; then recurse into left and right subtrees |
| Max Diameter | `MaxTreeDiameter` | Post-order returning (height, diameter) pair; at each node diameter candidate = leftHeight+rightHeight; propagate max(leftDiam, rightDiam, leftH+rightH); return height=1+max(leftH,rightH) |
| Max Path Sum | `MaxPathSum` | Post-order; discard negative subtree contributions (max with 0); path through node = node.val+leftGain+rightGain; update global max; return node.val + max(leftGain,rightGain) upward |
| Branch Sums | `BranchSum` | DFS carrying running sum; only append to result list when both children are null (leaf reached) |
| Node Depths Sum | `NodeDepths`, `SumOfAllNodeDepths` | Recursive: add current depth + recurse left with depth+1 + recurse right with depth+1; accumulate into running total |
| Height Balanced | `HeightBalanced` | Single-pass post-order returning (height, isBalanced); node is balanced only if both subtrees balanced AND abs(leftH-rightH)<=1; short-circuit on first false |
| LCA | `LeastCommonAncestor` | Recurse; return node if it matches p or q; if both left and right return non-null, current node is LCA; else return whichever subtree returned non-null |
| Flatten to Linked List | `FlattenBinaryTree` | Two approaches: (1) in-order traversal collecting all nodes, link each as right child with left=null; (2) recursive post-order returning leftmost/rightmost of each flattened subtree, then connect |
| Nodes at Distance K | `TreeNodesAtDistanceK` | Build child→parent map via BFS/DFS; then BFS from target node with distance counter and visited set; collect all nodes when distance==k |
| In-Order Successor | `FindSuccessor` | If node has right child: go left until null (leftmost of right subtree); if no right child: walk parent pointers until arriving from a left child |
| Serialize / Deserialize | `SerializeDeserializeBinaryTree` | Serialize: pre-order DFS appending values or "#" for null. Deserialize: consume list in pre-order, create node then recurse left then right |
| Evaluate Expression Tree | `EvaluateExpressionTree` | Post-order recursion; leaf nodes (non-negative) are operands; negative values encode operators: -1=add, -2=subtract, -3=divide, else=multiply |
| Right Sibling Tree | `RightSiblingTree` | Post-order traversal; for left children set right sibling = parent's right child; for right children set right sibling = parent's right sibling's left child |
| Count Topologies | `BinaryTreeTopologies` | Recursive: T(0)=1; T(n)=sum of T(i)*T(n-1-i) for i in 0..n-1 (left subtree has i nodes, right has n-1-i) |
| Tree Symmetry | `TreeSymmetry` | Recursive mirror check: two nodes are mirrors if values match AND left.left mirrors right.right AND left.right mirrors right.left |
| Merge Two Trees | `MergeAndAddTwoTrees` | Recursive: sum values, recurse on child pairs. Iterative: two stacks; when tree1 child is null attach tree2 subtree directly |
| Reconstruct from Pre-Order | `TreeFromPreOrderArray` | Advance through pre-order array using a mutable index; create node only if current value within (min,max) bounds; recurse left then right with updated bounds |

---

## Binary Search Trees

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| BST Construction | `BSTConstruction` | Iterative insert: traverse left/right until null slot found. Remove: three cases — no children (delete), one child (promote), two children (replace value with in-order successor then delete successor). Validate: recursive min/max bounds propagation |
| Closest Value in BST | `BSTClosest` | Iterative walk: at each node update closest if abs difference smaller than current best; go left if target<node, right if target>node |
| Validate BST | `ValidateThreeNodes` | `isDescendant()`: recursive BST search from one node toward another using comparison to navigate left/right. Validates three-node ancestor-descendant relationship by searching from both endpoints simultaneously |
| Same BST (no build) | `AreSameBST` | Compare roots; split each array into left sublist (values<root) and right sublist (values>root) using bounds; recursively compare sublists without building trees |
| Kth Largest | `FindKthLargestNode` | Reverse in-order (right→node→left) with a TreeInfo object holding counter; decrement counter on each visit; return node value when counter reaches 0 |
| Right Smaller Than | `RightSmallerThan` | Traverse array right-to-left; insert each element into augmented BST tracking left-subtree size; count of smaller elements = leftSize + (went-right increments) accumulated during insertion |
| Repair BST | `RepairBST` | In-order traversal; first violation (prev>current): firstNode=prev; second violation: secondNode=current; swap values of firstNode and secondNode |
| BST Sequences | `BSTSequence` | Backtracking: root must come first; left and right children become new candidates; recursively weave all valid orderings of remaining candidates |

---

## Dynamic Programming

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Climbing Stairs | `ClimbingStairs` | dp[i]=dp[i-1]+dp[i-2]; only track last two values; base cases dp[1]=1, dp[2]=2 |
| Coin Change (min) | `CoinChange` | 1-D dp[0..amount]=∞ except dp[0]=0; for each amount try each coin: dp[a]=min(dp[a], dp[a-coin]+1) |
| Coin Change (ways) | `CoinChangeProblem` | 2-D table; for each coin either skip it (take row above) or include it (dp[coin][amount-coinVal]); ordered by coin then amount |
| House Robber | `HouseRubber` | dp[i]=max(dp[i-1], dp[i-2]+nums[i]); at each house choose to skip or rob |
| House Robber II (circular) | `HouseRobber2` | Run house robber twice: once on nums[0..n-2], once on nums[1..n-1]; return max of both results |
| 0/1 Knapsack | `Knapsack` | 2-D dp[item][capacity]; for each item: skip (dp[i-1][c]) vs take (dp[i-1][c-weight]+value); backtrack table to reconstruct included items |
| LIS | `LongestIncreasingSubsequence` | Patience sort: maintain tails array (smallest tail of each length subsequence); binary search to find position for current element; replace or extend tails; O(n log n) |
| Edit Distance | `LevenshteinDistance` | 2-D dp with memoization; if chars match: dp[i-1][j-1]; else 1+min(insert=dp[i][j-1], delete=dp[i-1][j], replace=dp[i-1][j-1]) |
| LCS | `LongestStringSubsequence` | 2-D dp; if s1[i]==s2[j]: dp[i-1][j-1]+1; else max(dp[i-1][j], dp[i][j-1]) |
| Longest String Chain | `LongestStringChain` | Sort words by length; for each word try removing each character to form predecessor; dp[word]=max(dp[predecessor]+1); store in HashMap |
| Word Break | `WordBreak` | dp[i]=true if s[0..i] can be segmented; for each i scan j<i: if dp[j] true and s[j..i] in dictionary set dp[i]=true |
| Minimum Jumps | `MinNoOfJumps` | Track current window end and farthest reachable; when pointer reaches window end: one jump taken, set window end to farthest; count jumps |
| Combination Sum IV | `CombinationsSumIV` | 1-D dp[i]=ordered ways to sum to i; for each amount and each number<=amount: dp[i]+=dp[i-n] |
| Max Non-Adjacent Sum | `MaxSubSetNonAdjacent` | Two rolling variables include/exclude; nextInclude=exclude+current; nextExclude=max(include,exclude); advance |
| Unique Grid Paths | `UniquePaths` | 2-D dp[i][j]=dp[i-1][j]+dp[i][j-1]; first row and column all 1s |
| Decode Ways | `DecodeWays` | 1-D dp[i]; add dp[i-1] if s[i] valid single digit (1-9); add dp[i-2] if s[i-1..i] valid two-digit (10-26) |
| Min Palindrome Partitions | `PalindromePartitionMinCut` | Build 2-D isPalin table first; then dp[i]=min cuts for s[0..i]; for each j<=i if s[j..i] is palindrome: dp[i]=min(dp[i], dp[j-1]+1) |
| Max Sum Submatrix | `MaximumSumSubMatrix` | Fix left and right column bounds; compress rows into 1-D prefix column sums; run Kadane's on compressed 1-D array |
| Stock with K Transactions | `MaxProfitWithKTransactions` | 2-D dp[t][d]=max profit with at most t transactions up to day d; dp[t][d]=max(dp[t][d-1], max over all buy days b of dp[t-1][b-1]+prices[d]-prices[b]) |
| Power Set | `PowerSet` | For each element iterate all existing subsets and create new subsets by appending element; OR bitmask 0..2^n-1 where each bit = include/exclude |
| Subset Sum | `SubsetSum` | 2-D Boolean dp[i][s]=true if subset of first i elements sums to s; dp[i][s]=dp[i-1][s] OR dp[i-1][s-nums[i]] |
| Apartment Hunting | `ApartmentHunting` | For each facility two passes (left-right, right-left) computing min distance from each block; for each block compute max distance across all facilities; pick block with minimum of that max |

---

## Graphs

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| BFS | `BreadthFirstSearch` | ArrayDeque queue; add start node, poll and process, add all children to queue; no visited set (assumes tree/acyclic structure) |
| DFS | `DepthFirstSearch` | Recursive; visit current node, sequentially recurse into all children |
| Topological Sort | `TopologicalSort`, `CourseSchedule` | DFS with three states: unvisited/visiting/visited; detect cycle when visiting flag seen; push node to result stack on exit (all neighbors done). `CourseSchedule`: *(stub)* |
| Dijkstra | `Dijkstra` | Initialize distances array to ∞; visited boolean array; repeatedly pick unvisited vertex with minimum distance; relax all its edges; return distances array |
| Number of Islands | `NumberOfIslands` | *(stub — not implemented)* |
| Number of Provinces | `NumberOfProvinces` | Union-Find: iterate adjacency matrix, union connected nodes; count distinct root representatives at end |
| Clone Graph | `CloneGraph` | *(stub — not implemented)* |
| Bipartite Check | `BipartiteColoring` | DFS with explicit stack; assign color 1 to start; assign opposite color to each unvisited neighbor; return false if neighbor already has same color as current |
| Multi-Source BFS | `MinPassesOfMatrix` | Enqueue all positive cells initially; BFS expanding to adjacent negative cells flipping them to positive; each wave = one pass; count waves until no negatives remain |
| Pacific-Atlantic Water Flow | `PacificAtlanticWaterflow` | *(empty — not implemented)* |
| Remove Islands | `RemoveIsland` | DFS from all border cells marking border-connected 1s in separate boolean array; then zero out all 1s not in that marked set |
| Longest Consecutive Sequence | `LongestConsecutiveSequence` | *(stub — not implemented)* |

---

## Greedy

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Job Scheduling by Payment | `FreelancingProfit` | Sort jobs by payment descending; for each job greedily place it at the latest available time slot before its deadline; track filled slots |
| Group Photos by Height | `ClassGroupPhotos` | Sort both groups descending; determine which group should be in front; verify every element of front group is strictly less than corresponding element of back group |
| Task Assignment | `AssignTasks` | Sort tasks; map sorted indices back to original; pair task at sorted index i with task at sorted index n-1-i (weakest with hardest) |
| Huffman Encoding | `HuffmanEncoding`, `HuffmanNode` | Min-heap of (frequency, node); pop two smallest, create parent with summed frequency, push parent; repeat until one node remains; DFS to generate codes |

---

## Heaps

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Continuous Median | `Median` | Max-heap for lower half, min-heap for upper half; on insert route to correct heap then rebalance so sizes differ by at most 1; median = top of larger heap or avg of both tops |
| K-Sorted Array | `KSortedArray` | Build min-heap from first k+1 elements; for each remaining element push then poll min to output; drain heap at end |
| Merge K Sorted Lists | `MergeSortedLists` | Item wrapper (value, list index, element index); min-heap extracts minimum; insert next element from same list; repeat until heap empty |
| Min Laptops Needed | `FindMinUsedLaptops` | Sort intervals by start time; min-heap of end times; for each interval if heap top<=start reuse that laptop (pop); push current end; heap size at end = peak concurrent usage |

---

## Stacks

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Balanced Brackets | `BalancedBrackets` | Push open brackets; on close bracket pop and verify it is the matching open; return false on mismatch or empty stack; valid only if stack empty at end |
| Next Greater Element | `NextGreaterElement` | Traverse array backwards twice (for circular wrap); maintain stack of decreasing values; pop all stack values smaller than current (current is their next greater); push current |
| Sunset Views | `SunsetViews` | Traverse in direction opposite to sunset; push building to stack if taller than stack top (blocks shorter buildings); remaining stack = buildings with unobstructed views |

---

## Linked Lists

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Reverse List | `ReverseLinkedList` | Three pointers: prev=null, curr=head; each step save next, point curr.next=prev, advance prev=curr, curr=next |
| Merge Two Sorted Lists | `MergeSortedLinkedLists` | Compare both heads; link smaller to result; advance that list's pointer; when one list exhausted attach the other |
| Merge K Sorted Lists | `MergeKSortedLists` | *(stub — not implemented)* |
| Remove Kth from End | `RemoveKthNode` | Advance first pointer k steps ahead; move both pointers until first reaches tail; second pointer is just before node to remove |
| Remove Duplicates (sorted) | `RemoveDuplicateSorted` | Single pointer; skip consecutive nodes with same value (curr.next=curr.next.next); advance when values differ |
| Find Middle | `MiddleNode` | Fast pointer moves 2 steps, slow moves 1; when fast reaches end slow is at middle |
| Detect Cycle | `DetectLoop` | Floyd's: fast moves 2, slow moves 1; on meeting reset slow to head; advance both at speed 1; they meet again at cycle entry point |
| Intersection Point | `MergedListIntersection` | Two-pointer swap: when pointer reaches null switch to other list's head; they meet at intersection after traversing combined lengths. Also: length-difference alignment approach |
| Palindrome List | `LinkedListPalindrome` | Find middle with fast/slow pointers; reverse second half in-place; compare first half and reversed second half node by node |
| Zip / Interleave | `ZipLinkedList` | Find middle with fast/slow pointers; reverse second half; interleave by alternating one node from each half |
| Rearrange List | `RearrangeLinkedList` | Partition into three sublists: nodes smaller than k, nodes equal to k, nodes greater than k; connect the three sublists in order |
| LRU Cache | `LRUCache` | HashMap key→node for O(1) lookup; doubly-linked list for O(1) recency tracking; on get/put move node to head; on capacity overflow remove tail node and its HashMap entry |

---

## Trie

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Trie Construction | `Trie` | Each node: HashMap<Character,TrieNode>; insert walks/creates nodes per char marking leaf; search walks nodes returning false on missing char |
| Suffix Trie | `TrieConstruction` | Insert every suffix s[i..] for each i; uses '*' as end-of-word marker; all substrings findable by walking from root |
| Ukkonen Suffix Trie | `UkkonenSuffixTrie` | *(empty — not implemented)* |

---

## Bit Manipulation

| Pattern | File(s) | Algorithm Steps (as implemented) |
|---|---|---|
| Count Set Bits (Hamming) | `NumberOfOneBits` | Loop: n&(n-1) clears lowest set bit; count iterations until n==0 |
| Reverse Bits | `ReverseBits` | Shift result left and OR in LSB of n (n&1); shift n right; repeat 32 times |
| Missing Number via XOR | `MissingNumber` | XOR all values 0..n together with all array elements; paired values cancel leaving only the missing number |
| Add Without Arithmetic | `SumTwoInteger` | XOR gives sum without carry; AND<<1 gives carry bits; repeat until carry is zero |
| Count Bits 0..n | `CountingBits` | dp[i]=dp[i>>1]+(i&1); right shift reuses previously counted bits; add 1 if last bit was set |

---

## Key Technique Reference

| Technique | When to reach for it |
|---|---|
| Two-pointer (converging) | Sorted array, pair/triplet sums, container water |
| Two-pointer (same direction) | Sliding window, remove duplicates, fast/slow pointer |
| Sliding window | Subarray with sum constraint, longest substring without repeat |
| Prefix sum | Range sum queries, zero-sum subarrays |
| Hash map frequency | Anagrams, first non-repeat, two-sum complement lookup |
| Binary search | Sorted data, rotated array, answer-space search |
| BFS | Shortest path, level-order, multi-source spread, bipartite |
| DFS + backtrack | Permutations, subsets, path enumeration, topological sort |
| Monotonic stack | Next greater/smaller, sunset views, histogram |
| Two heaps | Running median, balanced lower/upper partition |
| Union-Find | Connected components, cycle detection in undirected graph |
| Topological sort | Dependency ordering, cycle detection in DAG |
| DP 1-D rolling | Coin change, stairs, rob, jump game |
| DP 2-D table | Edit distance, LCS, knapsack, unique paths |
| Interval sort + merge | Calendar, meeting rooms, activity selection |
| XOR tricks | Missing number, add without arithmetic, find unique |