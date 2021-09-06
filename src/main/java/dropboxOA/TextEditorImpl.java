package dropboxOA;


/*
A text editor is a type of computer program that edits plain text.

        Your task is to simulate the working process of a text editor which can handle five types of operations:

        INSERT <text> - add <text> to the end of the current text, where <text> consists of at most 20 English letters,

        DELETE - erase the last character of the current text (if the current text is empty, does nothing),

        COPY <index> - copy the substring of the current text starting from <index> and spanning until the end (if <index> is out of bounds copies an empty string), i.e. sets the clipboard value equal to the given substring,

        PASTE - add the last copied text to the end of the current text (if the last copied text is empty, does nothing),

        UNDO - undo the last successful INSERT, DELETE or PASTE operation (if there is nothing to undo, does nothing).

        You are given operations, an array of strings where each is an operation of one of the five types above. Your task is to find the resulting text after performing the given operations.

        NOTE: An operation is considered successful if the text in editor is changed after the operation is completed. In particular, deleting the last character of an empty text and pasting an empty string are unsuccessful operations.

        Example

        For operations = ["INSERT Code", "INSERT Signal", "DELETE", "UNDO"], the output should be newTextEditor(operations) = "CodeSignal".

        Initially the text is empty,

        After the "INSERT Code" operation, the text is "Code",

        After the "INSERT Signal" operation, the text is "CodeSignal",

        After the "DELETE" operation, the last character is removed, so the text is "CodeSigna",

        After the "UNDO" operation, the DELETE operation is undone, so the text is "CodeSignal",
        So the final string is "CodeSignal".

        For operations = ["INSERT Da", "COPY 0", "UNDO", "PASTE", "PASTE", "COPY 2", "PASTE", "PASTE", "DELETE", "INSERT aaam"], the output should be newTextEditor(operations) = "DaDaDaDaaam".

        Initially the text is empty,

        After the "INSERT Da" operation, the text is "Da",

        After the "COPY 0" operation, the clipboard is set to "Da", the text is left unchanged,

        After the "UNDO" operation, the INSERT operation is undone, so the text is "",

        After the "PASTE" operation, the text "Da" is inserted from the clipboard, so the editor text is changed to "Da",

        After the "PASTE" operation, the text "Da" is inserted from the clipboard, so the editor text is changed to "DaDa",

        After the "COPY 2" operation, the clipboard is set to "Da", the editor text is left unchanged,

        After the "PASTE" operation, the text "Da" is inserted, so the editor text is changed to "DaDaDa",

        After the "PASTE" operation, the text "Da" is inserted, so the editor text is changed to "DaDaDaDa",

        After the "DELETE" operation, the last character is removed, so the text is "DaDaDaD",

        After the "INSERT aaam" operation, the text is "DaDaDaDaaam",

        So the final editor text is "DaDaDaDaaam".

        Input/Output

        [execution time limit] 0.5 seconds (cpp)

        [input] array.string operations

        A sequence of operations. It's guaranteed that all the operations satisfy the format described in the description.

        Guaranteed constraints:
        1 ≤ operations.length ≤ 103.

        [output] string

        The resulting text after performing the given sequence of operations.
*/

import java.util.LinkedList;

class TextEditor
{
    private static LinkedList<String> text = new LinkedList<>();
    private static int cursorIndex = 0;

    public String copy(int index){
        return null;
    }

    public void delete(){

    }

    private static void insert(String input){
        text.add(input);
        cursorIndex = text.size() - 1;
    }

    public String print(){
        StringBuilder sb = new StringBuilder();
        for(String t : text){
            sb.append(t);
        }
        return sb.toString();
    }

    public int getCursorIndex(){
        return cursorIndex;
    }
    private static void processCommands(String[] commands){
        for(String cmd : commands){
            if(cmd.contains("INSERT")){
                String[] insertCmd = cmd.split("\\s+");
                insert(insertCmd[1]);
            }
        }
    }

    TextEditor(String[] commands) {

        processCommands(commands);
    }
}

public class TextEditorImpl {

    public static void main(String[] args){
        String[] commands = new String[]{
                "INSERT CODE", "INSERT TEXT"
        };

        TextEditor editor = new TextEditor(commands);
        System.out.println(editor.print());
        System.out.println(editor.getCursorIndex());
    }

}
