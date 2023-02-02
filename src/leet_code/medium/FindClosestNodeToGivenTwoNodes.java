package leet_code.medium;
//2359
public class FindClosestNodeToGivenTwoNodes {

    public static void main(String[] args) {
        int[] edges = {1,2,-1};
        int node1 = 0, node2 = 2;
        System.out.println(closestMeetingNode(edges,node1,node2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        if (edges == null || edges.length < 2) {
            return -1;
        }

        int len = edges.length;
        int[] visit1 = new int[len];
        int[] visit2 = new int[len];

        int res = len;
        while (node1 != -1 || node2 != -1) {
            if (node1 != -1) {
                if (visit2[node1] == 1) {
                    res = Math.min(res, node1);
                }

                if (visit1[node1] == 1) {
                    node1 = -1;
                } else {
                    visit1[node1] = 1;
                    node1 = edges[node1];
                }
            }
            if (node2 != -1) {
                if (visit1[node2] == 1) {
                    res = Math.min(res, node2);
                }
                if (visit2[node2] == 1) {
                    node2 = -1;
                } else {
                    visit2[node2] = 1;
                    node2 = edges[node2];
                }
            }

            if (res < len) {
                return res;
            }
        }

        return -1;
    }
}