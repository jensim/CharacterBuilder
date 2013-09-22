package se.jensim.chargen.prop;

/**
 *
 * @author jens
 */
public class ConstRoles {

	private ConstRoles() {
	}
	public static final String USER = "user",
			MODERATOR = "moderator",
			ADMIN = "admin",
			OWNER = "owner";
	public static final String[] ALL = new String[]{
		USER, MODERATOR, ADMIN, OWNER};
}
