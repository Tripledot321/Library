package Package1;

public class User {


    private boolean _validatedUser;
    private String _accountType;

    public User(boolean validatedUser, String accountType){
        this._validatedUser = validatedUser;
        this._accountType = accountType;
    }

    public boolean isUserAdmin(){

        boolean isAdmin = false;
        
        if(this._accountType.equalsIgnoreCase("admin") || this._accountType.equalsIgnoreCase("staff")){
            isAdmin = true;
        }


        return isAdmin;
    }

}

//public class UserDetails extends User {
//
//    public UserDetails(boolean validatedUser, String accountType) {
//        super(validatedUser, accountType);
//    }
//
//}
