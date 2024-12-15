public class NovelList {
    Novel head;
    Novel tail;

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahNovel(String id, String judul, String penulis, String genre, int tahunTerbit) {
        Novel novelBaru = new Novel(id, judul, penulis, genre, tahunTerbit);
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

        Novel temp = head;
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

        Novel temp = head;
        System.out.println("====================================================");
        System.out.println("|               Koleksi Daftar Novel              |");
        System.out.println("====================================================");

        int nomor = 1;
        System.out.println(
                "| No  | ID Buku | Judul                                 | Penulis                | Genre      | Tahun Terbit |");
        System.out.println(
                "|-----|---------|----------------------------------------|------------------------|------------|--------------|");

        while (temp != null) {
            System.out.printf("| %-3d | %-7s | %-38s | %-22s | %-10s | %-12d |\n",
                    nomor++,
                    temp.id,
                    temp.judul,
                    temp.penulis,
                    temp.genre,
                    temp.tahunTerbit);
            temp = temp.next;
        }

        System.out.println("====================================================");
    }

    public Novel cariNovel(String id) {
        Novel temp = head;
        while (temp != null) {
            if (temp.id.equals(id)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
