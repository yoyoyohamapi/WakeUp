package woo.com.wakeup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/**
 * AlbumTest
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-10
 * Time: 13:41
 */
@RunWith(RobolectricTestRunner.class)
public class AlbumTest {
    @Test
    public void testGetAlbum() {
        String coverSmallUrl = "http://img.xiami.net/images/album/img66/86366/4534811423729531_1.jpg";
        String coverLargeUrl = coverSmallUrl.replace("_1", "_4");
        System.out.println(coverLargeUrl);
    }
}
