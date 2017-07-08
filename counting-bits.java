public class Solution {
    public int[] countBits(int num) {
        int[] arr = new int[num+1]; arr[0] = 0; arr[1] = 1;
        int power = 1;
        while (power*2 <= num) {
            for (int i = power+1; i < power*2; i++) {
                arr[i] = arr[power] + arr[i-power];
            }
            power *= 2;
            arr[power] = 1;
        }
        for (int i = power+1; i <= num; i++) {
                arr[i] = arr[power] + arr[i-power];
        }
    }
    return arr;
}
