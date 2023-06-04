package com.peerfintech.datastructure.adjmatrix;

public class MGraph {
    static int MAX_VERTEX_NUM = 20;
    /**
     * 顶点数量
     */
    public int vexNum;

    /**
     * 弧数
     */
    public int arcNum;
    /**
     * 图的种类标志
     */
    GraphKind kind;

    /**
     * 邻接矩阵
     */
    public ArcCell[][] adjMatrix;

    /**
     * 顶点向量
     */
    public int[] ves;

    public MGraph() {
        adjMatrix = new ArcCell[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
        ves = new int[MAX_VERTEX_NUM];
    }

    public void print() {
        for (int i = 0; i < vexNum; i++) {
            for (int j = 0; j < vexNum; j++) {
                System.out.print(adjMatrix[i][j].vrType.value == Integer.MAX_VALUE ? "∞": adjMatrix[i][j].vrType.value);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
