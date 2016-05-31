package adapter.math;

public class AdapterArifmObject {

    private Arifmetika lib;

    public AdapterArifmObject() {
        lib = new Arifmetika();
    }

    public int  summa(int a, int b) {
        return lib.summa(new int[] {a, b});
    }

    public int multiply(int a, int b) {
        return lib.multiply(a, b, 1);
    }


}
