/*
8.10 Paint Fill: Implement the "paint nil" function that one might see on many image editing programs.
That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
nil in the surrounding area until the color changes from the original color.
 */

public class PaintFill {
    public static void paint(int[][] screen, int x, int y, int newColor){
        if(screen[x][y] != newColor){
            int originalColor = screen[x][y];
            paint(screen, x, y, originalColor, newColor);
        }
    }

    private static void paint(int[][] screen, int x, int y, int originalColor, int newColor){
        if(x < 0 || y < 0 || x >= screen.length || y >= screen[0].length){
            return;
        }

        if(screen[x][y] == originalColor){
            screen[x][y] = newColor;
            paint(screen, x - 1, y, originalColor, newColor);
            paint(screen, x + 1, y, originalColor, newColor);
            paint(screen, x, y - 1, originalColor, newColor);
            paint(screen, x, y + 1, originalColor, newColor);
        }
    }
}
