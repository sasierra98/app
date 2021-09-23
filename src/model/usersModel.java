package model;

public class usersModel {

    private int id;
    private String username, password, email;

    public usersModel(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public usersModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public usersModel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object[] toArray() {
        return new Object[]{id, username, password, email};
    }

//    @Override
//    public String toString() {
//        return username;
//    }

}
