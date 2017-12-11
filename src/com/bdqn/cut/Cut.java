package com.bdqn.cut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.bdqn.util.ArraysLUtil;
import com.bdqn.util.IOUtil;

public class Cut {

	public static void main(String[] args) {
		// 切割文件
		InputStream in = null;
		OutputStream out = null;
		String path = "E:" + File.separator + "testfile" 
				+ File.separator + "射雕英雄传.txt";
		// 81093  811 = 81100 7 
		
		// 预处理
		path = prepareHandle(path);
		
		try {
			in = new FileInputStream(path);
			 
			int totalWords = in.available();
			int loopCount = 100;
			// 既要能尽量平均分，同时还要保障它是6的倍数。
			int average = totalWords % loopCount == 0 ? totalWords / loopCount :
								totalWords / loopCount + 1;
			int lastWordCount = totalWords % loopCount == 0 ?  
					loopCount : (100 -(average * loopCount - totalWords));
			if(average % 6 != 0) {
				//13 
				int temp = average % 6;
				average += 6-temp;
				loopCount = totalWords % average == 0 ?
						totalWords / average : totalWords / average + 1;
				// 重新计算lastWordCount
				lastWordCount = totalWords % loopCount == 0 ?  
						loopCount : (average -(average * loopCount - totalWords));
			}
			int count = 0;
			byte[] bs = new byte[average];
			int result = -2;
			while((result = in.read(bs)) != -1) {
				count++;
				String targetPath = "E:" + File.separator + "testfile"
							+ File.separator + count + ".txt";
				out = new FileOutputStream(targetPath);
				if(count == loopCount) {
					bs = ArraysLUtil.changeByte(bs);
					out.write(bs);
				}
				out.write(bs);
			}
			 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(in, null);
		}
		
	}

	
	private static String prepareHandle(String path) {
		InputStream in = null;
		OutputStream out = null;
		// / . //  ming + copy
//		String path2 = path.substring(beginIndex, endIndex)
		// 写业务 都简单，啰嗦
		
//		in = new FileInputStream(path);
		
		return null;
	}
}








