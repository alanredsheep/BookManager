package com.redsheep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.redsheep.model.BookType;
import com.redsheep.util.StringUtil;

/**
 * BookType Dao¿‡
 * 
 * @param con
 * @return
 */
public class BookTypeDao {

	/**
	 * Add Book Type
	 * 
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookType bookType) throws Exception {
		String sql = "insert into t_booktype values(null,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookType.getBookType());
		return pstmt.executeUpdate();
	}

	/**
	 * Search Book Type
	 * 
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, BookType bookType) throws Exception {
		StringBuffer strBuff = new StringBuffer("select * from t_booktype");
		if (StringUtil.isNotEmpty(bookType.getBookType())) {
			strBuff.append(" and bookType like '%" + bookType.getBookType() + "%'");
		}
		PreparedStatement pstmt = con.prepareStatement(strBuff.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

	/**
	 * Delete Book Type
	 * 
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from t_bookType where bookTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * Update Book Type
	 * 
	 * @param con
	 * @param bookType
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, BookType bookType) throws Exception {
		String sql = "update t_bookType set bookType=? where bookTypeId=? ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(2, bookType.getId());
		pstmt.setString(1, bookType.getBookType());
		return pstmt.executeUpdate();
	}

}
