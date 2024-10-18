public class Narraycopy {
public static void main(String[] args) {
    int[] nums = new int[100];

    for (int i = 0; i < nums.length; i++) {
        System.out.println((i + 1)); 
    }
    for (int i = 0; i < nums.length; i++) {
        int[] nums1 = new int[100];
        for (i = 100; i < nums.length; i++) {
            nums[i] = nums1[i];
        }
        System.out.println((i - 1));
        
    }
}
}
