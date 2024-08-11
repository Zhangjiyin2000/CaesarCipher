
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shiftedAlphabetUpper = alphabet.substring(key) + alphabet.substring(0, key);
        String shiftedAlphabetLower = shiftedAlphabetUpper.toLowerCase();
        StringBuilder encrypted = new StringBuilder(input);
        String inputUpper = input.toUpperCase();
        for (int i = 0; i < input.length(); i++) {
            char currChar = inputUpper.charAt(i);
            int idx = alphabet.indexOf(currChar);
            if (idx != -1) {
                if(input.charAt(i) > 'A' && input.charAt(i) < 'Z') {
                    char newChar = shiftedAlphabetUpper.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                } else if (input.charAt(i) > 'a' && input.charAt(i) < 'z') {
                    char newChar = shiftedAlphabetLower.charAt(idx);
                    encrypted.setCharAt(i, newChar);
                }
                
            }
            
            
        }
        return encrypted.toString();
    }
    
    void testEncrypt() {
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));
    }
    
    void testCaesar() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String encrypted = encrypt(message, key);
        //System.out.println("key is " + key + "\n" + encrypted);
    }
    
    String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder encrypted = new StringBuilder(input);
        String encrypted1 = encrypt(input, key1);
        String encrypted2 = encrypt(input, key2);
        for (int i = 0; i < input.length(); i++) {
            if (i % 2 == 0) {
                encrypted.setCharAt(i, encrypted1.charAt(i));
            } else {
                encrypted.setCharAt(i, encrypted2.charAt(i));
            }
        }
        return encrypted.toString();
    }
    
    void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("First Legion", 23, 17) );
    }

}
