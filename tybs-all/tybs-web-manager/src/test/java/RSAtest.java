import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * create by Lfm
 * on 2018-05-14 15:54
 */
public class RSAtest {
    public static void main(String[] args) throws Exception {
//        // TODO Auto-generated method stub
        HashMap<String, Object> map = RSAUtils.getKeys();
        //生成公钥和私钥
        RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
        RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
        //模
        String modulus = publicKey.getModulus().toString();
        //公钥指数
        String public_exponent = publicKey.getPublicExponent().toString();
        //私钥指数
        String private_exponent = privateKey.getPrivateExponent().toString();
        //明文
        String ming = Md5Util.encodeByMd5("123456");
        System.out.println("加签："+ming);

        //使用模和指数生成公钥和私钥
        RSAPublicKey pubKey = RSAUtils.getPublicKey(modulus, public_exponent);
        System.out.println("pubKey:"+pubKey);
        RSAPrivateKey priKey = RSAUtils.getPrivateKey(modulus, private_exponent);
        System.out.println("priKey:"+priKey);
        //加密后的密文
        String mi = RSAUtils.encryptByPublicKey(ming, pubKey);
        System.err.println("加密后的密文:"+mi+"---------------"+mi.length()+"------");
        //解密后的明文
        ming = RSAUtils.decryptByPrivateKey(mi, priKey);
        System.err.println("解密后的明文:"+ming);

        System.out.println(ming.equals(RSAUtils.decryptByPrivateKey(mi, priKey)));
    }
}
