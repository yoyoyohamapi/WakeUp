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
        water.setDesc("维持电解质平衡\n增强人体的免疫功能，提供机体的抗病能力\n矿物质和微量元素的含量适宜人体");
        water.setId(RecordDrink.WATER);

        items.add(water);

        // 饮品：茶
        DrinkItem tea = new DrinkItem();
        tea.setImage(R.drawable.drink_tea);
        tea.setImageUnselected(R.drawable.drink_tea_unselected);
        tea.setDesc("防暑降温、解乏明目\n兴奋中枢神经，增强运动能力\n抑制细胞突变，具抗癌作用\n保养肌肤，护肤美容");
        tea.setId(RecordDrink.TEA);

        items.add(tea);

        // 饮品：咖啡
        DrinkItem coffee = new DrinkItem();
        coffee.setImage(R.drawable.drink_coffee);
        coffee.setImageUnselected(R.drawable.drink_coffee_unselected);
        coffee.setDesc("活络消化器官，有助消化\n可防止放射线伤害\n消除疲劳，促进代谢");
        coffee.setId(RecordDrink.COFFEE);

        items.add(coffee);
    }
}
