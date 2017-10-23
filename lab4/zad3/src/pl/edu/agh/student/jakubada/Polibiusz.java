package pl.edu.agh.student.jakubada;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Polibiusz implements Algorithm {

    // Declaration of map required to encrypt and decrypt strings with codes according to polybius table
    public static final BiMap<Character, Integer> polybiusMap = HashBiMap.create();

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
        String result = "";
        for (char el : toCrypt.toCharArray()) {
            if (el == ' ') {
                result = result.concat(" ");
            } else {
                result = result.concat(polybiusMap.get(el).toString());
            }
        }
        return result;
    }

    @Override
    public String decrypt(String toDecrypt) {
        String result = "";
        String[] splittedToDecrypt = toDecrypt.split(" ");
        for (String word : splittedToDecrypt) {
            for (int i = 0; i < word.length(); i += 2) {
                result = result.concat(polybiusMap.inverse().get(Integer.parseInt(word.substring(i, i + 2))).toString());
            }
            result = result.concat(" ");
        }
        result = result.substring(0,result.length()-1);
        return result;
    }
}
