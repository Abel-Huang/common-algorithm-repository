package com.abel.cp1.part2;

import java.util.Scanner;

/**
 * Created by huangjinajin on 2017/7/11.
 * 使用路径压缩的加权quick-union算法
 *  ????find()函数是这么写的么？
 * p147
 */
public class UF_QU_W_C {
    private int count;
    private int[] id;
    private int[] sz;
    public UF_QU_W_C(int N){
        count=N;
        id=new int[N];
        sz=new int[N];
        for(int i=0;i<N;i++){
            id[i]=i;
            sz[i]=1;
        }
    }

    /**
     * @return the number of component
     */
    public int count(){
        return this.count;
    }

    /**
     * @param p the old value
     * @return the new value
     */
    public int find(int p){
        int root=p;
        // 找到根节点
        while(root!=id[root]){
            root=id[root];
        }
        /**
         * 在将p指向根节点的过程中将所
         * 有中间的点也都指向root节点
         */
        while(p!=root){
            int x=p;
            id[x]=root;
            p=id[p];
        }
        return root;
    }

    /**
     * @param p
     * @param q
     * @return is the same value
     */
    public boolean connected(int p, int q){
        return find(p)==find(q);
    }

    /**
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pID=find(p);
        int qID=find(q);
        if(pID==qID)
            return;
        if (sz[pID]>sz[qID]){
            id[qID]=pID;
            sz[pID]+=sz[qID];
        }else{
            id[pID]=qID;
            sz[qID]+=sz[pID];
        }
        count--;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input N");
        int N=sc.nextInt();
        UF_QU_W_C uf=new UF_QU_W_C(N);
        System.out.println("Input M");
        int M=sc.nextInt();
        for(int i=0;i<M;i++){
            System.out.println("Input two integer");
            int p=sc.nextInt();
            int q=sc.nextInt();
            if(uf.connected(p,q))
                continue;
            uf.union(p,q);
            System.out.println(p+" : "+q);
        }
        System.out.println(uf.count()+" component");
    }
}
