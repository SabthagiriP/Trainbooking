public class User {
    private String name;
    private int age;
    private String mobileNo;
    private String email;
    private String password;

    public User(String name, int age, String mobileNo, String email, String password) {
        this.name = name;
        this.age = age;
        this.mobileNo = mobileNo;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}

