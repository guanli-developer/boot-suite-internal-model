package tech.guanli.boot.internal.model;

/**
 * cloneable model, it must implement clone to clone a concrete cloneable object
 * 
 * @author guan
 *
 * @param <T> generics of concrete cloneable object
 */
public interface Cloneable<T extends Cloneable<T>> {

	T clone();

}
