public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> flights = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if (!flights.containsKey(tickets[i][0])) {
                flights.put(tickets[i][0], new PriorityQueue<String>());
            }
            flights.get(tickets[i][0]).add(tickets[i][1]);
        }
        for (int i = 0; i < tickets.length; i++) {
            if (flights.get()
        }
    }
    public void dfs(String flight, ArrayList<String> flightOrder, HashMap<String, PriorityQueue<String>> flights) {
        PriorityQueue<String> connecting = flights.get(flight);
        flightOrder.add(connecting.pop());
        for (String next : connecting) {
            
        }
    }
}
