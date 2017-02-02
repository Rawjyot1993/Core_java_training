package shopping.domain;
import shopping.utils.DBConnection;
/**
 * Created by rawjyot on 1/25/17.
 */
public class User {

    private int id;
    private String userName;
    private String firstName;
    private String lastName;
    private String localAddress;
    private String OfficeAddress;






    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocalAddress() {
        return localAddress;
    }

    public void setLocalAddress(String localAddress) {
        this.localAddress = localAddress;
    }

    public String getOfficeAddress() {
        return OfficeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        OfficeAddress = officeAddress;
    }
}
