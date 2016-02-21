package com.softserveinc.ita.redplatform.common.predicate;

/**
* Predicates for dsiplaying datatable.
* 
* @author Hryhorii
*
*/
public class DataTablePredicate {
	/**
	 *draw datatable sequence.
	 */
	private int draw;
	
	/**
	 * display length.
	 */
	private int length;
	
	/**
	 * start index displaying.
	 */
	private int start;
	
	/**
	 * search field.
	 */
	private String search = "";
	
	/**
	 * sorting order.
	 */
	private String order;
	
	/**
	 * index of sorting column.
	 */
	private int column;

	public final int getDraw() {
		return draw;
	}

	public final void setDraw(final int newDraw) {
		this.draw = newDraw;
	}

	public final int getLength() {
		return length;
	}

	public final void setLength(final int newLength) {
		this.length = newLength;
	}

	public final int getStart() {
		return start;
	}

	public final void setStart(final int newStart) {
		this.start = newStart;
	}

	public final String getSearch() {
		return search;
	}

	public final void setSearch(final String newSearch) {
		this.search = newSearch;
	}

	public final String getOrder() {
		return order;
	}

	public final void setOrder(final String newOrder) {
		this.order = newOrder;
	}
	
	public final int getColumn() {
		return column;
	}

	public final void setColumn(final int newColumn) {
		this.column = newColumn;
	}
	
	/**
	 * Constructor.
	 * @param newDraw draw
	 * @param newStart start
	 * @param newLength length
	 * @param newColumn column
	 * @param newOrder order
	 * @param newSearch search
	 */
	public DataTablePredicate(final int newDraw, final int newStart, 
			final int newLength, final int newColumn, final String newOrder,
			final String newSearch) {
		this.draw = newDraw;
		this.start = newStart;
		this.length = newLength;
		this.column = newColumn;
		this.order = newOrder;
		this.search = newSearch;
	}
}

