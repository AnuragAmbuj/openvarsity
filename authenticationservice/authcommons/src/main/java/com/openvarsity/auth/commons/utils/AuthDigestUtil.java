package com.openvarsity.auth.commons.utils;

import com.openvarsity.auth.commons.exception.FatalCryptError;
import com.openvarsity.auth.commons.model.Token;
import com.openvarsity.auth.commons.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class AuthDigestUtil {

    //For NOW, this will be moved to key management service
    private static final SecretKey SECRET_KEY = generateSecretKey();
    private static final IvParameterSpec INIT_VECTOR = getInitializationVector();
    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    private static IvParameterSpec getInitializationVector() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    private static SecretKey generateSecretKey() {
        try {
            CommonsKeySpec keySpec = KeySpecFactory.getKeySpec();
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(keySpec.getSecret().toCharArray(), keySpec.getSalt().getBytes(), 65536, 256);
            return new SecretKeySpec(factory.generateSecret(spec)
                    .getEncoded(), "AES");
        } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
            throw new FatalCryptError("Fatal Key/Algorithm Error");
        }
    }



    public static String digest(String content){
        byte[] digestBytes = DigestUtils.getMd5Digest().digest(content.getBytes());
        return new String(digestBytes);
    }

    public static String createToken(User user){
        Token token = new Token();
        token.setUserIdClaim(user.getUserId());
        token.setDateClaim(user.getUpdatedOn());
        try {
            return encrypt(token.toString());
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidAlgorithmParameterException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
            throw new FatalCryptError(e);
        }
    }

    public static String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY, INIT_VECTOR);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    public static String decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {

        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY, INIT_VECTOR);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        return new String(plainText);
    }
}
