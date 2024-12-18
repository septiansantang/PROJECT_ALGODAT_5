public class QueuePeminjam {
    private NodePeminjam front;
    private NodePeminjam rear;
    public int n;

    public QueuePeminjam() {
        this.front = null;
        this.rear = null;
        this.n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public void enqueue(String nama){
        NodePeminjam newNode = new NodePeminjam(nama);
        if(isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        n++;
    }

    public NodePeminjam dequeue(){
        if (isEmpty()) return null;
        NodePeminjam dequeuedQueue = front;
        front = front.next;
        if (--n == 0) rear = null;
        return dequeuedQueue;
    }

    public void tampilkan(){
        System.out.println("====================================");
        System.out.println("=           DAFTAR ANTRIAN         =");
        if (isEmpty()) {
            System.out.println("Antrian Kosong");
        } else {
            NodePeminjam temp = front;
            int noAntrian = 0;
            while (temp!=null) {
                noAntrian++;
                System.out.println("====================================");
                System.out.print("Nama : "+temp.username+"\n");
                System.out.print("Antrian ke : "+noAntrian+"\n");
                System.out.print("Jumlah Buku : "+temp.buku.n+"\n"); //tidak keitung
                System.out.println("====================================");
                temp = temp.next;
            }
        }

    }

}
