package pl.edu.agh.student.jakubada;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.HashMap;
import java.util.Map;

public class LocalConstants {
    public static final BiMap<Character, Integer> POLYBIUS_MAP = HashBiMap.create();
    public static final BiMap<Integer, Character> POLYBIUS_MAP_INVERSE;

    // =================================================================================================================
    // constants for ROT11 Method
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ROTATION = 11;
    // =================================================================================================================
    static {
        POLYBIUS_MAP.put('a', 11);
        POLYBIUS_MAP.put('b', 12);
        POLYBIUS_MAP.put('c', 13);
        POLYBIUS_MAP.put('d', 14);
        POLYBIUS_MAP.put('e', 15);
        POLYBIUS_MAP.put('f', 21);
        POLYBIUS_MAP.put('g', 22);
        POLYBIUS_MAP.put('h', 23);
        POLYBIUS_MAP.put('i', 24);
        POLYBIUS_MAP.put('k', 25);
        POLYBIUS_MAP.put('l', 31);
        POLYBIUS_MAP.put('m', 32);
        POLYBIUS_MAP.put('n', 33);
        POLYBIUS_MAP.put('o', 34);
        POLYBIUS_MAP.put('p', 35);
        POLYBIUS_MAP.put('q', 41);
        POLYBIUS_MAP.put('r', 42);
        POLYBIUS_MAP.put('s', 43);
        POLYBIUS_MAP.put('t', 44);
        POLYBIUS_MAP.put('u', 45);
        POLYBIUS_MAP.put('v', 51);
        POLYBIUS_MAP.put('w', 52);
        POLYBIUS_MAP.put('x', 53);
        POLYBIUS_MAP.put('y', 54);
        POLYBIUS_MAP.put('z', 55);
        POLYBIUS_MAP_INVERSE = POLYBIUS_MAP.inverse();
    }
}
