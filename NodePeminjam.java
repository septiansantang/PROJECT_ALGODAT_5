public class NodePeminjam {
    String username;
    String password;
    StackBuku buku;
    NodePeminjam next;

    public NodePeminjam(String username) {
        this.username = username;
        this.buku = new StackBuku();
        this.next = null;
    }

    public void push(String id, String judulBuku, String penulis, String genre, int tahunTerbit) {
        buku.push("ID", judulBuku, penulis, genre, tahunTerbit);
    }

}