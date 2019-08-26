/**
 * Copyright (C)
 * FileName: PP
 * Author:   cp
 * Date:     2019/8/24 12:11
 * Description: PP 类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.collection.test;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈PP 类〉
 *
 * @author cp
 * @create 2019/8/24
 * @since 1.0.0
 */
public class PP {

    int id;
    String name;

    public PP(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PP pp = (PP) o;
        return id == pp.id &&
                Objects.equals(name, pp.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "PP{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
