package tech.guanli.boot.internal.model;

import java.io.Serializable;

/**
 * persistable model, it must have getter and setter for id
 * 
 * 
 * @author guan
 *
 * @param <ID> generics of property id
 */
public interface Persistable<ID extends Serializable> {

	ID getId();

	void setId(ID id);

}
