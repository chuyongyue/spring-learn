package com.peerfintech.datastructure.adjorthogonallist;

import com.peerfintech.datastructure.adjtable.VNode;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/14
 * Time: 22:18
 * Description: 十字链表存储的有向图
 */
public class OLGraph {
    // 最大的顶点个数
    final static int MAX_VERTEX_NUM = 20;
    // 表头向量
    VexNode[] xlist = new VexNode[MAX_VERTEX_NUM];
    // 有向图的顶点个数
    int vexnum;
    // 有向图的弧数
    int arcnum;
}
