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
        daftarNovel.tambahNovel("F001", "Pride and Prejudice", "Jane Austen", "Romansa", 1813);
        daftarNovel.tambahNovel("F002", "To Kill a Mockingbird", "Harper Lee", "Drama", 1960);
        daftarNovel.tambahNovel("F003", "1984", "George Orwell", "Distopia", 1949);
        daftarNovel.tambahNovel("F004", "The Great Gatsby", "F. Scott Fitzgerald", "Drama", 1925);
        daftarNovel.tambahNovel("F005", "Moby Dick", "Herman Melville", "Adventure", 1851);
        daftarNovel.tambahNovel("F006", "War and Peace", "Leo Tolstoy", "Sejarah", 1869);
        daftarNovel.tambahNovel("F007", "The Catcher in the Rye", "J.D. Salinger", "Drama", 1951);
        daftarNovel.tambahNovel("F008", "The Hobbit", "J.R.R. Tolkien", "Fantasi", 1937);
        daftarNovel.tambahNovel("F009", "Fahrenheit 451", "Ray Bradbury", "Fiksi", 1953);
        daftarNovel.tambahNovel("F010", "The Da Vinci Code", "Dan Brown", "Thriller", 2003);
        daftarNovel.tambahNovel("N005", "Pulang", "Leila S. Chudori", "Drama", 2012);
        daftarNovel.tambahNovel("N006", "5 cm", "Donny Dhirgantoro", "Adventure", 2005);
        daftarNovel.tambahNovel("N007", "Ayat-Ayat Cinta", "Habiburrahman El S", "Romansa", 2004);
        daftarNovel.tambahNovel("N008", "Negeri 5 Menara", "A. Fuadi", "Drama", 2009);
        daftarNovel.tambahNovel("N009", "Perahu Kertas", "Dee Lestari", "Romansa", 2009);
        daftarNovel.tambahNovel("N010", "Supernova: Ksatria, Puteri, dan Bintang Jatuh", "Dee Lestari", "Fiksi ", 2001);
        daftarNovel.tambahNovel("N011", "Divortiare", "Ika Natassa", "Romansa", 2008);
        daftarNovel.tambahNovel("N012", "Critical Eleven", "Ika Natassa", "Romansa", 2015);
        daftarNovel.tambahNovel("N013", "Rindu", "Tere Liye", "Sejarah", 2014);
        daftarNovel.tambahNovel("N014", "Hujan", "Tere Liye", "Fiksi", 2016);
        daftarNovel.tambahNovel("N015", "Garis Waktu", "Fiersa Besari", "Biografi", 2016);
        daftarNovel.tambahNovel("N016", "Kambing Jantan", "Raditya Dika", "Humor", 2005);
        daftarNovel.tambahNovel("N017", "Koala Kumal", "Raditya Dika", "Humor", 2015);
        daftarNovel.tambahNovel("N018", "Marmut Merah Jambu", "Raditya Dika", "Humor", 2010);
        daftarNovel.tambahNovel("N019", "Love", "Aiman Bagea", "Romansa", 2009);
        daftarNovel.tambahNovel("N020", "Fallin", "Inni Indrapradja", "Romansa", 2016);
        daftarNovel.tambahNovel("N021", "The Alchemist", "Paulo Coelho", "Adventure", 1988);
        daftarNovel.tambahNovel("N022", "The Lord of the Rings", "J.R.R. Tolkien", "Fantasi", 1954);
        daftarNovel.tambahNovel("N023", "The Kite Runner", "Khaled Hosseini", "Drama", 2003);
        daftarNovel.tambahNovel("N024", "Gone Girl", "Gillian Flynn", "Thriller", 2012);
        daftarNovel.tambahNovel("N025", "The Fault in Our Stars", "John Green", "Romansa", 2012);
        daftarNovel.tambahNovel("N026", "Life of Pi", "Yann Martel", "Adventure", 2001);
        daftarNovel.tambahNovel("N027", "The Twilight Saga: Twilight", "Stephenie Meyer", "Fantasi", 2005);
        daftarNovel.tambahNovel("N028", "The Hunger Games", "Suzanne Collins", "Distopia", 2008);
        daftarNovel.tambahNovel("N029", "Percy Jackson: The Lightning Thief", "Rick Riordan", "Fantasi", 2005);
        daftarNovel.tambahNovel("N030", "A Song of Ice and Fire: A Game of Thrones", "George R.R. Martin", "Fantasi", 1996);
        daftarNovel.tambahNovel("N031", "Me Before You", "Jojo Moyes", "Romansa", 2012);
        daftarNovel.tambahNovel("N032", "It Ends with Us", "Colleen Hoover", "Romansa", 2016);
        daftarNovel.tambahNovel("N033", "Divergent", "Veronica Roth", "Distopia", 2011);
        daftarNovel.tambahNovel("N034", "The Maze Runner", "James Dashner", "Distopia", 2009);
        daftarNovel.tambahNovel("N035", "The Shadow of the Wind", "Carlos Ruiz Zafón", "Misteri", 2001);
        daftarNovel.tambahNovel("N036", "The Book Thief", "Markus Zusak", "Drama", 2005);
        daftarNovel.tambahNovel("N037", "A Thousand Splendid Suns", "Khaled Hosseini", "Drama", 2007);
        daftarNovel.tambahNovel("N038", "The Secret History", "Donna Tartt", "Misteri", 1992);
        daftarNovel.tambahNovel("N039", "Where the Crawdads Sing", "Delia Owens", "Misteri", 2018);
        daftarNovel.tambahNovel("N040", "Normal People", "Sally Rooney", "Romansa", 2018);
        int pilihan;

        do {
            header("Perpustakaan Novel");
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