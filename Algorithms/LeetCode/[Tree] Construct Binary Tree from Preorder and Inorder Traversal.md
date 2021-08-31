# Construct Binary Tree from Preorder and Inorder Traversal.md
[!문제](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)


### 아이디어
- p[0]은 root임
- i에서 p[0] 값을 기준으로 좌측 서브트리와 우측 서브트리로 나뉨

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
        
        
        root.left = build(pStart+1, iStart, i-1, preorder, inorder);
        root.right = build(pStart+1+i-iStart, i+1, iEnd, preorder, inorder); //우측의 시작점은 pStart+1+좌측노드 수
        //우측의 시작점이 위와 같은 이유는 preorder의 경우 좌측방문을 완전히 끝낸 후 우측에 방문하기 때문 --> curr->left(1->... ->N)->right(1->...->N)
        return root;
    }
    
}
```
