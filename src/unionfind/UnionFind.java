package unionfind;

public class UnionFind {
    int size;
    int[] id;
    int[] sz;
    int numComponents;

    public UnionFind(int size) {
        if(size<=0)
            throw new IllegalArgumentException("Invalid Size");
        this.size = size;
        id=new int[size];
        sz=new int[size];

        for (int i = 0; i < size; i++) {
            id[i]=i;
            sz[i]=1;
        }
    }

    public int find(int node)
    {
        int root=node;
        while(root!=id[root]) root=id[root];
        //compress path
        while(node!=root)
        {
            int next=id[node];
            id[node]=root;
            node=next;
        }
    return root;
    }

    public boolean isConnected(int p, int q)
    {
        return  find(p)==find(q);
    }
    public int componentSize(int node)
    {
        return sz[node];
    }

    public void unify(int p , int q)
    {
        if(isConnected(p,q)) return;

        int root1=find(p);
        int root2=find(q);

        if(sz[root1]<sz[root2])
        {
            sz[root2]+=sz[root1];
            id[root1]=root2;
        }
        else
        {
            sz[root1]+=sz[root2];
            id[root2]=root1;
        }
        numComponents--;

    }

}
