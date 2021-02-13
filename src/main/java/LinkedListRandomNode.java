import java.util.Random;

public class LinkedListRandomNode {
    ListNode head = null;
    Random randomGenerator = null;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        randomGenerator = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int result = 0;
        int count = 0;
        ListNode node = head;
        while(node != null){
            count++;
            int randomInt = randomGenerator.nextInt(count);
            if(randomInt == 0){
                result = node.val;
            }
            node = node.next;
        }
        return result;
    }


}
