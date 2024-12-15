public class Pengguna {
    String username;
    String password;
    Pengguna next;

    public Pengguna(String username, String password){
        this.username = username;
        this.password = password;
        this.next = null;
    }
    
}
