public class Novel {
    String id;
    String judul;
    String penulis;
    String genre;
    int tahunTerbit;
    Novel next;

    public Novel(String id, String judul, String penulis, String genre, int tahunTerbit) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
        this.tahunTerbit = tahunTerbit;
        this.next = null;
    }
}
