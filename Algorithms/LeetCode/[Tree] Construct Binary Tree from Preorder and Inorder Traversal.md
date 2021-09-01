# Construct Binary Tree from Preorder and Inorder Traversal.md
[!문제](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)


### 아이디어
- p[0]은 root
- i에서 p[0] 값을 기준으로 좌측 서브 트리와 우측 서브 트리로 나뉨

```java

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,0,inorder.length-1,preorder,inorder);
        
    }
    
    public TreeNode build(int pStart, int iStart, int iEnd, int[] preorder, int[] inorder){
        if(pStart > preorder.length-1 || iStart > iEnd){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pStart]);
        int i;
        for(i=iStart ; i<=iEnd; i++)
            if(inorder[i]==root.val)
                break;
        
        
        root.left = build(pStart+1, iStart, i-1, preorder, inorder); //좌측 노드는 루트의 바로 다음
        root.right = build(pStart+1+i-iStart, i+1, iEnd, preorder, inorder); //우측 노드는 루트 이후 연속된 좌측 노드 이후 root->left(1->... ->N)->right(1->...->N)
        return root;
    }
    
}
```
