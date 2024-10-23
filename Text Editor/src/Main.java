import TextEditor.Document.Character.CharacterStyle;
import TextEditor.Document.Document;

public class Main {
    public static void main(String[] args) {
        Document doc = new Document();

        doc.addChar(0, 0, 'S', new CharacterStyle(true, true,"Arial"));
        doc.addChar(0, 1, 'A', new CharacterStyle(true, true,"Arial"));
        doc.addChar(0, 2, 'T', new CharacterStyle(true, true,"Arial"));
        doc.addChar(0, 3, 'V', new CharacterStyle(true, true,"Arial"));
        doc.addChar(0, 4, 'I', new CharacterStyle(true, true,"Arial"));
        doc.addChar(0, 5, 'K', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 0, 'K', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 1, 'A', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 2, 'U', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 3, 'S', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 4, 'H', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 5, 'I', new CharacterStyle(true, true,"Arial"));
        doc.addChar(1, 6, 'K', new CharacterStyle(true, true,"Arial"));
//        doc.print();
//        doc.undo();
//        doc.print();
//        doc.redo();
        doc.print();
        doc.removeChar(0, 0);
        doc.print();
        doc.undo();
        doc.print();
        doc.redo();
        doc.print();
    }
}