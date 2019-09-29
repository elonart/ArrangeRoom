import java.util.ArrayList;
import java.util.List;

public class Room {
    private final int bedNum;
    private List<Member> membersInRoom;

    Room(int bedNum){
        this.bedNum = bedNum;
        membersInRoom = new ArrayList<>();
    }

    int getBedNum(){
        return bedNum;
    }

    void addMember(Member member){
        membersInRoom.add(member);
    }

    List<Member> getMembersInRoom(){
        return membersInRoom;
    }

    boolean isEmpty(){
        return membersInRoom.size() == 0;
    }

    boolean isFull(){
        return membersInRoom.size() == bedNum;
    }

    boolean isConflict(Member newMember){
        for (Member member : membersInRoom){
            //if (member.getTypes().containsAll(newMember.getTypes()))
            if (member.isConflict(newMember))
                return true;
        }

        return false;
    }

    @Override
    public String toString(){
        String ret = "[";
        for (int i = 0; i < bedNum; i++){
            if(i == bedNum - 1)
                ret += membersInRoom.get(i).getName();
            else
                ret += membersInRoom.get(i).getName() + ", ";
        }

        return ret + "]";
    }
}
