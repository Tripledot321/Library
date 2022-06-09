package Package1;

public class AdminUser extends User implements IAdminUser{//IAdminUser extends IAdminUser

    private String _accountType;


    public AdminUser(boolean validatedUser, String accountType, String firstName, String lastName) {
        super(validatedUser, firstName, lastName);
        this._accountType = accountType;
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
        //unikt beteende
        return super.getName()+" ("+_accountType+")";
    }

}

//public class UserDetails extends User {
//
//    public UserDetails(boolean validatedUser, String accountType) {
//        super(validatedUser, accountType);
//    }
//
//}
