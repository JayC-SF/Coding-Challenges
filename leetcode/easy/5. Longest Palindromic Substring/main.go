package main

func longestPalindrome(s string) string {
	// do this for even palindromes
	max := ""
	i := 0
	for ; i < len(s)-2; i++ {
		max = checkForPalindrome(max, s, i, 3)
		max = checkForPalindrome(max, s, i, 2)
	}
	// continue for even palindrome one last time
	max = checkForPalindrome(max, s, i, 2)
	if len(max) <= 0 {
		max = s[0:1]
	}
	return max
}

func checkForPalindrome(max string, s string, i int, windowSize int) string {
	otherEnd := i + windowSize - 1
	if otherEnd < len(s) && s[i] == s[otherEnd] {
		// odd palindrome, check if can be increased
		l := i
		r := otherEnd
		sub := s[l : r+1]
		// store this palindrome
		if len(max) < len(sub) {
			max = sub
		}
		// make sure it doesn't go out of bounds
		for l > 0 && r < len(s)-1 {
			r++
			l--
			sub = s[l : r+1]
			if !isPalindrome(sub) {
				break
			}
			if len(max) < len(sub) {
				max = sub
			}
		}
	}
	return max
}

func isPalindrome(s string) bool {
	for i := 0; i < len(s)/2; i++ {
		l := s[i]
		r := s[len(s)-1-i]
		if r != l {
			return false
		}
	}
	return true
}
