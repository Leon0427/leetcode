class Solution {
    //动态规划：
    // 递推：获取s的前idx个字符构成的子串s'的【以第idx个字符结尾的最大不重复子串】；然后前idx+1个字符构成的子串s''的【以第idx个字符结尾的最大不重复子串】易得
    //所有的【以第i个字符结尾的最大不重复子串】中最长的，即为所求
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len==1)return 1;
        Map<Character,Integer> map = new HashMap<>();
        int longest = 0;
        int cur = 0;
        for(int i=0; i< len; i++){
            cur = getLongestSoFar(s, i, map, cur);
            longest = (longest>cur)?longest:cur;
            map.put(s.charAt(i),i);
        }
        return longest;
    }
    
    public int getLongestSoFar(String s, int idx, Map<Character, Integer> map, int formerCur){
        int formerBeginning = idx - formerCur;
        if(map.containsKey(s.charAt(idx)) && map.get(s.charAt(idx))>=formerBeginning)return idx - map.get(s.charAt(idx));
        else return formerCur+1;
    }
}