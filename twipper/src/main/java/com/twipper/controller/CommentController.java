package com.twipper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twipper.bean.Comment;
import com.twipper.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping
	public Comment post(@Validated @RequestBody Comment comment, Errors errors) {
		// If the fields of requested comment object are invalid,
		// throw Runtime Exception with validation errors.
		// NOTE: You can set HTTP status code and return it instead of throwing error.
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		// NOTE: You can also validate whether insertion succeeded or not here.
		return commentService.register(comment);
	}

	@GetMapping
	public List<Comment> get() {
		return commentService.retrieve();
	}

	@GetMapping("/{id}")
	public Comment get(@PathVariable String id) {
		return commentService.retrieve(id);
	}

	@PatchMapping
	public Comment patch(@Validated @RequestBody Comment comment, Errors errors) {
		if (errors.hasErrors()) {
			throw new RuntimeException((Throwable) errors);
		}
		return commentService.update(comment);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		return commentService.delete(id);
	}
}