package com.peerfintech.datastructure.adjorthogonallist;

import com.peerfintech.util.UseCaseUtil;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:23
 * Description: 基于十字链表存储的构造有向图
 */
public class DGCreator {
    public static void main(String[] args) {
        Scanner in = new Scanner(UseCaseUtil.getInput("DG"));
        while (in.hasNextLine()) {
            OLGraph olGraph = new OLGraph();
            // 输入顶点数和边数
            olGraph.vexnum = in.nextInt();
            olGraph.arcnum = in.nextInt();
            // 构造表头向量
            for (int i = 0; i < olGraph.vexnum; i++) {
                VexNode vexNode = new VexNode();
                vexNode.data = in.nextInt();
                vexNode.firstin = null;
                vexNode.firstout = null;
                olGraph.xlist[i] = vexNode;
            }

            // 输入弧
            for (int i = 0; i < olGraph.arcnum; i++) {
                ArcBox arcBox = new ArcBox();
                int tail  = in.nextInt();
                int head  = in.nextInt();
                arcBox.tailvex = tail;
                arcBox.headvex = head;
                arcBox.tlinx = olGraph.xlist[tail].firstout;
                arcBox.hlinx = olGraph.xlist[head].firstin;
                olGraph.xlist[tail].firstout = arcBox;
                olGraph.xlist[head].firstin = arcBox;
            }
            System.out.println(olGraph);
        }
    }
}
