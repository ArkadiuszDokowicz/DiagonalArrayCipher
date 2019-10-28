package Application.BBS;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class BlumBlumShub {

    private static final BigInteger two = BigInteger.valueOf(2L);

    private static final BigInteger three = BigInteger.valueOf(3L);

    private static final BigInteger four = BigInteger.valueOf(4L);

    private BigInteger n;

    private BigInteger state;
    private static BigInteger getPrime(int bits, Random rand) {
        BigInteger p;
        while (true) {
            p = new BigInteger(bits, 100, rand);
            if (p.mod(four).equals(three))
                break;
        }
        return p;
    }

    public static BigInteger generateN(int bits, Random rand) {
        BigInteger p = getPrime(bits/2, rand);
        BigInteger q = getPrime(bits/2, rand);

        // make sure p != q
        while (p.equals(q)) {
            q = getPrime(bits, rand);
        }
        return p.multiply(q);
    }
    public BlumBlumShub(int bits, Random rand) {
        this(generateN(bits, rand));
    }

    public BlumBlumShub(BigInteger n) {
        this(n, SecureRandom.getSeed(n.bitLength() / 8));
    }

    public BlumBlumShub(BigInteger n, byte[] seed) {
        this.n = n;
        setSeed(seed);
    }

    public void setSeed(byte[] seedBytes) {
        // ADD: use hardwired default for n
        BigInteger seed = new BigInteger(1, seedBytes);
        state = seed.mod(n);
    }
    public int next(int numBits) {
        int result = 0;
        for (int i = numBits; i != 0; --i) {
            state = state.modPow(two, n);
            result = (result << 1) | (state.testBit(0) ? 1 : 0);
        }
        return result;
    }

}