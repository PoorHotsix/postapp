package com.example.postapp.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder // 빌더 에노테이션 쓸 때 아래에 두개를 반드시 같이 씀
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ErrorResponse {

  private String code; // 에러 코드
  private String message; // 에러 메시지

}
