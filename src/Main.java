public class Main {

    static Triple F(long a, long b) {

        Triple res = new Triple(0, 0, 0);

        if(a == 0) {
            res.gcd = b;
            res.x = 0;
            res.y = 1;
            return res;
        }

        if(a > 0) {
            Triple triple_loc = F(b % a, a);
            long c = triple_loc.gcd;
            long x = triple_loc.x;
            long y = triple_loc.y;

            Triple res_loc = new Triple(c, y - x * (b / a), x);
            return res_loc;
        }

        return res;
    }

    static Triple F_wrap(long a, long b) {

        Triple res = a < b ? F(a, b) : F(b, a);

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

        Triple res = F_wrap(a, b);

        System.out.println("a: " + a + ", b: " + b);
        System.out.println("gcd: " + res.gcd + ", x: " + res.x + ", y: " + res.y);
        System.out.println("ax + by: " + (a * res.x + b * res.y));
    }
}
