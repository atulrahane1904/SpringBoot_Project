package com.personal_project.bloging_app.util;

import java.util.List;

import com.personal_project.bloging_app.dto.Post;

import lombok.Data;
@Data

public class PostResponse <T> {
private List<Post> content;
private int pageNumber;
private int pageSize;
private long totalElement;
private boolean lastPage;
private String message;
private int status;
private int totalPages;
//private T data;

}
