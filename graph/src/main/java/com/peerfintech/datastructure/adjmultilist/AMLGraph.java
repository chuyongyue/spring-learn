package com.peerfintech.datastructure.adjmultilist;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:44
 * Description: 邻接多重表 表示无向图
 */
public class AMLGraph {
    // 最大的顶点数
    final static int MAX_VERTEX_NUM = 20;

    VexBox[] adjMullist = new VexBox[MAX_VERTEX_NUM];
    // 顶点数
    int vexnum;
    // 边数
    int edgenum;
}
