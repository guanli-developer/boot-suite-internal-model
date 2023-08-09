package tech.guanli.boot.internal.model.concrete;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import lombok.Data;
import tech.guanli.boot.internal.model.Nestable;

@Data
public class NestedForest<ID extends Serializable, TREE extends Nestable<ID, TREE>> {

	List<TREE> forest;

	public TREE getFirstTree() {
		if (Objects.nonNull(forest) && forest.size() > 0) {
			return forest.get(0);
		} else {
			return null;
		}
	}

	public TREE getLastTree() {
		if (Objects.nonNull(forest) && forest.size() > 0) {
			return forest.get(forest.size() - 1);
		} else {
			return null;
		}
	}

}
