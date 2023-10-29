package random;

/**
 * @Author: yangyuecheng
 * @Description:
 * @CreateTime: 2023-10-29 12:18
 */
public class RandtoRand {


    public static void main(String[] args) {
        int count = 0;
        int testTimes = 10000;
        for (int i = 0; i < testTimes; i++) {
            if (f2() == 0) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println("=========================");
        int[] counts = new int[8];
        for (int i = 0; i < testTimes; i++) {
            int num = g();
            counts[num]++;
        }
        for (int i = 0; i < 8; i++) {
            System.out.println(i + "这个数，出现了" + counts[i] + " 次");
        }
    }

    // 1 - 5 的随机数
    public static int f() {
        return (int) (Math.random() * 5) + 1;
    }

    // 随机机制，只能用f()
    // 等概率返回0,1
    public static int f2() {
        int ans = 0;
        do {
            ans = f();
        } while (ans == 3);
        return ans < 3 ? 0 : 1;
    }

    // 000 - 111 做到等概率  （0 - 7）等概率返回一个
    // 3 个 二级制位
    public static int f3() {
        return (f2() << 2) + (f2() << 1) + (f2() << 0);
    }

    // 0 ~ 6 等概率返回一个
    public static int f4() {
        int ans = 0;
        do {
            ans = f3();
        } while (ans == 7);
        return ans;
    }

    // 1 ~ 7 随机
    public static int g() {
        return f4() + 1;
    }

    //以固定概率返回0 1
    public static int x() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    //等概率返回 0和1
    /*
      0 0 重做
      1 1 重做
      1 0  -> 1
      0 1  -> 0
     */
    public static int y() {
        int ans = 0;
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

}
