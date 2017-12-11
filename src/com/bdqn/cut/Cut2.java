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
import java.io.OutputStreamWriter;

import com.bdqn.util.ArraysLUtil;
import com.bdqn.util.IOUtil;

public class Cut2 {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// 切割文件
		BufferedReader br = null;
		BufferedWriter bw = null;
		String path = "E:" + File.separator + "testfile" 
				+ File.separator + "射雕英雄传.txt";
		int piece  = 100;
		// 先写个东西 能跑， 不管多烂 多好
		// 读取， 为了得到行数
		
		
		try {
			br = new BufferedReader(
						new InputStreamReader(
								new FileInputStream(path)));
			String result = "";
			int lineCount = 0;
			while((result = br.readLine()) != null) {
				lineCount++;
			}
			System.out.println(lineCount + "总行");
			
			int average = lineCount % piece == 0 ? 
							lineCount / piece : lineCount / piece + 1;
			System.out.println(average + "平均行");
			
			// 重算piece
			piece = lineCount % average == 0 ?
					lineCount / average : lineCount / average + 1;
			
			
			
			int lastLineCount =  lineCount % piece == 0 ? 
									average : average - ((piece * average - lineCount));
//			System.out.println(lastLineCount +  "最后一次行数");
			int count = 0;
			int readNum = 0;
			
			br = new BufferedReader(
					new InputStreamReader(
							new FileInputStream(path)));
			
			while((result = br.readLine()) != null ) {
				System.out.println("asdasdd");
				
				if(count == piece) {
					// 最后一次
					
				}
				// 
				if(readNum % average == 0) {
					count ++;
					String targetPath = "E:" + File.separator + 
							"testfile" + File.separator + count + ".txt";
					bw = new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(targetPath)));
				}
				
				bw.write(result);
				bw.newLine();
				readNum++;
				bw.flush();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtil.close(br, bw);
		}
		
		
		
	}

	
 
}








