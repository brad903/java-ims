## 이슈 관리 시스템
> 해당 프로젝트는 교육기관 코드스쿼드 [이슈 관리 시스템](https://github.com/code-squad/java-ims/tree/master/src/main/java/codesquad)에서 Fork받아 발전시킨 것입니다.

이슈 관리 시스템은 Github 저장소 내의 [Issues](https://github.com/issues)와 같은 기능을 하는 웹 애플케이션입니다.

​		

​	

## 구현된 기능

* 공통
  * 유효성 체크
  * 세션값에 따른 처리
* 로그인, 회원가입
  * 회원가입시 프로필 이미지 추가
  * 회원정보 수정, 로그아웃
* 이슈 관리
  * 이슈 추가, 수정, 삭제
  * 답변 수정 및 삭제에 대한 비동기처리
  * 마일스톤, 라벨, 담당자 설정
  * 삭제된 이슈, 답변에 대해 History로 관리

  

​	

## 배운 부분

'이슈 관리 시스템' 프로젝트 이전에 ['질문 답변 게시판'](https://github.com/brad903/java-qna-atdd) 프로젝트를 통해 인수, 통합, 단위 테스트를 기반으로 프로젝트를 만드는 것을 경험하였습니다. 이를 바탕으로 '이슈 관리 시스템' 전 과정에서 테스트 주도 개발을 통해서 개발할 수 있도록 노력하였습니다. 이를 통해 데모를 하지 않더라도 다양한 값에 대한 테스트를 진행할 수 있었고, 테스트 주도 개발의 즐거움과 테스트의 중요성을 또한 깨달을 수 있었습니다.

기능 구현 후에는 Amazon EC2를 이용하여 배포를 하는 경험을 하였습니다. 자동화 배포를 위한 셸스크립트를 작성하여 자동화 배포의 중요성과 그 필요성에 대해서도 배울 수 있었습니다.

​	

​		

## Dev Notes

* [Todays' Dev Notes(2018-12-29)](https://brad903.tistory.com/entry/Todays-Dev-Notes20181229?category=842599)
* [Today's Dev Notes(2018-12-30)](https://brad903.tistory.com/entry/Todays-Dev-Notes20181230?category=842599)
* [Today's Dev Notes(2019-01-01)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190101?category=842599)
* [Today's Dev Notes(2019-01-04)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190104?category=842599)
* [Today's Dev Notes(2019-01-05)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190105?category=842599)
* [Today's Dev Notes(2019-01-06)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190106?category=842599)
* [Todays' Dev Notes(2019-01-10)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190110-1?category=842599)
* [Todays' Dev Notes(2019-01-12)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190112?category=842599)
* [Today's Dev Notes(2019-01-15)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190115?category=842599)
* [Today's Dev Notes(2019-01-16)](https://brad903.tistory.com/entry/Todays-Dev-Notes20190116?category=842599)