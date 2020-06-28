package com.ht.util;

import java.util.List;


public interface DataService<T> {
    /**
     * 查询所有
     *
     * @return 泛型映射实体类集合
     */
    List<T> getAll();

    /**
     * 根据条件查询
     *
     * @param t 泛型，包含查询属性字段数据的映射实体类
     * @return 泛型映射实体类集合
     */
    List<T> getData(T t);

    /**
     * 根据主键查询单个
     *
     * @param t 泛型，包含查询属性字段数据的映射实体类
     * @return 泛型映射实体类
     */
    T getOne(T t);

    /**
     * 新增
     *
     * @param t 泛型，包含新增属性字段数据的映射实体类
     * @return 影响结果行数
     */
    Integer add(T t);



    /**
     * 删除
     *
     * @param t 泛型，包含含有删除主键的映射实体类
     * @return 影响结果行数
     */
    Integer del(T t);

    /**
     * 修改
     *
     * @param t 泛型，包含含有修改属性字段数据的映射实体类
     * @return 影响结果行数
     */
    Integer upd(T t);
}
