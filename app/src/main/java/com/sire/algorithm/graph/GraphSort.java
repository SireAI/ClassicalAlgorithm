package com.sire.algorithm.graph;

import com.sire.algorithm.IAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ==================================================
 * All Right Reserved
 * Date:2020/06/07
 * Author:Sire
 * Description:拓扑排序，由局部依赖关系获取拓扑排序
 * 图对象：有向无环图
 * Kahn 算法
 * ==================================================
 */
public class GraphSort implements IAlgorithm {
    private int v ;
    private LinkedList<Integer>[] adj;

    public GraphSort(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 顶点s指向顶点t
     * @param s
     * @param t
     */
    public void addEdge(int s,int t){
        adj[s].add(t);
    }

    /**
     * 搜索入度为0的点，该点没有依赖，有限打印
     * 与该点有联系的其他点的入度减1;
     * 若最终打印的个数少于顶点个数，说明存在环
     * 环的检测还可以用路径记录
     */
    public void sortByKahn(){
        //记录各个点的入度
        int[] inDegree = new int[v];
        //遍历获取入度
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < adj[i].size(); j++) {
                inDegree[adj[i].get(j)]+=1;
            }
        }
        //搜索入度为0的点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(inDegree[i] == 0 ){
                queue.offer(i);
            }
        }

        //排序打印
        while (!queue.isEmpty()){
            int p = queue.poll();
            System.out.println("->"+p);
            //连接点的入度减1
            for (int i = 0; i < adj[p].size(); i++) {
                inDegree[adj[p].get(i)]-=1;
                if(inDegree[adj[p].get(i)] == 0){
                    queue.add(adj[p].get(i));
                }
            }
        }

    }

    @Override
    public void go() {
        GraphSort graphSort = new GraphSort(9);
        graphSort.addEdge(1,2);
        graphSort.addEdge(2,3);
        graphSort.addEdge(3,5);
        graphSort.addEdge(5,6);
        graphSort.addEdge(3,4);
        graphSort.addEdge(7,8);
//        存在环
//        graphSort.addEdge(6,4);
        graphSort.sortByKahn();
    }
}
