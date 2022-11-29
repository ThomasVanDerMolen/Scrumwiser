
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class loginInfo {

    private int valid = 0;
    public void userPass() throws IOException
    {
        //valid = inputValid;
        String username;
        String password;

        // Used to hold the instance of a user who successfully logged in
        User loggedInUser = null;

        // Create an empty list to hold users
        List<User> listOfUsers = new ArrayList<>();

        // Add 3 users to the list
        listOfUsers.add(new User("user1","password1"));
        listOfUsers.add(new User("user2","password2"));
        listOfUsers.add(new User("user3","password3"));

        // Get user input
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        username = br.readLine();   
    
        password = br.readLine();

        // Iterate through list of users to see if we have a match
        for (User user : listOfUsers)
        {
            if (user.getUsername().equals(username))
            {
                if (user.getPassword().equals(password))
                {
                    loggedInUser = user;

                    // when a user is found, "break" stops iterating through the list
                    break;
                }
            }
        }

        // if loggedInUser was changed from null, it was successful
        if (loggedInUser != null)
        {
            valid = 1;
            
        }
        else
        {
            valid = 0;
            
        }
        
    }

    public int getValid()
    {
        return valid;
    }
    
}

