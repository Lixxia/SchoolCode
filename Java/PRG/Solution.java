
@SuppressWarnings("unused")
public class Solution {

	public static class Adv_G_C implements PRGAdversary {
		private PRGAdversary Adv_G2 = new Secret.Adv_G2(true);
		private PRG G = new Secret.G();
		public boolean guess(byte[] random) {
		    // call Adv_G2.guess(...) to solve this
		    return false;
		}
	}

	public static class Adv_G_B implements PRGAdversary {
		private PRGAdversary Adv_G2 = new Secret.Adv_G2(false);
		private PRG G = new Secret.G();
		public boolean guess(byte[] random) {
		    // call Adv_G2.guess(...) to solve this
		    return false;
		}
	}

	public static class Adv_G_A implements PRGAdversary {
		private PRGAdversary Adv_G1 = new Secret.Adv_G1();
		public boolean guess(byte[] random) {
		    // call Adv_G1.guess(...) to solve this
			byte[] first = Misc.split1(random,16,16);
			byte[] result = Misc.concat(random,first);
			return Adv_G1.guess(result);
		}
	}
}
