class PenggunaList {
    Pengguna head;
    Pengguna tail;
    


    public boolean isEmpty(){
        if(head==null){
            System.out.println("Tidak ada Pengguna yang terdaftar");
            return true;
        }
        return false;
    }

    public void tambah(String username, String password){
        Pengguna penggunaBaru = new Pengguna(username, password);
        if(head==null){
            head = penggunaBaru;
            tail = penggunaBaru;
        }else{
            tail.next = penggunaBaru;
            tail = penggunaBaru;
        }
    }

    public void hapus(String username){
        if(isEmpty()){
            return;
        }

        if(head.username.equals(username)){
            head = head.next;
            if(head==tail){
                tail = null;
            }
            return;
        }

        Pengguna temp = head;
        while (temp.next != null && temp.next.username.equals(username)) {
            temp = temp.next;
        }

        if(temp.next != null){
            temp.next = temp.next.next;
        }else{
            System.out.println("Pengguna dengan username "+username+" tidak ditemukan");
        }
    }

    public void tampilkan(){
        if(isEmpty()){
            return;
        }

        Pengguna temp = head;
        while (temp != null) {
            System.out.println(temp.username);
            temp = temp.next;
        }
    }
    public boolean signIn(String username, String password){
        boolean usernameExist = false;

        Pengguna temp = head;
        while (temp != null) {
            if(temp.username.equals(username)){
                System.out.println("Username telah diambil");
                usernameExist = true;
            }
            temp = temp.next;
        }
        return usernameExist;
    }

    public boolean logIn(String username, String password){
        boolean logInSukses = false;
        if(isEmpty()){
            return false;
        }

        Pengguna temp = head;
        while (temp != null) {
            if(temp.username.equals(username) && temp.password.equals(password)){
                logInSukses = true;
                break;
            }
            temp = temp.next;
        }
        return logInSukses;
    }
}