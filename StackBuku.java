public class StackBuku {
    NodeBukuPeminjam top;
    NodeBukuPeminjam bottom;
    public int n;

    public StackBuku() {
        this.top = null;
        this.bottom = null;
        this.n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(String id, String judul, String penulis, String genre, int tahunTerbit) {
        NodeBukuPeminjam newNode = new NodeBukuPeminjam(id, judul, penulis, genre, tahunTerbit);
        newNode.next = top;
        top = newNode;
        if (isEmpty()) {
            bottom = newNode;
        }
        n++;
    }

    public void push(NodeBukuPeminjam novel) {
        novel.next = top;
        top = novel;

        if (isEmpty()) {
            bottom = novel;
        }
        n++;
    }

    public int getsize() {
        return n;
    }

    public void printSize() {
        System.out.println(n);
    }

    public NodeBukuPeminjam pop() {
        if (isEmpty())
            return null;
        NodeBukuPeminjam poppedStack = top;
        top = top.next;
        if (--n == 0)
            bottom = null;
        return poppedStack;
    }
}
