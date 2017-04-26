/**
 * Created by User on 4/26/2017.
 */
public class CommentParser {

    public static Integer state = 0;
    public String text;
    public Integer currentIndex = 0;

    public CommentParser(String text) {
        this.text = text;
    }

    public void parseComments() {

        while(currentIndex < text.length()) {
            switch (state) {
                case 0: {  // start state
                    normalState();
                    break;
                }
                case 1: {
                    doubleSlash();
                    break; // single line comment
                }
                case 2: {
                    startComment();
                    break; // start comment
                }
                default:{
                    break;
                }
            }
        }

    }

    public void normalState(){
        if(text.charAt(currentIndex) == '/' && text.charAt(currentIndex+1) == '/'){
            System.out.print("Comment found with '//' = ");
            state = 1;
            currentIndex += 2;
            return;
        }
        if(text.charAt(currentIndex) == '/' && text.charAt(currentIndex+1) == '*'){
            System.out.print("Comment found with '/*' = ");
            state = 2;
            currentIndex += 2;
            return;
        }
        currentIndex++;
    }

    public void doubleSlash(){
        if(text.charAt(currentIndex) != '\n'){
            System.out.print(text.charAt(currentIndex));
            currentIndex++;
            return;
        }
        System.out.println();
        state=0;
        currentIndex++;
    }

    public void startComment(){
        if(currentIndex >= text.length() - 1){
            System.out.println("EROOOOR");
        }
        if(text.charAt(currentIndex) == '*' && (currentIndex < text.length() -1) && text.charAt(currentIndex + 1) == '/'){
            state = 0;
            currentIndex += 2;
            System.out.println();
            return;
        } else {
            System.out.print(text.charAt(currentIndex));
            currentIndex++;
            return;
        }
    }

}