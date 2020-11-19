import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <b>Description</b> :
 *
 * @author Vinod Akkepalli
 */
public class ContextUsingClass implements ApplicationContextAware, BeanNameAware {

    private int value;
    private ApplicationContext context = null;
    private String beanName;

    public ContextUsingClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ContextUsingClass{" +
                "value=" + value +
                ", context=" + context +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("bean name: " + beanName);
        this.beanName = beanName;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
