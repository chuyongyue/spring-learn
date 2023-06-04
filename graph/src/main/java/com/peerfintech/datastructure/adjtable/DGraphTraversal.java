package com.peerfintech.datastructure.adjtable;

import com.peerfintech.datastructure.forest.CSNode;
import com.peerfintech.datastructure.forest.CSTree;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/16
 * Time: 1:18
 * Description: 有向图邻接表的深度和广度遍历
 */
public class DGraphTraversal {
    final static int MAX = 20;
    boolean[] visited = new boolean[MAX];
    int[] finished = new int[MAX];
    int count = 0;
    public ALDGraph graph;

    // 深度优先遍历
    public void DFSTraverse(ALDGraph gra) {
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
    public void BFSTraverse(ALDGraph gra) {
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

    // 最左孩子右兄弟链表
    public void DFSForest(ALDGraph gra) {
        graph = gra;
        CSTree t = new CSTree();
        CSNode q = null;
        for (int i = 0; i < graph.vexnum; i++) {
            visited[i] = false;
        }
        count = 0;
        for (int i = 0; i < graph.vexnum; i++) {
            if (!visited[i]) {
                CSNode p = new CSNode();
                p.vexData = i;
                if (t.root == null) {
                    t.root = p;
                } else {
                    q.nextSibling = p;
                }
                q = p;
                DFSTree(i, q);
            }
        }
        inverseDFSTraverse();
    }

    public void DFSTree(int v, CSNode q) {
        visited[v] = true;
        boolean first = true;
        for (int i = getFirstAdjVex(v); i >= 0 ; i = nextAdjVex(v,i)) {
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
                DFSTree(i, q);
            }
        }
        finished[count++] = v;
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

    // 获取逆邻接表第一个
    private int getInverseAdjFirstVex(int v) {
        int vex = -1;
        if (graph.resvertices[v].firstarc != null) {
            vex = graph.resvertices[v].firstarc.adjvex;
        }
        return vex;
    }

    private int inverseAdjNextVex(int v, int pre) {
        int nextVex = -1;
        ArcNode arcNode = graph.resvertices[v].firstarc;
        while (arcNode != null) {
            if (arcNode.adjvex == pre && arcNode.nextarc != null) {
                nextVex = arcNode.nextarc.adjvex;
                break;
            }
            arcNode = arcNode.nextarc;
        }
        return nextVex;
    }

    // 逆深度优先遍历
    public void inverseDFSTraverse() {
        for (int i = 0; i < graph.vexnum; i++) {
            visited[i] = false;
        }
        for (int i = graph.vexnum - 1; i >= 0 ; i--) {
            // 对尚未访问的顶点调用DFS
            int vex = finished[i];
            if (!visited[vex]) {
                inverseDFS(vex);
            }
        }
        System.out.println("");
    }
    // 逆深度优先遍历
    private void inverseDFS(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = getInverseAdjFirstVex(v); i >= 0 ; i = inverseAdjNextVex(v, i)) {
            if (!visited[i]) {
                inverseDFS(i);
                System.out.println("");
            }
        }
    }
}
