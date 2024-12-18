public class NodePeminjam {
    String username;
    String password;
    StackBuku buku;
    NodePeminjam next;

    public NodePeminjam(String username){
        this.username = username;
        this.buku = new StackBuku();
        this.next = null;
    }
}