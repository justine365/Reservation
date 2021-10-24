# Reservation
백신 예약 프로젝트
==================

개발정보
--------------

### 제작자

오수민

### 목적


코로나19사태의 기존 백신예약 프로그램에서 더 편리하도록 지도에서 더 잘 찾을 수 있도록 구글맵을 추가하였고 전화걸기 버튼들을 추가하여 바로 예약한 센터에 전화를 걸 수 있도록 하였다. 또, 백신 치료제 절차, 예방접종 절차들의 정보를 제공하였고 예약 완료 전에 한번더 예약정보를 수정할 수 있도록 하여 편리성을 높였다.

### 제작기간


2021/8/22~2021/10/17

8/22 기획 프레젠테이션 제작 

8/29 모든 페이지 생성 및 디자인 제작

9/5 디자인 제작과 API 정보 불러오기 및 의료기관 선택 스피너 제작

9/12 의료기관 선택 스피너 제작

9/26 본인확인 페이지,수정 페이지 및 저장 기능 제작

10/3 구글 맵 API 연동 및 제작

10/10 구글맵 위도,경도 적용 및 의료기관 선택 스피너 오류 수정

10/17 의료기관 스피너 개선 및 디자인 추가

10/24 의료기관 스피너 오류 수정 및 디자인 

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

<img src="https://user-images.githubusercontent.com/83526407/138581886-db00c359-e16a-4bf2-9883-15912d203de6.jpg" width="20%" height="10%" title="intro"></img>

처음 화면입니다. 
3초 동안 화면이 고정되고 
다음화면으로 자동으로 넘어갑니다.

<img src="https://user-images.githubusercontent.com/83526407/138581949-dcabf6e8-16b4-4ea7-9363-832c35b405f0.jpg" width="20%" height="10%" title="intro-2"></img>

인트로 페이지 입니다.
백신 절차와 방역수칙에 대한 정보를 제공하고 지금 신청하기 버튼을 눌러 신청화면으로 넘어갑니다.


### 2.본인확인

<img src="https://user-images.githubusercontent.com/83526407/138582227-33e5d5e0-b55d-44d0-8bcf-7f0263c7818f.jpg" width="20%" height="10%" title="" ></img>

백신 신청을 위해 이름, 전화번호, 주민등록번호를 제공받고 저장합니다.

입력된 이름/전화번호/주민등록번호를 저장하고 입력되지 않았을경우에는 토스트 메세지와 함께 다음페이지로 넘어가지 못합니다

<img src="https://user-images.githubusercontent.com/83526407/138582174-b3bed001-2d10-4065-9278-f4e1f9c5fb51.jpg" width="20%" height="10%" title="" ></img>
<img src="https://user-images.githubusercontent.com/83526407/138582202-f2416768-c5da-48e0-ade7-69458e6c6218.jpg" width="20%" height="10%" title="" ></img>
<img src="https://user-images.githubusercontent.com/83526407/138582212-cdc27b2d-7670-4247-ac8c-63e4b2b29a1b.jpg" width="20%" height="10%" title="" ></img>


### 3.백신선택

<img src="https://user-images.githubusercontent.com/83526407/138582243-f4837468-97b7-4efa-8875-41fb1ae5eb22.jpg" width="20%" height="10%" title="" ></img>

두가지 백신을 선택할 수 있고 예외처리를 하여 하나만 선택가능합니다.

<img src="https://user-images.githubusercontent.com/83526407/138582251-d1da8cf0-663d-4b96-9323-41c872bc8147.jpg" width="20%" height="10%" title="" ></img>

선택하지 않았을 경우에는 토스트메세지와 함께 넘어가지 못합니다.

### 4.의료기관 선택

<img src="https://user-images.githubusercontent.com/83526407/138582341-431be746-7140-4837-8075-a7096b96223a.jpg" width="20%" height="10%" title="" ></img>

의료기관 선택 페이지입니다 정부에서 제공하는 공공데이터 API를 사용하여 스피너에 시도/시군구/센터이름으로 나누어 시도를 선택하면 시도 안에있는 센터들의 시군구가 다음 스피너에 나오고 시군구를 선택하면 시도 시군구 내부의 센터이름이 나옵니다.

<img src="https://user-images.githubusercontent.com/83526407/138582666-ad073b78-645b-47ba-9480-0d9d4aa86314.jpg" width="20%" height="10%" title="" ></img>

시도 선택페이지 입니다.

<img src="https://user-images.githubusercontent.com/83526407/138582669-77e74c5e-a210-48b5-97cf-9468c9061332.jpg" width="20%" height="10%" title="" ></img>

시도에 속하는 시군구들의 선택페이지 입니다

<img src="https://user-images.githubusercontent.com/83526407/138582675-9e69929c-3935-4b81-884b-3355b275caba.jpg" width="20%" height="10%" title="" ></img>

시도,시군구들에 속하는 센터들입니다.

### 5.구글 지도


<img src="https://user-images.githubusercontent.com/83526407/138582395-6686b29e-72aa-4d43-ae95-b1be2dacb918.jpg" width="20%" height="10%" title="" ></img>


마지막으로 선택한 시도/시군구/센터이름의 위도,경도의 API를 저장하여 구글지도에서 위치를 확인할 수 있습니다.

<img src="https://user-images.githubusercontent.com/83526407/138582712-868f2733-6891-4d6e-9739-68e9bb58bccd.jpg" width="20%" height="10%" title="" ></img>

구글 맵 요청전에 권한승인을 받습니다.

### 6.예약정보 확인 및 수정/ 의료기관으로 전화걸기

<img src="https://user-images.githubusercontent.com/83526407/138582407-6f4bf251-79b1-4e1c-acf2-fc23f897e35e.jpg" width="20%" height="10%" title="" ></img>

예약정보를 확인하는 페이지로 넘어가고 EditText이기 때문에 예약정보를 수정할 수 있고 수정된 정보는 저장됩니다.

<img src="https://user-images.githubusercontent.com/83526407/138582421-329eae55-cb6c-4efe-ad81-2db919be8932.jpg" width="20%" height="10%" title="" ></img>

스피너 뷰의 시도/시군구/센터이름의 기관의 전화번호를 저장하여 전화번호가 입력된 전화앱으로 연동됩니다.


### 7.예약 정보 확정

<img src="https://user-images.githubusercontent.com/83526407/138582450-346e5558-4644-42ba-841a-3e4f2e6ad013.jpg" width="20%" height="10%" title="" ></img>

전 페이지에서 저장된 예약정보를 확정시킵니다


### 8.예약완료

<img src="https://user-images.githubusercontent.com/83526407/138582451-14385adc-592f-4c90-a44a-7d824bfbc84e.jpg" width="20%" height="10%" title="" ></img>

예약완료 페이지입니다.













