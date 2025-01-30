package doublylinkedlist.texteditorapp;

class TextEditor {
    TextState currentState;
    int maxHistorySize;
    TextState head;
    TextState tail;
    int historyCount;

    TextEditor(int maxHistorySize) {
        this.maxHistorySize = maxHistorySize;
        this.currentState = null;
        this.head = null;
        this.tail = null;
        this.historyCount = 0;
    }

    // Add a new state to the history
    void addTextState(String content) {
        TextState newState = new TextState(content);

        // If the history is full, remove the oldest state
        if (historyCount == maxHistorySize) {
            head = head.next;
            head.prev = null;
            historyCount--;
        }

        // If currentState is not null, set its next pointer to the new state
        if (currentState != null) {
            currentState.next = newState;
            newState.prev = currentState;
        }

        // Update currentState to the new state
        currentState = newState;

        // If head is null, it means this is the first state
        if (head == null) {
            head = newState;
        }

        // Update tail to the new state
        tail = newState;

        // Increment the history count
        historyCount++;
    }

    // Undo the text state
    void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.content);
        } else {
            System.out.println("No more undo history.");
        }
    }

    // Redo the text state
    void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.content);
        } else {
            System.out.println("No more redo history.");
        }
    }

    // Display the current state of the text
    void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current Text: " + currentState.content);
        } else {
            System.out.println("No text state available.");
        }
    }

    // Display all the states in history (for testing purposes)
    void displayHistory() {
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.content);
            temp = temp.next;
        }
    }
}
