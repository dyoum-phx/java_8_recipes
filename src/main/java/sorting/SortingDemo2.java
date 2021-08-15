package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortingDemo2
{
    public static void main(String[] args)
    {
        int[][] rooms = new int[][]{{5, 8}, {2, 4}, {1, 10}};
        //printRooms(rooms);
        System.out.println(minRooms(rooms));
    }

    public static void printRooms(int[][] rooms)
    {
        for(int i=0; i<rooms.length; i++)
        {
            System.out.println("room start: " + rooms[i][0] + " end: " + rooms[i][1]);
        }
    }

    public static int minRooms(int[][] rooms)
    {
        Arrays.sort(rooms, (a,b) -> a[0] - b[0]);
        printRooms(rooms);
        int minRooms = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int currTime = 0;
        for(int i=0; i<rooms.length; i++)
        {
            if(minHeap.peek() != null && minHeap.peek() >= rooms[i][0])
            {
                minHeap.offer(rooms[i][1]);
                minRooms++;
            }
            else if(minHeap.peek() != null && minHeap.peek() < rooms[i][0])
            {
                minHeap.poll();
            }
            else
            {
                minHeap.offer(rooms[i][1]);
                minRooms++;
            }

        }

        return minRooms;
    }
}
