package Package1;

public class User {

    //här har vi en basic användarklass

    private boolean _validatedUser;
    private String _accountType;

    public User(boolean validatedUser, String accountType){
        this._validatedUser = validatedUser;
        this._accountType = accountType;
    }

}
