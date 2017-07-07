/**
 * Created by yashi on 07-07-2017.
 */
public class Employee {

   private int id;
    private String fname;
    private String lname;
    private String location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Id: "+id+" FirstName: "+fname+" LastName: "+lname+" Location: "+location;
    }
}
