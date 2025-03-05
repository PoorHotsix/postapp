package com.example.postapp.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;



@Data
@Slf4j
public class PageResponseDto<T> {

  private List<T> dtoList;

  private PageRequestDto pageRequestDto;

  private long totalCount; // 총 데이터 갯수

  private List<Integer> pageNumList = new ArrayList<>();

  // private int start; // 시작 페이지 번호

  // private int end; // 끝 페이지 번호

  private boolean prev = false, next = false;

  private int prevPage, nextPage, totalPage, currentPage;

  private int pageSize = 10; // 1,2,3 ... 10


  @Builder
  public PageResponseDto(List<T> dtoList, PageRequestDto pageRequestDto, long totalCount) {
    
    this.dtoList = dtoList;
    this.pageRequestDto = pageRequestDto;
    this.totalCount = totalCount;
    this.currentPage = pageRequestDto.getPage();

    int end = (int)(Math.ceil(pageRequestDto.getPage() / (double)pageSize)) * pageSize;

    int start = end - (pageSize - 1);

    log.info("end : {}", end);

    int lastPage =  (int)(Math.ceil(totalCount / (double)pageRequestDto.getSize()));

    log.info("lastPage : {}", lastPage);

    this.totalPage = lastPage;

    end = end > lastPage ? lastPage : end;

    prev = start > 1;

    next = totalCount > (end * pageRequestDto.getSize());

    pageNumList = IntStream.range(start, end + 1).boxed().collect(Collectors.toList());

    prevPage = prev ? start - 1 : 0;

    nextPage = next ? end + 1 : 0;

  }



}
