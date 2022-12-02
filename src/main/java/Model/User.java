package Model;

public class User {
    private int idUser;
    private String userName;
    private String password;
    private String phoneNumber;
    private String email;
    private String address;
    private int statusUser;

    public int getIdUser() {
        return idUser;
    }

    public class Users {
        private int idUser;
        private String userName;
        private String password;
        private String phoneNumber;
        private String email;
        private String address;
        private int statusUser;

        public void setIdUser(int idUser) {
            this.idUser = idUser;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getStatusUser() {
            return statusUser;
        }

        public void setStatusUser(int statusUser) {
            this.statusUser = statusUser;
        }

        public Users() {
        }

        public Users(String userName, String password, String phoneNumber, String email, String address, int statusUser) {
            this.userName = userName;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
            this.statusUser = statusUser;
        }

        public Users(int idUser, String userName, String password, String phoneNumber, String email, String address, int statusUser) {
            this.idUser = idUser;
            this.userName = userName;
            this.password = password;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
            this.statusUser = statusUser;
        }
    }
}