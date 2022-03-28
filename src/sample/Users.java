package sample;

public class Users {
    private String userId;
    private String password;

    public Users(String s1,String s2){
        userId=s1;
        password=s2;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;

    }

    @Override
    public String toString() {
        return "Users{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
