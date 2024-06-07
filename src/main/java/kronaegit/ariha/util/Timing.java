package kronaegit.ariha.util;

public class Timing {
    private long s;
    public Timing() {
        this.s = System.currentTimeMillis();
    }
    public long get() {
        return System.currentTimeMillis() - s;
    }
    public long now() {
        long n = System.currentTimeMillis();
        long o = n - s;
        s = n;
        return o;
    }
}
