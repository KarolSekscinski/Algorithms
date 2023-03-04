package pl.edu.pw.ee;

class LongestCommonSubsequence {

    private int[][] valuesInArray;

    private int[][] transition;

    private boolean[][] path;
    private String topStr;

    private String leftStr;

    public LongestCommonSubsequence(String topStr, String leftStr) {
        if (topStr == null || leftStr == null) {
            throw new IllegalArgumentException("Strings cannot be null!");
        }
        this.topStr = topStr;
        this.leftStr = leftStr;
        valuesInArray = new int[leftStr.length() + 1][topStr.length() + 1];
        transition = new int[leftStr.length() + 1][topStr.length() + 1];
        path = new boolean[leftStr.length() + 1][topStr.length() + 1];


        for (int i = 1; i < valuesInArray.length; i++) {
            int intFromLeftStr = leftStr.charAt(i - 1);
            for (int j = 1; j < valuesInArray[i].length; j++) {
                int intFromTopStr = topStr.charAt(j - 1);
                if (intFromLeftStr == intFromTopStr) {
                    valuesInArray[i][j] = valuesInArray[i - 1][j - 1] + 1;
                    transition[i][j] = 2;
                    continue;
                }
                if (valuesInArray[i - 1][j] >= valuesInArray[i][j - 1]) {
                    valuesInArray[i][j] = valuesInArray[i - 1][j];
                    transition[i][j] = 3;
                } else {
                    valuesInArray[i][j] = valuesInArray[i][j - 1];
                    transition[i][j] = 1;
                }
            }
        }
    }

    public String findLCS() {
        if (topStr == null) {
            throw new IllegalStateException
                    ("Cannot find LCS because strings cannot be null!");
        }
        StringBuilder longestCommonSubsequence = new StringBuilder();
        for (int i = transition.length - 1; i > 0; ) {
            for (int j = transition[i].length - 1; j > 0; ) {
                if (transition[i][j] == 3) {
                    path[i][j] = true;
                    i--;
                }
                if (transition[i][j] == 2) {
                    longestCommonSubsequence.append(topStr.charAt(j - 1));
                    path[i][j] = true;
                    i--;
                    j--;

                }
                if (transition[i][j] == 1) {
                    path[i][j] = true;
                    j--;
                }
                if (valuesInArray[i][j] == 0) {
                    i = 0;
                    j = 0;

                }
            }

        }
        longestCommonSubsequence.reverse();
        return longestCommonSubsequence.toString();
    }

    public void display() {
        if (topStr == null || leftStr == null) {
            throw new IllegalStateException
                    ("Cannot display! No Subsequence!");
        }
        int t, l = 0;
        char character;
        System.out.print("+");
        for (int j = 0; j < transition[0].length + 1; j++) {
            System.out.print(" - - - +");
        }
        System.out.println();
        System.out.println();
        System.out.print("|");
        for (int j = 0; j < transition[0].length + 1; j++) {
            System.out.print("       |");
        }
        System.out.println();
        System.out.print("                ");

        for (t = 0; t < transition[0].length - 1; t++) {
            character = topStr.charAt(t);
            if (character == '\n') {
                System.out.print("   " + "\\n" + "   ");
            } else if (character == '\t') {
                System.out.print("   " + "\\t" + "   ");
            } else if (character == '\b') {
                System.out.print("   " + "\\b" + "   ");
            } else if (character == '\r') {
                System.out.print("   " + "\\r" + "   ");
            } else if (character == '\f') {
                System.out.print("   " + "\\f" + "   ");
            } else {
                System.out.print("    " + character + "   ");
            }

        }
        System.out.println();

        System.out.print("|");
        for (int j = 0; j < transition[0].length + 1; j++) {
            System.out.print("       |");
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i < transition.length; i++) {

            System.out.print("+");
            for (int j = 0; j < transition[i].length + 1; j++) {
                System.out.print(" - - - +");
            }
            System.out.println();
            System.out.println();
            System.out.print("|       |");
            for (int j = 0; j < transition[i].length; j++) {

                if (transition[i][j] == 2) {
                    if (path[i][j]) {
                        System.out.print(" \\     |");
                    } else {
                        System.out.print("       |");
                    }


                } else if (transition[i][j] == 3) {
                    if (path[i][j]) {
                        System.out.print("   ^   |");
                    } else {
                        System.out.print("       |");
                    }

                } else {
                    System.out.print("       |");
                }

            }

            System.out.println();
            if (i == 0) {
                System.out.print("        ");
            }
            if (i > 0) {
                character = leftStr.charAt(l);
                if (character == '\n') {
                    System.out.print("   " + "\\n" + "   ");
                } else if (character == '\t') {
                    System.out.print("   " + "\\t" + "   ");
                } else if (character == '\b') {
                    System.out.print("   " + "\\b" + "   ");
                } else if (character == '\r') {
                    System.out.print("   " + "\\r" + "   ");
                } else if (character == '\f') {
                    System.out.print("   " + "\\f" + "   ");
                } else {
                    System.out.print("    " + character + "   ");
                }
                l++;
            }

            for (int j = 0; j < transition[i].length; j++) {
                if (transition[i][j] == 1) {
                    if (path[i][j]) {
                        System.out.print("  < " + valuesInArray[i][j] + "   ");
                        continue;
                    }
                }

                System.out.print("    " + valuesInArray[i][j] + "   ");


            }
            System.out.println();
            System.out.print("|");
            for (int j = 0; j < transition[i].length + 1; j++) {
                System.out.print("       |");
            }
            System.out.println();

            System.out.println();

        }
        System.out.print("+");
        for (int j = 0; j < transition[0].length + 1; j++) {
            System.out.print(" - - - +");
        }
        System.out.println();

    }
}
