package tech.guanli.boot.internal.model;

import java.io.Serializable;

/**
 * hereditable model is a object has getter and setter for properties id and
 * parentId
 * 
 * 
 * @author guan
 *
 * @param <ID> generics for Serializable property Id
 */
public interface Hereditable<ID extends Serializable> {

	ID getId();

	void setId(ID id);

	ID getParentId();

	void setParentId(ID id);

}
