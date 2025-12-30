package student;

//9783



public class MergeSorter <T extends Comparable<T>> implements Sorter<T>{

    public MergeSorter() {

    }

    public boolean sort (T [] items) {
        mergeSort(items, 0, items.length - 1);
    }

    public void mergeSort(T[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        merge(array, start, mid, end);
    }

    @SuppressWarnings("unchecked")
    public void merge(T[] array, int start, int mid, int end) {

        int leftLen = mid - start + 1;
        int rightLen = end - mid;

        Comparable[] leftArr = new Comparable[leftLen];
        Comparable[] rightArr = new Comparable[rightLen];

        for (int i = 0; i < leftLen; i++) {
            leftArr[i] = array[start + i];
        }

        for (int i = 0; i < rightLen; i++) {
            rightArr[i] = array[mid + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = start;

        while (i < leftLen && j < rightLen) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                array[k] = (T)leftArr[i];
            } else if (array[k] == rightArr[j]) {
                j++;
            }
            k++;
        }

        while (i < leftLen) {
            array[k] = (T)leftArr[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            array[k] = (T)rightArr[j];
            j++;
            k++;
        }

    }
}


