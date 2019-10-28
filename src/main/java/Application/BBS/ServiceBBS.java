package Application.BBS;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.BitSet;

public class ServiceBBS {

    private SecureRandom r = new SecureRandom();
    private int bitSize;
    private BlumBlumShub bbs;
    private BigInteger nval;

    public ServiceBBS(){
        this.r.nextInt();
        this.bitSize = 512;
        this.generateN();
    }

    private void generateN(){
     nval = BlumBlumShub.generateN(bitSize, r);
    byte[] seed = new byte[bitSize/8];
        r.nextBytes(seed);
        bbs= new BlumBlumShub(nval, seed);
    }

    public String  generate20kBitesAsString(){
    StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 2500; ++i) {
        BitSet bi=(Bits.convert(bbs.next(8)));
        for( int y = 0; y < 8;  y++ )
        {
            stringBuilder.append(bi.get(y) ? 1: 0 );
        }
    }return stringBuilder.toString();
    }

    public StringBuilder  generate20kBitesAsStringBuilder(){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 2500; ++i) {
            BitSet bi=(Bits.convert(bbs.next(8)));
            for( int y = 0; y < 8;  y++ )
            {
                stringBuilder.append(bi.get(y) ? 1: 0 );
            }
        }return stringBuilder;
    }


    public BitSet get20kBitesAsBitSet(){
        StringBuilder stringBuilder = this.generate20kBitesAsStringBuilder();
    BitSet twentyThousandBits= new BitSet();
    char[] bitsAsString = stringBuilder.toString().toCharArray();
        for(int i=0;i<bitsAsString.length;i++){
        if(bitsAsString[i]=='1'){
            twentyThousandBits.set(i);
        }
    }
        return twentyThousandBits;
    }
}
