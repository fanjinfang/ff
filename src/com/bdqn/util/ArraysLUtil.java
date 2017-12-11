package com.bdqn.util;

public class ArraysLUtil {

	
	
	
	public static char[] changeByte(char[] chars) {
		if(chars == null)
			return null;
		int index = -1;
		for(int i = 0; i < chars.length; i++) {
			if(chars[i] == '\u0000') {
				index = i;
				break;
			}
		}
		char[] b = new char[index];
		for(int i = 0; i < index; i++) {
			b[i] = chars[i];
		}
		return b;
	}
	
	
	public static byte[] changeByte(byte[] bs) {
		if(bs == null)
			return null;
		int index = -1;
		for(int i = 0; i < bs.length; i++) {
			if(bs[i] == 0) {
				index = i;
				break;
			}
		}
		if(index == -1) 
			return bs;
		byte[] b = new byte[index];
		for(int i = 0; i < index; i++) {
			b[i] = bs[i];
		}
		return b;
	}
}
