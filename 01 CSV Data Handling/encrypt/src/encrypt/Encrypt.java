package encrypt;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.io.*;
public class Encrypt {
	private static final String key = "1234567890123456"; // 16-char AES key

    public static String encrypt(String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, k);
        return Base64.getEncoder().encodeToString(cipher.doFinal(str.getBytes()));
    }

    public static String decrypt(String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec k = new SecretKeySpec(key.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, k);
        return new String(cipher.doFinal(Base64.getDecoder().decode(str)));
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
             FileWriter writer = new FileWriter("encrypted_employees.csv")) {
            
            String header = br.readLine();
            writer.write(header + "\n");
            String line;
            while ((line = br.readLine()) != null) {
                String[] emp = line.split(",");
                emp[3] = encrypt(emp[3]); // encrypt salary
                writer.write(String.join(",", emp) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Encryption done. Decryption example:");
        try {
            System.out.println("Decrypted: " + decrypt(encrypt("70000")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
