import Application.BBS.ServiceBBS;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.BitSet;

import static org.junit.Assert.assertTrue;

public class TestForBBS {

    @Test
    public void testForBites(){
        ServiceBBS serviceBBS = new ServiceBBS();
        BitSet bitSet = serviceBBS.get20kBitesAsBitSet();
        int oneCounter=0;
        for(int i=0;i<20000;i++){
            if(bitSet.get(i)){
                oneCounter++;
            }
        }
    assertTrue(oneCounter>9000);
    }


}
