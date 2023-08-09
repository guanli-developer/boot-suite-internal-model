package tech.guanli.boot.internal.model.utils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import tech.guanli.boot.internal.model.Sortable;

public final class Sortables {

	public static final <SortIndex extends Comparable<SortIndex>, T extends Sortable<SortIndex>> void sortAsc(
			List<T> collection) {
		Collections.sort(collection, (o1, o2) -> {
			if (Objects.isNull(o1.getSortIndex())) {
				return -1;
			} else {
				return o1.getSortIndex().compareTo(o2.getSortIndex());
			}
		});
	}

	public static final <SortIndex extends Comparable<SortIndex>, T extends Sortable<SortIndex>> void sortDesc(
			List<T> collection) {
		Collections.sort(collection, (o1, o2) -> {
			if (Objects.isNull(o2.getSortIndex())) {
				return -1;
			} else {
				return o2.getSortIndex().compareTo(o1.getSortIndex());
			}
		});
	}

}
