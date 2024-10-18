public class Narraycopy {
    public static void main(String[] args) {
        int[] nums = new int[100];
        int[] nums1 = new int[100];
    
        for (int i = 0; i < nums.length; i++) {
            System.out.println((i + 1)); 
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = nums[nums.length -1 -i];  
            System.out.println(100 - i);
        }
    }
    }
