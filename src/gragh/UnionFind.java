package gragh;

class UnionFind {
    int[] id;
//    int[] size;    //几乎不用
    int count;

    public UnionFind(int len) {
        this.id = new int[len];
//        this.size = new int[len];
        this.count = len;

    }

    public boolean find(int p, int q) {
        System.out.println(root(p) == root(q));
        System.out.println("root" +p + " : " + root(p) + q + " : " + root(q));
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int pi = root(p), qi = root(q);
//        if (this.size[pi] < this.size[qi]) {
//            this.id[pi] = qi;
//            this.size[qi] += this.size[pi];
//        } else {
            this.id[qi] = pi;
//            this.size[pi] += this.size[qi];
//        }
        this.count--;
    }

    public int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]]; // path compression
            i = id[i];
        }
        return i;
    }
}
