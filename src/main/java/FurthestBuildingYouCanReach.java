import java.util.HashMap;

public class FurthestBuildingYouCanReach {
    public static int furthestBuilding(int[] heights, int bricks, int ladders){
        return furthestbuilding(0, heights, bricks, ladders);
    }

    private static int furthestbuilding(int index, int[] heights, int bricks, int ladders){
        int result;
        if(index + 1 >= heights.length){
            result = index;
        }else if(heights[index] >= heights[index + 1]){
            result =  furthestbuilding(index + 1, heights, bricks, ladders);
        }
        else if(heights[index + 1] - heights[index] <= bricks){
            result =  furthestbuilding(index + 1, heights, bricks - (heights[index + 1] - heights[index]), ladders);
        } else if(ladders > 0){
            result = furthestbuilding(index + 1, heights, bricks, ladders - 1);
        }else{
            result = index;
        }

        return result;
    }
}
