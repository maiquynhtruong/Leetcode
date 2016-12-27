public class Solution {
    public boolean isUgly(int num) {
        if (num < 1) return false;
        if (num == 1 || num == 2 || num == 3 || num == 5) return true;
        while (num > 0) {
	        if (num % 2 == 0 ) {
	            while (num > 0 && num % 2 == 0) {
	            	num /= 2;
	            	if (num == 1) return true;
	            	// System.out.println("2num= " + num);
	            }
	        }
	        if (num % 3 == 0) {
	        	while (num > 0 && num % 3 == 0) {
	            	num /= 3;
	            	if (num == 1) return true;
	            	System.out.println("3num= " + num);
	            }
	        }
	        if (num % 5 == 0) {
	        	while (num > 0 && num % 5 == 0) {
	            	num /= 5;
	            	if (num == 1) return true;
	            	System.out.println("5num= " + num);
	            }
	        }
	        return false;
        }
        return false;
    }
}
