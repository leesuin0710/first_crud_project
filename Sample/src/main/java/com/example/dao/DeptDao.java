//DeptDao.java
package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.model.Dept;

@Mapper
public interface DeptDao {
	public List<Dept> getBoardList();
	
	public void registBoard(Dept dept);

	public Dept getBoardDetail(int bno);
	
	public void updateBoard(Dept dept);

	public void deleteBoard(Long bno);

	public Dept getBoardDetail(Long bno);
}
