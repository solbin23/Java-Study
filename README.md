# Java 중급 공부 레포

## Generics

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

## 컬렉션 프레임워크 - ArrayList

#### 배열의 특징
+ 배열에서 자료를 찾을 때 인덱스를 사용하면 매우 빠르게 찾을 수 있다.
+ 인덱스를 통한 입력, 변경, 조회의 경우 한번의 계산으로 자료의 위치를 찾을 수 있다.
1) arr[2]에 위치한 자료를 찾는다고 가정
2) 배열은 메모리상에 순서대로 붙어서 존재
3) int는 4byte를 차지함
4) 따라서 배열의 시작 위치인 x100부터 시작해서 자료의 크기(4byte)와 인텍스 번호를 곱하면 인덱스의 위치를 알 수 있다.
5) 배열의 시작 참조(x100) + (자료의 크기(4byte) * 인덱스 위치(2)) = x108이 나옴

#### 배열의 검색
+ 배열에 들어있는 데이터를 찾는 것을 검색이라함
+ 배열에 들어있는 데이터를 검색할 때는 배열에 들어있는 데이터를 하나하나 비교해야함
+ 이전과 같이 인덱스를 사용하여 한번에 찾을 수 없음
+ 배열 안에 들어있는 데이터를 하나하나 확인해야함
+ 따라서 평균적으로 볼 때 배열의 크기가 클 수록 오랜 시간이 걸림

#### 배열의 크기와 검색 연산
+ 배열의 크기 1: arr[0] 연산 1회
+ 배열의 크기 2: arr[0], arr[1] 연산 2회
+ 배열의 크기 3: arr[0], arr[1], arr[2] 연산 3회
+ 배열의 크기 10000: arr[0], arr[1], arr[2] ..... arr[9999] 연산 10000회

**배열의 크기가 n이면 연산도 n만큼 필요함.**

----
#### 빅오(O) 표기법

알고리즘의 성능을 분석할 때 사용하는 수학적 표현방식.

특히 알고리즘이 처리해야 할 데이터의 양이 증가할 때, 그 알고리즘이 얼마나 빠르게 실행되는지 나타냄

**빅오 표기법의 예시**
+ O(1) - 상수 시간: 입력 데이터의 크기에 관계없이 알고리즘의 실행 시간이 일정
  + ex) 배열에서 인덱스를 사용하는 경우
+ O(n) - 선형 시간: 알고리즘의 실행 시간이 입력 데이터의 크기에 비례하여 증가
  + ex) 배열의 검색, 배열의 모든 요소를 순회하는 경우
+ O(n²) - 제곱 시간: 알고리즘의 실행 시간이 입력 데이터의 크기의 제곱에 비례하여 증가
  + ex) 보통 이중 루프를 사용하는 알고리즘에서 나타남 -> 이중 for문...
+ O(log n) - 로그 시간: 알고리즘의 실행 시간이 데이터 크기의 로그에 비례하여 증가
  + ex) 이진 탐색
+ O(n log n) - 선형 로그 시간:
  + ex) 많은 효율적인 정렬 알고리즘들

----

>**배열 정리**
>+ 배열의 인덱스 사용: O(1)
>+ 배열의 순차 검색: O(n)

---

> **배열에 데이터를 추가할 때 위치에 따른 성능 변화**
> + 배열의 첫번째 위치에 추가
 >   + 배열의 첫번째 위치를 찾는데는 인덱스를 사용하므로 O(1)이 걸린다.
 >   + 모든 데이터를 배열의 크기만큼 한 칸씩 이동해야한다. 따라서 O(n)만큼의 연산이 걸린다.
 >   + O(1+n) -> O(n)
>+ 배열의 중간 위치에 추가
 >   + 배열의 첫번째 위치를 찾는데는 O(1)이 걸린다.
 >   + index의 오른쪽에 있는 데이터를 모두 한 칸씩 이동해야 한다. 따라서 평균 연산은 O(n/2)가 된다.
 >   + O(1+n/2) -> O(n)
>+ 배열의 마지막 위치에 추가
 >   + 이 경우 배열이 이동하지 않고 배열의 길이를 사용하면 마지막 인덱스에 바로 접근할 수 있으므로 한 번의 계산으로 위치를 찾을 수 있고, 기존 배열을 이동하지 않으므로 O(1)이 된다.

---
### List 자료 구조

순서가 있고, 중복을 허용하는 자료 구조를 리스트라 한다.

일반적으로 배열과 리스트는 구분해서 이야기함. 리스트는 배열보다 유연한 자료 구조로, 크기가 동적으로 변할 수 있다.
+ 배열: 순서가 있고 중복을 허용하지만 크기가 정적으로 고정됨
+ 리스트: 순서가 있고 중복을 허용하지만 크기가 동적으로 변할 수 있음
> 여기서 중복을 허용한다는 뜻은 같은 데이터를 입력할 수 있다는 것
> 예를 들어 arr[0] = 1, arr[1] = 1 은 하나의 배열에 같은 숫자 1이 입력되었다. 이것이 중복을 허용한다는 뜻이다.
> 자료 구조 중에는 중복을 허용하지 않는 자료구조도 존재한다.

---
## 컬렉션 프레임워크 - LinkedList

#### 노드와 연결

낭비되는 메모리 없이 딱 필요한 만큼만 메모리를 확보해서 사용하고, 앞이나 중간에 데이터를 추가하거나 삭제할 때도 효율적인 자료구조가 있다.

바로 노드를 만들고 각 노드를 서로 연결하는 방식이다.

---
#### 정리
+ 노드는 내부에 데이터와 다음 노드에 대한 참조를 가지고 있다.
+ 지금까지 추가한 코드의 구조는 각각 노드가 참조를 통해 연결(Link)되어 있다.
+ 데이터를 추가할 때 동적으로 필요한 만큼의 노드만 만들어서 연결하면 되기 때문에 배열과 다르게 메모리를 낭비하지 않는다.
  + 물론 next 필드를 통해 참조값을 보관해야 하기 때문에 배열과 비교해서 추가적인 메모리 낭비도 발생한다.
+ 이렇게 각각의 노드를 연결해서 사용하는 자료구조로 리스트를 만들 수 있는데, 이것을 연결 리스트라고 한다.

---

### 연결 리스트와 빅오

**Object get(int index)**
+ 특정 위치에 있는 데이터를 반환
+ 특정 위치의 노드를 찾는데 O(n)이 걸림

**void add(Object e)**
+ 마지막에 데이터를 추가한다.
+ O(n)
  + 마지막 노드를 찾는데 O(n)이 소요된다. 마지막 노드에 새로운 노드를 추가하는데 O(1)이 걸린다. 따라서 O(n) 이다.

**int indexOf(Object o)**
+ 데이터를 검색하고, 검색된 위치를 반환한다.
+ O(n)
  + 모든 노드를 순회하면서 equals()를 사용해서 같은 데이터가 있는지 찾는다.
---

**정리**

직접 구현한 배열 리스트와 연결 리스트의 성능 비교 표

|    **기능**     | **배열리스트** | **연결리스트** |
|:-------------:|:---------:|:---------:|
|   **인덱스조회**   |   O(1)    |   O(n)    |
|    **검색**     |   O(n)    |   O(n)    |
| **앞에 추가(삭제)** |   O(n)    |   O(1)    |
| **뒤에 추가(삭제)** |   O(1)    |   O(n)    |
| **평균 추가(삭제)** |   O(n)    |   O(n)    |

**추가,삭제**
+ 배열 리스트는 인덱스를 통해 추가나 삭제할 위치를 O(1)로 빠르게 찾지만, 추가나 삭제 이후에 데이터를 한칸씩 밀어야 한다. 이 부분이 O(n)으로 오래 걸린다.
+ 연결 리스트는 인덱스를 통해 추가나 삭제할 위치를 O(n)으로 느리게 찾지만, 실제 데이터의 추가는 간단한 참조 변경으로 빠르게 O(1)로 수행된다.

**앞에 추가(삭제)**
+ 배열 리스트: 추가나 삭제할 위치는 찾는데 O(1), 데이터를 한칸씩 이동 O(n) -> O(n)
+ 연결 리스트: 추가나 삭제할 위치는 찾는데 O(1), 노드를 변경하는데 O(1) -> O(1)

**평균 추가(삭제)**
+ 배열 리스트: 추가나 삭제할 위치는 찾는데 O(1), 인덱스 이후의 데이터를 한칸씩 이동 O(n/2) -> O(n)
+ 연결 리스트: 추가나 삭제할 위치는 찾는데 O(n/2), 노드를 변경하는데 O(1) -> O(n)

**뒤에 추가(삭제)**
+ 배열 리스트: 추가나 삭제할 위치는 찾는데 O(1), 이동할 데이터 없음 -> O(1)
+ 연결 리스트: 추가나 삭제할 위치는 찾는데 O(n), 노드를 변경하는데 O(1) -> O(n)

**인덱스 조회**
+ 배열 리스트: 배열에 인덱스를 사용해서 값을 O(1)로 찾을 수 있음
+ 연결 리스트: 노드를 인덱스 수 만큼 이동해야함 O(n)

**검색**
+ 배열 리스트: 데이터를 찾을 때 까지 배열을 순회 O(n)
+ 연결 리스트: 데이터를 찾을 때 까지 노드를 순회 O(n)

**시간 복잡도와 실제 성능**
+ 이론적으로 MyLinkedList의 평균 추가(중간 삽입) 연산은 MyArrayList보다 빠를 수 있다. 그러나 실제 성능은 요소의 순차적 접근 속도, 메모리 할당 및 해제 비용, CPU 캐시 활용도 등 다양한 요소에 의해 영향을 받는다.
+ MyArrayList는 요소들이 메모리 상에서 연속적으로 위치하여 CPU 캐시 효율이 좋고, 메모리 접근 속도가 빠르다.
+ 반면, MyLinkedList는 각 요소가 별도의 객체로 존재하고 다음 요소의 참조를 저장하기 때문에 CPU 캐시 효율이 떨어지고, 메모리 접근 속도가 상대적으로 느릴 수 있다.

**정리**

이론적으로 MyLinkedList가 평균 추가(중간 삽입)에 있어 더 효율적일 수 있지만, 컴퓨터 시스템의 메모리 접근 패턴, CPU 캐시 최적화 등을 고려할 때 MyArrayList가 실제 사용 환경에서 더 나은 성능을 보여주는 경우가 많다.

----

### 리스트(List) vs 세트(Set)

자료 구조에서의 **List**와 **Set**은 각각 특정한 방식으로 데이터를 지정하고 관리하는 데 사용된다.

**List(리스트)**
+ **정의**: 리스트는 요소들의 순차적인 컬렉션이다. 요소들은 특정 순서를 가지며, 같은 요소가 여러 번 나타날 수 있다.
+ **특징**
  + **순서 유지**: 리스트에 추가된 요소는 특정한 순서를 유지한다. 이 순서는 요소가 추가된 순서를 반영할 수 있다.
  + **중복 허용**: 리스트는 동일한 값이나 객체의 중복을 허용한다. 예를 들어, 같은 숫자나 문자열을 리스트 안에 여러 번 저장할 수 있다.
  + **인덱스 접근**: 리스트의 각 요소는 인덱스를 통해 접근할 수 있다. 인덱스는 보통 0부터 시작한다.
+ **용도**: 순서가 중요하거나 중복된 요소를 허용해야 하는 경우에 주로 사용된다.

**Set(셋)**
+ **정의**: set은 유일한 요소들의 컬렉션이다.
+ **특징**
  + **유일성**: set에는 중복된 요소가 존재하지 않는다. set에 요소를 추가할 때, 이미 존재하는 요소면 무시된다.
  + **순서 미보장**: 대부분의 set 구현에서는 요소들의 순서를 보장하지 않는다. 즉, 요소를 출력할 때 입력 순서와 다를 수 있다.
  + **빠른 검색**: set은 요소의 유무를 빠르게 확인할 수 있도록 최적화되어 있다. 이는 데이터의 중복을 방지하고 빠른 조회를 가능하게 한다.
+ **용도**: 중복을 허용하지 않고, 요소의 유무만 중요한 경우에 사용된다.

**예시**
+ **List**: 장바구니 목록, 순서가 중요한 일련의 이벤트 목록
+ **Set**: 회원 ID 집합, 고유한 항목의 집합