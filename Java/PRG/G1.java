
/** Implementation of a derived PRG (32 bytes->48 bytes).
 * It uses the PRG G (16 bytes->32 bytes).
 * G1(s1||s2) = G(s1)||s2 with s1,s2 16 bytes.
 */
public class G1 implements PRG {
	private PRG G = new Secret.G();
	public int getInputLen() { return 256/8; } // 32
	public int getOutputLen() { return 3*128/8; } // 48
	public byte[] random(byte[] seed) {
		byte[] s1 = Misc.split1(seed,16,16);
		byte[] s2 = Misc.split2(seed,16,16);
		byte[] r1 = G.random(s1);
		return Misc.concat(r1,s2);
	}
}