package bfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSTest {

    public static boolean bfs(HashMap<String, String[]> graph) {
        Queue<String> queue = new LinkedList<>();
        String[] names = graph.get("you");
        for (String name : names)
            queue.offer(name);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (str != null && str.contains("m"))
                return true;
            else {
                String[] strs = graph.get(str);
                if(strs != null) {
                    for (String name : strs)
                        queue.offer(name);
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        HashMap<String, String[]> graph = new HashMap<>();
        String[] yous = {"alice", "bob", "claire"};
        graph.put("you", yous);
        String[] bobs = {"anuj", "peggy"};
        graph.put("bob", bobs);
        String[] alices = {"peggy"};
        graph.put("alice", alices);
        String[] claires = {"thom", "jonny"};
        graph.put("claire", claires);
        graph.put("anuj", null);
        graph.put("peggy", null);
        graph.put("thom", null);
        graph.put("jonny", null);
        System.out.println(bfs(graph));
    }
}
