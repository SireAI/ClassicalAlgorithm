package com.sire.algorithm.mode;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/06
 * Author:Sire
 * Description:2.预加载方式
 * ==================================================
 */
public class Singleton3 {
  private static Singleton3 instance = new Singleton3();

  private Singleton3() {}

  public static Singleton3 getInstance() {
    return instance;
  }
}
