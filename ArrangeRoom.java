import java.util.*;

public class ArrangeRoom {
    public static void main(String[] args){
        //test();
        arrangeRoom();
    }

    private static void test(){
        List<Integer> list1 = Arrays.asList(6,7,8,9,10,11,12,13,14,15);
        List<Integer> list2 = Arrays.asList(7,8);
        List<Integer> list3 = Arrays.asList(3,7,8);
        List<Integer> list4 = Arrays.asList(3);

        //System.out.println(list1.retainAll(list2) + " " + list1.retainAll(list3) + " "
        //    + list1.retainAll(list4));
        if (list1.retainAll(list2)){
            System.out.println("Huy");

        }
        //System.out.println("" + list1.retainAll(list2));

    }

    private static void arrangeRoom(){
        //int[] rooms = {4, 4, 3, 3, 3};
        Room[] rooms = initRoom();
        int index = 0;
        List<Member> members1 = initMember1();
        for (int i = 0; i < members1.size(); i++)
            rooms[i].addMember(members1.get(i));

        List<Member> members2 = initMember2();
        Random random = new Random(5);
        Collections.shuffle(members2, random);

        for (Member member : members2){
            addToRoom(member, rooms, index);
            index = 0;
        }

        for (Room room : rooms)
            System.out.println(room);
    }

    private static void addToRoom(Member newMember, Room[] rooms, int index){
        if (rooms[index].isFull()){
            int newIndex = index + 1;
            addToRoom(newMember, rooms, newIndex);
        }else {
            if (rooms[index].isEmpty())
                rooms[index].addMember(newMember);
            else {
                if (rooms[index].isConflict(newMember)){
                    int newIndex = index + 1;
                    addToRoom(newMember, rooms, newIndex);
                }else {
                    rooms[index].addMember(newMember);
                }
            }
        }
    }

    private static Room[] initRoom(){
        return new Room[]{new Room(3), new Room(3),
                new Room(4)};
        /*
        return new Room[]{new Room(3), new Room(3),
                new Room(3), new Room(4), new Room(4)};
        */
    }

    private static List<Room> initRoom2(){
        return Arrays.asList(new Room(4), new Room(4),
                new Room(3), new Room(3), new Room(3));

    }

    private static List<Member> initMember1(){
        List<Member> members = new ArrayList<>();

        Member oyama = new Member("小山義人");
        oyama.setTypes(Arrays.asList(6,7,8,9,10,11,12,13,14,15));
        members.add(oyama);
        /*
        Member sasaki = new Member("佐々木誠");
        sasaki.setTypes(Arrays.asList(1,3,4,5,6,8,9,10));
        members.add(sasaki);

        Member musida = new Member("武田吉晃");
        musida.setTypes(Arrays.asList(7,13));
        members.add(musida);
        */
        Member arai = new Member("新井健");
        arai.setTypes(Arrays.asList(6,7,11,12));
        members.add(arai);

        Member shin = new Member("辛承鋼");
        shin.setTypes(Arrays.asList(3,9));
        members.add(shin);

        return members;
    }

    private static List<Member> initMember2() {
        List<Member> members = new ArrayList<>();

        Member oi = new Member("大井達也");
        oi.setTypes(Arrays.asList(14, 15));
        members.add(oi);

        Member toya = new Member("戸谷洋介");
        toya.setTypes(Arrays.asList(11));
        members.add(toya);

        Member takizawa = new Member("瀧澤良爾");
        takizawa.setTypes(Arrays.asList(14));
        members.add(takizawa);

        Member kawabe = new Member("川邉博");
        kawabe.setTypes(Arrays.asList(13));
        members.add(kawabe);
        /*
        Member ishikawa = new Member("石川貴之");
        ishikawa.setTypes(Arrays.asList(5,8));
        members.add(ishikawa);

        Member noduki = new Member("野月祐治");
        noduki.setTypes(Arrays.asList(12));
        members.add(noduki);

        Member tanaka = new Member("田中悠太");
        tanaka.setTypes(Arrays.asList(15));
        members.add(tanaka);

        Member kazama = new Member("風間健");
        kazama.setTypes(Arrays.asList(3));
        members.add(kazama);

        Member momoi = new Member("桃井雅俊");
        momoi.setTypes(Arrays.asList(10));
        members.add(momoi);
        */

        Member nagayoshi = new Member("永吉徹");
        nagayoshi.setTypes(Arrays.asList(2));
        members.add(nagayoshi);

        Member yoshinaga = new Member("吉永安寿");
        yoshinaga.setTypes(Arrays.asList(2));
        members.add(yoshinaga);

        Member hieu = new Member("DANGQUANGHIEU");
        hieu.setTypes(Arrays.asList(5));
        members.add(hieu);

        return members;
    }
}
