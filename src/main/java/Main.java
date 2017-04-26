import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by User on 4/26/2017.
 */
public class Main {

    private static final String FILENAME = "F:\\test.txt";
    private static String x = "";

    public static void main(String[] args) {

        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine = new String();
            br = new BufferedReader(new FileReader(FILENAME));
            while ((sCurrentLine = br.readLine()) != null) {
                x += sCurrentLine;
                x += "\n";
            }

            CommentParser commentParser = new CommentParser(x);
            commentParser.parseComments();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
