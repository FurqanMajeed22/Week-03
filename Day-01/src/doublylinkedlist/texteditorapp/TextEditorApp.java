package doublylinkedlist.texteditorapp;

public class TextEditorApp {
    public static void main(String[] args) {
        // Initialize the text editor with a max history size of 5
        TextEditor editor = new TextEditor(5);

        // Adding text states
        editor.addTextState("Hello");
        editor.addTextState("Hello World");
        editor.addTextState("Hello World!");
        editor.addTextState("Hello World!!");
        editor.addTextState("Hello World!!!");

        // Display the current text state
        editor.displayCurrentState();

        // Perform some undo operations
        editor.undo();
        editor.undo();

        // Display the current text state after undo
        editor.displayCurrentState();

        // Perform redo operations
        editor.redo();

        // Display the current text state after redo
        editor.displayCurrentState();

        // Add more states to test history size limitation
        editor.addTextState("Hello Universe!");
        editor.addTextState("Hello Universe!!");

        // Display all the states in history
        editor.displayHistory();
    }
}
