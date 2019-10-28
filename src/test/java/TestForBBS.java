import Application.BBS.Bits;
import Application.BBS.BlumBlumShub;
import Application.BBS.ServiceBBS;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.BitSet;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.DEFAULT)
public class TestForBBS {
    private ServiceBBS serviceBBS = new ServiceBBS();
    private BitSet bitSet = serviceBBS.generate20kBitesAsBitSet();
    @Test
    public void testForBites(){
        int oneCounter=0;
        for(int i=0;i<20000;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
        }
    assertTrue(10275>oneCounter && oneCounter>9725);
    }
    @Test
    public void testForSeries1For0(){
        int zeroCounter=0;
        for(int i=2315;i<2685;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>1);
    }
    @Test
    public void testForSeries2For0(){
        int zeroCounter=0;
        for(int i=1114;i<1386;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>2);
    }
    @Test
    public void testForSeries3For0(){
        int zeroCounter=0;
        for(int i=527;i<732;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>3);
    }
    @Test
    public void testForSeries4For0(){
        int zeroCounter=0;
        for(int i=240;i<384;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>4);
    }
    @Test
    public void testForSeries5For0(){
        int zeroCounter=0;
        for(int i=103;i<209;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>5);
    }
    @Test
    public void testForSeries6For0(){
        int zeroCounter=0;
        for(int i=103;i<209;i++){
            if(bitSet.get(i)){
                zeroCounter=0;
            }
            else{
                zeroCounter++;
            }
        }
        assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>6);
    }
    @Test
    public void testForSeries1For1(){
        int oneCounter=0;
        for(int i=2315;i<2685;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>1);
    }
    @Test
    public void testForSeries2For1(){
        int oneCounter=0;
        for(int i=1114;i<1386;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>2);
    }
    @Test
    public void testForSeries3For1(){
        int oneCounter=0;
        for(int i=527;i<732;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>3);
    }
    @Test
    public void testForSeries4For1(){
        int oneCounter=0;
        for(int i=240;i<384;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>4);
    }
    @Test
    public void testForSeries5For1(){
        int oneCounter=0;
        for(int i=103;i<209;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>5);
    }
    @Test
    public void testForSeries6For1(){
        int oneCounter=0;
        for(int i=103;i<209;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
            else{
                oneCounter=0;
            }
        }
        assertFalse("oneCounter was"+ oneCounter,oneCounter>6);
    }
    @Test
    public void testLongSeries(){
        int oneCounter=0;
        int zeroCounter=0;
        for(int i=0;i<20000;i++){
            if(bitSet.get(i)){
                oneCounter++;
                zeroCounter=0;
                assertFalse("oneCounter was"+ oneCounter,oneCounter>26);
            }
            else{
                zeroCounter++;
                oneCounter=0;
                assertFalse("zeroCounter was"+ zeroCounter,zeroCounter>26);
            }
        }
    }

    public void testPoker(){
        HashMap<Integer,Integer> hashMap =new HashMap<>();

        for(int i=0;i<20000;i=i+4){
            BitSet bs=new BitSet();
        }

    }

}
