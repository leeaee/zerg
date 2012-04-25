/*
 * +--------------------------------------------------------------------------+
 * | Project: EWORK_SERVER                                                    |
 * +--------------------------------------------------------------------------+
 * | Copyright (c) 2000-2004 Konlink R&D Center.	All Righrs Reserved.	  |
 * +--------------------------------------------------------------------------+
 * | This source file is subject to Konlink(c) Software/Webware license,      |
 * | that is bundled with this package in the file LICENSE, and is            |
 * | available at through the world-wide-web at                               |
 * | http://www.konlink.com/                                                  |
 * | If you did not receive a copy of the Konlink(c) Software/Webware license |
 * | and are unable to obtain it through the world-wide-web, please send a    |
 * | note to license@konlink.com so we can mail you a copy immediately.       |
 * +--------------------------------------------------------------------------+
 * | Authors: Gregory Song <gregory@konlink.com>                              |
 * +--------------------------------------------------------------------------+
 *
 * Create Author:	Gregory Song
 * Create Date:		2004-11-16
 * Function:		Internationalization Implemented Message Entity.
 *
 * $RCSfile: I18NMessage.java,v $
 * $Revision: 1.2 $
 * $Date: 2006/03/14 08:27:17 $
 * $Author: biliang $
 */

package com.nsn.zerg.viper.core.i18n;

import java.io.Serializable;

/**
 * Internationalization Implemented Message Entity. <p /> A I18NMessage Instance can be translated with a dictionary to
 * human-being language.
 *
 * @author <A href="mailto:gregory@konlink.com">Gregory Song</A>
 * @version $Revision: 1.2 $
 * @since 7.00.00
 */
public class I18NMessage implements Serializable
{
    private static final long serialVersionUID = 2321819617330853202L;
    //Properties
    private String msgKey;
    private Object[] params;

    /**
     * toString()方法用此常量字符串分割 <code>msgKey</code> 和 Object[] 参数
     */
    public static final String DELIMITOR = "|";

    //Constructor
    /**
     * 空构造函数. <p /> 在通过toString()方法得到的结果新建一个I18NMessage实例的时候，可以先用本空构造函数，然后用{@link #loadFromSerialized}方法。
     * <pre>
     * I18NMessage msg = new I18NMessage();
     * msg.loadFromSerialized(someString);
     * </pre>
     */
    public I18NMessage() {
    }

    /**
     * 用一个消息的key来构造一个实例.
     *
     * @param key 国际化消息的key
     */
    public I18NMessage(String key) {
        this.msgKey = key;
    }

    /**
     * 用一个消息的key，及其参数构造一个实例.
     *
     * @param key    国际化消息的key
     * @param params 国际化消息的参数
     */
    public I18NMessage(String key, Object[] params) {
        this.msgKey = key;
        this.params = params;
    }

    /**
     * 用一个消息的key，和单个参数构造一个实例. <p /> 当只有一个参数时，调用此构造函数，可不用临时生成一个Object数组。
     *
     * @param key         国际化消息的key
     * @param singleParam 单个的国际化消息参数
     */
    public I18NMessage(String key, Object singleParam) {
        this.msgKey = key;
        this.params = new Object[]{singleParam};
    }

    //Methods
    /**
     * 从序列化过的I18NMessage字符串中恢复I18NMessage的数据。
     *
     * @param serialized 序列化的 I18NMessage 字符串，通常都是由 {@link #toString} 方法得到。
     */
    public void loadFromSerialized(String serialized) {
        String[] strArray = serialized.split(DELIMITOR);

        if (strArray.length > 0) {
            this.msgKey = strArray[0];

            //the length of the array is more than 1, there should be parameters.
            if (strArray.length > 1) {
                this.params = new Object[strArray.length - 1];
                System.arraycopy(strArray, 1, this.params, 0, strArray.length - 1);
            }
        }
    }

    /**
     * 获得消息的key
     *
     * @return key
     */
    public String getMsgKey() {
        return msgKey;
    }

    /**
     * 获得消息的参数
     *
     * @return Object数组
     */
    public Object[] getParams() {
        return params;
    }

    /**
     * To judge whether two I18NMessage instance are equal. <p /> This require that the message keys are equal and every
     * element of <code>params</code> are equal.
     *
     * @return <code>true</code> on equal.
     */
    @Override
    public boolean equals(Object obj) {
        //Whether obj is an instance of I18NMessage
        if (obj instanceof I18NMessage) {
            I18NMessage msg = (I18NMessage) obj;

            //Whether the key are equals
            if (this.msgKey.equals(msg.getMsgKey())) {

                //Whether the length of params are equal
                if (this.params.length == msg.getParams().length) {

                    //Judge each element of params
                    for (int i = 0; i < params.length; i++) {
                        if (!this.params[i].equals(msg.getParams()[i])) {
                            return false;
                        }
                    }

                    return true;
                }

                return false;
            }

            return false;
        }

        return false;
    }

    /**
     * Get a string of this message.
     * <p/>
     * This is NOT the translated string. This is useful for a 'serialized' store, for example, in session, cookie, or
     * database.
     * <p/>
     * The string generated by this method can be used as the parameter of the method {@link #loadFromSerialized}.
     * <p/>
     *
     * @return flatterned I18NMessage.
     */
    @Override
    public String toString() {
        //Add msgKey at first
        StringBuilder sb = new StringBuilder(this.msgKey);

        //If there's more than 1 parameters, append them and seperated with "|".
        if (this.params.length > 0) {
            sb.append(DELIMITOR);
            for (int i = 0; i < this.params.length; i++) {
                sb.append(params[i].toString());
                if (i != this.params.length - 1) {
                    sb.append(DELIMITOR);
                }
            }
        }

        return sb.toString();
    }

    //Methods

}
