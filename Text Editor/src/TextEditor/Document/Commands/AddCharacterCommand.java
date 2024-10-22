package TextEditor.Document.Commands;

import TextEditor.Document.Character.FlyWeightCharactor;
import TextEditor.Document.Document;

public class AddCharacterCommand extends Command{

    public AddCharacterCommand(int row, int col, FlyWeightCharactor flyWeightCharactor, Document doc) {
        super(row, col, flyWeightCharactor, doc);
    }

    @Override
    public void execute() {
        doc.executeAddChar(row, col, flyWeightCharactor);
    }

    @Override
    public void unExecute() {
        doc.executeRemoveChar(row, col);
    }
}
