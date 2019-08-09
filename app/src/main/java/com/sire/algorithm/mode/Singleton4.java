package com.sire.algorithm.mode;

/**
 * ==================================================
 * All Right Reserved
 * Date:2019/08/06
 * Author:Sire
 * Description:2.多线程安全懒加载
 * ==================================================
 */
public class Singleton4 {

  private Singleton4() {}

  public static Singleton4 getInstance() {
    return HOLDER.instance;
  }
  private static class HOLDER{
    private static Singleton4 instance = new Singleton4();
  }
}
