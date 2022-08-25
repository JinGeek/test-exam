package idv.heartisan.test.exam.utils;

import org.dozer.DozerBeanMapper;

/**
 * @author Jin Qi
 * @date 2022/8/4
 */
public class DozerUtil {

    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.
     */
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <T> T map(final Object source, final Class<T> destinationClass) {
        return dozer.map(source, destinationClass);
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中.
     */
    public static void copy(final Object source, final Object destinationObject) {
        dozer.map(source, destinationObject);
    }

}
