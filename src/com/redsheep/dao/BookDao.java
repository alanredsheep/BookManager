package com.redsheep.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.redsheep.model.Book;
import com.redsheep.util.StringUtil;

/**
 * Book Dao
 * 
 * @author Redsheep
 *
 */
public class BookDao {

	/**
	 * Add Book
	 * 
	 * @param con
	 * @return
	 */
	public int add(Connection con, com.redsheep.model.Book book) throws Exception {
		String sql = "insert into t_book values(null,?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setBoolean(3, book.isDomestic());
		pstmt.setFloat(4, book.getGrade());
		pstmt.setFloat(5, book.getPrice());
		pstmt.setInt(6, book.getBookTypeId());

		return pstmt.executeUpdate();
	}

	/**
	 * Search Book Info
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con, com.redsheep.model.Book book) throws Exception {
		StringBuffer strBuff = new StringBuffer(
				"select * from t_book b,t_bookType bt where b.bookTypeId = bt.bookTypeId");
		if (StringUtil.isNotEmpty(book.getBookName())) {
			strBuff.append(" and b.bookName like '%" + book.getBookName() + "%'");
		}
		if (StringUtil.isNotEmpty(book.getAuthor())) {
			strBuff.append(" and b.author like '%" + book.getAuthor() + "%'");
		}
		if (book.getBookTypeId() != null && book.getBookTypeId() != -1) {
			strBuff.append(" and b.bookTypeId=" + book.getBookTypeId());
		}
		PreparedStatement pstmt = con.prepareStatement(strBuff.toString());

		return pstmt.executeQuery();
	}

	/**
	 * Delete Book
	 * 
	 * @param con
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, String id) throws Exception {
		String sql = "delete from t_book where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		return pstmt.executeUpdate();
	}

	/**
	 * update Book info
	 * 
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con, Book book) throws Exception {
		String sql = "update t_book set bookName=?,author=?,isDomestic=?,grade=?,price=?,bookTypeId=? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, book.getBookName());
		pstmt.setString(2, book.getAuthor());
		pstmt.setBoolean(3, book.isDomestic());
		pstmt.setFloat(4, book.getGrade());
		pstmt.setFloat(5, book.getPrice());
		pstmt.setInt(6, book.getBookTypeId());
		pstmt.setInt(7, book.getId());
		return pstmt.executeUpdate();
	}

	/**
	 * Find if there are any books in the specific bookType
	 * 
	 * @param con
	 * @param bookTypeId
	 * @return
	 * @throws Exception
	 */
	public boolean existBookByBookTypeId(Connection con, String bookTypeId) throws Exception {
		String sql = "select * from t_book where bookTypeId=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, bookTypeId);
		ResultSet rs = pstmt.executeQuery();
		return rs.next();
	}
}
