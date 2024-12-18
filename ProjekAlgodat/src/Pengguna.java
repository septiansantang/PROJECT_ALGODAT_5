public class Pengguna {
    String username;
    String password;
    StackBuku buku;
    Pengguna next;

    public Pengguna(String username, String password){
        this.username = username;
        this.password = password;
        this.next = null;
    }
}