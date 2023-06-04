package com.peerfintech.datastructure.adjtable;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/5
 * Time: 21:40
 * Description: 基于邻接表构造有向图
 */
public class DGMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("tableDG"));
        int vexNum = in.nextInt();
        int arcNum = in.nextInt();
        ALDGraph aldGraph = new ALDGraph(vexNum, arcNum);
        for (int i = 0; i < vexNum; i++) {
            VNode node1 = new VNode();
            node1.data = i;
            aldGraph.vertices[i] = node1;
            VNode node2 = new VNode();
            node2.data = i;
            aldGraph.resvertices[i] = node2;
        }
        // 输入弧
        for (int i = 0; i < arcNum; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            ArcNode resveArc = new ArcNode();
            ArcNode arcNode = new ArcNode();
            arcNode.adjvex = end;
            arcNode.nextarc = aldGraph.vertices[start].firstarc;
            aldGraph.vertices[start].firstarc = arcNode;

            resveArc.adjvex = start;
            resveArc.nextarc = aldGraph.resvertices[end].firstarc;
            aldGraph.resvertices[end].firstarc = resveArc;
        }
        DGraphTraversal traversal = new DGraphTraversal();
        // traversal.BFSTraverse(aldGraph);
        // traversal.DFSTraverse(aldGraph);
        traversal.DFSForest(aldGraph);
    }
}
