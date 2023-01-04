package org.nwolfhub.messengermessages.crypto;


import org.nwolfhub.messengermessages.crypto.model.Key;
import org.nwolfhub.shared.Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;

public class CryptoController {
    public static HashMap<String, String> awaiting = new HashMap<>();

    /**
     * acceptKey is called to
     * @param keyString
     * @return
     * @throws Exception when key fails tp
     */
    public static byte[] acceptKey(String keyString) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        PublicKey key = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(keyString)));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String text = Utils.generateString(100);
        awaiting.put(keyString, text);
        byte[] encodedText = cipher.doFinal(text.getBytes());
        return encodedText;
    }

    /**
     * verifyKey method is called to verify that user has provided the key that he has access to
     * @param key
     * @param text
     * @return null if key fails to verify or key without owner if success
     */
    public static Key verifyKey(String key, String text) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if(awaiting.get(key).equals(text)) {
            Key accepted = new Key();
            PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.getDecoder().decode(key)));
            accepted.setKey(publicKey);
            return accepted;
        } else return null;
    }
}
