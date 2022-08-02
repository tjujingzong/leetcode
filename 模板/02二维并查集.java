class Solution {

  int max = 0;
  public int maxAreaOfIsland(int[][] grid) {
      int m = grid.length, n = grid[0].length;
      UnionFind uf = new UnionFind(grid);
      for(int i = 0; i < m; i++){
          for(int j = 0; j < n; j++){
              int landx = i * n + j;
              if(grid[i][j] == 1){ // 以下两行，如果右侧或下侧能够合并到当前岛中，合并之
                  if(j < n - 1 && grid[i][j + 1] == 1) uf.union(landx, landx + 1);
                  if(i < m - 1 && grid[i + 1][j] == 1) uf.union(landx, landx + n);
              }
          }
      }
      return max;
  }

  private class UnionFind{
      private int[] parents;
      private int[] size;

      public UnionFind(int[][] grid){
          int m = grid.length, n = grid[0].length;
          this.parents = new int[m * n];
          this.size = new int[m * n];
          for(int i = 0; i < m; i++){
              for(int j = 0; j < n; j++) {
                  if(grid[i][j] == 1){ // 针对单格岛，赋值parents[k]和size[k]
                      int k = i * n + j;
                      parents[k] = k;
                      size[k] = 1;
                      if(max != 1) max = 1; // 有单格岛时更新max=1
                  }
              }
          }
      }
      // 带路径压缩的查找
      public int find(int x){
          if(parents[x] == x) return x;
          return parents[x] = find(parents[x]);
      }
      // 按大小求并
      public void union(int x, int y){
          int xRoot = find(x);
          int yRoot = find(y);
          if(xRoot != yRoot){
              if(size[yRoot] <= size[xRoot]) { // y所在集合大小小于等于x所在集合时，yRoot挂到xRoot上
                  parents[yRoot] = xRoot;
                  size[xRoot] += size[yRoot];
                  max = Math.max(max, size[xRoot]); // 更新max
              }
              else { // xRoot挂到yRoot上
                  parents[xRoot] = yRoot;
                  size[yRoot] += size[xRoot];
                  max = Math.max(max, size[yRoot]); // 更新max
              }
          }
      }
  }
}
