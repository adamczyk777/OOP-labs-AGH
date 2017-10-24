package pl.edu.agh.student.jakubada;

/** Interfejs Algorithm
 *  posiada metodę crypt i decrypt
 *  jest używany do okreslania sposobu obłsugi algorytmów do szyfrowania tekstu*/

public interface Algorithm {
    String crypt(String toCrypt);

    String decrypt(String toDecrypt);
}
