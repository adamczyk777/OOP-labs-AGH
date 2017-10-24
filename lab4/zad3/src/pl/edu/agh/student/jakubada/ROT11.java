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
        StringBuilder stringBuilder = new StringBuilder();

        //iterate over letters
        for (char letter : input.toCharArray()) {
            if (letter == ' ') {
                stringBuilder.append(" ");
            } else {
                stringBuilder.append(ALPHABET.charAt(
                        (ALPHABET.indexOf(letter) + rotation + ALPHABET.length()) % ALPHABET.length()
                ));
            }
        }
        return stringBuilder.toString();
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
