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
  ---
      제네릭 타입 설정
      class ComplexBox< T extends Animal >

      제네릭 메서드 설정
      < T > T printAndReturn(T t)
  
      -> 제네릭 타입보다 제네릭 메서드가 높은 우선순위를 가진다.

      <실행결과>
      animal.className:generic.animal.Dog
      t.className: generic.animal.Cat
      returnCat = Animal{name='야옹이', size=50}
  ---
  
### 비제한 와일드카드

  **printGenericV1(Box< T > box)**

  **printWildCardV1(Box< ? > box)**
+ 두 메서드는 비슷한 기능을 한다. 하나는 제네릭 메서드를 사용하고 하나는 일반적인 메서드에 와일드 카드를 사용했다.
+ 와일드 카드는 제네릭 타입이나 제네릭 메서드를 정의할 때 사용하는 것이 아니다. Box< Dog >, Box< Cat > 처럼 타입 인자가 정해진 제네릭 타입을 전달 받아서 활요할 때 사용한다.
+ 와일드 카드인 ? 는 모든 타입을 다 받을 수 있다는 뜻
  + ? == < ? extends Object >
  + 이렇게 ? 만 사용해서 제한 없이 모든 타입을 다 받을 수 있는 와일드카드를 비제한 와일드 카드라고 한다.

---
### 타입 이레이저

이레이저(eraser)는 지우개라는 뜻

제네릭은 자바 컴파일 단계에서만 사용되고, 컴파일 이후에는 제네릭 정보가 삭제됨.

제네릭에 사용한 타입 매개변수가 모두 사라지는 것.

쉽게 이야기해서 컴파일 전인 .java에는 제네릭의 타입 매개변수가 존재하지만, 컴파일 이후인 자바 바이트코드 .class에는 타입 매개변수가 존재하지 않는 것.

instanceof는 항상 Object와 비교하게 된다. 이렇게 되면 항상 참이 반환되는 문제가 발생함.
  + 이런 문제 때문에 타입 매개변수에 instanceof를 허용하지 않음

new T는 항상 new Object가 되어버림. 
  + 따라서 자바는 타입 매개변수에 new 를 허용하지 않음