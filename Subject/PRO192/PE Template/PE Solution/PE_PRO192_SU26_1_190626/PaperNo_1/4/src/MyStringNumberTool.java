/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NgoAnhHuy
 */
public class MyStringNumberTool implements IStringNumberTool {

    @Override
    public String buildAcronym(String string) {
        if (string == null || string.isEmpty()) {
            return "";
        }

        String[] words = string.split(" ");
        String result = "";

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstCharacter = word.charAt(0);

                if (Character.isLetter(firstCharacter)) {
                    result += Character.toUpperCase(firstCharacter);
                }
            }
        }

        return result;
    }

    @Override
    public String decimalToBinary(int i) {
        if (i == 0) {
            return "0";
        }

        String binary = "";

        while (i > 0) {
            int remainder = i % 2;

            binary = remainder + binary;

            i = i / 2;
        }

        return binary;
    }

}
