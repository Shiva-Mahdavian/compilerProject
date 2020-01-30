import java.util.EnumMap;

public class HtmlGen {
    public static EnumMap<Type, String> type2color;

    public static void init() {
        type2color = new EnumMap<Type, String>(Type .class);
        type2color.put(Type.Reserved, Color.Blue.getVal());
        type2color.put(Type.Identifier, Color.Violate.getVal());
        type2color.put(Type.Integer, Color.LightBlue.getVal());
        type2color.put(Type.Real, Color.LightYellow.getVal());
        type2color.put(Type.String, Color.Green.getVal());
        type2color.put(Type.Char, Color.Green.getVal());
        type2color.put(Type.SpecialChar, Color.Blue.getVal());
        type2color.put(Type.Comment, Color.Gray.getVal());
        type2color.put(Type.Other, Color.Black.getVal());
    }
}
