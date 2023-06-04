package com.peerfintech.datastructure.adjtable;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/5
 * Time: 20:57
 * Description:图的邻接表存储表示，一般用于无向图
 */
public class ALGraph {
    int vexnum; // 顶点数
    int arcnum; // 弧数
    VNode[] vertices; // 顶点数组

    public ALGraph(int vexnum, int arcnum) {
        this.vexnum = vexnum;
        this.arcnum = arcnum;
        vertices = new VNode[vexnum];
    }
}
