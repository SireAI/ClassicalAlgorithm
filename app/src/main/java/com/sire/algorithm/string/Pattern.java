package com.sire.algorithm.string;

import com.sire.algorithm.IAlgorithm;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/25
 * Author:Sire
 * Description:正则表达式中，最重要的就是通配符，通配
 * 符结合在一起，可以表达非常丰富的语义。为了方便讲解，我假设
 * 正则表达式中只包含“*”和“?”这两种通配符，并且对这两个通配符的
 * 语义稍微做些改变，其中，“*”匹配任意多个（大于等于 0 个）任意字
 * 符，“?”匹配零个或者一个任意字符。基于以上背景假设，我们看下，如何用回
 * 溯算法，判断一个给定的文本，能否跟给定的正则表达式匹配
 * ==================================================
 */
public class Pattern implements IAlgorithm {

    private final char[] patterns;
    private boolean matched = false;

    public Pattern(String pattern) {
        patterns = pattern.toCharArray();
    }

    @Override
    public void go() {

    }

    public boolean match(String texts) {
        matched = false;
        rematch(0, 0, texts.toCharArray());
        return matched;
    }


    /**
     * 按照每个正则表达式字符来分阶段
     * 终止条件
     *
     * @param pi
     * @param ti
     * @param texts
     */
    public void rematch(int pi, int ti, char[] texts) {
        //已经匹配
        if (matched) {
            return;
        }
        //正则表达式走到末尾
        if (pi == patterns.length) {
            //字符也走到末尾，则匹配
            if (ti == texts.length) {
                matched = true;
            }
            return;
        }
        //集中字符的回溯处理
        if (patterns[pi] == '*') {
            //当前*匹配0，1，2，3...个字符
            for (int i = ti; i < texts.length; i++) {
                rematch(pi + 1, i, texts);
            }
        } else if (patterns[pi] == '?') {
            //匹配0个
            rematch(pi + 1, ti, texts);
            //匹配一个
            rematch(pi + 1, ti + 1, texts);
        } else //字符对应匹配
            if (pi < patterns.length && ti < texts.length && patterns[pi] == texts[ti]) {
                rematch(pi + 1, ti + 1, texts);
            }
    }

}
