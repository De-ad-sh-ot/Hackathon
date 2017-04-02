package infotech.hackathon.login;


public class UserProfile {

    private String username;
    private String email;
    private String mobileNo;
    private String name;
    private int userType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getUserType() {
        return userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String companyName) {
        this.name = companyName;
    }
}