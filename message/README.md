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
```html
<label for = "itemName" th:text="#{item.itemName}"></label>
```
### editForm.html
```html
<label for = "itemName" th:text="#{item.itemName}"></label>
```
각 HTML들은 위와 같이 해당 데이터를 key 값으로 불러서 사용한다
<br>
<br>
## 2. 국제화
접속한 나라에 따라 화면에 보이는 글자를 다르게 하려면 어떻게 해야할까??

메시지 파일(messages.properties)를 나라별로 관리를 하면 서비스를 국제화를 할 수 있다

ex) 클라이언트에서 보낸 HTTP 요청(accept-language)값이 en일 경우 messages_en.properties를 사용
```java
item=Item
item.id=Item ID
item.itemName=Item Name
item.price=price
item.quantity=quantity
```
ex) 클라이언트에서 보낸 HTTP 요청(accept-language)의 값이 ko인 경우 messages_ko.properties의 값을 이용
```java
item=상품
item.id=상품ID
item.itemName=상품명
item.price=가격
item.quantity=수량
```

accept-language 헤더값을 사용하거나 또는 사용자가 직접 언어를 선택하도록 하고 쿠키 등을 사용해서 처리하면 각 나라의 언어에 맞게 페이지를 보여줄 수 있다.
스프링도 기본적인 메시지와 국제화를 편하게 사용할 수 있도록 기능을 제공하고 있다. 
