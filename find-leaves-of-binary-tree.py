# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        heights = []
        def getHeight(root, heights):
            if root == None:
                return -1
            right = getHeight(root.right, heights)
            left = getHeight(root.left, heights)
            height = 1 + max(right, left)
            
            if len(heights) == height:
                heights.append([])
            heights[height].append(root.val)
            return height
        getHeight(root, heights)
        return heights
        
     
            
            
            
    
    
        
