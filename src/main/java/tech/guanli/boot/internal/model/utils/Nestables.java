package tech.guanli.boot.internal.model.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import tech.guanli.boot.internal.model.Nestable;

public final class Nestables {

	/**
	 * 将嵌套对象列表转换为森林
	 * 
	 * @param <ID>        嵌套对象id泛型
	 * @param <CHILD>     嵌套对象泛型
	 * @param nestables   嵌套对象集合
	 * @param topParentId 根节点父级id，可以指定为特征值或null
	 * @return 嵌套对象森林，根节点父级id为指定特征值
	 */
	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> listToTree(
			List<CHILD> nestables, ID topParentId) {
		Map<ID, List<CHILD>> idNestableMap = new HashMap<>();
		List<CHILD> forest = new ArrayList<>();
		nestables.forEach(nestable -> {
			if (Objects.equals(topParentId, nestable.getParentId())) {
				forest.add(nestable);
			} else {
				idNestableMap.putIfAbsent(nestable.getParentId(), new ArrayList<>());
				idNestableMap.get(nestable.getParentId()).add(nestable);
			}
			idNestableMap.putIfAbsent(nestable.getId(), new ArrayList<>());
			nestable.setChildren(idNestableMap.get(nestable.getId()));
		});
		return forest;
	}

	/**
	 * 将嵌套对象列表转换为森林，根节点为父级id为null的对象
	 * 
	 * @param <ID>      嵌套对象id泛型
	 * @param <CHILD>   嵌套对象泛型
	 * @param nestables 嵌套对象集合
	 * @return 嵌套对象森林，根节点为父级id为null的对象
	 */
	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> listToTree(
			List<CHILD> nestables) {
		return listToTree(nestables, null);
	}

	/**
	 * 扁平化森林，将每一个树节点转换到列表中
	 * 
	 * @param <ID>    嵌套对象id泛型
	 * @param <CHILD> 嵌套对象泛型
	 * @param forest  森林
	 * @return
	 */
	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> flatForest(
			List<CHILD> forest) {
		List<CHILD> trees = new ArrayList<>();
		forest.forEach(tree -> {
			trees.addAll(flatTree(tree));
		});
		return trees;
	}

	/**
	 * 扁平化森林，将每一个树节点转换到列表中，并且移除节点下的子节点数据，返回轻量化列表
	 * 
	 * @param <ID>
	 * @param <CHILD>
	 * @param forest
	 * @return
	 */
	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> flatForestLight(
			List<CHILD> forest) {
		List<CHILD> trees = new ArrayList<>();
		forest.forEach(tree -> {
			trees.addAll(flatTreeLight(tree));
		});
		return trees;
	}

	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> flatTree(CHILD tree) {
		List<CHILD> trees = new ArrayList<>();
		flatTree(tree, trees);
		return trees;
	}

	private static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> void flatTree(CHILD tree,
			List<CHILD> expandedTrees) {
		expandedTrees.add(tree);
		tree.getChildren().forEach(child -> {
			flatTree(child, expandedTrees);
		});
	}

	public static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> List<CHILD> flatTreeLight(
			CHILD tree) {
		List<CHILD> trees = new ArrayList<>();
		flatTreeLight(tree, trees);
		return trees;
	}

	private static final <ID extends Serializable, CHILD extends Nestable<ID, CHILD>> void flatTreeLight(CHILD tree,
			List<CHILD> expandedTrees) {
		expandedTrees.add(tree);
		tree.getChildren().forEach(child -> {
			flatTreeLight(child, expandedTrees);
		});
		tree.getChildren().clear();
	}
}
