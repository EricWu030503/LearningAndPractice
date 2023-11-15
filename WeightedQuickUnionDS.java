interface DisjointSets {
    /** Connects two items P and Q. */
    void connect(int p, int q);

    /** Checks to see if two items are connected. */
    boolean isConnected(int p, int q);
}

class QuickFindDS implements DisjointSets {
    private int[] id;

    public QuickFindDS(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = -1;
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}

class QuickUnionDS implements DisjointSets {
    private int[] parent;
    // An array that represents the disjoint sets. Each index is an element, and the value at each index represents its parent. For root elements, the value is negative

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
    }

    private int find(int p) { // find the parent of element p
        int r = p;
        while (parent[r] >= 0) {
            r = parent[r];
        }
        return r;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        parent[i] = j;
    }
}

class UnionFind {
    /**
     * DO NOT DELETE OR MODIFY THIS, OTHERWISE THE TESTS WILL NOT PASS.
     * You can assume that we are only working with non-negative integers as the items
     * in our disjoint sets.
     */
    private int[] data;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        return Math.abs(data[find(v)]);
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return data[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {
        if (v < 0 || v >= data.length) {
            throw new IllegalArgumentException("Invalid item.");
        }
        int root = v;
        while (data[root] >= 0) {
            root = data[root];
        }
        while (v != root) {
            int parent = data[v];
            data[v] = root;
            v = parent;
        }
        return root;
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing a item with itself or items that are
       already connected should not change the structure. */

    public void union(int v1, int v2) {
        int root_v1 = find(v1);
        int root_v2 = find(v2);

        if (root_v1 == root_v2) {
            return;
        }

        if (data[root_v1] < data[root_v2]) {
            data[root_v1] += data[root_v2];
            data[root_v2] = root_v1;
        } else {
            data[root_v2] += data[root_v1];
            data[root_v1] = root_v2;
        }
    }

    /**
     * DO NOT DELETE OR MODIFY THIS, OTHERWISE THE TESTS WILL NOT PASS.
     */
    public int[] returnData() {
        return data;
    }
}

    public class WeightedQuickUnionDS implements DisjointSets {
        private int[] parent;
        private int[] size;  // Added for weighting

        public WeightedQuickUnionDS(int N) {
            parent = new int[N];
            size = new int[N];  // Initialize size array
            for (int i = 0; i < N; i++) {
                parent[i] = i;  // Each node is its own parent initially
                size[i] = 1;   // Each tree has size 1 initially
            }
        }

        private int find(int p) {
            int root = p;
            while (root != parent[root]) {
                root = parent[root];
            }
            // Path compression
            while (p != root) {
                int next = parent[p];
                parent[p] = root;
                p = next;
            }
            return root;
        }

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        public void connect(int p, int q) {
            int i = find(p);
            int j = find(q);

            if (i == j) return;  // Already connected

            // Weighting: Attach the smaller tree to the root of the larger tree
            if (size[i] < size[j]) {
                parent[i] = j;
                size[j] += size[i];
            } else {
                parent[j] = i;
                size[i] += size[j];
            }
        }
    }

