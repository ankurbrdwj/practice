package com.ankur.interview.practice.bitmanipulation;

public class Bitwise {

    public static boolean geBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    /*
    /clean msb till i = 4th bit in num =-7 --> 11111001
    mask 00010000 -00000001 =2^5-1=2-1=31 =    00011111
    num&mask                               --> 00011001
     */
    public static int clearBitMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitsIthrough0(int num, int i) {
        int mask = -1 << (i + 1);
        return num & mask;
    }

    public static int updateBit(int num, int i, boolean bitIs1) {
        int mask = ~(1 << i);
        int value = bitIs1 ? 1 : 0;
        return (num & mask) | (value << i);
    }

    public static String printBinary(int num) {
        StringBuilder result = new StringBuilder();
        do {
            if (((num & 1) == 1)) {
                result.append("1");
            } else {
                result.append("0");
            }
            num = num >>> 1;
        } while (num != 0);
        return result.reverse().toString();
    }
}
