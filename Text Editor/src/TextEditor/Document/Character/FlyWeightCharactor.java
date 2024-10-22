package TextEditor.Document.Character;

public class FlyWeightCharactor {
    public char character;
    CharacterStyle style;

    public FlyWeightCharactor(char character, CharacterStyle style) {
        this.character = character;
        this.style = style;
    }
}
