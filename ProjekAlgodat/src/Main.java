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
        QueuePeminjam antrianPeminjam = new QueuePeminjam();
        StackBuku bukuPeminjam = new StackBuku();
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
            System.out.println("1. Log-In");
            System.out.println("2. Sign-In");
            System.out.println("3. Daftar Pengguna");
            System.out.println("4. Exit");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.println("Log-In Screen");
                    System.out.print("Username: ");
                    String username = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    int logInState = listPengguna.logIn(username, password);

                    if (logInState == 0) {
                        System.out.println("Log-In Berhasil! Selamat datang, " + username);

                        int pilihanMenu;
                        do {
                            header("Menu Utama - Perpustakaan Novel");
                            System.out.println("1. Antri Pinjam Novel");
                            System.out.println("2. Tampilkan Antrian Peminjaman");
                            System.out.println("3. Tampilkan Semua Novel");
                            System.out.println("4. Cari Novel Berdasarkan ID");
                            System.out.println("5. Tambah Novel Berdasarkan ID");
                            System.out.println("6. Refresh Antrian");
                            System.out.println("7. Logout");
                            System.out.print("Masukkan pilihan: ");
                            pilihanMenu = scanner.nextInt();
                            scanner.nextLine();

                            switch (pilihanMenu) {
                                case 1:
                                    antrianPeminjam.enqueue(username, daftarNovel);
                                    break;
                                case 2:
                                    antrianPeminjam.tampilkan();
                                    break;
                                case 3:
                                    daftarNovel.tampilkanNovel();
                                    System.out.print("Urutkan Novel? (y/n): ");
                                    String urutkan = scanner.nextLine();
                                    if (urutkan.equalsIgnoreCase("y")) {
                                        System.out.println("1. Urutkan berdasarkan ID");
                                        System.out.println("2. Urutkan berdasarkan Judul");
                                        System.out.println("3. Urutkan berdasarkan Penulis");
                                        System.out.println("4. Urutkan berdasarkan Tahun");
                                        System.out.print("Masukkan pilihan: ");
                                        int pilihanUrutan = scanner.nextInt();
                                        scanner.nextLine();
                                        daftarNovel.urutkanNovel(pilihanUrutan);
                                        daftarNovel.tampilkanNovel();                                  
                                    }
                                    break;

                                case 4:
                                    System.out.print("Masukkan ID Novel yang dicari: ");
                                    String id = scanner.nextLine();
                                    NodeBukuPeminjam novel = daftarNovel.cariNovel(id);
                                    if (novel != null) {
                                        System.out.println("Novel ditemukan!");
                                        System.out.println("====================================");
                                        System.out.println("Judul: " + novel.judul + "\nPenulis: " + novel.penulis);
                                        System.out.println("====================================");
                                    } else {
                                        System.out.println("Novel dengan ID " + id + " tidak ditemukan.");
                                    }
                                    break;

                                case 5:
                                    System.out.print("Masukkan ID Novel yang dicari: ");
                                    id = scanner.nextLine();
                                    novel = daftarNovel.cariNovel(id);
                                    bukuPeminjam.push(novel);
                                    break;

                                case 6:
                                    antrianPeminjam.refreshQueue();
                                    break;
                                case 7:
                                    System.out.println("Anda telah logout. Kembali ke menu awal.");
                                    break;

                                default:
                                    System.out.println("Pilihan invalid.");
                                    break;
                            }
                        } while (pilihanMenu != 7);
                    } else if (logInState == 1) {
                        System.out.println("Log-In Gagal! Username atau password salah.");
                    } else if (logInState == 2) {
                        int pilihanMenu;
                        do {
                            header("Menu Admin - Perpustakaan Novel");
                            System.out.println("1. Tambah Novel");
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
                                    System.out.print("Urutkan Novel? (y/n): ");
                                    String urutkan = scanner.nextLine();
                                    if (urutkan.equalsIgnoreCase("y")) {
                                        System.out.println("1. Urutkan berdasarkan ID");
                                        System.out.println("2. Urutkan berdasarkan Judul");
                                        System.out.println("3. Urutkan berdasarkan Penulis");
                                        System.out.println("4. Urutkan berdasarkan Tahun");
                                        System.out.print("Masukkan pilihan: ");
                                        int pilihanUrutan = scanner.nextInt();
                                        scanner.nextLine();
                                        daftarNovel.urutkanNovel(pilihanUrutan);
                                        daftarNovel.tampilkanNovel();                                  
                                    }
                                    break;

                                case 4:
                                    System.out.print("Masukkan ID Novel yang dicari: ");
                                    id = scanner.nextLine();
                                    NodeBukuPeminjam novel = daftarNovel.cariNovel(id);
                                    if (novel != null) {
                                        System.out.println("Novel ditemukan!");
                                        System.out.println("====================================");
                                        System.out.println("Judul: " + novel.judul + "\nPenulis: " + novel.penulis);
                                        System.out.println("====================================");
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
                    }
                    break;

                case 2:

                    System.out.println("Sign-In Screen");
                    System.out.print("Username: ");
                    String usernameBaru = scanner.nextLine();
                    System.out.print("Password: ");
                    String passwordBaru = scanner.nextLine();
                    int signInState = listPengguna.signIn(usernameBaru, passwordBaru);

                    if (signInState == 1) {
                        System.out.println("Gagal Sign-In. Username sudah digunakan.");
                    } else if (signInState == 0) {
                        listPengguna.tambah(usernameBaru, passwordBaru);
                        System.out.println("Sign-In Berhasil! Silakan Log-In untuk melanjutkan.");
                    } else if (signInState == 2) {
                        System.out.println("Gagal Sign-In. Username tidak boleh Admin");
                    }
                    break;
                case 3:
                    listPengguna.tampilkan();
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan sistem perpustakaan.");
                    break;

                default:
                    System.out.println("Pilihan invalid.");
                    break;
            }
        } while (pilihan != 4);
        scanner.close();
    }
}