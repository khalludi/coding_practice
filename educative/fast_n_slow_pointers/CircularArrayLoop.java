class CircularArrayLoop {

    public static int updateIndex(int idx, int[] arr) {
        if(idx + arr[idx] >= arr.length) {
            return idx + arr[idx] - arr.length;
        } else if (idx + arr[idx] < 0) {
            return idx + arr[idx] + arr.length;
        } else {
            return idx + arr[idx];
        }
    }

    public static boolean loopExists(int[] arr) {
        int cnt = 0;
        boolean movingForward = true;
        int slowPtr = 0;
        int fastPtr = updateIndex(0, arr);
        while (cnt < arr.length && slowPtr != fastPtr) {
            // Process slow pointer
            int tmp = updateIndex(slowPtr, arr);
            if ((arr[slowPtr] > 0 && movingForward) || (arr[slowPtr] < 0 && !movingForward)) {
                slowPtr = tmp;
            } else {
                // Reset
                movingForward = !movingForward;
                fastPtr = tmp;
                cnt++;
                continue;
            }

            // Process fast pointer twice
            tmp = updateIndex(fastPtr, arr);
            if ((arr[fastPtr] > 0 && movingForward) || (arr[fastPtr] < 0 && !movingForward)) {
                fastPtr = tmp;
            } else {
                // Reset
                movingForward = !movingForward;
                slowPtr = fastPtr;
                fastPtr = tmp;
                cnt++;
                continue;
            }

            tmp = updateIndex(fastPtr, arr);
            if ((arr[fastPtr] > 0 && movingForward) || (arr[fastPtr] < 0 && !movingForward)) {
                fastPtr = tmp;
            } else {
                // Reset
                movingForward = !movingForward;
                slowPtr = fastPtr;
                fastPtr = tmp;
                cnt++;
                continue;
            }
        }

        return cnt != arr.length;


    }

    public static void main(String[] args) {
        System.out.println(CircularArrayLoop.loopExists(new int[] { 1, 2, -1, 2, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 2, -1, 2 }));
        System.out.println(CircularArrayLoop.loopExists(new int[] { 2, 1, -1, -2 }));
    }
}