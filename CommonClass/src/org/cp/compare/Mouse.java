/**
 * Copyright (C)
 * FileName: Mouse
 * Author:   cp
 * Date:     2019/8/12 21:30
 * Description: 鼠标实体类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package org.cp.compare;

/**
 * 〈一句话功能简述〉<br> 
 * 〈鼠标实体类〉
 *  实现Comparable 接口 重写compareTo()方法
 *
 * @author cp
 * @create 2019/8/12
 * @since 1.0.0
 */
public class Mouse implements Comparable<Mouse>{

    private String name;

    private Double price;

    public Mouse(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Mouse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Mouse o) {
        Mouse m = (Mouse) o;
        return this.price.compareTo(m.price);
    }
}
