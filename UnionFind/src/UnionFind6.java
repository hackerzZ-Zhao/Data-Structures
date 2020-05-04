public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank; // 树的深度

    public UnionFind6(int size){
        parent = new int[size];
        rank = new int[size];

        for(int i = 0; i < size; i ++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize(){
        return parent.length;
    }

    private int find(int p){
        if (p < 0 && p >= parent.length){
            throw new IllegalArgumentException();
        }
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    // 基于size进行优化，将节点少的指向节点多的
    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        }
        else if(rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }
}