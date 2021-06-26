package cn.group17.dto;

import cn.group17.model.MetaDomain;

/**
 * 标签、分类列表
 */
public class MetaDto extends MetaDomain {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
