public class Whisper
{
	public String toWhom(String[] usernames, String typed)
	{
		if(!typed.substring(0, 4).equalsIgnoreCase("/msg"))
			return "not a whisper";

		String[] split = typed.split(" ");

		if(split.length == 1)
			return "not a whisper";

		int usernameIndex = -1;
		int splitIndex = -1;
		String username = "";
        String nameToCheck = "";
		for(int i = 1; i<split.length; i++)
		{
			nameToCheck += split[i];

			for(int j = 0; j<usernames.length; j++)
				if(nameToCheck.equalsIgnoreCase(usernames[j]))
				{
					usernameIndex = j;
					splitIndex = i;
                	username = nameToCheck;
					break;
				}

			nameToCheck += " ";
		}

		// username not found
		if(usernameIndex == -1)
			return "user is not logged in";

		// check for no space after username
		int startLength = 5 + username.length();
		if(typed.length() == startLength)
			return "user is not logged in";

		return usernames[usernameIndex];
	}
}