package com.sire.algorithm.mode;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/06
 * Author:Sire
 * Description:2.单线程环境
 * ==================================================
 */
public class Singleton1 {
  private static Singleton1 instance;

  private Singleton1() {}

  public static Singleton1 getInstance() {
    if (instance == null) {
      instance = new Singleton1();
    }
    return instance;
  }
}
