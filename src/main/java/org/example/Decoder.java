package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Decoder {
    public static void main(String[] args) {
        String encodedMessage1 = "t2st3ng g1tset ufttjoh";
        String encodedMessage2 = "o4h4ll5";
        String encodedMessage3 = "1ppl2s 1r2 3l4g3t3m3t3";

        String decodedMessage1 = decode(encodedMessage1);
        String decodedMessage2 = decode(encodedMessage2);
        String decodedMessage3 = decode(encodedMessage3);

        System.out.println(decodedMessage1);
        System.out.println(decodedMessage2);
        System.out.println(decodedMessage3);
    }

    public static String decode(String message) {
        String[] words = message.split(" ");
        StringBuilder decodedMessage = new StringBuilder();

        for (String word : words) {
            if (word.matches("[0-9]+")) {
                decodedMessage.append(decodeVowels(word));
            } else {
                decodedMessage.append(decodeConsonants(word));
            }

            decodedMessage.append(" ");
        }

        decodedMessage.deleteCharAt(decodedMessage.length() - 1);
        return decodedMessage.toString();
    }

    private static String decodeVowels(String encoded) {
        return encoded
                .replaceAll("1", "a")
                .replaceAll("2", "e")
                .replaceAll("3", "i")
                .replaceAll("4", "o")
                .replaceAll("5", "u");
    }

    private static String decodeConsonants(String encoded) {
        StringBuilder decoded = new StringBuilder();
        char prevConsonant = ' ';

        for (char c : encoded.toCharArray()) {
            if (Character.isLetter(c)) {
                if (!isVowel(c)) {
                    prevConsonant = (char) (c + 1);
                    if (prevConsonant > 'z') {
                        prevConsonant = 'a';
                    }
                    decoded.append(prevConsonant);
                } else {
                    decoded.append(c);
                }
            } else {
                decoded.append(c);
            }
        }

        return decoded.toString();
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
