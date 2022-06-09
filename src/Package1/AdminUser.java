package Package1;

public class AdminUser implements IAdminUser {//IAdminUser extends IUser


    private boolean _validatedUser;
    private String _accountType;
    private String _firstName;
    private String _lastName;

    public AdminUser(boolean validatedUser, String accountType, String firstName, String lastName){
        this._validatedUser = validatedUser;
        this._accountType = accountType;
        this._firstName = firstName;
        this._lastName = lastName;
    }

    @Override
    public boolean isUserAdmin(){
        boolean isAdmin = false;

        if(this._accountType.equalsIgnoreCase("admin") || this._accountType.equalsIgnoreCase("staff")){
            isAdmin = true;
        }
        return isAdmin;
    }

    @Override
    public String getName(){

        return _firstName+" "+_lastName;
    }

}

//public class UserDetails extends User {
//
//    public UserDetails(boolean validatedUser, String accountType) {
//        super(validatedUser, accountType);
//    }
//
//}
