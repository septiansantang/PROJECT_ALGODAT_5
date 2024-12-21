import java.util.Scanner;

public class QueuePeminjam {
    private NodePeminjam front;
    private NodePeminjam rear;
    public int n;

    public QueuePeminjam() {
        this.front = null;
        this.rear = null;
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enqueue(String nama, NovelList novelList) {
        NodePeminjam newNode = new NodePeminjam(nama);

        Scanner scanner = new Scanner(System.in);
        boolean lagi = true;

        while (lagi) {
            System.out.print("Masukkan judul buku yang ingin dipinjam: ");
            String judulBuku = scanner.nextLine();

            // Cari buku di novelList global
            NodeBukuPeminjam bukuDipinjam = novelList.cariNovel(judulBuku);
            if (bukuDipinjam == null) {
                System.out.println("Buku dengan judul '" + judulBuku + "' tidak ditemukan.");
            } else {
                newNode.buku.push(bukuDipinjam.id, bukuDipinjam.judul, bukuDipinjam.penulis, bukuDipinjam.genre,
                        bukuDipinjam.tahunTerbit);
                novelList.hapusNovel(bukuDipinjam.id);
                System.out.println("Buku '" + judulBuku + "' berhasil dipinjam.");
            }

            System.out.print("Ingin meminjam buku lain? (y/n): ");
            String jawab = scanner.nextLine();
            if (jawab.equalsIgnoreCase("n")) {
                lagi = false;
            }
        }

        scanner.close();

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        n++;
    }

    public void refreshQueue() {
        if (isEmpty()) {
            System.out.println("Antrean kosong, tidak ada yang bisa di-refresh.");
        } else {
            NodePeminjam removedNode = dequeue();
            System.out.println("Peminjam '" + removedNode.username + "' telah dihapus dari antrean.");

            System.out.println("Antrean berhasil di-refresh. Peminjam berikutnya adalah: ");
            tampilkan();
        }
    }

    public NodePeminjam dequeue() {
        if (isEmpty())
            return null;
        NodePeminjam dequeuedQueue = front;
        front = front.next;
        if (--n == 0)
            rear = null;
        return dequeuedQueue;
    }

    public void tampilkan() {
        System.out.println("====================================");
        System.out.println("=           DAFTAR ANTRIAN         =");
        if (isEmpty()) {
            System.out.println("Antrian Kosong");
        } else {
            NodePeminjam temp = front;

            int noAntrian = 0;
            while (temp != null) {
                noAntrian++;
                System.out.println("====================================");
                System.out.print("Nama : " + temp.username + "\n");
                System.out.print("Antrian ke : " + noAntrian + "\n");
                System.out.print("Jumlah Buku : ");
                temp.buku.printSize();
                System.out.println();
                System.out.println("====================================");
                temp = temp.next;
            }
        }
    }

}
