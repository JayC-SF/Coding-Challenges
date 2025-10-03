import java.util.*;

class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        var map = new HashMap<String, List<String>>();

        for (var str : strs) {
            int[] charCount = new int[26];
            for (var i = 0; i < str.length(); i++)
                charCount[str.charAt(i) - 'a']++;
            var strBuilder = new StringBuilder();

            for (var i = 0; i < charCount.length; i++) {
                var count = charCount[i];
                for (var j = 0; j < count; j++)
                    strBuilder.append(i + 'a');
            }

            var sortedStr = strBuilder.toString();
            map.putIfAbsent(sortedStr, new ArrayList<String>());
            map.get(sortedStr).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
