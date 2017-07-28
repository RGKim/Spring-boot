package br.com.t4k.user.util;

public class SiteUtils {
	
	public static Long checkBlankOrNullToZero(String num){
		if(num.isEmpty()){
			return 0L;
		}
		return Long.valueOf(num);
	}

}
