package bitwiseOperation.print32bit;

/**
 * @Author: yangyuecheng
 * @Description: 打印整数的二进制32位
 * @CreateTime: 2023-10-28 15:28
 */
public class Solution {

    public static void print(int num) {
        for (int i = 31; i >= 0; --i) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
    }

    /*
        5

        1 0 1
          &
        1 0 0      1 << 2
        1 0 0        == 1

        0 1 0 1
           &
        1 0 0 0    1 << 3
        0 0 0 0      == 0

        & 运算 都为1 得 1 , 其他都得 0
        | 运算 有1就得1
        ^ 运算 相同为0，不同为1
        ~ 运算 1变0 ， 0变1

     */
    public static void main(String[] args) {
        int num = 5;
        print(num);
    }
}
