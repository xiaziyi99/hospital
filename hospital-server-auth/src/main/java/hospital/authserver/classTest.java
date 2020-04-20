package hospital.authserver;
import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;
public class classTest {
    @Test
    public void Test1() throws Exception {
        ConfigTools configTools = new ConfigTools();
        String password = "1234";
        String[] arr = configTools.genKeyPair(512);
        System.out.println("private_Key="+arr[0]);
        System.out.println("public_value="+arr[1]);
        //私钥加密
        String encryptpassword=configTools.encrypt(arr[0],password);
        System.out.println("加密后的password:"+encryptpassword);
        //公钥解密
        System.out.println("解密后:"+configTools.decrypt(arr[1],encryptpassword));
    }
}
