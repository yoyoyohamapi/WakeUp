package woo.com.wakeup;

import com.snappydb.SnappydbException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.Date;

import woo.com.wakeup.model.entitySnappy.Record;

/**
 * RecordTest
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-26
 * Time: 10:16
 */
@RunWith(RobolectricTestRunner.class)
public class RecordTest {
    @Test
    public void testSave() {
        Record record = new Record(RuntimeEnvironment.application);
        record.setDrink(1);
        record.setActivity(2);
        record.setDate(new Date());
        record.setTodayRecommend(null);
        try {
            record.save();
        } catch (SnappydbException e) {
            e.printStackTrace();
        }
    }

    public void testFind() {

    }
}
