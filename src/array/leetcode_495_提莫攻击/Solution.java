package array.leetcode_495_提莫攻击;

/**
 * @Author: yangyuecheng
 * @CreateTime: 2023-10-18 17:31
 * @Description: 提莫攻击
 */
public class Solution {

    /*两次攻击时间间隔和中毒时间比较
    中毒时间每次累计加的就是两者比较时间短的那个
    最后一秒一定会延续一次中毒时间*/
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int maxTime = 0;
        for (int i = 0; i < timeSeries.length - 1; i++) {
            int curr = timeSeries[i + 1] - timeSeries[i];
            if (curr < duration) {
                maxTime += curr;
            } else {
                maxTime += duration;
            }
//            maxTime += Math.min(curr, duration); //用这个公式求最小值耗费性能
        }
        return maxTime + duration;
    }

}
