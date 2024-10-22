package TextEditor.Document.Character;

import java.util.HashMap;
import java.util.Map;

public class FlyWeightCharacterFactory {
    Map<String, CharacterStyle> characterStyleRepo = new HashMap<>();
    Map<String, FlyWeightCharactor> characterRepo = new HashMap<>();

//    todo improve
    public FlyWeightCharactor getFlyWeightCharacter(Character c, CharacterStyle style) {
        Boolean isBold = style.isBold;
        Boolean isItalic = style.isItalic;
        String font = style.font;
        String characterKey = c.toString() + "_" + isBold.toString() + "_" + isItalic.toString() + "_" + font;
        if(characterRepo.containsKey(characterKey)) return characterRepo.get(characterKey);
        String styleKey = "_" + isBold.toString() + "_" + isItalic.toString() + "_" + font;
        CharacterStyle styleObj;
        if(characterStyleRepo.containsKey(styleKey)) {
            styleObj = characterStyleRepo.get(styleKey);
        } else {
            styleObj = new CharacterStyle(isBold, isItalic, font);
            characterStyleRepo.put(styleKey, styleObj);
        }
        FlyWeightCharactor flyWeightCharactor = new FlyWeightCharactor(c, styleObj);
        characterRepo.put(characterKey, flyWeightCharactor);
        return flyWeightCharactor;
    }

}
