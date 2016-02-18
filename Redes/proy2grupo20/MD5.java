import java.security.*;
import java.math.*;
 
public class MD5 {
    public static String md5(String s) throws Exception{
       	MessageDigest m=MessageDigest.getInstance("MD5");
       	m.update(s.getBytes(),0,s.length());
	String ans = new BigInteger(1,m.digest()).toString(16);
	return ans;
   }
}

