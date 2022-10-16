# Java I/O

---

1. Stream 이란?
2. Stream 특징
3. Stream 종류
4. Java - InputStream

---

## Stream 이란?

Stream 이란, Data 를 운반하는데 사용되는 연결통로이다.

Stream 은 단방향 통신만 가능하기 때문에 하나의 Stream 으로는 입/출력을 동시에 처리할 수 없다.

Stream 은 연속적으로 Data를 주고 받는다.

Queue와 같은 FIFO 구조로 동작한다고 보면 된다.

Java 에서 입출력을 수행하기 위해 Stream 을 사용한다.

## Stream 특징

Stream 은 Byte 단위로 Data 를 전송하여, 입출력 대상에 따라 각기 다른 Stream 을 사용한다.

## Stream 종류

### File 사용
FileInputStream
FileOutputStream

### Memory 사용
ByteArrayInputStream
ByteArrayOutputStream

### Process 사용
PipedInputStream
PipedOutputStream


그 외 다수 ...

---

### 참고사항

Network Programming 에서 사용되는 정수는 32bit 의 **Big-Endian** 형식이다. (CPU 마다 다름)

공식문서를 읽는법 -> 일단 코드 실행시켜보고 그 다음에 긴 내용을 다시 봐보자

CPU 는 자료형이 어떻든, 정수형은 int, 실수형은 double 으로 계산한다.

그래서 float 같이 바이트 수가 적다고 CPU 처리 속도에 대해 유리한게아니라 패딩이 되어 들어가기때문에 CPU 측면에서는 큰 의미는 없다. 

---

## 네트워크에서의 Stream

위에서 언급한 File, Memory, Process 가 PC로 바뀐 것 뿐이다.

또한 이 Stream 을 연결해주는 역할을 Socket 이 수행한다.

---

## Java - InputStream

