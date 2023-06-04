package com.peerfintech.datastructure.adjmultilist;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:46
 * Description: 基于邻接多重表存储创建的无向图
 */
public class UGCreator {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("UG"));
        while (in.hasNextLine()) {
            AMLGraph amlGraph = new AMLGraph();
            // 输入顶点数和边数
            int vexNum = in.nextInt();
            int edgeNum = in.nextInt();
            amlGraph.vexnum = vexNum;
            amlGraph.edgenum = edgeNum;
            // 构造顶点表
            for (int k = 0; k < vexNum; k++) {
                VexBox vexBox = new VexBox();
                vexBox.data = in.nextInt();
                vexBox.firstEdge = null;
                amlGraph.adjMullist[k] = vexBox;
            }
            // 输入边
            for (int k = 0; k < edgeNum; k++) {
                EBox eBox = new EBox();
                eBox.mark = VisitIf.unvisited;
                int i = in.nextInt();
                int j = in.nextInt();
                eBox.ivex = i;
                eBox.jvex = j;
                eBox.ilink = amlGraph.adjMullist[i].firstEdge;
                eBox.jlink = amlGraph.adjMullist[j].firstEdge;
                amlGraph.adjMullist[i].firstEdge = eBox;
                amlGraph.adjMullist[j].firstEdge = eBox;
            }
            System.out.println(amlGraph);
        }
    }
}
