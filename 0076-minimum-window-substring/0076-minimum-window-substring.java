class Solution {
    public String minWindow(String s, String t) {
        int formed = 0;
        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }
        int required = tMap.size();
        Map<Character, Integer> sMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);
            if (tMap.containsKey(ch)
                    && sMap.get(ch).intValue() == tMap.get(ch).intValue()) {
                formed++;
            }
            while (formed == required) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }
                char leftChr = s.charAt(left);

                sMap.put(leftChr, sMap.get(leftChr) - 1);

                if (sMap.get(leftChr) == 0) {
                    sMap.remove(leftChr);
                }
                if (tMap.containsKey(leftChr)
                        && sMap.getOrDefault(leftChr, 0) < tMap.get(leftChr)) {
                    formed--;
                }
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE)
            return "";

        return s.substring(start, start + minLength);
    }
}