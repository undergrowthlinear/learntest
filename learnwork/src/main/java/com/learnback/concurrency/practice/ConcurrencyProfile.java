/*   
* Copyright (c) 2016 by WuZhang 
*             All rights reserved                         
*/
package com.learnback.concurrency.practice;

/**
* @Description: TODO(
* 用于Java Concurrency in Practice的简介---->
* 每个线程拥有自己的栈、局部变量、程序计数器,共享进程中堆上的共享变量
* 3-4-3
* 3----并发的来源----提升资源的利用率、提升模块的公平性、提高任务交互的便利性
* 4----线程的优势----利用多核处理器、建模的简化、异步执行的简化、灵敏度的提高
* 3----线程的问题----
* 	安全性(永远不让糟糕的事情发生----多线程访问共享数据,执行的顺序问题)、
* 	活跃性(正确的事情最终要发生----死锁、饥饿)、
* 	性能(尽快的执行----线程上下文的切换、cpu资源的消耗)
* )
* @Author <a href="zhangwu@wxchina.coom">Wu.Zhang</a>
* @Date 2016年3月15日
* @Version 1.0.0
*/
public class ConcurrencyProfile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Java Concurrency in Practice");
	}

}
