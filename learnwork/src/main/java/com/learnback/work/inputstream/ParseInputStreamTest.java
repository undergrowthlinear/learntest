package com.learnback.work.inputstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ParseInputStreamTest {

	private static Executor executor;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// 初始化
		final String dir = "F:\\work\\project\\400_V_5_3\\文档\\维护\\yhzj\\";
		int num = 5;
		executor = Executors.newFixedThreadPool(num);

		final List<String> allPhone = loadPhoneList(dir + "all.txt");
		for (int i = 1; i <= num; i++) {
			final int curr = i;
			executor.execute(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						List<String> filterPhone = loadPhoneList(dir + curr + ".txt");
						final String tmpFile = dir + "output" + curr + ".txt";
						filterPhone(allPhone, filterPhone, tmpFile);
						System.out.println(Thread.currentThread().getName() + "\t总共" + allPhone.size() + "号码," + "待过滤的"
								+ filterPhone.size() + "号码");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	/*	List<String> filterPhone = loadPhoneList("F:\\work\\project\\400_V_5_3\\文档\\维护\\yhzj\\second.txt");
		System.out.println("总共" + allPhone.size() + "号码," + "待过滤的" + filterPhone.size() + "号码");
		String tmpFile = "F:\\work\\project\\400_V_5_3\\文档\\维护\\yhzj\\yhzjTmp.txt";
		// 过滤第一个文件
		filterPhone(allPhone, filterPhone, tmpFile);
		filterPhone = loadPhoneList("F:\\work\\project\\400_V_5_3\\文档\\维护\\yhzj\\first.txt");
		allPhone = loadPhoneList(tmpFile);
		System.out.println("总共" + allPhone.size() + "号码," + "待过滤的" + filterPhone.size() + "号码");
		String finalFile = "F:\\work\\project\\400_V_5_3\\文档\\维护\\yhzj\\yhzj.txt";
		// 过滤第二个文件
		filterPhone(allPhone, filterPhone, finalFile);
		// 最终的文件
		allPhone = loadPhoneList(finalFile);
		System.out.println("总共" + allPhone.size() + "号码");*/
	}

	/**
	 * 将过滤好的号码输出到文件中
	 * 
	 * @param resultPhone
	 * @throws IOException
	 */
	private static void writeFile(List<String> resultPhone, String fileName) throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		for (String string : resultPhone) {
			writer.write(string);
			writer.newLine();
		}
		writer.flush();
		writer.close();
	}

	/**
	 * 过滤电话号码
	 * 
	 * @param allPhone
	 * @param filterPhone
	 * @return
	 * @throws IOException
	 */
	private static void filterPhone(List<String> allPhone, List<String> filterPhone, String fileName)
			throws IOException {
		// TODO Auto-generated method stub
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		boolean flag = true;
		for (String all : allPhone) {
			for (String filter : filterPhone) {
				if (all.trim().equals(filter.trim())) {
					flag = false;
					break;
				}
			}
			if (flag) {
				writer.write(all);
				writer.newLine();
			}
			flag = true;
		}
		writer.flush();
		writer.close();
	}

	/**
	 * 加载号码
	 * 
	 * @param string
	 * @return
	 * @throws IOException
	 */
	private static List<String> loadPhoneList(String fileName) throws IOException {
		// TODO Auto-generated method stub
		List<String> phonesList = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String tmpString = null;
		while ((tmpString = reader.readLine()) != null) {
			phonesList.add(tmpString);
		}
		return phonesList;
	}

}
