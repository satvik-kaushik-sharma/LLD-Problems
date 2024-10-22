package TextEditor.Document.Character;


public class CharacterStyle {
    public Boolean isBold;
    public Boolean isItalic;
    public String font;

    public CharacterStyle(boolean isBold, boolean isItalic, String font) {
        this.isBold = isBold;
        this.isItalic = isItalic;
        this.font = font;
    }
}
