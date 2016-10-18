package algorithm;

public class BulbSwitcher319 {
	//AC 0ms
	//第i盏灯是否是开的取决于i的公约数的个数的奇偶性 奇数开偶数关  只有平方数数的约数的个数是奇数  n范围了平方数的个数为sqrt(n)
    public int bulbSwitch(int n) {
    	return (int)Math.sqrt(n);
    }
}
