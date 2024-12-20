public class NovelList {
    NodeBukuPeminjam head;
    NodeBukuPeminjam tail;
    BSTBuku bst;

    public NovelList() {
        this.bst = new BSTBuku();
    }

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
        bst.insert(novelBaru); // Add novel to BST
        System.out.println("Novel berhasil ditambahkan: " + judul);
    }

    public void tampilkanNovel() {
        if (isEmpty()) {
            System.out.println("====================================================");
            System.out.println("|               Daftar Novel Kosong               |");
            System.out.println("====================================================");
            return;
        }

        NodeBukuPeminjam temp = head;
        System.out.println(
                "======================================================================================================================");
        System.out.printf("%" + ((118 - 20) / 2) + "s%s%n", "", "Koleksi Daftar Novel");
        System.out.println(
                "======================================================================================================================");

        int nomor = 1;
        System.out.printf("| %-3s | %-7s | %-45s | %-22s | %-10s | %-12s |\n", "No", "ID", "Judul", "Penulis", "Genre",
                "Tahun Terbit");
        System.out.println(
                "|-----|---------|-----------------------------------------------|------------------------|------------|--------------|");

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
        System.out.println(
                "======================================================================================================================");
    }

    public NodeBukuPeminjam cariNovel(String idBuku) {
        NodeBukuPeminjam result = bst.search(idBuku);
        return result;
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

    public void urutkanNovel(int pilihan) {
        switch (pilihan) {
            case 1: head = mergeSort(head, "id"); break;
            case 2: head = mergeSort(head, "judul"); break;
            case 3: head = mergeSort(head, "penulis"); break;
            case 4: head = mergeSort(head, "tahunTerbit"); break;
            default: System.out.println("Pilihan invalid."); break;
        }
    }

    private NodeBukuPeminjam mergeSort(NodeBukuPeminjam head, String kriteria) {
        if (head == null || head.next == null) {
            return head;
        }
        NodeBukuPeminjam tengah = getTengah(head);
        NodeBukuPeminjam bagianKedua = tengah.next;
        tengah.next = null;

        NodeBukuPeminjam bagianKiri = mergeSort(head, kriteria);
        NodeBukuPeminjam bagianKanan = mergeSort(bagianKedua, kriteria);
        return merge(bagianKiri, bagianKanan, kriteria);
    }

    private NodeBukuPeminjam merge(NodeBukuPeminjam kiri, NodeBukuPeminjam kanan, String kriteria) {
        NodeBukuPeminjam head;

        if (compare(kiri, kanan, kriteria) <= 0) {
            head = kiri;
            kiri = kiri.next;
        } else {
            head = kanan;
            kanan = kanan.next;
        }

        NodeBukuPeminjam current = head;
        while (kiri != null && kanan != null) {
            if (compare(kiri, kanan, kriteria) <= 0) {
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

    private int compare(NodeBukuPeminjam a, NodeBukuPeminjam b, String kriteria) {
        switch (kriteria) {
            case "id": return a.id.compareToIgnoreCase(b.id);
            case "judul": return a.judul.compareToIgnoreCase(b.judul);
            case "penulis": return a.penulis.compareToIgnoreCase(b.penulis);
            case "tahunTerbit": return Integer.compare(a.tahunTerbit, b.tahunTerbit);
            default: return 0;
        }
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