package me.king.admin.web.vo;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class DataTablesRsp<T> {
	public int draw;
	public int recordsTotal;
	public int recordsFiltered;
	public List<T> data;
	public String error;
	public DataTablesRsp(int draw) {
		super();
		this.draw = draw;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
	
}
