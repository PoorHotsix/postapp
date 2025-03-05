package com.example.postapp.exception;


// Unchecked Exception
public class ArticleNotFoundException extends RuntimeException {

  public ArticleNotFoundException() {
    super("게시글 정보가 수정되지 않습니다.");
  }

  public ArticleNotFoundException(String message) {
    super(message);
  }


}
