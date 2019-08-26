/**
 * Copyright (C)
 * FileName: ListRemoveRepeat
 * Author:   cp
 * Date:     2019/8/24 11:56
 * Description: List 去除重复数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * 〈一句话功能简述〉<br> 
 * 〈List 去除重复数据〉
 *
 *  生成一个ArrayList，存入一万个1-100间的自然数
 *  去除其中重复的数据
 *  输出结果
 *
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class ListRemoveRepeat {

    @Test
    public void duplicateList() {

        ArrayList<Object> list = new ArrayList<>();
//        HashSet<Object> set = new HashSet<>(list);
        HashSet<Object> set = new HashSet<>();
        set.addAll(list);

    }

}
