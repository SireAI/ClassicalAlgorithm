package com.sire.algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/05/17
 * Author:Sire
 * Description:使用邻接表表示图结构，数组+链表(其他动态数据结构，红黑树，跳表)
 * 该类描述的是无向图
 * ==================================================
 */
public class Graph {
    private int v ;
    private LinkedList<Integer>[] graph;
    /**
     *
     * @param v  顶点个数
     */
    public Graph(int v) {
        this.v = v;
        this.graph = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new LinkedList();
        }
    }

    public void addEdge(int start,int end){
        graph[start].add(end);
        graph[end].add(start);
    }

    /**
     * 广度优先搜索两点之间最短路径
     * @param start
     * @param end
     */
    public void bfs(int start,int end){
        //边界判断
        if(start == end){
            return;
        }
        //记录访问点，防止重复访问
        boolean[] visited = new boolean[v];
        //记录访问路径,每个位置存储的是上一个路径点
        int[] path = new int[v];
        for (int i = 0; i < v; i++) {
            path[i] = -1;
        }
        //记录遍历索引点，该点已经被遍历，但其相邻点可能没有被遍历
        Queue<Integer> queue = new LinkedList<>();
        //初始化第一个节点
        visited[start] = true;
        queue.add(start);
        while (queue.size()>0){
            int p = queue.poll();
            //遍历这个点的所有直接相邻点
            LinkedList<Integer> points = graph[p];
            for (int i = 0; i < points.size(); i++) {
                //若该店没有没有访问过，则进行处理
                if(!visited[points.get(i)]){
                    //记录路径
                   path[points.get(i)] = p;
                   if(end == points.get(i)){
                       //找到，打印
                       printBFS(path,start,end);
                       return;
                   }
                   visited[points.get(i)] =true;
                   queue.add(points.get(i));
                }
            }

        }
    }

    /**
     * 打印路径
     * @param path
     * @param start
     * @param end
     */
    private void printBFS(int[] path, int start, int end) {
        Stack<Integer> points = new Stack<>();
        while (path[end]!=-1){
            points.push(path[end]);
            end = path[end];
        }
        while (points.size()>0){
            System.out.println(points.pop());
        }
    }

    private boolean found = false;
    /**
     * 深度优先看，搜索一条可达路径，并非最短路径
     * @param start
     * @param end
     */
    public void dfs(int start,int end){
        found = false;
        if(start == end){
            return;
        }
        boolean[] visited = new boolean[v];
        int[] path = new int[v];
        for (int i = 0; i < v; i++) {
            path[i] = -1;
        }
        recurDfs(visited,path,start,end);
        printDFS(path,start,end);
    }

    /**
     * 递归深度遍历
     * 终止条件遍历的节点等于最终要找的节点
     * 递推公式，对比下个节点与最终节点
     * @param visited
     * @param path
     * @param start
     * @param end
     */
    private void recurDfs(boolean[] visited, int[] path, int start, int end) {
        //判断是否找到
        if(found){
            return;
        }
        visited[start] = true;
        if(start == end){
            found = true;
            return;
        }
       //没找到则取下一个
        for (int i = 0; i < graph[start].size(); i++) {
            if(!visited[graph[start].get(i)]){
                path[start] = graph[start].get(i);
                recurDfs(visited,path,graph[start].get(i),end);
            }
        }

    }

    /**
     * 回溯思想
     * @param path
     * @param start
     * @param end
     */
    private void printDFS(int[] path, int start, int end) {
        if(path[end]!=-1 && start != end){
            printBFS(path,start,path[end]);
        }
        System.out.println(end);
    }


}
