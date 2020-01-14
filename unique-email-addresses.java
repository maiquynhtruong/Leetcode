class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < emails.length; i++) {
            String[] parts = emails[i].split("@");
            String local = parseLocal(parts[0]);
            set.add(local+"@"+parts[1]);
        }
        return set.size();
    }
    
    public String parseLocal(String s) {
        String[] parts = s.split("\\+");
        return parts[0].replace(".", "");
    }
}
