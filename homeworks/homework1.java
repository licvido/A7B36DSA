import java.util.Arrays;

class Homework1 implements Mergesort {

	public int[] getFirstHalfOf(int[] array) {
		int length = (array.length / 2) + (array.length % 2);
		return Arrays.copyOfRange(array, 0, length);
	}


	public int[] getSecondHalfOf(int[] array) {
		int length = (array.length / 2) + (array.length % 2);
		return Arrays.copyOfRange(array, length, array.length);
	}


	public int[] merge(int[] firstHalf, int[] secondHalf) {
		int[] res = new int[firstHalf.length + secondHalf.length];
        int i = 0;

		while ((firstHalf.length > 0) && (secondHalf.length > 0)) {
			if (firstHalf[0] > secondHalf[0]) {
				res[i++] = secondHalf[0];
				secondHalf = Arrays.copyOfRange(secondHalf, 1, secondHalf.length);

			} else {
				res[i++] = firstHalf[0];
				firstHalf = Arrays.copyOfRange(firstHalf, 1, firstHalf.length);
			}

			if ((firstHalf.length == 0) && (secondHalf.length != 0)) {
				System.arraycopy(secondHalf, 0, res, i, secondHalf.length);
			}

			if ((firstHalf.length != 0) && (secondHalf.length == 0)) {
				System.arraycopy(firstHalf, 0, res, i, firstHalf.length);
			}
		}

		return res;
	}


    public int[] mergesort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] leftHalf = mergesort(getFirstHalfOf(array));
        int[] rightHalf = mergesort(getSecondHalfOf(array));
        return merge(leftHalf, rightHalf);
    }

}