package tech.guanli.boot.internal.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * nestable model must have Serializable id property and it's children list
 * 
 * @author guan
 *
 * @param <ID>    generics Serializable id property
 * @param <Child> generics of children node type, in general, it's nestable
 *                object self type
 */
public interface Nestable<ID extends Serializable, Child extends Nestable<ID, Child>> extends Hereditable<ID> {

	List<Child> getChildren();

	void setChildren(List<Child> children);

	default Boolean hasChildren() {
		return Objects.nonNull(getChildren()) && getChildren().size() > 0;
	}

}
