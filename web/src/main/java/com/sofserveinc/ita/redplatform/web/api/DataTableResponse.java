package com.sofserveinc.ita.redplatform.web.api;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data table response.
 * @param <T> represent data item.
 * 
 * @author Hryhorii
 */
public class DataTableResponse<T> implements Serializable {
	
	/**
	 * Total records, before filtering .
	 */
    @JsonProperty(value = "iTotalRecords")
    private long totalRecords;

    /**
     * integer	Total records, after filtering .
     */
    @JsonProperty(value = "iTotalDisplayRecords")
    private long totalDisplayRecords;

    /**
     * 	Information for DataTables to use for rendering.
     */
    @JsonProperty(value = "sEcho")
    private String echo;

    /**
     * Optional - this is a string of column names, comma separated.
     */
    @JsonProperty(value = "sColumns")
    private String columns;

    /**
     * The data in a 2D array. 
     */
    @JsonProperty(value = "aaData")
    private List<T> data;

	public final long getTotalRecords() {
		return totalRecords;
	}

	public final void setTotalRecords(final long newTotalRecords) {
		this.totalRecords = newTotalRecords;
	}

	public final long getTotalDisplayRecords() {
		return totalDisplayRecords;
	}

	public final void setTotalDisplayRecords(
			final long newTotalDisplayRecords) {
		this.totalDisplayRecords = newTotalDisplayRecords;
	}

	public final String getEcho() {
		return echo;
	}

	public final void setEcho(final String newEcho) {
		this.echo = newEcho;
	}

	public final String getColumns() {
		return columns;
	}

	public final void setColumns(final String newColumns) {
		this.columns = newColumns;
	}

	public final List<T> getData() {
		return data;
	}
	
	public final void setData(final List<T> newData) {
		this.data = newData;
	}
}
