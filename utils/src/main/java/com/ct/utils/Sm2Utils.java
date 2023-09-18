package com.ct.utils;


import com.antherd.smcrypto.sm2.Keypair;
import com.antherd.smcrypto.sm2.Sm2;

public class Sm2Utils {

    public static void test() {
        Keypair keypair = Sm2.generateKeyPairHex();
        String privateKey = keypair.getPrivateKey();
        String publicKey = "04298364ec840088475eae92a591e01284d1abefcda348b47eb324bb521bb03b0b2a5bc393f6b71dabb8f15c99a0050818b56b23f31743b93df9cf8948f15ddb54";//keypair.getPublicKey();
        System.out.println("公钥:" + publicKey);
        System.out.println("私钥:" + privateKey);
        String data = encodeM2(publicKey,"123456");
        System.out.println("加密数据:" + data );
        System.out.println("解密数据:" + Sm2.doDecrypt(data, privateKey));
    }

    public static String encodeM2(String publicKeyStr, String data) {

        String encryptData = Sm2.doEncrypt(data, publicKeyStr);
        return encryptData;
    }


}
