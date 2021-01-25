class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder == null) 
            return false;

        if(postorder.length == 0)
            return true;

        return verifyPostorderBST(postorder, 0, postorder.length - 1);    

    }

    private boolean verifyPostorderBST(int[] postorder, int left, int right) {
        if (left >= right)
            return true;

        int root = postorder[right];
        int i = left;
        for (i = left; i < right; i++)
            if (postorder[i] > root)
                break;
        
        int j = i;
        for (j = i; j < right; j++) 
            if (postorder[j] < root)
                return false;

        boolean l = true;
        if (i > 0)
            l = verifyPostorderBST(postorder, left, i - 1);

        boolean r = true;
        if (i < right)
            r = verifyPostorderBST(postorder, i, right - 1);

        return (l && r);
    }
}