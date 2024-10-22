package TextEditor.Document;

import TextEditor.Document.Character.CharacterStyle;
import TextEditor.Document.Character.FlyWeightCharacterFactory;
import TextEditor.Document.Character.FlyWeightCharactor;
import TextEditor.Document.Commands.AddCharacterCommand;
import TextEditor.Document.Commands.Command;
import TextEditor.Document.Commands.RemoveCharacterCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Document {
    FlyWeightCharacterFactory flyWeightCharacterFactory = new FlyWeightCharacterFactory();
    List<List<FlyWeightCharactor>> text = new ArrayList<>();
    Stack<Command> undoStack = new Stack<>();
    Stack<Command> redoStack = new Stack<>();

    public Document() {
    }

    public void addChar(int row, int col, Character c, CharacterStyle style) {
        while(row > text.size() - 1) {
            text.add(new ArrayList<>());
        }
        col = Math.min(col, text.get(row).size());
        FlyWeightCharactor flyWeightCharactor = flyWeightCharacterFactory.getFlyWeightCharacter(c, style);
        Command command = new AddCharacterCommand(row, col, flyWeightCharactor, this);
        undoStack.add(command);
        command.execute();
    }

    public void removeChar(int row, int col) {
//        TODO do within bounds check for row col
        FlyWeightCharactor flyWeightCharactor = text.get(row).get(col);
        Command command = new RemoveCharacterCommand(row, col, flyWeightCharactor, this);
        undoStack.add(command);
        command.execute();
    }

    public void executeAddChar(int row, int col, FlyWeightCharactor flyWeightCharactor) {
        List<FlyWeightCharactor> textRow = this.text.get(row);
//        char could have been added in middle of row as well
//        textRow.add(flyWeightCharactor);
//        int j = textRow.size() - 1;
//        while(j != col) {
//            Collections.swap(textRow, j, j-1);
//        }
        textRow.add(col, flyWeightCharactor);

    }

    public void executeRemoveChar(int row, int col) {
        List<FlyWeightCharactor> textRow = this.text.get(row);
        textRow.remove(col);
    }

    public void undo() {
        Command cmd = undoStack.pop();
        cmd.unExecute();
        redoStack.add(cmd);
    }
    public void redo() {
        Command cmd = redoStack.pop();
        cmd.execute();
        undoStack.add(cmd);
    }

    public void print() {
        for(int i=0;i<this.text.size();i++) {
            for(int j=0;j<this.text.get(i).size();j++) {
                System.out.print(this.text.get(i).get(j).character);
            }
            System.out.println();
        }
        System.out.println("---");
    }
}
