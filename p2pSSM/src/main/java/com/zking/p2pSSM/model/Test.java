package com.zking.p2pSSM.model;

import lombok.ToString;

@ToString
public class Test {
    private Integer id;

    private Integer index;

    private Integer intVal;

    public Test(Integer id, Integer index, Integer intVal) {
        this.id = id;
        this.index = index;
        this.intVal = intVal;
    }

    public Test() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Integer getIntVal() {
        return intVal;
    }

    public void setIntVal(Integer intVal) {
        this.intVal = intVal;
    }
}