
/** Interface for pseudo random generators */
public interface PRG {
	/** Returns the input length of the PRG (in bytes) */
	int getInputLen();

	/** Returns the output length of the PRG (in bytes) */
	int getOutputLen();
	
	/** Returns G(seed) where G is the PRG. */
	byte[] random(byte[] seed);
}
