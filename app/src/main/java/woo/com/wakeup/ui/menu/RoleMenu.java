package woo.com.wakeup.ui.menu;

import java.util.ArrayList;
import java.util.List;

import woo.com.wakeup.R;
import woo.com.wakeup.model.entity.RecordRole;

/**
 * RoleMenu
 * Desc: 角色选择菜单
 * Team: InHand
 * User: Wooxxx
 * Date: 2015-11-11
 * Time: 10:46
 */
public class RoleMenu {
    public static List<RoleItem> items = new ArrayList<>();

    static{
        RoleItem roleHungry = new RoleItem();
        roleHungry.setId(RecordRole.HUNGRY);
        roleHungry.setImage(R.drawable.role_hungry);
        RoleItem roleSports = new RoleItem();
        roleSports.setId(RecordRole.SPORTS);
        roleSports.setImage(R.drawable.role_sports);
        RoleItem roleLearning = new RoleItem();
        roleLearning.setId(RecordRole.LEARNING);
        roleLearning.setImage(R.drawable.role_learning);
        items.add(roleHungry);
        items.add(roleSports);
        items.add(roleLearning);
    }
}
