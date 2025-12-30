package student;

public class MergeTester {

    public static void main(String[] args) {
        Integer[] intArr = {4, 2, 6, 12, 9, 4, 8};

        Integer[] expected = {2, 4, 4, 6, 8, 9, 12};
        MergeSorter intTest = new MergeSorter();
        intTest.sort(intArr);
        System.out.println(intArr);

    }
}
