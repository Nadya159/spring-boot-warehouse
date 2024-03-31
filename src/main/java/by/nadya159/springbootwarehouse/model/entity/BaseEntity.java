package by.nadya159.springbootwarehouse.model.entity;

import java.io.Serializable;

/**
 * Interface для создания классов entities
 */
public interface BaseEntity<T extends Serializable> {
    T getId();
    void setId(T id);
}
