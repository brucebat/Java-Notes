package string;

/**
 * @author 闲宇非鱼(brucebat)
 * @version 1.0
 * @since Created at 2024/12/18 12:34
 */
public class RomanNumeralTwo {

    public static void main(String[] args) {
        int num = 3749;
        StringBuffer result = new StringBuffer();
        int step = 1000;
        while(step > 0) {
            int temp = num / step;
            num = num - temp * step;
            if (temp > 0) {
                if (step > 100) {
                    while(temp > 0) {
                        result.append("M");
                        temp--;
                    }
                } else if (step > 10) {
                    if (temp == 9) {
                        result.append("CM");
                    } else if (temp == 4) {
                        result.append("CD");
                    } else if (temp >=5) {
                        result.append("D");
                        temp = temp - 5;
                        while (temp > 0) {
                            result.append("C");
                            temp--;
                        }
                    } else {
                        while (temp > 0) {
                            result.append("C");
                            temp--;
                        }
                    }
                } else if (step > 1) {
                    if (temp == 9) {
                        result.append("XC");
                    } else if (temp == 4) {
                        result.append("XL");
                    } else if (temp >=5) {
                        result.append("L");
                        temp = temp - 5;
                        while (temp > 0) {
                            result.append("X");
                            temp--;
                        }
                    } else {
                        while (temp > 0) {
                            result.append("X");
                            temp--;
                        }
                    }
                } else {
                    if (temp == 9) {
                        result.append("IX");
                    } else if (temp == 4) {
                        result.append("IV");
                    } else if (temp >=5) {
                        result.append("V");
                        temp = temp - 5;
                        while (temp > 0) {
                            result.append("I");
                            temp--;
                        }
                    } else {
                        while (temp > 0) {
                            result.append("I");
                            temp--;
                        }
                    }
                }
            }
            step = step / 10;
        }
        System.out.println(result);
    }
}
