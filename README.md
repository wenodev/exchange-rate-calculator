# 환율계산기 💰

## 소개

환율을 계산하는 웹페이지입니다. 외부 API를 이용하여 비지니스 로직을 구현하며, 이에 따른 적절한 테스트 코드를 작성하는 것이 목표입니다.

## 요구 사항

- 송금국가는 미국으로 고정입니다.
- 미국의 통화는 USD 입니다.
- 수취국가는 한국, 일본, 필리핀이며 각각 KRW, JPY, PHP 입니다.
- 환율과 수취금액은 소숫점 2번째 자리까지이며 3자리 이상은 콤마를 찍습니다. ex) 1,234.00

## 기능 명세

- [x] 외부 API를 통해 환율 정보를 얻는다.
- [x] 서버가 시작할 때, 환율 정보를 저장한다.
- [x] 원하는 통화의 환율 정보를 조회한다.
- [x] 수취금액을 계산한다.

## 화면 명세

- [x] 계산기 항목을 보여준다.
- [x] 통화 선택에 따른 환율을 보여준다.
- [x] 송금액과 환율을 계산하여 수취금액을 보여준다.
