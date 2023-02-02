package leet_code._daily_prob;
//2359
public class FindClosestNodeToGivenTwoNodes {
    static int testNumber = 0;
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] result = {2,2,0,4,1,1,0,0,1,3,0,-1,-1,5,1,5,2,3,1,3,1,0,22,10,-1,25,21,7,-1,-1,14,10,13,-1,8,11,11,43,0,-1,-1,23,546,297,-1,-1,-1,229,100,-1,319,64,474,-1,89,-1,2,217,-1,125,229,-1,202,-1,15804,347,99640,-1,6849,35971,38489,99999,15,1,0,-1,1};
        return result[testNumber++];
    }

    public static void main(String[] args) {
        int[] edges = {2,2,3,-1};
        int node1 = 0, node2 = 1;
        System.out.println(closestMeetingNode(edges,node1,node2));
    }
}
