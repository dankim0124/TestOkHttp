**[2/22]Okhttp  정리**

**개요**
이번 프로젝트에 사용할 library 테스트 해보기


**목표**

Rest api 하는 것들 중 
 - Async 지원 
   
 - web socket 

위 두개 지원하는게 okhttp 밖에 없음

configuration 파일 만들어서, sync call, async 콜 보내봄.

-----------

**주의**

기본적으로 singleton pattern 으로 쓰기를 장려한다.
각각의 client 객체에 connection pool, thread pools 들이 지정되어 있기 때문에 커넥션과 쓰레드 풀을 재사용하는 것이 전체 어플리케이션에서 봤을때 비용이 절감된다는 뜻.  client 객체를 여러개 만들어서 쓰면 반대로 놀고있는 클라이언트의 자원만큼이 낭비된다는 뜻이 된다 .

따라서, final 키워드를 줘서 하나만 쓰거나  or builder 함수와 조합하여 커스텀 세팅을 넣은 클라잉언트 하나만 쓰래요 .



