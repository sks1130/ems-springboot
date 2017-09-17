/**
 * 
 */
package com.ems.models;

/**
 * @author sachin
 *
 */
public class Response<T> {

	T data;
	String status;
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Response [data=" + data + ", status=" + status + "]";
	}
}
