public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon){
        int[][] cache = new int[dungeon.length][dungeon[0].length];

        return calculateMinimumHP(0, 0, dungeon, cache);
    }

    private int calculateMinimumHP(int x, int y, int[][] dungeon, int[][] cache){
        if(x >= dungeon.length || y >= dungeon[0].length){
            return Integer.MAX_VALUE;
        }
        if(x == dungeon.length - 1 && y == dungeon[0].length - 1){
            return Math.max(-dungeon[x][y] + 1, 1);
        }
        if(cache[x][y] != 0){
            return cache[x][y];
        }
        else{
            int minimumHP = Math.max(Math.min(calculateMinimumHP(x, y + 1, dungeon, cache),
                    calculateMinimumHP(x + 1, y, dungeon, cache)) - dungeon[x][y], 1);
            cache[x][y] = minimumHP;
            return minimumHP;
        }
    }

    public int calculateMinimumHPBottomUp(int[][] dungeon){
        int[][] cache = new int[dungeon.length][dungeon[0].length];
        for(int i = dungeon.length - 1; i >= 0; i--)
            for(int j = dungeon[0].length - 1; j >= 0; j--){
                if(i == dungeon.length - 1 && j == dungeon[0].length - 1){
                    cache[i][j] = Math.max(-dungeon[i][j] + 1, 1);
                }else if(i + 1 >= dungeon.length){
                    cache[i][j] = Math.max(cache[i][j + 1] - dungeon[i][j], 1);
                }else if(j + 1 >= dungeon[0].length){
                    cache[i][j] = Math.max(cache[i + 1][j] - dungeon[i][j], 1);
                }else{
                    cache[i][j] = Math.max(Math.min(cache[i][j + 1], cache[i + 1][j]) - dungeon[i][j], 1);
                }
            }
        return cache[0][0];
    }
}
