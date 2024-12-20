class BSTBuku {
    class Node {
        NodeBukuPeminjam data;
        Node left, right;

        public Node(NodeBukuPeminjam data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public BSTBuku() {
        root = null;
    }

    public void insert(NodeBukuPeminjam data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, NodeBukuPeminjam data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data.id.compareToIgnoreCase(root.data.id) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.id.compareToIgnoreCase(root.data.id) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }
    
    public NodeBukuPeminjam search(String id) {
        return searchRec(root, id);
    }
    
    private NodeBukuPeminjam searchRec(Node root, String id) {
        if (root == null || root.data.id.equalsIgnoreCase(id)) {
            return root != null ? root.data : null;
        }
        if (id.compareToIgnoreCase(root.data.id) < 0) {
            return searchRec(root.left, id);
        }
        return searchRec(root.right, id);
    }
    

    public void displayInOrder() {
        displayInOrderRec(root);
    }

    private void displayInOrderRec(Node root) {
        if (root != null) {
            displayInOrderRec(root.left);
            System.out.println(root.data.judul + " by " + root.data.penulis);
            displayInOrderRec(root.right);
        }
    }
}