package com.cyj.spring.common.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author:cyj
 * @data:2018/1/24 10:21
 * @describe:
 */
public class ArithUtil {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    //这个类不能实例化
    private ArithUtil() {
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @param v3 乘数
     * @return 三个参数的积
     */
    public static double muls(double v1, double v2, double v3) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        BigDecimal b3 = new BigDecimal(Double.toString(v3));
        BigDecimal b4 = new BigDecimal(Double.toString(b1.multiply(b2).doubleValue()));
        return b3.multiply(b4).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */
    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }


    /**
     * 提供精确的指数幂处理。
     *
     * @param v 底数
     * @param n 幂
     * @return 指数幂结果
     */
    public static double pow(double v, int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.pow(n).doubleValue();
    }

    /**
     * 提供精确的开方运算。
     *
     * @param number       底数
     * @param n            根号下n次幂
     * @param scale        小数点后保留几位
     * @param roundingMode 舍入模式
     * @return 指数幂运算结果
     */
    public static BigDecimal bigRoot(BigDecimal number, int n, int scale, int roundingMode) {
        boolean negate = false;
        if (n < 0) {
            throw new ArithmeticException();
        }
        if (number.compareTo(BigDecimal.ZERO) < 0) {
            if (n % 2 == 0) {
                throw new ArithmeticException();
            } else {
                number = number.negate();
                negate = true;
            }
        }

        BigDecimal root;

        if (n == 0) {
            root = BigDecimal.ONE;
        } else if (n == 1) {
            root = number;
        } else {
            final BigInteger N = BigInteger.valueOf(n);
            final BigInteger N2 = BigInteger.TEN.pow(n);
            final BigInteger N3 = BigInteger.TEN.pow(n - 1);
            final BigInteger NINE = BigInteger.valueOf(9);

            BigInteger[] C = new BigInteger[n + 1];
            for (int i = 0; i <= n; i++) {
                C[i] = combination(n, i);
            }

            BigInteger integer = number.toBigInteger();
            String strInt = integer.toString();
            int lenInt = strInt.length();
            for (int i = lenInt % n; i < n && i > 0; i++) {
                strInt = "0" + strInt;
            }
            lenInt = (lenInt + n - 1) / n * n;
            BigDecimal fraction = number.subtract(number.setScale(0, BigDecimal.ROUND_DOWN));
            int lenFrac = (fraction.scale() + n - 1) / n * n;
            fraction = fraction.movePointRight(lenFrac);
            String strFrac = fraction.toPlainString();
            for (int i = strFrac.length(); i < lenFrac; i++) {
                strFrac = "0" + strFrac;
            }
            BigInteger res = BigInteger.ZERO;
            BigInteger rem = BigInteger.ZERO;
            for (int i = 0; i < lenInt / n; i++) {
                rem = rem.multiply(N2);

                BigInteger temp = new BigInteger(strInt.substring(i * n, i * n + n));
                rem = rem.add(temp);

                BigInteger j;
                if (res.compareTo(BigInteger.ZERO) != 0) {
                    j = rem.divide(res.pow(n - 1).multiply(N).multiply(N3));
                } else {
                    j = NINE;
                }
                BigInteger test = BigInteger.ZERO;
                temp = res.multiply(BigInteger.TEN);
                while (j.compareTo(BigInteger.ZERO) >= 0) {
                    test = BigInteger.ZERO;
                    if (j.compareTo(BigInteger.ZERO) > 0) {
                        for (int k = 1; k <= n; k++) {
                            test = test.add(j.pow(k).multiply(C[k]).multiply(temp.pow(n - k)));
                        }
                    }
                    if (test.compareTo(rem) <= 0) {
                        break;
                    }
                    j = j.subtract(BigInteger.ONE);
                }

                rem = rem.subtract(test);
                res = res.multiply(BigInteger.TEN);
                res = res.add(j);
            }
            for (int i = 0; i <= scale; i++) {
                rem = rem.multiply(N2);

                if (i < lenFrac / n) {
                    BigInteger temp = new BigInteger(strFrac.substring(i * n, i * n + n));
                    rem = rem.add(temp);
                }

                BigInteger j;
                if (res.compareTo(BigInteger.ZERO) != 0) {
                    j = rem.divide(res.pow(n - 1).multiply(N).multiply(N3));
                } else {
                    j = NINE;
                }
                BigInteger test = BigInteger.ZERO;
                BigInteger temp = res.multiply(BigInteger.TEN);
                while (j.compareTo(BigInteger.ZERO) >= 0) {
                    //easyExcel = res.multiply(BigInteger.TEN);
                    //easyExcel = ((easyExcel.add(j)).pow(n)).subtract(easyExcel.pow(n));
                    test = BigInteger.ZERO;
                    if (j.compareTo(BigInteger.ZERO) > 0) {
                        for (int k = 1; k <= n; k++) {
                            test = test.add(j.pow(k).multiply(C[k]).multiply(temp.pow(n - k)));
                        }
                    }
                    if (test.compareTo(rem) <= 0) {
                        break;
                    }
                    j = j.subtract(BigInteger.ONE);
                }

                rem = rem.subtract(test);
                res = res.multiply(BigInteger.TEN);
                res = res.add(j);
            }
            root = new BigDecimal(res).movePointLeft(scale + 1);
            if (negate) {
                root = root.negate();
            }
        }
        return root.setScale(scale, roundingMode);
    }

    public static BigInteger combination(int n, int k) {
        if (k > n || n < 0 || k < 0) {
            return BigInteger.ZERO;
        }
        if (k > n / 2) {
            return combination(n, n - k);
        }
        BigInteger N1 = BigInteger.ONE;
        BigInteger N2 = BigInteger.ONE;
        BigInteger N = BigInteger.valueOf(n);
        BigInteger K = BigInteger.valueOf(k);
        for (int i = 0; i < k; i++) {
            N1 = N1.multiply(N);
            N2 = N2.multiply(K);
            N = N.subtract(BigInteger.ONE);
            K = K.subtract(BigInteger.ONE);
        }
        return N1.divide(N2);
    }
}

