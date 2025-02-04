import org.junit.Test;
import stringbuffer.concatenate.ConcatenateStrings;
import stringbuilder.removeduplicate.Removeduplicates;
import stringbuilder.reverse.Reverse;

import static org.junit.Assert.assertEquals;


public class test {
    @Test
    public void q1(){

        assertEquals(Reverse.reverse("Furqan"),"naqruF");
    }
    @Test
    public void q2(){
        assertEquals(Removeduplicates.removeduplicates("fffddsssuihh"),"fdsuih");

    }
    @Test
    public  void q3(){
        String []arr={"Furqan","Anubhav","Deepansh"};
        assertEquals(ConcatenateStrings.concatenate(arr),"FurqanAnubhavDeepansh");
    }

}
