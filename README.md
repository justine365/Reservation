# Reservation
백신 예약 프로젝트
==================

개발정보
--------------

### 제작자

오수민

### 목적


코로나19사태의 기존 백신예약 프로그램의 문제점들을 개선하여 다양한 기능들을 추가하고 편리성을 높이기 위함

### 제작기간


2021/8/29~2021/10/17

### 개발환경


-android

-android studio

-java 8

### 사용 API


-백신예약접종API

-Google map API

주요기능
--------------


### 1.Intro


.![KakaoTalk_20211024_013542008](https://user-images.githubusercontent.com/83526407/138566494-6e3c740f-5821-45fd-80ba-c095c4cb9baa.jpg)
처음 화면입니다.
지금 신청하기 버튼을 클릭하여 본인확인페이지로 넘어갈 수 있습니다.


### 2.본인확인


.![KakaoTalk_20211024_013542008_01](https://user-images.githubusercontent.com/83526407/138566498-2680954f-06a3-474b-a11e-a8c789ecdded.jpg)
입력된 이름/전화번호/주민등록번호를 저장하고 입력되지 않았을경우에는 토스트 메세지와 함께 다음페이지로 넘어가지 못합니다


### 3.백신선택


.![KakaoTalk_20211024_013542008_02](https://user-images.githubusercontent.com/83526407/138566506-42effa92-4546-4474-bdeb-90600d7f6bcb.jpg)

두가지 백신을 선택할 수 있고 선택하지 않았을 경우에는 토스트메세지와 함께 넘어가지 못합니다.

### 4.의료기관 선택


.![KakaoTalk_20211024_013542008_03](https://user-images.githubusercontent.com/83526407/138566510-06f5c8fe-1b0e-44b4-95a5-4a5f373d015c.jpg)

의료기관 선택 페이지입니다 API에서 시도/시군구/센터 이름 순차적으로 스피너 뷰에 넣었고 선택한 스피너의 주소를 API에서 받아서 구글지도에서 볼 수 있습니다

시도 선택페이지 입니다.

![KakaoTalk_20211024_013542008_04](https://user-images.githubusercontent.com/83526407/138566517-ee9d8773-f4f7-4dd1-902b-239f3e190997.jpg)

시도를 선택하면 그 시도 하위의 시군구들이 뷰에 나옵니다.

![KakaoTalk_20211024_013542008_05](https://user-images.githubusercontent.com/83526407/138566522-bac0cf0d-32b8-4a31-8b19-8cf34fa2a303.jpg)

시군구를 선택하면 하위의 센터이름들이 뷰에 나옵니다

![KakaoTalk_20211024_013542008_06](https://user-images.githubusercontent.com/83526407/138566526-ccbfa4bc-8e3c-46df-a14f-8678533ef255.jpg)


### 5.구글 지도


.![KakaoTalk_20211024_013542008_07](https://user-images.githubusercontent.com/83526407/138566528-a1200c9f-266b-4a3f-875a-1e7ea9f1b962.jpg)

마지막으로 선택한 스피너의 API에서 위도,경도를 저장하여 구글지도에서 사용하여 위치를 확인할 수 있습니다. 
구글 맵 요청전에 권한승인을 받습니다.

### 6.예약정보 확인 및 수정/ 의료기관으로 전화걸기


.![KakaoTalk_20211024_013542008_08](https://user-images.githubusercontent.com/83526407/138566533-12c21a3d-0258-4d80-a876-f40249d946cb.jpg)

예약정보를 확인하는 페이지로 넘어가고 EditText이기 때문에 예약정보를 수정할 수 있고 수정된 정보는 저장됩니다.


스피너 뷰의 시도/시군구/센터이름의 기관의 전화번호를 저장하여 전화번호가 입력된 전화앱으로 연동됩니다.


### 7.예약 정보 확정


.![KakaoTalk_20211024_013542008_09](https://user-images.githubusercontent.com/83526407/138566535-52502efc-2799-4848-b2b6-d7cd903dbf74.jpg)

예약정보를 확정하여 저장된 내용을 뷰에 표현합니다


### 8.예약완료

![KakaoTalk_20211024_013542008_10](https://user-images.githubusercontent.com/83526407/138566536-98fdc540-69a1-49bc-83e3-f5e8952fcde6.jpg)

예약완료 페이지입니다.













