package com.mb.middle.ware.base;

import java.util.List;

public interface BaseService {
	public List<?> select() throws Exception;
	
	public Object selectByPrimaryKey(int id) throws Exception;

	public Object create(Object record) throws Exception;
	
	public Object update(Object record) throws Exception;

	public int deleteByPrimaryKey(String id) throws Exception;
}
