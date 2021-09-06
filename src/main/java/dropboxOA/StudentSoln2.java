package dropboxOA;

import java.util.Stack;

class StudentSoln2 {


    public String performEditorActions(String[][] actions) {
        Stack<String> result = new Stack<String>();
        Stack<String[]> undo = new Stack<String[]>();
        Stack<String[]> redo = new Stack<String[]>();
        for(String[] action : actions) {
            switch(action[0]) {
                case "INSERT":
                    result.push(action[1]);
                    undo.push(action);
                    break;
                case "DELETE":
                    undo.push(new String[]{action[0], result.pop()});
                    break;
                case "UNDO":
                    action = undo.pop();
                    if(action[0].equals("INSERT")) {
                        result.pop();
                    } else {
                        result.push(action[1]);
                    }
                    redo.push(action);
                    break;
                case "REDO":
                    if(!redo.isEmpty()) {
                        action = redo.pop();
                        if(action[0].equals("INSERT")) {
                            result.push(action[1]);
                            undo.push(action);
                        } else {
                            action[1] = result.pop();
                            undo.push(action);
                        }
                    }
                    break;
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!result.isEmpty()) {
            sb.append(result.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        StudentSoln2 s = new StudentSoln2();
        System.out.println(s.performEditorActions(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"}}));

        System.out.println(s.performEditorActions(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"DELETE"},
        }));

        System.out.println(s.performEditorActions(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"DELETE"},
                {"UNDO"}
        }));

        System.out.println(s.performEditorActions(new String[][]{{"INSERT", "a"},
                {"INSERT", "b"},
                {"UNDO"},
                {"REDO"},
                {"REDO"}
        }));
    }

}

//https://leetcode.com/discuss/interview-question/770704/amazon-onsite-text-editor