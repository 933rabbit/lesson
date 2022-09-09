package com.twipper.service;

import java.util.List;

import com.twipper.bean.Comment;

public interface CommentService {

	/**
	 * Register a new customer information.
	 *
	 * @param comment customer object which we want to register
	 * @return comment object registered
	 */
	Comment register(Comment comment);

	/**
	 * Retrieve all comment information.
	 *
	 * @return all comment information
	 */
	List<Comment> retrieve();

	/**
	 * Retrieve the comment information having the same id as provided.
	 *
	 * @param id identity of comment information
	 * @return comment information having the same id as provided
	 */
	Comment retrieve(String id);

	/**
	 * Update comment information.
	 *
	 * @param comment customer object which we want to update
	 * @return comment object updated
	 */
	Comment update(Comment comment);

	/**
	 * Delete customer information.
	 *
	 * @param id identity of comment information
	 * @return identity of deleted comment
	 */
	String delete(String id);
}