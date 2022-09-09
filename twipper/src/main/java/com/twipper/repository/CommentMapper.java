package com.twipper.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.twipper.bean.Comment;

@Mapper
public interface CommentMapper {

	/**
	 * Insert a new comment record to the database.
	 *
	 * @param comment comment object which we want to insert
	 * @return the number of inserted records
	 */
	int insert(Comment comment);

	/**
	 * Select all records from database.
	 *
	 * @return all records stored in database
	 */
	List<Comment> selectAll();

	/**
	 * Retrieve a record with the same id as provided.
	 *
	 * @param id identity of comment record
	 * @return comment record which has the same id as provided
	 */
	Comment select(String id);

	/**
	 * Update an existing record.
	 *
	 * @param comment comment object having the updating contents
	 * @return the number of updated records
	 */
	int update(Comment comment);

	/**
	 * Delete a record with the same id as provided.
	 *
	 * @param id identity of comment record
	 * @return the number of deleted records
	 */
	int delete(String id);
}