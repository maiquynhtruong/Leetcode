class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int i, j, r1 = 0, c1 = 0, r2 = matrix.length-1, c2 = matrix[0].length-1;
        
        while (r1 <= r2 && c1 <= c2) {
            for (i = r1, j = c1; j <= c2; j++) {
                list.add(matrix[i][j]);
            }
            
            for (i = r1+1, j = c2; i <= r2; i++) {
                list.add(matrix[i][j]);
            }
            
            if(r1 < r2 && c1 < c2) {
                for (i = r2, j = c2-1; j > c1; j--) list.add(matrix[i][j]);
                for (i = r2, j = c1; i > r1; i--) list.add(matrix[i][j]);
            }
             
            c1++; c2--;
            r1++; r2--;
        }
        
        return list;
    }
    
}

/**

[1, 2, 3, 4],
[5, 6, 7, 8],
[9,10,11,12],
[13,14,15,16],
[17,18,19,20]

i = 0, j = 0 -> m-1
i = 1 -> n-1, j -> m-1
i = n-1, j = m-1 -> 0
i = n-1 -> 1, j = 0

i = 1, j = 1 -> m-2
i = 2 -> n-2, j = m-2
i = n-2, j = m-2 -> 1
i = n-2 -> 2, j = 1

for j = col, j < m-col, j++ ; i = row
for i = row+1, i < n-row, i++ ; j = m-col-1
for j = m-col-1, j >= col, j-- ; i = n-row-1
for i = n-row-1, i >= row+1, i-- ; j = col
col++, row++
**/
