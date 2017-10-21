package pl.edu.agh.student.jakubada;

import java.util.HashMap;
import java.util.Map;

public class Polibiusz implements Algorithm {

    @Override
    public String crypt(String toCrypt) {
        toCrypt = toCrypt.replaceAll("j", "i");
        toCrypt = toCrypt.toLowerCase();
        String result = "";
        for (char el : toCrypt.toCharArray()) {
            result = result.concat(LocalConstants.POLYBIUS_MAP.get(el).toString());
        }
        return result;
    }

    @Override
    public String decrypt(String toDecrypt) {
        String result = "";
        for (int i = 0; i < toDecrypt.length(); i++) {
            result +=
        }
        return null;
    }
}
