public class DisjointSet {
    int [] size;
    int [] parent;

    public DisjointSet(int n){
        size = new int[n+1];
        parent = new int[n+1];

        for(int i=0;i<n+1;i++){
            size[i]=1;
            parent[i]=i;
        }

    }

    public int findParent(int i){
        if(i==parent[i]){
            return i;
        }

        parent[i] = findParent(parent[i]);
        return parent[i];
    }
    
    public void union(int i, int j){
        int pi = findParent(i);
        int pj = findParent(j);

        if(pi==pj) return;

        if(size[i]<size[j]){
            parent[pi] = pj;
            size[pj]+=size[pi];
        }
        else{
            parent[pj] = pi;
            size[pi]+=size[pj];
        }
    }

}
