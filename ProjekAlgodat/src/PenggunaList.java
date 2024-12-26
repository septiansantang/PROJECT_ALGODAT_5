class PenggunaList {
    Pengguna head;
    Pengguna tail;

    public boolean isEmpty() {
        if (head == null) {
            System.out.println("Tidak ada Pengguna yang terdaftar");
            return true;
        }
        return false;
    }

    public void tambah(String username, String password) {
        Pengguna penggunaBaru = new Pengguna(username, password);
        if (head == null) {
            head = penggunaBaru;
            tail = penggunaBaru;
        } else {
            tail.next = penggunaBaru;
            tail = penggunaBaru;
        }
    }

    public void tampilkan() {
        if (isEmpty()) {
            return;
        }

        Pengguna temp = head;
        while (temp != null) {
            System.out.println(temp.username);
            temp = temp.next;
        }
    }

    public int signIn(String username, String password) {
        int usernameState = 0;
        if (username.equals("Admin")) {
            return usernameState = 2;
        }

        Pengguna temp = head;
        while (temp != null) {
            if (temp.username.equals(username)) {
                usernameState = 1;
                break;
            }
            temp = temp.next;
        }
        return usernameState;
    }

    public int logIn(String username, String password) {
        int logInState = 1;
        if (username.equals("Admin") && password.equals(("Admin"))) {
            return logInState = 2;
        }
        if (isEmpty()) {
            return 1;
        }

        Pengguna temp = head;
        while (temp != null) {
            if (temp.username.equals(username) && temp.password.equals(password)) {
                logInState = 0;
                break;
            }
            temp = temp.next;
        }
        return logInState;
    }
}
