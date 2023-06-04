package com.peerfintech.datastructure.adjtable;

/**
 * Created with IntelliJ IDEA.
 * Author: cy
 * Date: 2023/4/5
 * Time: 21:38
 * Description: 基于邻接表构造有向图
 */
public class ALDGraph {
    int vexnum; // 顶点数
    int arcnum; // 弧数
    VNode[] vertices; // 顶点数组
    VNode[] resvertices; // 逆邻接表

    public ALDGraph(int vexnum, int arcnum) {
        this.arcnum = arcnum;
        this.vexnum = vexnum;
        vertices = new VNode[vexnum];
        resvertices = new VNode[vexnum];
    }
}
