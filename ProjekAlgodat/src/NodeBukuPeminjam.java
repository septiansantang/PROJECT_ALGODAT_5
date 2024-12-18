public class NodeBukuPeminjam {
    String id;
    String judul;
    String penulis;
    String genre;
    int tahunTerbit;
    NodeBukuPeminjam next;

    public NodeBukuPeminjam(String id, String judul, String penulis, String genre, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.tahunTerbit = tahunTerbit;
        this.next = null;
    }
}