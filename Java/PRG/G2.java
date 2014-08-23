
/** Implementation of a derived PRG (16 bytes->48 bytes).
 * It uses the PRG G (16 bytes->32 bytes).
 * G1(seed) = G(first)||second
 * with first||second := G(seed) and first,second 16 bytes
 */
public class G2 implements PRG {
	private PRG G = new Secret.G();
	public int getInputLen() { return 16; }
	public int getOutputLen() { return 48; }
	public byte[] random(byte[] seed) {
		byte[] g_rand = G.random(seed);
		byte[] first = Misc.split1(g_rand, 16, 16);
		byte[] second = Misc.split2(g_rand, 16, 16);
		byte[] g_rand2 = G.random(first);
		byte[] final_rand = Misc.concat(g_rand2,second);
		return final_rand;
	}
}