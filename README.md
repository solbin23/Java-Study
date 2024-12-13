# Generics-Study
## Java 중급 공부 레포
---
+ **제네릭 타입**
  + 정의: GenericClass< T >
  + 타입 인자 전달: 객체를 생성하는 시점
    + ex) new GenericClass< String >
+ **제네릭 메서드**
  + 정의 : < T > T genericMethod(T t)
  + 타입 인자 전달 : 메서드를 호출하는 시점
    + ex) GenericMethod.< Integer >genericMethod(i)
  + 제네릭 메서드는 클래스 전체가 아니라 특정 메서드 단위로 제네릭을 도입할 때 사용한다.
  + 제네릭 메서드를 정의할 때는 메서드의 반환 타입 왼쪽에 다이아몬드를 사용해서 < T >와 같이 타입 매개변수를 적어준다.
  + 제네릭 메서드는 메서드를 실제 호출하는 시점에 다이아몬드를 사용해서 < Integer > 와 같이 타입을 정하고 호출한다.