package pe.gob.regionica.indicadores.rest.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class RestMD5 {

	public static String getMD5(String input) {
        byte[] source;
        try {
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7','8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        
        try {
			MessageDigest md = MessageDigest.getInstance(RestConstants.AlgoritmoCrypt);
			md.update(source);
			byte temp[] = md.digest();
			char str[] = new char[16 * 2];
			int k = 0;
			for (int i = 0; i < 16; i++) {
				byte byte0 = temp[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			result = new String(str);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
        return result;
	}
}
