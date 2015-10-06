package woo.com.wakeup.ui.activity;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * ActivityScope
 * Desc: 定义一个Activity级别的生命期
 * Date: 2015/10/6
 * Time: 9:50
 * Created by: Wooxxx
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
