import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingInt {
    public static int algo(String fileName){
        long numOfInts = (long)Integer.MAX_VALUE + 1;
        byte[] bitVector = new byte[(int)numOfInts / 8];

        try(Scanner sc = new Scanner(new File(fileName))){
            while(sc.hasNextInt()){
                int num = sc.nextInt();
                bitVector[num / 8] |= 1 << num % 8;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        bitVector[0] |= 1;
        byte mask = (byte)0b11111111;
        for(int i = 0; i < bitVector.length; i++){
            if((bitVector[i] ^ mask) != 0){
                for(int j = 0; j < 8; j++){
                    if((bitVector[i] & 1 << j) == 0){
                        return 8 * i + j;
                    }
                }
            }
        }
        return -1;
    }
}
