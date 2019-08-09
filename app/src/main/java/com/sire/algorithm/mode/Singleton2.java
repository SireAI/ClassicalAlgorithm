package com.sire.algorithm.mode;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/06
 * Author:Sire
 * Description:2.多线线程环境
 * ==================================================
 */
public class Singleton2 {
  private static Singleton2 instance;

  private Singleton2() {}

  public static Singleton2 getInstance() {
    if (instance == null) {
      synchronized (Singleton2.class){
        if(instance == null){
          instance = new Singleton2();
        }
      }
    }
    return instance;
  }
}
