package Package1;

public class UserService {

    private DatabaseConn database;
    public UserService(DatabaseConn database){
        this.database = database;
    }

    public void signInUser(String username, String password){

        System.out.println("User service was requested to sign in username: '"+username+"' and user password: '"+password+"'");

        boolean result = database.validateUser(username, password);

    }

}
