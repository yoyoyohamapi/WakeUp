package woo.com.wakeup.ui.menu;

import java.util.ArrayList;
import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.RecordDrink;

/**
 * DrinkMenu
 * Desc: 茶饮清单
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-10-30
 * Time: 21:19
 */
public final class DrinkMenu {
    public static final List<DrinkItem> items = new ArrayList<>();

    static {
        // 饮品：清水
        DrinkItem water = new DrinkItem();
        water.setImage(R.drawable.drink_water);
        water.setImageUnselected(R.drawable.drink_water_unselected);
        water.setDesc("");
        water.setId(RecordDrink.WATER);

        items.add(water);

        // 饮品：茶
        DrinkItem tea = new DrinkItem();
        tea.setImage(R.drawable.drink_tea);
        tea.setImageUnselected(R.drawable.drink_tea_unselected);
        tea.setDesc("");
        tea.setId(RecordDrink.TEA);

        items.add(tea);

        // 饮品：咖啡
        DrinkItem coffee = new DrinkItem();
        coffee.setImage(R.drawable.drink_coffee);
        coffee.setImageUnselected(R.drawable.drink_coffee_unselected);
        coffee.setDesc("");
        coffee.setId(RecordDrink.COFFEE);

        items.add(coffee);
    }
}
