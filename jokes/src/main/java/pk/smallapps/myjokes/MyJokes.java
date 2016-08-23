package pk.smallapps.myjokes;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class MyJokes {
    public MyJokes() {
    }

    public String getRandomJoke() throws IOException {
        Random rand = new Random();
        int randomNumber = rand.nextInt((8000 - 1) + 1) + 1;
        InputStream in = this.getClass().getResourceAsStream("/jokesfile.text");
        Scanner scanner = new Scanner(in);
        int i = 0;
        boolean isBuildingString = false;
        StringBuilder stringBuilder = new StringBuilder();
        while (scanner.hasNextLine()) {
            i++;
            String line = scanner.nextLine();
            if (i >= randomNumber && line.length()>1 && line.charAt(0) == '-') {
                isBuildingString = true;
            }
            if ( isBuildingString){
                while (scanner.hasNext()){
                    String jokeLine = scanner.nextLine();
                    if (jokeLine.length()>1 && jokeLine.charAt(0) == '-') {
                        break;
                    }
                    else{
                        stringBuilder.append("\n"+jokeLine);
                    }
                }
                break;
            }
//            System.out.println(line);
        }
        scanner.close();
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();

    }

}
