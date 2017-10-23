package pl.edu.agh.student.jakubada;

public class ROT11 implements Algorithm {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int ROTATION = 11;

    // static ROT shifting method used as a helper for other methods
    private static String rotCryptingShifter(String input, int rotation) {
        // lower casing the input string
        input = input.toLowerCase();

        // declare output shifted string
        String output = "";

        //iterate over letters
        for (char letter : input.toCharArray()) {
            if (letter == ' ') {
                output += " ";
            } else {
                output += ALPHABET.charAt(
                        (ALPHABET.indexOf(letter) + rotation + ALPHABET.length()) % ALPHABET.length()
                );
            }
        }
        return output;
    }

    // normal rotation using helper method
    @Override
    public String crypt(String toCrypt) {
        return rotCryptingShifter(toCrypt, ROTATION);
    }

    // using - rotation to do opposite of shifting forward ROT unshifting it :)
    @Override
    public String decrypt(String toDecrypt) {
        return rotCryptingShifter(toDecrypt, -ROTATION);

    }
}
