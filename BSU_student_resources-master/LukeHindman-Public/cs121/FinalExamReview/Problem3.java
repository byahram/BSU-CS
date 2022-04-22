public class Problem3 {
	public static void main (String[] args) {

		for(int i = 100; i > 0; i--) {

			/* Check if i is odd */
			if(i%2 != 0) {
				/* check if i is multiple of 3 */
				if (i % 3 == 0) {
					if (i % 11 == 0) {
						System.out.print("Yay!");
					} else {
						System.out.print(i);
					}
					System.out.print(" ");


				}
			}
		}
		System.out.println();

	}
}