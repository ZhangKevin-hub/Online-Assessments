class Solution(object):
    def maxAreaOfIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        # get length of matrix:
        rows, cols = len(grid),len(grid[0])
        # set to prevent iterating over previous visited
        visit = set()
        def dfs(r,c):
            # outbounds conditionals
            if(r < 0  or r==rows
               or c < 0 or c == cols
               or (r,c) in visit
               or grid[r][c]==0):
                return 0
            # add values to set and iterate until outbounds recursion
            visit.add((r,c))
            return (1+dfs(r+1,c)+dfs(r-1,c)+dfs(r,c+1)+dfs(r,c-1))
        area = 0
        for r in range(rows):
            for c in range(cols):
                area = max(dfs(r,c),area)
        return area
