package tech.guanli.boot.internal.model;

import java.io.Serializable;

/**
 * sortable object must have a comparable property as sortIndex
 * 
 * @author guan
 *
 * @param <SortIndex> comparable sortIndex property
 */
public interface Sortable<SortIndex extends Comparable<SortIndex>> extends Serializable {

	SortIndex getSortIndex();

	void setSortIndex(SortIndex sortIndex);

}
