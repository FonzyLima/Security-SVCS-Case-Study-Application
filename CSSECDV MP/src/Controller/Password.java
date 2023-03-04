/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
/**
 *
 * @author user
 */
public class Password {
    
    public String hashPassword(String password){
        byte[] salt = new byte[16]; // generate a random salt
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            String encodedHash = Base64.getEncoder().encodeToString(hash);
            return encodedHash;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // handle any errors that might occur during hashing
            return null;
        }
    }
    
}
