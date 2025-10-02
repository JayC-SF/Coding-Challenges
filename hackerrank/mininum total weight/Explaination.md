# Explanation of the Code

## Goal
We are given:
- An array of `weights` (e.g., chocolate weights).
- An integer `d` representing the number of operations.

Each operation:
1. Take the **largest weight** available.
2. "Eat" half of it (integer division).
3. Put the **remaining half** back.

After `d` operations, we return the **sum of all weights left**.

---

## Step 1: Priority Queue Setup
- A `PriorityQueue` (heap) is used to always get the largest weight quickly.
- By default, Java’s PriorityQueue is a **min-heap**, so we pass a comparator
  to make it behave like a **max-heap**.

---

## Step 2: Insert Weights
- Add all items from the `weights` array into the priority queue.

---

## Step 3: Perform `d` Operations
For each of the `d` operations:
- Remove the largest element (`poll` from max-heap).
- Compute half of it (`eatenWeight = largest / 2`).
- Subtract the eaten weight from the original.
- Insert the leftover back into the heap.

---

## Step 4: Compute Final Sum
- After all operations, iterate through the heap and sum all remaining weights.
- Return this sum.

---

## Example Walkthrough
Input:
```
weights = [30, 20, 25]
d = 4
```

Operations:
1. Take 30 → eat 15 → put back 15 → heap = {25, 20, 15}
2. Take 25 → eat 12 → put back 13 → heap = {20, 15, 13}
3. Take 20 → eat 10 → put back 10 → heap = {15, 13, 10}
4. Take 15 → eat 7 → put back 8  → heap = {13, 10, 8}

Final sum = 13 + 10 + 8 = **31**

Output:
```
31
```
