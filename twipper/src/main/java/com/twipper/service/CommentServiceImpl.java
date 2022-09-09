package com.twipper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twipper.bean.Comment;
import com.twipper.repository.CommentMapper;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper mapper;

	@Override
	public Comment register(Comment comment) {
		/*		String formattedEmail = formatEmail(comment.getEmail());
				comment.setEmail(formattedEmail);
		
				mapper.insert(comment);
		*/ return comment;
	}

	@Override
	public List<Comment> retrieve() {
		return mapper.selectAll();
	}

	@Override
	public Comment retrieve(String id) {
		return mapper.select(id);
	}

	@Override
	public Comment update(Comment comment) {
		/*		String formattedEmail = formatEmail(comment.getEmail());
				comment.setEmail(formattedEmail);
		
				mapper.update(comment);
				*/return comment;
	}

	@Override
	public String delete(String id) {
		mapper.delete(id);
		return id;
	}

	private String formatEmail(String email) {
		String[] separatedEmail = email.split("@");
		return separatedEmail[0] + "@" + separatedEmail[1].toLowerCase();
	}

}