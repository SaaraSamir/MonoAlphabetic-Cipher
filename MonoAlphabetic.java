
package monoalphabetic;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner; 

public class MonoAlphabetic {
    static char[] keys = {'q','z','j','m','c','h','y','k','t','v','f','i','a','l','p','r','g','o','w',
        'd','u','x','e','s','n','b'};
    static char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String plainText = "abdelghany";
        System.out.println(alphabet);
        System.out.println(keys);
        System.out.println();
        System.out.println(plainText);
        System.out.println(encrypt(plainText));
        System.out.println();
        System.out.println(decrypt("qzmciykqln"));   
         File encryption_file = new File("example_encrypt.txt");
        try {
            encryptfile(encryption_file);

        } catch (Exception e) {
            System.out.println(e);
        }
        //Test decrypt file method
        File decryption_file = new File("example_decrypt.txt");
        try {
            decryptfile(decryption_file);

        } catch (Exception e) {
            System.out.println(e);
        }
        

    }
    static String encrypt(String plainText) {
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] == plainText.charAt(i)) {
                    encryptedText += keys[j];
                }
            }
        }
        return encryptedText;
    }

    static String decrypt(String cipherText) {
        String decryptedText = "";
        for (int i = 0; i < cipherText.length(); i++) {
            for (int j = 0; j < keys.length; j++) {
                if (keys[j] == cipherText.charAt(i)) {
                    decryptedText += alphabet[j];
                }
            }
        }
        return decryptedText;
    }
    static void encryptfile(File plainTextFile) throws IOException {

        Scanner scanner = new Scanner(plainTextFile);

        File output = new File("encrypt.txt");
        PrintWriter pw = new PrintWriter(output);

        while (scanner.hasNext()) {
            pw.println(encrypt(scanner.nextLine()));
        }

        pw.flush();
        pw.close();
    }

    static void decryptfile(File cipherTextFile) throws IOException {

        Scanner input = new Scanner(cipherTextFile);

        File output = new File("decrypt.txt");
        PrintWriter pw = new PrintWriter(output);

        while (input.hasNext()) {
            pw.println(decrypt(input.nextLine()));
        }

        pw.flush();
        pw.close();
    }
}
