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


## 3.스프링이 제공하는 메시지 기능

스프링은 기본적 메시지 관리 기능을 제공한다 
메시지 관리 기능을 사용하려면 MessageSource를 스프링 빈으로 등록하면 된다.
```java
public MessageSource messageSource() {
  ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasenames("message","errors");
    messageSource.setDefaultEncoding("utf-8");
    return messageSource;
    }
```
* basenames : 설정파일 이름 지정
* messages로 지정하면 messages.properties 파일 사용
* 국제화 기능을 적용하려면 messages_en.properties 같이 파일명 마지막에 언어정보를 준다
* /resource/messages.properties에 위치한다

> 스프링 부트를 사용하면 스프링 부트가 자동으로 MessageSource를 빈으로 등록함


```text
스프링부트 메시지 소스 기본 값
spring.messages.basename = messages
```


### 스프링의 국제화 메시지 선택
메시지 기능은 Locale 정보를 알아야 언어를 선택할 수 있는데 스프링은 언어 선택시 기본으로 Accept-Language 헤더 값을 사용한다

### LocaleResolver
스프링은 Locale 선택 방식을 변경할 수 있도록 LocaleResolver 인터페이스를 제공한다.

스프링부트는 기본으로 Accept-Language를 활용하는 AcceptHeaderLocaleResolver을 사용함.


```java
public interface LocaleResolver {
  
  Locale resolveLocale(HttpServletRequest request);
  void setLocale(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable Locale locle)
  
  }
```



