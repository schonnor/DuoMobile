package duo;

public class loginIndex { //Creates the loginIndex object

    private String username;
    private String password;
    private String sigRequest;

    public String getUsername() { //method for getting the username of any loginIndex object
        return username;
    }

    public void setUsername(String username) { //method for setting the username of any loginIndex object
        this.username = username;
    }

    public String getPassword() { //method for getting the password of any loginIndex object
        return password;
    }

    public void setPassword(String password) { //method for setting the password of any loginIndex object
        this.password = password;
    }
    
    public String getSigRequest() { //method for getting the sigRequest of any loginIndex object
        return sigRequest;
    }
    /*
     * To ensure that all Duo Web SDK's are linked to an actual account, Duo provides three variables with every Web SDK that must be verified
     * Integration key and Secret key below are both used as part of generating the signed request to access the Web SDK, while a third Host variable
     * is generated and can be found in login.html as part of the call to Duo's provided Javascript
     */
    public void setSigRequest() { //method for setting the sigRequest of any loginIndex object, no parameter required, generates it all on its own
    	String ikey = "DIIDEISCSE5SPOZR41KL"; //Given by Duo in the Web SDK
    	String skey = "PJEgxAWQOwumI0TE6yT7vfIDyDB0FIxpcvREJFMh"; //Given by Duo in the Web SDK
    	String akey = "b6b6b6b6b6b6b6b6b6b6b6b6b6b6b6b6b6b6bb6b6b66b6b6b6b6"; //This is randomly generated and should be stored separate from Duo
    	String sig_request = DuoWeb.signRequest(ikey, skey, akey, username); //Generates the signed request by calling on the DuoWeb.java given by Duo
    	this.sigRequest = sig_request;
    }  

}