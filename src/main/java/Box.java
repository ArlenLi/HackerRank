import java.util.ArrayList;
import java.util.List;

public class Box {
    public int height;
    public int width;
    public int depth;

    public Box(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    public void swapWidthAndDepthIfNecessary(){
        if(width > depth){
            int temp = width;
            width = depth;
            depth = temp;
        }
    }

    public static List<Box> generateRotations(Box box){
        List<Box> rotations = new ArrayList<>();
        box.swapWidthAndDepthIfNecessary();
        rotations.add(box);

        Box variableBox1 = new Box(box.width, box.height, box.depth);
        variableBox1.swapWidthAndDepthIfNecessary();
        rotations.add(variableBox1);

        Box variableBox2 = new Box(box.depth, box.width, box.height);
        variableBox2.swapWidthAndDepthIfNecessary();
        rotations.add(variableBox2);
        return rotations;
    }

}
