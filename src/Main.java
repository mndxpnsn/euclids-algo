public class Main {

    static Triple F_rec(long a, long b) {

        Triple res = new Triple(0, 0, 0);

        if(a == 0) {
            return new Triple(b, 0, 1);
        }

        if(a > 0) {
            Triple triple_loc = F_rec(b % a, a);
            long c = triple_loc.gcd;
            long x = triple_loc.x;
            long y = triple_loc.y;

            return new Triple(c, y - x * (b / a), x);
        }

        return res;
    }

    static Triple F(long a, long b) {

        Triple res = a < b ? F_rec(a, b) : F_rec(b, a);

        if(a > b) {
            long tmp = res.x;
            res.x = res.y;
            res.y = tmp;
        }

        return res;
    }

    public static void main(String[] args) {

        long a = 320;
        long b = 2700;

        Triple res = F(a, b);

        System.out.println("a: " + a + ", b: " + b);
        System.out.println("gcd: " + res.gcd + ", x: " + res.x + ", y: " + res.y);
        System.out.println("ax + by: " + (a * res.x + b * res.y));
    }
}
