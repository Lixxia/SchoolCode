import static java.lang.System.out;

import java.util.Random;

public class Misc {
	/** Concatenates two byte arrays */
	public static byte[] concat(byte a[], byte b[]) {
		byte[] result = new byte[a.length+b.length];
		for (int i=0; i<a.length; i++)
			result[i] = a[i];
		for (int i=0; i<b.length; i++)
			result[a.length+i] = b[i];
		return result;
	}

	/** Splits array into two arrays of lengths len1,len2 and returns the first */
	public static byte[] split1(byte[] array, int len1, int len2) {
		if (len1+len2 != array.length)
			throw new IllegalArgumentException("i+j != array.length ("+len1+"+"+len2+"!="+array.length+")");
		byte result[] = new byte[len1];
		for (int i=0; i<len1; i++)
			result[i] = array[i];
		return result;
	}
	
	/** Splits array into two arrays of lengths len1,len2 and returns the second */
	public static byte[] split2(byte[] array, int len1, int len2) {
		if (len1+len2 != array.length)
			throw new IllegalArgumentException("i+j != array.length ("+len1+"+"+len2+"!="+array.length+")");
		byte result[] = new byte[len2];
		for (int i=0; i<len2; i++)
			result[i] = array[i+len1];
		return result;
	}
	
	/** Returns true iff array1 and array2 have identical content */
	public static boolean arrayEqual(byte array1[], byte array2[]) {
		if (array1.length!=array2.length)
			throw new IllegalArgumentException("arrays have different lengths +("+array1.length+" vs "+array2.length+")");
		boolean eq = true;
		for (int i=0; i<array1.length; i++)
			if (array1[i] != array2[i]) { eq = false; break; }
		return eq;
	}

	private static Random R = new Random();
	/** Fills a byte array with random data */
	public static void fillRandom(byte[] array) {
		R.nextBytes(array);
	}
	
	/** Tests whether Adv is a successful adversary for the PRG G.
	 * It runs a 1000 executions of the PRG game, and outputs and returns 
	 * the success rate.
	 * A bad adversary will have success rate around 0.5.
	 * A good one close to 1. */
	public static double testAdversary(PRG G, PRGAdversary Adv) {
		Random R = new Random();
		int numTries = 1000;
		int numSuccess = 0;
		for (int i=0; i<numTries; i++) {
			boolean b_chall = R.nextBoolean();
			byte[] rand;
			if (b_chall) {
				byte[] seed = new byte[G.getInputLen()];
				R.nextBytes(seed);
				rand = G.random(seed);
			} else {
				rand = new byte[G.getOutputLen()];
				R.nextBytes(rand);
			}
			boolean b_adv = Adv.guess(rand);
//			System.out.println("b_adv="+b_adv+", b_chall="+b_chall);
			if (b_adv == b_chall) numSuccess ++;
		}
		double rate = ((double)numSuccess)/numTries; 
		System.out.println("Success rate: "+rate);
		return rate;
	}

	/** Prints the content of the array array */
	public static void printArray(byte[] array) {
		if (array.length==0) out.println("[]"); 
		StringBuffer strb = new StringBuffer("[");
		strb.append(Integer.toHexString(array[0]&0xFF));
		for (int i=1; i<array.length; i++)
			strb.append(", ").append(Integer.toHexString(array[i]&0xFF));
		strb.append("]");
		out.println(strb);
	}

	
	/** Tests all the adversaries (both those that are given, and those that should be implemented in the homework) */
	public static void main(String args[]) {
		out.println("Testing builtin adversary against G1");
		testAdversary(new G1(), new Secret.Adv_G1());

		out.println("Testing builtin adversary Adv_G2(true) against G2");
		testAdversary(new G2(), new Secret.Adv_G2(true));
		
		out.println("Testing builtin adversary Adv_G2(false) against G2");
		testAdversary(new G2(), new Secret.Adv_G2(false));
		
		out.println("Testing your first adversary (Adv_G_A) against G");
		testAdversary(new Secret.G(), new Solution.Adv_G_A());

		out.println("Testing your second adversary (Adv_G_B) against G");
		testAdversary(new Secret.G(), new Solution.Adv_G_B());

		out.println("Testing your third adversary (Adv_G_C) against G");
		testAdversary(new Secret.G(), new Solution.Adv_G_C());
	}
}
