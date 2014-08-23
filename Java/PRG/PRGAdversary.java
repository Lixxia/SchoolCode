
/** Interface for adversaries against PRGs. */
public interface PRGAdversary {
	/** This function is called in the PRG game by the challenger
	 * with a random string random. The adversary should try to 
	 * return true if random is pseudo-random, 
	 * and false if random is truly random.
	 */
	boolean guess(byte[] random);
}
