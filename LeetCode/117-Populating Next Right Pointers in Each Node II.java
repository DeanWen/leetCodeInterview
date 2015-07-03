//Same idea to Populating Next Right Pointers in Each Node I
//Now need find the next valid node first
//then recursively deal with RIGHT child first
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode nextValid = root.next;
        while (nextValid != null) {
            if (nextValid.left != null) {
                nextValid = nextValid.left;
                break;
            }
            if (nextValid.right != null) {
                nextValid = nextValid.right;
                break;
            }
            nextValid = nextValid.next;
        }
        
        if (root.right != null) {
            root.right.next = nextValid;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }else {
                root.left.next = nextValid;
            }
        }

        connect(root.right);
        connect(root.left);
    }
}
