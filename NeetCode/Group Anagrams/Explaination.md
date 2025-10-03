# Group Anagrams

This Java solution groups anagrams from an array of strings by:

- Counting character frequencies for each string using a 26-element array
- Generating a canonical key by reconstructing the string from character counts
- Using a HashMap to group strings with identical character counts together
- Returning the grouped anagrams as a list of lists

The algorithm efficiently groups anagrams in O(n*k) time complexity, where n is the number of strings and k is the maximum string length.