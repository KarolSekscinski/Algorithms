package pl.edu.pw.ee;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class Huffman {

    private int[] asciiTable;

    private HuffmanNode nodeTree;

    private byte[] bytes;

    private String path = "/file.txt";


    private HashMap<Character, String> hashMapOfTree = new HashMap<>();

    private HashMap<String, Character> hashMapOfCodes = new HashMap<>();

    public int huffman(String pathToRootDir, boolean compress) throws IOException {

        path = pathToRootDir + path;
        int num = 0;
        if (compress) {
            asciiTable = countCharacters(path);

            nodeTree = pQueue(asciiTable);

            bytes = changeStringIntoBits(encodeString(path));

            num = encodeFile(path, bytes, false);

            bytes = encodeTreeToString(nodeTree);

            encodeFile(path, bytes, true);

        }
        if (!compress) {
            bytes = decodeFile(path, false);

            String file = decodeStringFromFile(bytes);

            bytes = decodeFile(path, true);

            String tree = decodeStringFromFile(bytes);

            nodeTree = creatingTreeFromFile(tree);

            num = writeToDecodedFile(file);

        }
        return num;
    }


    private int writeToDecodedFile(String text) throws IOException {
        String temp = "";
        int charsInFile = 0;
        try (FileWriter fileWriter = new FileWriter(path); PrintWriter printWriter = new PrintWriter(fileWriter)) {
            char singleChar, charToWrite;

            for (int i = 0; i < text.length(); i++) {
                singleChar = text.charAt(i);
                temp = temp + singleChar;
                if (hashMapOfCodes.get(temp) != null) {
                    charToWrite = hashMapOfCodes.get(temp);
                    printWriter.print(charToWrite);
                    charsInFile++;
                    temp = "";
                }

            }

        } catch (IOException e) {
            throw new IOException("[Error] An error ocurred during decoding file.");
        }
        return charsInFile;
    }

    private HuffmanNode creatingTreeFromFile(String dataFromFile) {
        HuffmanNode root = null;
        if (dataFromFile.charAt(0) == '0') {
            root = new HuffmanNode();
            root.parent = null;
        }
        if (dataFromFile.charAt(0) == '1') {
            String subStringForChars = dataFromFile.substring(1);
            int character = Integer.parseInt(subStringForChars, 2);
            char singleChar = (char) character;

            root = new HuffmanNode(0, singleChar);
            root.parent = null;
            printCharsFromCode(root, "0");
            return root;
        }
        for (int i = 1; i < dataFromFile.length(); i++) {

            char character = dataFromFile.charAt(i);

            if (character == '0') {
                if (root.leftNode == null && root.rightNode == null) {
                    HuffmanNode nodeLeft = new HuffmanNode();
                    nodeLeft.parent = root;
                    root.leftNode = nodeLeft;
                    root = nodeLeft;
                    continue;
                }
                if (root.leftNode != null && root.rightNode == null) {
                    HuffmanNode nodeRight = new HuffmanNode();
                    nodeRight.parent = root;
                    root.rightNode = nodeRight;
                    root = nodeRight;
                }
            }
            if (character == '1') {
                String subStringForChars = dataFromFile.substring(i + 1, i + 9);
                i += 8;
                int characterForLeaf = Integer.parseInt(subStringForChars, 2);
                char singleCharOfLeaf = (char) characterForLeaf;
                HuffmanNode leaf = new HuffmanNode(0, singleCharOfLeaf);

                if (root.leftNode == null && root.rightNode == null) {
                    leaf.parent = root;
                    root.leftNode = leaf;
                    continue;
                }
                if (root.leftNode != null && root.rightNode == null) {
                    leaf.parent = root;
                    root.rightNode = leaf;

                    while (root.parent != null && root.parent.leftNode != null && root.parent.rightNode != null) {
                        root = root.parent;
                    }
                    if (root.parent != null) {
                        root = root.parent;
                    } else {
                        break;
                    }

                }
            }
        }
        while (root.parent != null) {

            root = root.parent;
        }

        printCharsFromCode(root, "");

        return root;
    }


    private String decodeStringFromFile(byte[] arrayOfBitesFromFile) {

        String substring;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < arrayOfBitesFromFile.length; i++) {
            temp.append(String.format("%8s", Integer.toBinaryString(arrayOfBitesFromFile[i] & 0xFF)).replace(' ', '0'));
        }
        String numOfNotUsedBits = temp.substring(0, 3);
        int numberOfNotUsedBits = Integer.parseInt(numOfNotUsedBits, 2);
        if (numberOfNotUsedBits == 3) {
            substring = temp.substring(3);
            return substring;
        }

        substring = temp.substring(3, temp.length() - numberOfNotUsedBits + 3);

        return substring;
    }

    private byte[] decodeFile(String pathToRootDir, boolean tree) throws IOException {
        pathToRootDir = pathToRootDir.substring(0, pathToRootDir.length() - 4);
        if (tree) {
            pathToRootDir = pathToRootDir + ".tr3";
        } else {
            pathToRootDir = pathToRootDir + ".ctf";
        }
        File file = new File(pathToRootDir);

        byte[] decodedFile = new byte[(int) file.length()];
        try (FileInputStream fileInputStream = new FileInputStream(file)) {

            fileInputStream.read(decodedFile);

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Empty file!");
        } catch (IOException e) {
            throw new IOException("[Error] An error ocurred during decoding file.");
        }
        return decodedFile;
    }


    private void printCode(HuffmanNode root, String s) {
        if (root.leftNode == null && root.rightNode == null && Character.isDefined(root.character)) {
            hashMapOfTree.put(root.character, s);
            root.code = s;
            return;
        }
        if (root.leftNode != null) {
            printCode(root.leftNode, s + "0");
        } else {
            throw new NoSuchElementException("[Error encoding] leftNode of root is empty!");
        }
        if (root.rightNode != null) {
            printCode(root.rightNode, s + "1");
        } else {
            throw new NoSuchElementException("[Error encoding] rightNode of root is empty!");
        }


    }

    private void printCharsFromCode(HuffmanNode root, String s) {

        if (root.leftNode == null && root.rightNode == null && Character.isDefined(root.character)) {

            hashMapOfCodes.put(s, root.character);

            root.code = s;

            return;
        }
        if (root.leftNode != null) {
            printCharsFromCode(root.leftNode, s + "0");
        } else {
            throw new NoSuchElementException("[Error decoding] leftNode of root is empty!");
        }
        if (root.rightNode != null) {
            printCharsFromCode(root.rightNode, s + "1");
        } else {
            throw new NoSuchElementException("[Error decoding] rightNode of root is empty!");
        }


    }

    private String formatTraversation(HuffmanNode node) {
        String temp = "";
        if (node.leftNode == null && node.rightNode == null && Character.isDefined(node.character)) {
            int numberOfBitsToByte = 8 - Integer.toBinaryString(node.character).length();
            temp += "1";
            for (int i = 0; i < numberOfBitsToByte; i++) {
                temp += "0";
            }
            temp += Integer.toBinaryString(node.character);
        } else {
            temp += "0";
        }

        return temp;

    }

    private String getPreOrder(HuffmanNode head, String result) {
        if (head != null) {
            result += formatTraversation(head);
            result = getPreOrder(head.leftNode, result);
            result = getPreOrder(head.rightNode, result);
        }

        return result;
    }

    private String getPreOrder(HuffmanNode root) {
        String result = "";
        result = getPreOrder(root, result);
        result = result.trim();
        return result;
    }

    private byte[] encodeTreeToString(HuffmanNode node) {
        StringBuilder tree = new StringBuilder(getPreOrder(node));
        byte[] arrayOfBits = changeStringIntoBits(tree);
        return arrayOfBits;
    }

    private int encodeFile(String pathToRootDir, byte[] encodedFile, boolean tree) throws IOException {
        pathToRootDir = pathToRootDir.substring(0, pathToRootDir.length() - 4);

        if (tree) {
            pathToRootDir = pathToRootDir + ".tr3";
        } else {
            pathToRootDir = pathToRootDir + ".ctf";
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(pathToRootDir);
            outputStream.write(encodedFile);
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("[Error] An error ocurred during encoding file.");
        } catch (IOException e) {
            throw new IOException("[Error] An error ocurred during writing to file or closing file.");
        }

        return 8 * encodedFile.length;
    }

    private StringBuilder encodeString(String pathToRootDir) throws IOException {
        StringBuilder temp = new StringBuilder();
        try (FileReader fileReader = new FileReader(pathToRootDir); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int singleChar;
            while ((singleChar = bufferedReader.read()) != -1) {
                char c = (char) singleChar;
                temp.append(hashMapOfTree.get(c));
            }

        } catch (IOException e) {
            throw new IOException("[Error] An error ocurred during encoding file.");

        }
        return temp;
    }

    private byte[] changeStringIntoBits(StringBuilder temp) {
        StringBuilder numOfNotUsedBits = new StringBuilder();
        if (temp.length() % 8 != 0) {
            numOfNotUsedBits = new StringBuilder(Integer.toBinaryString(8 - temp.length() % 8));
        }
        if (temp.length() % 8 == 0) {
            numOfNotUsedBits = new StringBuilder("000");
        }

        while (numOfNotUsedBits.length() < 3) {
            numOfNotUsedBits.insert(0, "0");

        }
        temp.insert(0, numOfNotUsedBits);

        while (temp.length() % 8 != 0) {
            temp.append("0");
        }
        int lengthOfArray = temp.length() / 8;
        byte[] arrayOfBytesToCode = new byte[lengthOfArray];
        for (int i = 0; i < temp.length(); i += 8) {
            String substring = temp.substring(i, i + 8);
            int a = Integer.parseInt(substring, 2);
            arrayOfBytesToCode[i / 8] = (byte) a;

        }
        return arrayOfBytesToCode;
    }

    private HuffmanNode pQueue(int[] asciiTable) {
        ArrayList<HuffmanNode> queue = new ArrayList<>();
        for (int i = 0; i < asciiTable.length; i++) {
            if (asciiTable[i] != 0) {
                HuffmanNode node = new HuffmanNode(asciiTable[i], (char) i);
                queue.add(node);
            }
        }
        Collections.sort(queue);
        HuffmanNode root = null;
        if (queue.size() == 1) {
            root = queue.get(0);
            printCode(root, "0");
            return root;
        }

        while (queue.size() > 1) {
            HuffmanNode firstNode = queue.remove(0);

            HuffmanNode secondNode = queue.remove(0);

            HuffmanNode parentNode = new HuffmanNode();

            parentNode.numOfCharacters = firstNode.numOfCharacters + secondNode.numOfCharacters;

            parentNode.leftNode = firstNode;

            parentNode.rightNode = secondNode;
            root = parentNode;
            queue.add(parentNode);
            Collections.sort(queue);
        }
        printCode(root, "");
        return root;
    }

    private int[] countCharacters(String pathToRootDir) throws IOException {

        int[] asciiTable = new int[256];
        try (FileReader fileReader = new FileReader(pathToRootDir); BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            int i;

            while ((i = bufferedReader.read()) != -1) {

                if (i > 127) {
                    throw new IllegalArgumentException("You cannot compress non-ascii chars!");
                }
                asciiTable[i]++;

            }
            int value = 0;
            for (int j = 0; j < asciiTable.length; j++) {
                value += asciiTable[j];
            }
            if (value == 0) {
                throw new IllegalArgumentException("File is empty!");
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("[Error] An error ocurred during reading file. File not found!");
        } catch (IOException e) {
            throw new IOException("[Error] An error ocurred during reading file.");
        }

        return asciiTable;
    }

    private class HuffmanNode implements Comparable<HuffmanNode> {
        private int numOfCharacters;
        private char character;
        private String code;
        private HuffmanNode leftNode, rightNode;
        private HuffmanNode parent;

        public HuffmanNode(int freq, int asciiValue) {
            this.character = (char) asciiValue;
            this.numOfCharacters = freq;
        }

        public HuffmanNode() {
        }

        public int compareTo(HuffmanNode node) {
            return this.numOfCharacters - node.numOfCharacters;
        }

    }


}
