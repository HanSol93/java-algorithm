import java.util.Scanner;
import java.util.Comparator;
// 원형 이중 연결 리스트 클래스 DblLinkedList<E>의 사용 예 

class DblLinkedListTeater {
    static Scanner scnIn = new Scanner(System.in);

    // 데이터 (회원번호 + 이름)
    static class Data {
        // 번호를 입력 받습니까?
        static final int NO = 1;
        // 이름을 입력 받습니까? 
        static final int NAME = 2;

        // 회원번호
        private Integer no;
        // 이름
        private String name;

        // 문자열을 반환합니다.
        public String toString() {
            return "(" + no + ") " + name;
        }

        // 데이터를 입력합니다.
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = scnIn.nextInt();
            }

            if((sw & NAME) == NAME) {
                System.out.print("이름 : ");
                name = scnIn.next();
            }
        }

        // 회원 번호로 순서를 매기는 comparator
        public static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        // 이름으로 순서를 매기는 comparator
        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    enum Menu {
        ADD_FIRST(  "머리에 노드를 삽입"),
        ADD_LAST(   "꼬리에 노드를 삽입"),
        ADD(        "선택 노드의 바로 뒤에 삽입"),
        RMV_FIRST(  "머리 노드를 삭제"),
        RMV_LAST(   "꼬리 노드를 삭제"),
        RMV_CRNT(   "선택 노드를 삭제"),
        CLEAR(      "모든 노드를 삭제"),
        SEARCH_NO(  "번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT(       "선택 노드를 뒤쪽으로"),
        PREV(       "선택 노드를 앞쪽으로"),
        PRINT_CRNT( "선택 노드를 출력"),
        DUMP(       "모든 노드를 출력"),
        TERMINATE(  "종료");

        // 출력할 문자열
        private final String message;

        // 서수가 idx인 열거의 반환 
        static Menu MenuAt(int idx) {
            for(Menu m : Menu.values()) {
                if(m.ordinal() == idx) {
                    return m;
                }
            }
            return null;
        }

        // 생성자 
        Menu(String string) {
            message = string;
        }

        // 출력할 문자열 반환
        String getMessage() {
            return message;
        }
    }

    // 메뉴 선택
    static Menu SelectMenu() {
        int key;

        do {
            for(Menu m : Menu.values()) {
                System.out.printf("(%d) %s ", m.ordinal(), m.getMessage());
                if((m.ordinal() % 3) == 2 && m.ordinal() !=  Menu.TERMINATE.ordinal()) {
                    System.out.println();
                }
            }
            System.out.print(" : ");
            key = scnIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu; // 메뉴
        Data data; // 추가용 데이터 참조 
        Data ptr; // 검색용 데이터 참조 
        Data temp = new Data(); // 입력용 데이터 

        DblLinkedList<Data> list = new DblLinkedList<Data>(); // 리스트를 생성 

        do {
            switch(menu = SelectMenu()) {
                // 머리에 노드 삽입 
                case ADD_FIRST : 
                    data = new Data();
                    data.scanData("머리에 삽입", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;
                
                // 꼬리에 노드 삽입
                case ADD_LAST :
                    data = new Data();
                    data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                    list.addFirst(data);
                    break;

                // 선택 노드의 바로 뒤에 노드를 삽입
                case ADD : 
                    data = new Data();
                    data.scanData("선택 노드의 바로 뒤에 삽입", Data.NO | Data.NAME);
                    break;

                // 머리 노드를 삭제 
                case RMV_FIRST : 
                    list.removeFirst();
                    break;

                // 꼬리 노드를 삭제
                case RMV_LAST :
                    list.removeLast();
                    break;

                // 선택 노드를 삭제
                case RMV_CRNT :
                    list.removeCurrentNode();
                    break;

                // 회원 번호로 검색
                case SEARCH_NO : 
                    temp.scanData("검색", Data.NO);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if(ptr == null) {
                        System.out.println("그 번호의 데이터가 없습니다.");
                    } else {
                        System.out.println("검색 성공" + ptr);
                    }
                    break;

                // 회원 번호로 검색
                case SEARCH_NAME : 
                    temp.scanData("검색", Data.NAME);
                    ptr = list.search(temp, Data.NAME_ORDER);
                    if(ptr == null) {
                        System.out.println("그 번호의 데이터가 없습니다.");
                    } else {
                        System.out.println("검색 성공" + ptr);
                    }
                    break;

                // 선택 노드를 뒤쪽으로 진행
                case NEXT : 
                    list.next();
                    break;

                // 선택 노드를 앞쪽으로 진행
                case PREV : 
                    list.prev();
                    break;

                // 선택 노드의 데이터를 출력
                case PRINT_CRNT : 
                    list.printCurrentNode();
                    break;

                // 모든 데이터를 리스트 순서로 출력 
                case DUMP : 
                    list.dump();
                    break;

                case CLEAR :
                    list.clear();
                    break;
            }
        } while(menu != Menu.TERMINATE);
    }
}