package Entity;

public class User {

    protected String userId;
    protected String username;
    protected String password;
    protected boolean authorized;

    public User(String userId, String username, String password, boolean authorized) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.authorized = authorized;
    }

    public User () {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorized=" + authorized +
                '}';
    }
}
