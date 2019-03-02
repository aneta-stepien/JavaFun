package vi;

class ElementRemoval {

    /**
     *  Given an array of elements, we want to remove exactly one element.
     *  After the element is removed, the remaining array should in a sorted state (non-descending)
     *  E.g., for an array: [2, 5, 7, 3, 7, 11] the answer is 2 (we can remove 3-rd or 4-th element)
     *  For an array: [1 5 2 7 1 9] the answer is 0 (there is no way to remove one element so that the rest is sorted)
     *  @param elements array of elements, e.g. [3, 4, 5, 3, 6]
     *  */
    public static int countNumberOfWaysToRemoveAnElement(int[] elements) {
        int previousElement = 0;

        int result = 0;
        boolean foundABadPair = false;

        for(int i=0; i<elements.length; i++){
            int element = elements[i];
            if(element < previousElement){
                if(foundABadPair){
                    return 0;
                }
                foundABadPair = true;
                result = checkSecondElementRemoval(elements, previousElement, result, i);
                result = checkFirstElementRemoval(elements, result, i, element);
                if (result == 0) {
                    return 0;
                }
            }
            previousElement = element;
        }

        if(!foundABadPair){
            return elements.length;
        } else {
            return result;
        }
    }

    private static int checkFirstElementRemoval(int[] A, int result, int i, int element) {
        if(i > 1) {
            int previousElement = A[i-2];
            if(element >= previousElement){
                result++;
            }
        } else {
            result++;
        }
        return result;
    }

    private static int checkSecondElementRemoval(int[] A, int previousElement, int result, int i) {
        if(A.length > i+1){
            int nextElement = A[i+1];
            if (nextElement >= previousElement) {
                result++;
            }
        } else {
            result++;
        }
        return result;
    }


}