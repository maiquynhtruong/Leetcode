public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> flights = new HashMap<String, PriorityQueue<String>>();
        for (int i = 0; i < tickets.length; i++) {
            if (!flights.containsKey(tickets[i][0])) {
                flights.put(tickets[i][0], new PriorityQueue<String>());
            }
            flights.get(tickets[i][0]).add(tickets[i][1]);
        }
        ArrayList<String> flightOrder = new ArrayList<String>();
        System.out.println();
        dfs("JFK", flightOrder, flights, tickets.length+1);
        flightOrder.add(0,"JFK");
        return flightOrder;
    }
    public void dfs(String flight, ArrayList<String> flightOrder, HashMap<String, PriorityQueue<String>> flights, int len) {
        if (flightOrder.size() == len) return;
        if (!flights.containsKey(flight) || flights.isEmpty()) return;
        PriorityQueue<String> connecting = flights.get(flight);
        System.out.println(Arrays.toString(connecting.toArray()));
        while (!connecting.isEmpty()) {
            String nextFlight = connecting.poll();
            dfs(nextFlight, flightOrder, flights, len);
            flightOrder.add(0, nextFlight);
        }
        
    }
}
