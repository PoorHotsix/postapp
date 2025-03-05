package com.example.postapp.service;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.example.postapp.dto.PageRequestDto;
import com.example.postapp.dto.PageResponseDto;
import com.example.postapp.dto.PostDto;
import static org.junit.jupiter.api.Assertions.*;
import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
@Transactional
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostServiceImplTest {

  @Autowired
  private PostService postService;


  @Test
  public void test() {
    assertNotNull(postService);
  }

  @Test
  @Rollback(false)
  public void testRegisterPost() {

    // given

    // when
    PostDto postDto = new PostDto();
    postDto.setTitle("제목1");
    postDto.setContents("내용1");
    postDto.setWriter("작가1");
    postDto.setRegDate(LocalDateTime.now());

    Long id = postService.registerPost(postDto);

    log.info("id : {}", id);

    // then
    assertNotNull(id);

  }

  // @Test
  // void testRegisterPost() {

  //   // given
  //   PostDto postDto = PostDto.builder()
  //     .title("test1")
  //     .contents("content1")
  //     .writer("writer1")
  //     .regDate(LocalDateTime.now())
  //     .build();

  //   // when
  //   long id = postService.registerPost(postDto);

  //   // then
  //   assertNotNull(id);

  //   log.info("post id : {}", id);

  // }


  // @Test
  // public void testPaging() {

  //   // given
  //   PageRequestDto pageRequestDto = PageRequestDto.builder()
  //     .page(1)
  //     .size(10)
  //     .build();

  //   // when
  //   PageResponseDto<PostDto> pageResponseDto = postService.paging(pageRequestDto);


  //   // then
  //   log.info("totalCount : {}", pageResponseDto.getTotalCount());
  //   log.info("page : {}", pageResponseDto.getPageRequestDto().getPage());
  //   log.info("size : {}", pageResponseDto.getPageRequestDto().getSize());

  //   pageResponseDto.getDtoList().forEach(post -> {

  //     log.info("id : {}, title : {}", post.getId(), post.getTitle());

  //   });

  // }

}
