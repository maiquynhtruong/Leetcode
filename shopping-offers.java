public class Solution {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int total = Integer.MAX_VAL;
        for (int o = 0; o < special.size(); o++) {
            boolean validOffer = true;
            List<Integer> offer = special.get(o);
            for (int i = 0; i < needs.size()-1; i++) {
                int remaining = needs.get(i) - offer.get(i);
                needs.set(i, remaining);
                if (remaining < 0) validOffer = false;
            }
            if (validOffer) total = Math.min(total, shoppingOffers(price, special, needs) + offer.get(offer.size()-1));
            for (int i = 0; i < needs.size()-1; i++) {
                needs.set(i, needs.get(i) + offer.get(i));
            }
        }
        int noOffers = 0;
        for (int i = 0; i < needs.size(); i++) noOffers += price.get(i)*needs.get(i);
        return Math.min(noOffers, total);
    } 
    public static void main(String args[]) {
        
        
    }
}
