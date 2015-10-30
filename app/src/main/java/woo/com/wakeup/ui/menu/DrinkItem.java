package woo.com.wakeup.ui.menu;


/**
 * DrinkItem
 * Desc:
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 22:04
 */
public class DrinkItem {
    // 原图，为选中的图
    private int image, imageUnselected;
    // 饮品描述
    private String desc;
    // Id
    private int id;


    public DrinkItem() {
    }

    public DrinkItem(int image, int imageUnselected, String desc, int id) {
        this.image = image;
        this.imageUnselected = imageUnselected;
        this.desc = desc;
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImageUnselected() {
        return imageUnselected;
    }

    public void setImageUnselected(int imageUnselected) {
        this.imageUnselected = imageUnselected;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
