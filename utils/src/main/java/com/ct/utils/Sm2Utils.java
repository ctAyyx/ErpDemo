package com.ct.utils;


import android.util.Base64;
import com.ct.utils.crypt.HexUtils;
import com.ct.utils.crypt.SM2Utils;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Sm2Utils {

    public static String encrypt() {
        try {
            String publicKey = "04298364ec840088475eae92a591e01284d1abefcda348b47eb324bb521bb03b0b2a5bc393f6b71dabb8f15c99a0050818b56b23f31743b93df9cf8948f15ddb54";//keypair.getPublicKey();
            byte[] publicBytes = HexUtils.decodeHex(publicKey.toCharArray());
            byte[] cipherBytes = SM2Utils.encrypt(publicBytes, "123456".getBytes());
            // return HexUtils.encodeHexStr(cipherBytes);
          return new String(cipherBytes);
           //return Base64.encodeToString(cipherBytes, Base64.NO_WRAP);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }



}
