package com.peerfintech.datastructure.adjmatrix;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/15
 * Time: 0:27
 * Description: 图的遍历
 */
public class GraphTraversal {
    final static int MAX = 20;
    boolean[] visited = new boolean[MAX];

    public MGraph graph;
    GraphKind graphKind;
    // 深度优先遍历
    public void DFSTraverse(MGraph gra, GraphKind kind) {
        graph = gra;
        graphKind = kind;
        for (int i = 0; i < graph.vexNum; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < graph.vexNum; i++) {
            // 对尚未访问的顶点调用DFS
            if (!visited[i]) {
                DFS(i);
            }
        }
        System.out.println("");
    }
    // 深度优先遍历
    private void DFS(int v) {
        visited[v] = true;
        System.out.print(graph.ves[v] + " ");
        for (int i = getFirstAdjVex(v); i >= 0 ; i = nextAdjVex(v, i)) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    // 广度优先遍历
    public void BFSTraverse(MGraph graph, GraphKind kind) {
        // 初始化访问标志数组
        for (int i = 0; i < graph.vexNum; i++) {
            visited[i] = false;
        }
        // 初始化队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.vexNum; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print(i + " ");
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    int v = queue.removeFirst();
                    for (int j = getFirstAdjVex(v); j >= 0 ; j = nextAdjVex(v, j)) {
                        if (!visited[j]) {
                            visited[j] = true;
                            System.out.print(j + " ");
                            queue.addLast(j);
                        }
                    }
                }
            }
        }
        System.out.println("");
    }

    // 获取该顶点第一个邻接点
    private int getFirstAdjVex(int v) {
        int firstVex = -1;
        for (int i = 0; i < graph.vexNum; i++) {
            if (i != v) {
                // 是否相邻
                if (graphKind == GraphKind.DN || graphKind == GraphKind.UDN) {
                    if (graph.adjMatrix[v][i].vrType.value != Integer.MAX_VALUE) {
                        firstVex = i;
                        break;
                    }
                } else {
                    if (graph.adjMatrix[v][i].vrType.value == 1) {
                        firstVex = i;
                        break;
                    }
                }
            }
        }
        return firstVex;
    }

    // 获取该顶点下一个邻接点
    private int nextAdjVex(int v, int pre) {
        int nextVex = -1;
        for (int i = pre + 1; i < graph.vexNum; i++) {
            if (i != v) {
                // 是否相邻
                if (graphKind == GraphKind.DN || graphKind == GraphKind.UDN) {
                    if (graph.adjMatrix[v][i].vrType.value != Integer.MAX_VALUE) {
                        nextVex = i;
                        break;
                    }
                } else {
                    if (graph.adjMatrix[v][i].vrType.value == 1) {
                        nextVex = i;
                        break;
                    }
                }
            }
        }
        return nextVex;
    }
}
