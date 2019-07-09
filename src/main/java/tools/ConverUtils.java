package tools;

import org.springframework.beans.BeanUtils;

/**
 * @author zfm
 * @Description labada工具类
 * @date 2019/7/1
 */
public class ConverUtils {


    public static <D> D convert(Object src, Class<D> clazz) {
        if (src == null) {
            return null;
        } else {
            assert clazz != null;
            Object dst = null;
            try {
                dst = clazz.newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(src, dst);
            return (D) dst;
        }

    }
}
