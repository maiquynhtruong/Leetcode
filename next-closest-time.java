class Solution {
    public String nextClosestTime(String timeStr) {
        HashSet<Integer> digits = new HashSet<>();
        String[] hrMin = timeStr.split(":");
        int hr = Integer.valueOf(hrMin[0]), min = Integer.valueOf(hrMin[1]);
        for (char d : hrMin[0].toCharArray()) digits.add(d - '0'); 
        for (char d : hrMin[1].toCharArray()) digits.add(d - '0');
        
        int time = hr*60 + min, minDif = Integer.MAX_VALUE, closest = time;
        for (int t = time+1; t <= 24*60 + time-1; t++) {
            if (checkValidTime(digits, t)) {
                // System.out.println("time= " + t + ", hr= " + (t/60)%24 + ", min= " + t%60);
                if (minDif > t - time) {
                    minDif = t - time;
                    closest = t;
                }
            } 
        }
        String hrStr = String.valueOf((closest/60) % 24); if (hrStr.length() < 2) hrStr = "0" + hrStr;
        String minStr = String.valueOf(closest%60); if (minStr.length() < 2) minStr = "0" + minStr;
        return hrStr + ":" + minStr;
    }
    
    public boolean checkValidTime(HashSet<Integer> set, int t) {    
        int hr = (t/60)%24, min = t%60;
        if (!set.contains(hr/10) || !set.contains(hr%10)) return false;
        if (!set.contains(min/10) || !set.contains(min%10)) return false;
        return true;
    }
}
