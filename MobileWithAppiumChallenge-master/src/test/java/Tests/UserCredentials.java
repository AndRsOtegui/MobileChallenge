package Tests;

public class UserCredentials {
    private String userName;

    private String passWord;

    public void setCredentials(){
        String userVariableUserName = "usernameIMDB";
        userName = System.getenv(userVariableUserName);
        String userVariablePassword ="passwordIMDB";
        passWord = System.getenv(userVariablePassword);
    }

    public String getUserName(){
        return userName;
    }

    public String getPassWord(){
        return passWord;
    }
}
