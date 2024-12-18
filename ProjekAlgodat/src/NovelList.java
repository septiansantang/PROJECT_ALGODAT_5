public class NovelList {
    NodeBukuPeminjam head;
    NodeBukuPeminjam tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahNovel(String id, String judul, String penulis, String genre, int tahunTerbit) {
        NodeBukuPeminjam novelBaru = new NodeBukuPeminjam(id, judul, penulis, genre, tahunTerbit);
        if (isEmpty()) {
            head = novelBaru;
            tail = novelBaru;
        } else {
            tail.next = novelBaru;
            tail = novelBaru;
        }
        System.out.println("Novel berhasil ditambahkan: " + judul);
    }

    public void hapusNovel(String id) {
        if (isEmpty()) {
            System.out.println("Daftar novel kosong.");
            return;
        }

        if (head.id.equals(id)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Novel dengan ID " + id + " berhasil dihapus.");
            return;
        }

        NodeBukuPeminjam temp = head;
        while (temp.next != null && !temp.next.id.equals(id)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Novel dengan ID " + id + " tidak ditemukan.");
        } else {
            temp.next = temp.next.next;
            if (temp.next == null) {
                tail = temp;
            }
            System.out.println("Novel dengan ID " + id + " berhasil dihapus.");
        }
    }

    public void tampilkanNovel() {
        if (isEmpty()) {
            System.out.println("====================================================");
            System.out.println("|               Daftar Novel Kosong               |");
            System.out.println("====================================================");
            return;
        }

        NodeBukuPeminjam temp = head;
        System.out.println("======================================================================================================================");
        System.out.printf("%" + ((118 - 20)/2) + "s%s%n" , "" , "Koleksi Daftar Novel");
        System.out.println("======================================================================================================================");

        int nomor = 1;
        System.out.printf("| %-3s | %-7s | %-45s | %-22s | %-10s | %-12s |\n", "No", "ID", "Judul", "Penulis", "Genre", "Tahun Terbit");
        System.out.println("|-----|---------|-----------------------------------------------|------------------------|------------|--------------|");

        while (temp != null) {
            System.out.printf("| %-3s | %-7s | %-45s | %-22s | %-10s | %-12s |\n",
                    nomor++,
                    temp.id,
                    temp.judul,
                    temp.penulis,
                    temp.genre,
                    temp.tahunTerbit);
            temp = temp.next;
        }
        System.out.println("======================================================================================================================");
    }

    public NodeBukuPeminjam cariNovel(String id) {
        NodeBukuPeminjam temp = head;
        while (temp != null) {
            if (temp.id.equals(id)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void urutkanNovelByJudul() {
        head = mergeSort(head);
    }
    
    private NodeBukuPeminjam mergeSort(NodeBukuPeminjam head) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeBukuPeminjam tengah = getTengah(head);
        NodeBukuPeminjam bagianKedua = tengah.next;
        tengah.next = null;
        NodeBukuPeminjam bagianKiri = mergeSort(head);
        NodeBukuPeminjam bagianKanan = mergeSort(bagianKedua);
    
        return merge(bagianKiri, bagianKanan);
    }
    
    private NodeBukuPeminjam merge(NodeBukuPeminjam kiri, NodeBukuPeminjam kanan) {
        NodeBukuPeminjam head;
        if (kiri.judul.compareToIgnoreCase(kanan.judul) <= 0) {
            head = kiri;
            kiri = kiri.next;
        } else {
            head = kanan;
            kanan = kanan.next;
        }
    
        NodeBukuPeminjam current = head;
        while (kiri != null && kanan != null) {
            if (kiri.judul.compareToIgnoreCase(kanan.judul) <= 0) {
                current.next = kiri;
                kiri = kiri.next;
            } else {
                current.next = kanan;
                kanan = kanan.next;
            }
            current = current.next;
        }
        current.next = (kiri != null) ? kiri : kanan;
        return head;
    }
    
    private NodeBukuPeminjam getTengah(NodeBukuPeminjam head) {
        if (head == null) {
            return null;
        }
        NodeBukuPeminjam slow = head;
        NodeBukuPeminjam fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}