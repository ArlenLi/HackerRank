import java.util.ArrayList;
import java.util.List;

public class StackOfBoxes {
    public static int calculateHighestStack(List<Box> boxes){
        List<Box> rotations = new ArrayList<>();
        for (Box box:
             boxes) {
            rotations.addAll(Box.generateRotations(box));
        }

        rotations.sort((box1, box2) -> {
            return box2.width - box1.width;
        });

        int[] highests = new int[rotations.size()];
        int maxHeight = 0;
        for(int i = 0; i < rotations.size(); i++){
            int height = maxHeight(i, highests, rotations);
            if(height > maxHeight){
                maxHeight = height;
            }
        }
        return maxHeight;
    }

    private static int maxHeight(int bottomBoxIndex, int[] highests, List<Box> rotations){
        if(highests[bottomBoxIndex] != 0){
            return highests[bottomBoxIndex];
        }

        int maxHeightAboveBase = 0;
        Box bottomBox = rotations.get(bottomBoxIndex);
        for(int i = bottomBoxIndex + 1; i < rotations.size(); i++){
            if(rotations.get(i).width < bottomBox.width &&
                    rotations.get(i).depth < bottomBox.depth){
                int height = maxHeight(i, highests, rotations);
                if(height > maxHeightAboveBase){
                    maxHeightAboveBase = height;
                }
            }
        }

        int highestOfBottomBox = bottomBox.height + maxHeightAboveBase;
        highests[bottomBoxIndex] = highestOfBottomBox;
        return highestOfBottomBox;
    }
}
