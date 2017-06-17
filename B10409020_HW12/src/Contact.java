import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact implements Comparable<Contact> {
    private String name;   // �m�W
    private Date birthday; // �X�ͤ��
    private String phone;  // �q�ܸ��X
    private String email;  // �q�l�l��
    
    /**
     * Constructor
     * @param String name
     * @param Date birthday
     * @param String phone
     * @param String email
     */
    public Contact(String name, Date birthday, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    /**
     * ���o�m�W
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * ���o�X�ͤ��
     * @return Date
     */
    public Date getBirthday() {
        return birthday;
    }
    
    public String getBirth(){
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");         
         return sdf.format(birthday);
    }
    
    /**
     * ���o�q�ܸ��X
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * ���o�q�l�l��
     * @return String
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "\t" + this.getBirth() + "\t" + phone + "\t" + email ;
    }
    
    

    /**
     * ��@ Comparable ���� compareTo ��k
     */
    public int compareTo(Contact other) {
        return (this.birthday.compareTo(other.birthday));
    }

}
