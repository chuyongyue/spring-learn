package com.peerfintech.datastructure.adjtable;

import com.peerfintech.datastructure.forest.CSTree;
import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/5
 * Time: 21:08
 * Description: 基于邻接表存储无向图
 */
public class UDGMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("UDG3"));
        // 输入顶点
        int vexNum = in.nextInt();
        // 输入边数
        int arcNum = in.nextInt();
        ALGraph graph = new ALGraph(vexNum, arcNum);
        for (int i = 0; i < vexNum; i++) {
            VNode node = new VNode();
            node.data = i;
            graph.vertices[i] = node;
        }
        // 一个一个输入弧
        for (int i = 0; i < arcNum; i++) {
            int node1 = in.nextInt();
            int node2 = in.nextInt();
            ArcNode arc1 = new ArcNode();
            arc1.adjvex = node1;
            arc1.nextarc = graph.vertices[node2].firstarc;
            graph.vertices[node2].firstarc = arc1;
            ArcNode arc2 = new ArcNode();
            arc2.adjvex = node2;
            arc2.nextarc = graph.vertices[node1].firstarc;
            graph.vertices[node1].firstarc = arc2;
        }

        UDGGraphTraversal traversal = new UDGGraphTraversal();
        //traversal.BFSTraverse(graph);
        traversal.DFSTraverse(graph);
        CSTree tree = traversal.DFSForest(graph);
        System.out.println(tree);
    }
}
