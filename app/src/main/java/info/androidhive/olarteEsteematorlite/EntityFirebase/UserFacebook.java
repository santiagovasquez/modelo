package info.androidhive.olarteEsteematorlite.EntityFirebase;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by santiagovasquez on 10/04/2017.
 */
public class UserFacebook {

    public String uid;
    public String email;
    public String firstName;
    public String lastName;
    public String gender;

    public UserFacebook(){

    }

    public UserFacebook(String uid,String email,String firstName, String lastName,String gender){
        this.email=email;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gender=gender;
        this.uid=uid;
    }

    public Map<String, Object> map (){
        HashMap<String , Object> result = new HashMap<>();
        result.put("uid",uid);
        result.put("email",email);
        result.put("firstName",firstName);
        result.put("lastName",lastName);
        result.put("gender",gender);
        return result;
    }

}
