import java.util.Scanner;

public class Main {
    public static void header(String title) {
        System.out.println("====================================");
        System.out.print("=");
        for (int i = 0; i < (34 - title.length()) / 2; i++)
            System.out.print(" ");
        System.out.print(title.toUpperCase());
        if (title.length() % 2 != 0)
            System.out.print(" ");
        for (int i = 0; i < (34 - title.length()) / 2; i++)
            System.out.print(" ");
        System.out.println("=");
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PenggunaList listPengguna = new PenggunaList();
        NovelList daftarNovel = new NovelList();
        daftarNovel.tambahNovel("N001", "Laskar Pelangi", "Andrea Hirata", "Drama", 2005);
        daftarNovel.tambahNovel("N002", "Dilan 1990", "Pidi Baiq", "Romansa", 2014);
        daftarNovel.tambahNovel("N003", "Bumi", "Tere Liye", "Fantasi", 2014);
        daftarNovel.tambahNovel("N004", "Sherlock Holmes", "Arthur Conan Doyle", "Misteri", 1892);
        daftarNovel.tambahNovel("HP001", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasi", 1997);
        daftarNovel.tambahNovel("HP002", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", "Fantasi", 1998);
        daftarNovel.tambahNovel("HP003", "Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "Fantasi", 1999);
        daftarNovel.tambahNovel("HP004", "Harry Potter and the Goblet of Fire", "J.K. Rowling", "Fantasi", 2000);
        daftarNovel.tambahNovel("HP005", "Harry Potter and the Order of the Phoenix", "J.K. Rowling", "Fantasi", 2003);
        daftarNovel.tambahNovel("HP006", "Harry Potter and the Half-Blood Prince", "J.K. Rowling", "Fantasi", 2005);
        daftarNovel.tambahNovel("HP007", "Harry Potter and the Deathly Hallows", "J.K. Rowling", "Fantasi", 2007);
        int pilihan;

        do {
            header("Perpustakaan Novel Ian");
            System.out.println("\n1. Log-In");
            System.out.println("2. Sign-In");
            System.out.println("3. Exit");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: // Log-In
                    System.out.println("Log-In Screen");
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    boolean logInSukses = listPengguna.logIn(username, password);

                    if (logInSukses) {
                        System.out.println("Log-In Berhasil! Selamat datang, " + username);

                        int pilihanMenu;
                        do {
                            header("Menu Utama - Perpustakaan Novel");
                            System.out.println("\n1. Tambah Novel");
                            System.out.println("2. Hapus Novel");
                            System.out.println("3. Tampilkan Semua Novel");
                            System.out.println("4. Cari Novel Berdasarkan ID");
                            System.out.println("5. Logout");
                            System.out.print("Masukkan pilihan: ");
                            pilihanMenu = scanner.nextInt();
                            scanner.nextLine();

                            switch (pilihanMenu) {
                                case 1:
                                    System.out.print("Masukkan ID Novel: ");
                                    String id = scanner.nextLine();
                                    System.out.print("Masukkan Judul Novel: ");
                                    String judul = scanner.nextLine();
                                    System.out.print("Masukkan Nama Penulis: ");
                                    String penulis = scanner.nextLine();
                                    System.out.print("Masukkan Genre Novel: ");
                                    String genre = scanner.nextLine();
                                    System.out.print("Masukkan Tahun Terbit: ");
                                    int tahunTerbit = scanner.nextInt();
                                    scanner.nextLine();
                                    daftarNovel.tambahNovel(id, judul, penulis, genre, tahunTerbit);
                                    break;

                                case 2:
                                    System.out.print("Masukkan ID Novel yang akan dihapus: ");
                                    id = scanner.nextLine();
                                    daftarNovel.hapusNovel(id);
                                    break;

                                case 3:
                                    daftarNovel.tampilkanNovel();
                                    break;

                                case 4:
                                    System.out.print("Masukkan ID Novel yang dicari: ");
                                    id = scanner.nextLine();
                                    Novel novel = daftarNovel.cariNovel(id);
                                    if (novel != null) {
                                        System.out.println("Novel ditemukan: Judul: " + novel.judul + ", Penulis: "
                                                + novel.penulis);
                                    } else {
                                        System.out.println("Novel dengan ID " + id + " tidak ditemukan.");
                                    }
                                    break;

                                case 5:
                                    System.out.println("Anda telah logout. Kembali ke menu awal.");
                                    break;

                                default:
                                    System.out.println("Pilihan invalid.");
                                    break;
                            }
                        } while (pilihanMenu != 5);

                    } else {
                        System.out.println("Log-In Gagal! Username atau password salah.");
                    }
                    break;

                case 2:
                    System.out.println("Sign-In Screen");
                    System.out.print("Username: ");
                    String usernameBaru = scanner.nextLine();
                    System.out.print("Password: ");
                    String passwordBaru = scanner.nextLine();
                    boolean signInGagal = listPengguna.signIn(usernameBaru, passwordBaru);

                    if (signInGagal) {
                        System.out.println("Gagal Sign-In. Username sudah digunakan.");
                    } else {
                        listPengguna.tambah(usernameBaru, passwordBaru);
                        System.out.println("Sign-In Berhasil! Silakan Log-In untuk melanjutkan.");
                    }
                    break;

                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                    break;

                default:
                    System.out.println("Pilihan invalid.");
                    break;
            }
        } while (pilihan != 3);

        scanner.close();
    }

}
