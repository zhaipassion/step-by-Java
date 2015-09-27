package liXingHua.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 对属性监听
 *
 * @author Bob
 */
public class AttributeListenerDemo implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scab) {
        System.out.println("增加属性：name->" + scab.getName() + ", value->" + scab.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scab) {
        System.out.println("删除属性：name->" + scab.getName() + ", value->" + scab.getValue());
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scab) {
        System.out.println("重置属性：name->" + scab.getName() + ", value->" + scab.getValue());
    }

}
