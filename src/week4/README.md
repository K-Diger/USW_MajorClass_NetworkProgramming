# Stop and Wait

요즘 같이 회선 사양이 좋아진 상황에서는 효율이 너무 떨어짐

# 대안 1. Pipelining

## Pipelining

확인 응답 (ACK) 를 기다리지 않고 여러 Packet을 전송하도록 허용한다.

## Pipelining - 오류 회복

GBN (Go-Back-N) == Sliding Window Protocol

SR (Selective-Repeat)

## 연결지향형 프로토콜의 특이점

실제로는 회선 연결이 되어있는게 아님, 상호 통신간에 무순서로 도착하는 패킷에, 순서를 부여하고 따르겠다는 의미

## GBN 단점

패킷을 0 ~ 9번까지 보내는 중, 5번 패킷만 ACK 가 오지 않았다고 한다.

그러면 5번 패킷부터 시작해서 9번까지 전부 다시 보내줘야한다.

--> 네트워크 부하 발생

GBN 단점을 보완한게 SR이다. 요청자가 못 받은 패킷만 다시 보내줌

## 오버로딩은 반환형을 신경쓰지 않는다.

즉, 매개변수 갯수, 자료형을 다른 것만 오버로딩이고

반환형 다르고 같은 매개변수 갯수 + 자료형을 가진 것은 오버로딩이 아니다.