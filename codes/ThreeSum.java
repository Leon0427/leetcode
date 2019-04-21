import java.util.*;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i =0; i< nums.length -2; i++){
            if(nums[i]>0)break;
            if(i>=1 && nums[i]==nums[i-1])continue;
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int total = nums[i]+nums[l]+nums[r];
                if(total==0){
                    ArrayList<Integer> a = new ArrayList<Integer>();
                    a.add(nums[i]);
                    a.add(nums[l]);
                    a.add(nums[r]);
                    ans.add(a);
                    l++;
                    r--;
                    while(l<r && nums[l]==nums[l-1]){
                        l++;
                    }
                    while(l<r && nums[r]==nums[r+1]){
                        r--;
                    }
                }else if(total<0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}