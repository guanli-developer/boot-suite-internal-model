package tech.guanli.boot.internal.model.implemention;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import tech.guanli.boot.internal.model.Returnable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class PageData<T extends Returnable> implements Returnable {
	private static final long serialVersionUID = 1L;

	private Long total;

	private Long totalPage;

	private Integer pageNumber;

	private Integer pageSize;

	private Collection<T> data;

}
