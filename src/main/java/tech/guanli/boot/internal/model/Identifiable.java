package tech.guanli.boot.internal.model;

import java.io.Serializable;

/**
 * identifiable model, it must hava getter and setter for a property implements
 * Serializable
 * 
 * 
 * @author guan
 *
 * @param <Identity> generics for identity property implements Serializable
 */
public interface Identifiable<Identity extends Serializable> extends Serializable {

	Identity getIdentity();

	void setIdentity(Identity identity);

}
