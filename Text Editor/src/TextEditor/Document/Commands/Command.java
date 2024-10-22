package TextEditor.Document.Commands;

import TextEditor.Document.Character.FlyWeightCharactor;
import TextEditor.Document.Document;

public abstract class Command {
    int row;
    int col;
    FlyWeightCharactor flyWeightCharactor;
    Document doc;

    public Command(int row, int col, FlyWeightCharactor flyWeightCharactor, Document doc) {
        this.row = row;
        this.col = col;
        this.flyWeightCharactor = flyWeightCharactor;
        this.doc = doc;
    }

    public abstract void execute();
    public abstract void unExecute();
}
