package main

func lengthOfLongestSubstring(s string) int {
	charCounts := map[byte]int{}
	maxLength := 0
	sLen := len(s)
	// left inclusive, right exclusive of window
	left, right := 0, 0
	for right < sLen {
		length := len(charCounts)
		if len(charCounts) == right-left {
			// extend window
			// update length
			maxLength = length
			charCounts[s[right]]++
			right++
		} else {
			// shift window and remove left byte from the map
			if charCounts[s[left]] <= 1 {
				delete(charCounts, s[left])
			} else {
				charCounts[s[left]]--
			}
			left++
			// add the right value into the window
			charCounts[s[right]]++
			right++
		}
	}
	// terminating conditions
	length := len(charCounts)
	if len(charCounts) == right-left {
		maxLength = length
	}

	return maxLength
}
