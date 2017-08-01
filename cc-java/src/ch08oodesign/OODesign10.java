package ch08oodesign; /**
 * 8.10 Chain(즉, 연결 리스트)을 사용해 충돌을 해결하는 해시 테이블 설계하고 구현하라.
 * --> (코드리뷰: 완료 / 한글 설명 리뷰: TBD / 영문 설명 리뷰: TBD)
 * --> 요약: jim & bob 이 동일한 hashing value 를 가질 경우 Key가 없으면 찾기 어려우므로, Cell<K, V> 타입의 연결리스트 사용 
 *          가장 널리 사용된느 방법은 Binary Search Tree를 사용하여 검색시간 O(1)을 이용하는 것이다.
 * --> 체크: BST 검색 시간 O(1) ? 
 * 
 * (6E)
 * 7.12 Hash Table: Design and implement a hash table which uses chaining (linked lists) to handle collisions.
 *                  Hints: #287, #307
 */

import java.util.LinkedList;

/**
 * 다른 키 값이 해싱펑션에 의해 동일한 해시값, 즉, 배열의 동일한 인덱스 값이 나올 경우 collision handle 이 필요하다.
 * <-- 해싱 펑션을 잘 설계하는 것이 중요하지만, 중복 발생 가능성은 항상 존재하고, 배열길이를 무한정 늘릴수 없으므로...
 * 
 * (1) Hash Table의 데이터 저장 Bucket --> Array, ArrayList 사용
 *      - ArrayList 는 ensureCapacity() 를 이용하여 초기 공간 확보 가능 --> 그러나 초기화는 필요 ???
 * 
 * 데이터 입력을 위해 해싱키 생성 필요
 * 
 * (2) 해싱코드(즉, Bucket의 index값) 생성방법(stupid~~)
 *      1) 키의 스트링 길이와 배열의 인덱스로 해싱
 *      2) 키 객체의 자바 내장 hashCode()와 배열의 인덱스로 해싱후 Math.abs()
 * 
 * (3) 데이터 put: Bucket index 를 검색하여 해당 LinkedList Head 에서 삽입/삭제 연산
 * (4) 데이터 get: 특별 로직 없음. Bucket 검색 --> LinkedList 검색
 * (5) 데이터 remove: Head 에서 삭제 발생시 Head Node인 경우 Bucket의 Reference 도 업데이트 필요
 * 
 * (6) 해시 테이블 출력: 랜덤한 해시값으로 인해 Array/ArrayList의 빈 버킷이 있을수 있으므로 고려해서 출력 필요
 * 
 * (7)LinkedList의 사용
 *      1) Java 내장 LinkedList 사용시 K-V 저장용 Cell 정의 필요 --> put() 연산시 간단연산을 위해 삭제하는 로직도 좋음
 *      2) 새 클래스 정의 --> 양방향 LinkedListNode 정의 --> 로직이 더 명확하고 간단해 질수도 있음 --> 그러나 기능의 제약은 존재
 */

public class OODesign10 {
    //--------------------------------------------------------------------------------
    // A. Custom LinkedListNode<K, V> 사용할 경우 (6E 소스 코드 기준)
    /*
    class Hasher<K, V> {
        private class LinkedListNode<K, V> {
            public K key;
            public V value;
            public LinkedListNode<K, V> prev;
            public LinkedListNode<K, V> next;

            public LinkedListNode(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public String printForward() {
                String node = "(" + key + ", " + value + ")";
                if (next != null) {
                    return node + "->" + next.printForward();
                } else {
                    return node;
                }
            }
        }

        // Bucket
        private ArrayList<LinkedList<K, V>> array;

        public Hasher(int capacity) {
            array = new ArrayList<LinkedList<K, V>>();
            array.ensureCapacity(capacity);

            for (int i = 0; i < capacity; i++) {
                array.add(null);
            }
        }

        //
        private int getIndexForKey(K key) {
            int index = Math.abs(key.hashCode() % array.size());
            // int index = key.toString().length() % array.size();

            return index;
        }

        private LinkedListNode<K, V> getNodeForKey(K key) {
            int index = getIndexForKey(key);
            LinkedList<K, V> current = array.get(index);

            while (current != null) {
                if (current.key == key) {   // compare more~~
                    break;
                }
                current = current.next;
            }

            return null;
        }

        public V put(K key, V value) {
            LinkedList<K, V> node = getNodeForKey(key);
            if (node != null) {
                V data = node.value;
                node.value = value;
                return data;
            }

            node = new LinkedListNode<K, V>(key, value);
            int index = getIndexForKey(key);
            LinkedListNode<K, V> oldNode = array.get(index);
            if (oldNode != null) {
                node.next = oldNode;
                node.next.prev = node;
            }

            array.set(index, node);

            return null;    // value
        }

        public V get(K key) {
            LinkedListNode<K, V> node = getNodeForKey(key);
            return node != null ? node.value : node;
        }

        public V remove(K key) {
            LinkedListNode<K, V> node = getNodeForKey(key);
            if (node != null) {
                // previous
                if (node.prev != null) {
                    node.prev.next = node.next;
                } else {
                    int hashKey = getIndexForKey(key);
                    array.set(hashKey, node.next);
                }

                // next
                if (node.next != null) {
                    node.next.prev = node.prev;
                }

                return node.value;
            }

            return null;
        }

        public void printTable() {
            for (int i = 0; i < array.size(); i++) {
                String data = array.get(i) == null ? "" : array.get(i).printForward();
                System.out.println(i + " : " + data);
            }
        }
    }
    */


    //--------------------------------------------------------------------------------
    // B. Java Built-in LinkedList + Custom Cell<K, V> 사용할 경우 (한글 책 기준 - 구현 중)
    /*
    class Cell<K, V> {
        private K key;
        private V value;

        public Cell(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public boolean equivalent(K key) {
            return this.key.compareTo(key) == 0;
        }

        public V getValue() {
            return value;
        }
    }

    class Hash<K, V> {
        LinkedList<Cell<K, V>>[] items = new LinkedList<Cell<K, V>>[10];

        // 아주 무식한 해시함수이므로 jim, bob 이 키을 경우 동이한 해시값이 나오게 되어 collision 이 발생하게 된다.
        private int hashCodeOfKey(K key) {
            return key.toString().length() % items.length;
        }

        public void put(K key, V value) {
            int index = hashCodeOfKey(key);

            // first time
            if (items[index] == null) {
                items[index] = new LinkedList<Cell<K, V>>();
            }
            LinkedList<Cell<K, V>> list = items[index];

            // duplicate/exist --> remove
            for (Cell<K, V> c : list) {
                if (c.equivalent(key)) {
                    list.remove(c); // c.setValue(value);
                    break;
                }
            }

            list.add(new Cell(key, value));
        }

        public V get(K key) {
            int index = hashCodeOfKey(key);
            LinkedList<Cell<K, V>> list = items[index];

            for (Cell<K, V> c : list) {
                if (c.equivalent(key)) {
                    return c.getValue();
                }
            }

            return null;
        }
    }
    */
}