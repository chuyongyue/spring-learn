package com.peerfintech.datastructure.adjtable;

import com.peerfintech.datastructure.forest.CSNode;
import com.peerfintech.datastructure.forest.CSTree;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/16
 * Time: 1:15
 * Description: 无向图邻接表的深度和广度遍历
 */
public class UDGGraphTraversal {
    final static int MAX = 20;
    boolean[] visited = new boolean[MAX];

    public ALGraph graph;

    // 深度优先遍历
    public void DFSTraverse(ALGraph gra) {
        graph = gra;
        for (int i = 0; i < graph.vexnum; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < graph.vexnum; i++) {
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
        System.out.print(v + " ");
        for (int i = getFirstAdjVex(v); i >= 0 ; i = nextAdjVex(v, i)) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }

    // 广度优先遍历
    public void BFSTraverse(ALGraph gra) {
        graph = gra;
        // 初始化访问标志数组
        for (int i = 0; i < graph.vexnum; i++) {
            visited[i] = false;
        }
        // 初始化队列
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < graph.vexnum; i++) {
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
        int vex = -1;
        if (graph.vertices[v].firstarc != null) {
            vex = graph.vertices[v].firstarc.adjvex;
        }
        return vex;

    }

    // 获取该顶点下一个邻接点
    private int nextAdjVex(int v, int pre) {
        int nextVex = -1;
        ArcNode arcNode = graph.vertices[v].firstarc;
        while (arcNode != null) {
            if (arcNode.adjvex == pre && arcNode.nextarc != null) {
                nextVex = arcNode.nextarc.adjvex;
                break;
            }
            arcNode = arcNode.nextarc;
        }

        return nextVex;
    }

    // 无向非连通图的深度优先生成树
    public CSTree DFSForest(ALGraph alGraph) {
        graph = alGraph;
        CSTree t = new CSTree();
        for (int i = 0; i < alGraph.vexnum; i++) {
            visited[i] = false;
        }
        // q为当前生成树
        CSNode q = null;
        for (int i = 0; i < alGraph.vexnum; i++) {
            if (!visited[i]) {
                CSNode p = new CSNode();
                p.vexData = i;
                if (t.root == null) {
                    t.root = p; // 是第一棵生成树的根
                } else {
                    q.nextSibling = p;
                }
                q = p;
                DFSTree(i, q);
            }
        }
        return t;
    }

    public void DFSTree(int v, CSNode q) {
        visited[v] = true;
        boolean first = true; // 表示为节点下，深度遍历第一个邻接节点

        for (int i = getFirstAdjVex(v); i >= 0 ; i = nextAdjVex(v, i)) {
            if (!visited[i]) {
                CSNode p = new CSNode();
                p.vexData = i;
                if (first) {
                    q.lChild = p;
                    first = false;
                } else {
                    q.nextSibling = p;
                }
                q = p;
                DFSTree(i,q);
            }
        }
    }
}
