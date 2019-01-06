class Solution {
    public String longestPalindrome(String s) {
        //1.获取字符串长度n
        //2.获取以每一个字符开始是最长回文子字符串
        //3.for
        int max = 0;
        String ans = "";
        for(int i =0; i< s.length();i++){
            if(max>s.length() - i)break;
            for(int j = s.length()-1;j>=i;j--){
                if(j-i+1<=max)break;
                if(s.charAt(j)!=s.charAt(i))continue;
                else if(isPalindrome(s,i,j) && (j - i + 1)>max){
                        max = j - i + 1;
                        ans = s.substring(i,j+1);
                        break;
                }
            }            
        }
        return ans;
    }
    
    public boolean isPalindrome(String s, int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start+=1;
            end-=1;
        }
        return true;
    }
}