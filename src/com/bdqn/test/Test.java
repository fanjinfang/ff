package com.bdqn.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Test {

	
	public static void main(String[] args) {
		
		// UTF-8 属于不定长字符编码
		InputStream in  = null;
		String path = "E:" + File.separator + "test.txt";
		
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
