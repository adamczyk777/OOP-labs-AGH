package pl.edu.agh.student.jakubada;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//        some placeholder
    }

    static void primitiveFinalParameter(final double var) {
//        Invalid because you can't change  a value of a primitive "object"? variable
        var = 12;
    }

    static void objectFinalParameter(final LinkedList<Double> list) {
//        Perfectly valid because the reference stays the same when adding deleting elements to/from list
        list.add(12.2);
        list.remove(0);
//        Though we can't change the reference:
        list = new LinkedList<>();
    }

}

// Errors after compilation:
// Error:(13, 9) java: final parameter var may not be assigned
// Error:(21, 9) java: final parameter list may not be assigned