# 메시지, 국제화

## 1. 메시지
기획자가 화면에 보이는 상품명이란 단어를 상품이름으로 수정해달라는 요청이 왔을 때 파일 수가 적을 때는 문제가 되지 않는다.

__그러나 파일이 수십 수백개라면..??__

  > 모든 파일을 고치다가 진이 다 빠질 것이다...

이런 다양한 메시지를 한 곳에서 관리하도록 하는 기능을 __메시지 기능이라고__ 한다.


ex) messages.properties 메시지 관리용 파일을 만들고

```java
item=상품
item.id=상품ID
item.itemName=상품명
item.price=가격
item.quantity=수량
```

### addForm.html
```
<label for = "itemName" th:text="#{item.itemName}"></label>
```
### editForm.html
```
<label for = "itemName" th:text="#{item.itemName}"></label>
```
각 HTML들은 위와 같이 해당 데이터를 key 값으로 불러서 사용한다
<br>
<br>
## 2. 국제화
