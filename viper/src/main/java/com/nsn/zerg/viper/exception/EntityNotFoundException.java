package com.nsn.zerg.viper.exception;

import com.nsn.zerg.viper.core.exception.JerseyException;

import javax.ws.rs.core.Response;

/**
 * Exception to describe entity is missing.
 *
 * User: YiLi
 * Date: 3/20/12
 * Time: 18:08 PM
 */
public class EntityNotFoundException extends JerseyException {

    //Properties
    private static final long serialVersionUID = -1732421582718005304L;
    private static final String BASE_KEY = "exception.entity.missing";
    public static final Response.Status NOT_FOUND = Response.Status.NOT_FOUND;

    //Constructor
    /**
     * 用一个消息的key构造，仅仅简单的说明。
     */
    public EntityNotFoundException(String key) {
        super(NOT_FOUND, key);
    }

    /**
     * 指明没有找到的实体的类型key和具体的实体主键. 如：
     * <pre>
     * throw new EntityNotFoundException("entity.user", "gregory");
     * or
     * throw new EntityNotFoundException(EntityNotFoundException.GROUP, "konlink");
     * </pre>
     *
     * @param entityKey 实体的类型的字典key
     * @param entityId  实体的主键
     */
    public EntityNotFoundException(String entityKey, Object entityId) {
        super(NOT_FOUND, BASE_KEY, new Object[]{"{" + entityKey + "}", entityId});
    }
} // end class