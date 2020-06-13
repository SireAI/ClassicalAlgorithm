package com.sire.algorithm.tree;

import com.sire.algorithm.IAlgorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/04
 * Author:Sire
 * Description:字典树实现，字符集范围a~z
 * 经典实用场景：字符串前缀匹配，自动提示补全
 * 固定字符串组的提示是常用的场景
 * ==================================================
 */
public class TrieTree implements IAlgorithm {

    /**
     * 根节点
     */
    private TrieNode root = new TrieNode('/');

    @Override
    public void go() {
        TrieTree trieTree = new TrieTree();
        String[] strings = {"hello", "hellofsadfsa", "hellofsad", "he", "hellovvv", "helloeee"};
        for (int i = 0; i < strings.length; i++) {
            trieTree.insert(strings[i]);
        }
//        for (int i = 0; i < strings.length; i++) {
//            boolean contain = trieTree.contain(strings[i]);
//            System.out.println(strings[i]+":"+contain);
//        }

        List<String> matches = trieTree.findPrefixMatch("helloe");
        Collections.sort(matches);
        for (int i = 0; i < matches.size(); i++) {
            System.out.println(matches.get(i));
        }
    }

    /**
     * 插入字符操作
     *
     * @param text
     */
    public void insert(String text) {
        if (text == null || text.isEmpty()) {
            return;
        }
        char[] texts = text.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < texts.length; i++) {
            //ASCLL码转换索引转换
            char pathChar = texts[i];
            int index = pathChar - 'a';
            if (p.childrens()[index] == null) {
                //无该字符节点
                p.childrens()[index] = new TrieNode(pathChar);
            }
            p = p.childrens()[index];
        }
        p.isEndNode = true;
    }

    /**
     * 查找操作
     *
     * @param pattern
     * @return
     */
    public boolean contain(String pattern) {
        if (pattern == null || pattern.isEmpty()) {
            return false;
        }
        TrieNode p = root;
        char[] patterns = pattern.toCharArray();
        for (int i = 0; i < patterns.length; i++) {
            char pathChar = patterns[i];
            int index = pathChar - 'a';
            if (p.childrens()[index] == null) {
                return false;
            }
            p = p.childrens()[index];
        }
        return p.isEndNode;
    }

    /**
     * 获取前缀匹配的字符集合
     *
     * @param prefix
     * @return
     */
    public List<String> findPrefixMatch(String prefix) {
        List<String> matchedString = new ArrayList<>();
        if (prefix == null || prefix.isEmpty()) {
            return matchedString;
        }
        //确认是否包含前缀
        char[] prefixes = prefix.toCharArray();
        TrieNode p = root;
        for (int i = 0; i < prefixes.length; i++) {
            char patchChar = prefixes[i];
            int index = patchChar - 'a';
            if (p.childrens()[index] == null) {
                //若前缀不匹配直接返回
                return matchedString;
            }
            p = p.childrens()[index];
        }
        //遍历该节点的各个子节点存储的所有字符串
        for (int i = 0; i < p.children.length; i++) {
            if (p.childrens()[i] != null) {
                String pathChar = prefix + p.childrens()[i].data;
                decodeStrings(p.childrens()[i], matchedString, pathChar);
            }
        }

        return matchedString;
    }

    /**
     * 获取某个字符串
     * 回溯算法，按照节点分成多个阶段
     *
     * @param root
     * @param matchedString
     * @param pathChar
     */
    private void decodeStrings(TrieNode root, List<String> matchedString, String pathChar) {
        if (!root.hasNodes()) {
            return;
        }
        for (int i = 0; i < root.childrens().length; i++) {
            if (root.childrens()[i] != null) {
                String indexPathChar = pathChar + root.childrens()[i].data;
                if (root.childrens()[i].isEndNode) {
                    matchedString.add(indexPathChar);
                }
                decodeStrings(root.childrens()[i], matchedString, indexPathChar);
            }
        }
    }


    /**
     * 字典树节点
     */
    private static class TrieNode {
        private TrieNode[] children;
        /**
         * 代表一个字符串的结尾，但并不意味着路径结束
         */
        private boolean isEndNode;
        private char data;

        public TrieNode(char data) {
            this.data = data;
        }

        public TrieNode[] childrens() {
            if (children == null) {
                children = new TrieNode[26];
            }
            return children;
        }

        /**
         * 是否有节点
         *
         * @return
         */
        public boolean hasNodes() {
            return children != null;
        }

    }
}
