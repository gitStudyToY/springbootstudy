package com.example.demo.domain;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 定义Task类，创建三个处理函数分别模拟三个执行任务的操作，操作消耗时间随机取（10秒内）
 */
@Component
public class Task {

    public static Random random = new Random();

    /**
     * 此时可以反复执行单元测试，您可能会遇到各种不同的结果，比如：
     没有任何任务相关的输出
     有部分任务相关的输出
     乱序的任务相关的输出
     原因是目前doTaskOne、doTaskTwo、doTaskThree三个函数的时候已经是异步执行了。主程序在异步调用之后，主程序并不会理会这三个函数是否执行完成了，
     由于没有其他需要执行的内容，所以程序就自动结束了，导致了不完整或是没有输出任务相关内容的情况。
     * @throws Exception
     */
    @Async   //@Async注解就能简单的将原来的同步函数变为异步函数     @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
    public void doTaskOne() throws Exception{
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒" );
    }

    @Async
    public void doTaskTwo() throws Exception{
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒" );
    }

    @Async
    public void doTaskThree() throws Exception{
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒" );
    }

} 