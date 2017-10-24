package pl.edu.agh.student.jakubada;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/** Klasa Polibiusz implementuje interfejs Algorithm
 * służy do przechowywania algorytmu szyfrującego Polibiusza, udostepnia metody takie jak określa interfejs
 * poza tym zawiera niezbędne prywatne statyczne stałe*/

public class Polibiusz implements Algorithm {

    // Declaration of map required to encrypt and decrypt strings with codes according to polybius table
    private static final BiMap<Character, Integer> polybiusMap = HashBiMap.create();

    // Inicjalizacja wartości mapy
    static {
        polybiusMap.put('a', 11);
        polybiusMap.put('b', 12);
        polybiusMap.put('c', 13);
        polybiusMap.put('d', 14);
        polybiusMap.put('e', 15);
        polybiusMap.put('f', 21);
        polybiusMap.put('g', 22);
        polybiusMap.put('h', 23);
        polybiusMap.put('i', 24);
        polybiusMap.put('k', 25);
        polybiusMap.put('l', 31);
        polybiusMap.put('m', 32);
        polybiusMap.put('n', 33);
        polybiusMap.put('o', 34);
        polybiusMap.put('p', 35);
        polybiusMap.put('q', 41);
        polybiusMap.put('r', 42);
        polybiusMap.put('s', 43);
        polybiusMap.put('t', 44);
        polybiusMap.put('u', 45);
        polybiusMap.put('v', 51);
        polybiusMap.put('w', 52);
        polybiusMap.put('x', 53);
        polybiusMap.put('y', 54);
        polybiusMap.put('z', 55);
    }

    @Override
    public String crypt(String toCrypt) {
        toCrypt = toCrypt.toLowerCase();
        toCrypt = toCrypt.replaceAll("j", "i");
        StringBuilder result = new StringBuilder();
        for (char el : toCrypt.toCharArray()) {
            if (el == ' ') {
                result.append(" ");
            } else {
                result.append(polybiusMap.get(el).toString());
            }
        }
        return result.toString();
    }

    @Override
    public String decrypt(String toDecrypt) {
        StringBuilder result = new StringBuilder();
        String[] splittedToDecrypt = toDecrypt.split(" ");
        for (String word : splittedToDecrypt) {
            for (int i = 0; i < word.length(); i += 2) {
                result.append((polybiusMap.inverse().get(Integer.parseInt(word.substring(i, i + 2))).toString()));
            }
            result.append((" "));
        }
        result.setLength(result.length()-1);
        return result.toString();
    }
}
