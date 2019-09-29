import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    List<Integer> types;

    Member(String name){
        this.name = name;
        types = new ArrayList<>();
    }

    String getName(){
        return name;
    }

    void setTypes(List<Integer> types){
        //this.types = new ArrayList<>(types);
        this.types = types;
    }

    List<Integer> getTypes(){
        return types;
    }

    boolean isConflict(Member newMember){
        for (int type : types){
            for (int aType : newMember.getTypes())
                if (type == aType)
                    return true;
        }

        return false;
    }
}
