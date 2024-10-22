package TextEditor.Document.Commands;

import TextEditor.Document.Character.FlyWeightCharactor;
import TextEditor.Document.Document;

public class RemoveCharacterCommand extends Command{

    public RemoveCharacterCommand(int row, int col, FlyWeightCharactor flyWeightCharactor, Document doc) {
        super(row, col, flyWeightCharactor, doc);
    }

    @Override
    public void execute() {
        doc.executeRemoveChar(row, col);
    }

    @Override
    public void unExecute() {
        doc.executeAddChar(row, col, flyWeightCharactor);
    }
}
