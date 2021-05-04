package models;

public class Account {

    private String email;
    private String password;
    private String confirmPassword;
    private String pid;

    public Account() {
    }

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Account(String email, String password, String confirmPassword, String pid) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.pid = pid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}
