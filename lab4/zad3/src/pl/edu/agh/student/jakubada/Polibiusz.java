package pl.edu.agh.student.jakubada;

public class Polibiusz implements Algorithm {

    @Override
    public String crypt(String toCrypt) {
        toCrypt = toCrypt.toLowerCase();
        toCrypt = toCrypt.replaceAll("j", "i");
        String result = "";
        for (char el : toCrypt.toCharArray()) {
            if (el == ' ') {
                result = result.concat(" ");
            } else {
                result = result.concat(LocalConstants.POLYBIUS_MAP.get(el).toString());
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
                result = result.concat(LocalConstants.POLYBIUS_MAP_INVERSE.get(Integer.parseInt(word.substring(i, i + 2))).toString());
            }
            result = result.concat(" ");
        }
        result = result.substring(0,result.length()-1);
        return result;
    }
}
