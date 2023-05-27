# 개발자 인터뷰 사전 과제
## 싱품 교환 서비스 💻

SHARETREATS는 고객으로 부터 상품 코드를 받고 해당하는 상품을 고객에게 교환해 주려 합니다.
방식은 Console로만 이용해서 입출력을 받을 수 있습니다. 

## 프로젝트 기능 및 설계 ⚒️
###  Product
- 따로 회원가입이나 로그인의 기능은 없습니다.

- 개발자(관리자)는 HELP(명령어 모음)에 없는 상품 코드를 생산할 수 있습니다. (PRODUCT CREATE_PRODUCT)<br>
1 - 이 명령어는 개발자가 20개의 상품코드를 생산합니다.<br>
2 - 생성된 20개의 상품코드 중 무작위로 10개를 가져와 tradeProduct에 저장합니다.

- 시용자는 현재 올라와 있는 상품코드 10개(tradeProduct)와 현재 교환 여부의 List를 조회할 수 있습니다.<br>
1 - 요구사항에는 전체 상품코드를 조회할 수 있는 기능이 없어, 따로 추가하였습니다.(조회할 때 상점코드도 같이 볼 수 있습니다.)
2 - true 상태일 경우에는 현재 교환할 수 있는 상태이며, false일 경우 이미 교환을 완료한 상태입니다.

- 사용자는 CHECK, HELP, CLAIM 명령어를 통해 각각 명령어에 맞는 기능을 수행할 수 있습니다.<br><br>
**1 - CHECK 상품코드** -> 해당 상품이 교환이 가능한지 알 수 있습니다.<br>
(기능추가) 만약, 해당 상품코드가 현재 List에 없는 경우 해당 상품은 존재하지 않는다는 응답을 받을 수 있습니다.<br>
(기능추가) 추가적으로 List에는 있으나, false(이미 교환완료)인 상품은 이미 교환을 했다는 응답을 받을 수 있습니다.<br><br>
**2 - HELP** -> 사용자가 사용할 명령어들이 사용법과 해당 명령어의 설명을 응답합니다.<br><br>
**3 - CLAIM 상점코드 상품코드** -> 해당 상점코드의 상품코드를 입력해 상품을 교환합니다.<br>
(기능추가) 만약, 상점코드가 입력값과 다를 경우, 상점코드가 같지 않다는 응답을 받을 수 있습니다.<br>
(기능추가) 입력한 해당 상품코드가 존재하지 않을 경우, 상품이 존재하지 않다는 응답을 받을 수 있습니다.<br>
(기능추가) 입력한 상품코드가 이미 교환한 상품일 경우, 이미 교환을 했다는 응답을 받을 수 있습니다.<br><br>
**4 - (기능추가) USER GET_LIST** -> 사용자가 무엇을 교환했고, 사용자가 교환한 상품들을 조회할 수 있어야 된다 생각하여 추가했습니다. 
응답값으로 해당 상품의 상점코드와 상품코드를 LIST 형식으로 볼 수 있습니다.

## Project Architecture 🔭

![image](https://github.com/yeb0/product/assets/119172260/2c9c4aa6-ae3c-452c-bb97-8c229d6f87a3)


## Stack 📐
- Java 11
