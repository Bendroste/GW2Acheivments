package Daily;

/**
 * Created by Ben Droste on 4/30/2017.
 */
public class DailyAcheivments {
    public String type;
    public int id;
    public String name;

    public DailyAcheivments(String type ,int id, String name) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "type='" + type + '\'' +
                ", id=" + id +
                ", name='" + name + '\'';
    }
}
