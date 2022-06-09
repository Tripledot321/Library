package Package1;

public class User implements IUser {


    private boolean _validatedUser;
    private String _firstName;
    private String _lastName;

    public User(boolean validatedUser, String firstName, String lastName){
        this._validatedUser = validatedUser;
        this._firstName = firstName;
        this._lastName = lastName;
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
