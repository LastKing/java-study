/**
  寻找数组的中心索引
  https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 */

public class Test10{

  public int pivotIndex(int[] nums) {
      for(int i=0;i<nums.length;i++){
        if(total(nums,0,i)==total(nums,i,nums.length)){
          return i;
        }
      }
      return -1;
  }

  private int total(int[]nums,int start,int end){
    int sum=0;
    for(int i=start;i<end;i++){
      sum+=nums[i];
    }
    return sum;
  }

  public static void main(String args[]){
    Test10 test10=new Test10();

    System.out.println(test10.pivotIndex(new int[]{1,7,3,6,5,6}));
    System.out.println(test10.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));

  }

}
