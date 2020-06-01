package unionfind;

public class LeetCode_FriendCircled_547 {

    class Solution {

        class UnionFind
        {
            int size;

            int[] id;
            int[] sz;
            int compSize=0;

            public UnionFind(int size)
            {
                this.size=size;

                id= new int[size];
                sz= new int[size];
                compSize=size;
                for(int i=0;i<size;i++)
                {
                    id[i]=i;
                    sz[i]=1;
                }
            }

            public int find(int i)
            {

                int root=i;

                while(root!=id[root]) root=id[root];

                while(i!=root)
                {
                    int next=id[root];
                    id[i]=next;
                    i=next;

                }
                return root;

            }

            public void union(int p, int q)
            {

                if(find(p)==find(q)) return;

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
                compSize--;
            }

            public int count()
            {
                return compSize;
            }



        }


        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFind u=new UnionFind(n);

            for(int i=0;i<n-1;i++)
            {
                for(int j=i+1;j<n;j++)
                {
                    if(M[i][j]==1)
                        u.union(i,j);
                }
            }
            return u.count();
        }


    }

}
