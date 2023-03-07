package tech.guanli.boot.internal.model;

import java.io.Serializable;

/**
 * payload is designed for all object who will be received from request
 * 
 * @author guan
 *
 */
public interface Payload<Id extends Serializable> extends Transmissible {

	Id getId();

	void setId(Id id);

}
