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

    public void urutkanNovel(int pilihan) {
        switch (pilihan) {
            case 1: head = mergeSort(head, "id"); break;
            case 2: head = mergeSort(head, "judul"); break;
            case 3: head = mergeSort(head, "penulis"); break;
            case 4: head = mergeSort(head, "tahunTerbit"); break;
            default: System.out.println("Pilihan invalid."); break;
        }
    }
    
    private Novel mergeSort(Novel head, String kriteria) {
        if (head == null || head.next == null) {
            return head;
        }

        Novel tengah = getTengah(head);
        Novel bagianKedua = tengah.next;
        tengah.next = null;

        Novel bagianKiri = mergeSort(head, kriteria);
        Novel bagianKanan = mergeSort(bagianKedua, kriteria);

        return merge(bagianKiri, bagianKanan, kriteria);
    }

    
    private Novel merge(Novel kiri, Novel kanan, String kriteria) {
        Novel head;

        if (compare(kiri, kanan, kriteria) <= 0) {
            head = kiri;
            kiri = kiri.next;
        } else {
            head = kanan;
            kanan = kanan.next;
        }

        Novel current = head;

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

    private int compare(Novel a, Novel b, String kriteria) {
        switch (kriteria) {
            case "id": return a.id.compareToIgnoreCase(b.id);
            case "judul": return a.judul.compareToIgnoreCase(b.judul);
            case "penulis": return a.penulis.compareToIgnoreCase(b.penulis);
            case "tahunTerbit": return Integer.compare(a.tahunTerbit, b.tahunTerbit);
            default: return 0;
        }
    }
    
    private Novel getTengah(Novel head) {
        if (head == null) {
            return null;
        }
        Novel slow = head;
        Novel fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}