public class User {
    private String username;
    private String password;

    User (String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    String getUsername() {return username;}
    String getPassword() {return password;}
}
