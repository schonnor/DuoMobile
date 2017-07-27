/* This is the primary function through which all HTML files, and all Java files are run
 * It features a simple, one url webpage with a get and post path
 */
package duo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //Spring runs through a controller, this @ declares this to be the main controller
public class DuoController {

	private static String privateUsername = "username"; //Username and password are hardcoded for this demo, no actual storage of log in information occurs
	private static String privatePassword = "password";
	
    @GetMapping("/loginIndex") //The get mapping, any call to "/loginIndex" with a "GET" method will be directed here, also functions as the start up page
    public String loginIndex(Model model) { //Parameter Model model in this case creates a model map that can receive a new object, in this case the loginIndex object, to store information inputted in this login page
    	model.addAttribute("loginIndex", new loginIndex()); //Here the loginIndex() object is created and added to the model, so inputted information can be sent from loginIndex.html to this object an be stored
        return "loginIndex"; //This returns the loginIndex.html file to the /loginIndex call, loading the loginIndex.html page whenever /loginIndex is called with a "GET" method
    }
    
    @PostMapping("/loginIndex") //The post mapping, any call to "/loginIndex" with a "POST" method will be directed here
    public String login(@ModelAttribute loginIndex loginIndex) { //login() receives the modelAttribute loginIndex created in line 20, so it can gain access to the username, password, and sigREquest generated in that model
    	if(privateUsername.equals(loginIndex.getUsername()) && privatePassword.equals(loginIndex.getPassword()))//Compares the inputted username and password to the hardcoded ones in line 15, if they match it moves to login.html
    	{
    		loginIndex.setSigRequest(); //This calls the setSigRequest method in the loginIndex attribute brought in from the parameter, creating a sigRequest that the login.html file later uses
    		return "login"; //This returns the login.html file to the /loginIndex call, loading the login.html page when /loginIndex called ith a "POST" method passes the if tree
    	}
    	else //Should the username and password entered at the initial loginIndex page not match the hardcoded ones in line 15 
    		return "notLogin"; //This returns the page notLogin.html which simply alerts the enduser of an error and sends them back to the initial login page to try again
    }
}