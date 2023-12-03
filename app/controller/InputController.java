package app.controller;

import java.util.Scanner;

public class InputController {
    private final Scanner scanner = new Scanner(System.in);

    public Input scan() {
        String value = "";
        value = scanner.nextLine();
        return new Input(value);
    }


    public static class Input {
        String value;

        private Input(String value) {
            this.value = value;
        }

        public String toString() {
            return value;
        }

        public int toInt(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0;
            }
        }

        public double toDouble(String str) {
            try {
                return Double.parseDouble(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0.0;
            }
        }

        public char[] toCharArray(String str) {
            return str.toCharArray();
        }

        public float toFloat(String str) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
    }

}
