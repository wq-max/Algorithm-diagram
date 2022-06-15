package djs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Djs {

    private static final int MAX = Integer.MAX_VALUE;

    public static void djs(HashMap<String, HashMap<String, Integer>> graph) {
        HashMap<String,Integer> costs = new HashMap<>();
        HashMap<String, String> parents = new HashMap<>();
        ArrayList<String> processed = new ArrayList<>(graph.size());
        for (Map.Entry<String, HashMap<String, Integer>> entry : graph.entrySet()) {
            if (entry.getKey().equals("S")) {
                costs.putAll(entry.getValue());
                entry.getValue().forEach((k, v) -> parents.put(k, entry.getKey()));
            } else {
                if (!costs.containsKey(entry.getKey())) {
                    costs.put(entry.getKey(), MAX);
                    parents.put(entry.getKey(), null);
                }
            }
        }
        String node = findLowestNode(costs, processed);
        while (node != null) {
            int cost = costs.get(node);
            HashMap<String, Integer> neighbors = graph.get(node);
            for (String neighbor : neighbors.keySet()) {
                int newCost = cost + neighbors.get(neighbor);
                if (costs.get(neighbor) > newCost) {
                    costs.replace(neighbor, newCost);
                    parents.replace(neighbor, node);
                }
            }
            processed.add(node);
            node = findLowestNode(costs, processed);
        }
        System.out.println(costs);
        System.out.println(parents);
        Stack<String> paths = new Stack<>();
        paths.push("F");
        String s = parents.get("F");
        do {
            paths.push(s);
            s = parents.get(s);
        }while (!s.equals("S"));
        paths.push("S");
        System.out.print("Lowest Path is :");
        while (!paths.isEmpty()) {
            String str = paths.pop();
            if (!str.equals("F"))
                System.out.print(str + "-->");
            else
                System.out.println(str);

        }
        System.out.println("lowest distance is : " + costs.get("F"));


    }

    public static String findLowestNode(HashMap<String,Integer> costs, ArrayList<String> processed) {
        int lowest = MAX;
        String lowestNode = null;
        for (Map.Entry<String, Integer> entry : costs.entrySet()) {
            if (lowest > entry.getValue() && !processed.contains(entry.getKey())) {
                lowest = entry.getValue();
                lowestNode = entry.getKey();
            }
        }
        return lowestNode;
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> graph = new HashMap<>();
        HashMap<String, Integer> Snodes = new HashMap<>();
        Snodes.put("A", 6);
        Snodes.put("B", 2);
        graph.put("S", Snodes);
        HashMap<String, Integer> Anodes = new HashMap<>();
        Anodes.put("F", 1);
        graph.put("A", Anodes);
        HashMap<String, Integer> Bnodes = new HashMap<>();
        Bnodes.put("A", 3);
        Bnodes.put("F", 5);
        graph.put("B", Bnodes);
        HashMap<String, Integer> Fnodes = new HashMap<>();
        Fnodes.put("F", 0);
        graph.put("F", Fnodes);
        System.out.println(graph);
        djs(graph);
    }
}
