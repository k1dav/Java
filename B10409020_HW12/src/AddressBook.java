
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AddressBook {

    private Map<String, Contact> contacts = new TreeMap<String, Contact>(); // �p���H�C��
    private static Scanner scanner = new Scanner(System.in);

    /**
     * �{���i�J�I
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        String input;
        do {
            showMenu(); // ��ܿ��
            input = scanner.next();
            System.out.println();

            switch (input) {
                case "1": // �s�W�p���H
                    addressBook.addContact();
                    break;
                case "2": // ����p���H�C��
                    addressBook.showContacts();
                    break;
                case "3": // �s���p���H 
                    addressBook.editContact();
                    break;
                case "4": // �R���p���H 
                    addressBook.deleteContact();
                    break;
                case "5": // �פJ�p���H
                    try {
                        addressBook.importContacts();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "6": // �ץX�p���H
                    try {
                        addressBook.exportContacts();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "7": // �M���p���H�C��
                    addressBook.clearList();
                    break;
            }

            System.out.println();
        } while (!input.equals("0"));
    }

    /**
     * ��ܿ��
     */
    public static void showMenu() {
        System.out.println("***** Address Book *****");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contacts");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("************************");
        System.out.print("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }

    /**
     * �s�W�p���H
     */
    public void addContact() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Phone: ");
        String phone = scanner.next();
        System.out.print("E-mail: ");
        String email = scanner.next();
        System.out.print("Birthday(yyyy/MM/dd): ");
        String birthdayString = scanner.next();

        // ���ҿ�J�榡
        if (isValidFormat(name, birthdayString, phone, email)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // �榡�Ƥ��
            Date birthday = null; // �ŧiDate����
            try {
                birthday = sdf.parse(birthdayString); // �ѪR����r��ò���Date����
                contacts.put(name, new Contact(name, birthday, phone, email)); // �[�J�p���H
                System.out.println("The contact has been Edited.");
//                Collections.sort(contacts); // �Ƨ�(���X�ͤ��)
            } catch (ParseException e) { // �Y�r�ꤣ�Ť���榡�h�ߥXParseException���ҥ~
                e.printStackTrace(); // ��ܰ��|�l��
            }
        }
    }

    public void editContact() {
        System.out.println("Please enter the name of contact that you want to edit.");
        System.out.print("Name:");
        String name = scanner.next();

        Contact contact = contacts.get(name);

        if (contact != null) {
            System.out.print("Phone: ");
            String phone = scanner.next();
            System.out.print("E-mail: ");
            String email = scanner.next();
            System.out.print("Birthday(yyyy/MM/dd): ");
            String birthdayString = scanner.next();
            if (isValidFormat(name, birthdayString, phone, email)) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // �榡�Ƥ��
                Date birthday = null; // �ŧiDate����
                try {
                    birthday = sdf.parse(birthdayString); // �ѪR����r��ò���Date����
                    contacts.remove(name); // �[�J�p���H
                    contacts.put(name, new Contact(name, birthday, phone, email));
                    System.out.println("The contact has been added.");
//                Collections.sort(contacts); // �Ƨ�(���X�ͤ��)
                } catch (ParseException e) { // �Y�r�ꤣ�Ť���榡�h�ߥXParseException���ҥ~
                    e.printStackTrace(); // ��ܰ��|�l��
                }
            }

        } else {
            System.out.println("Not found!");
            return;
        }

    }

    public void deleteContact() {
        System.out.println("Please enter the name of contact that you want to delete.");
        System.out.print("Name:");
        String name = scanner.next();

        Contact contact = contacts.get(name);

        if (contact != null) {
            System.out.print("Phone: ");
            contacts.remove(name);
        } else {
            System.out.println("Not found!");
            return;
        }
        System.out.println("The contact has been deleted.");

    }

    public void importContacts() throws IOException {
        FileReader fr = new FileReader("data.txt");
        BufferedReader br = new BufferedReader(fr);
        while (br.ready()) {
            String line = br.readLine();
            String div[] = line.split("\t");
            if (isValidFormat(div[0], div[1], div[2], div[3])) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // �榡�Ƥ��
                Date birthday = null; // �ŧiDate����
                try {
                    birthday = sdf.parse(div[1]); // �ѪR����r��ò���Date����
                    contacts.put(div[0], new Contact(div[0], birthday, div[2], div[3])); // �[�J�p���H
                } catch (ParseException e) { // �Y�r�ꤣ�Ť���榡�h�ߥXParseException���ҥ~
                    e.printStackTrace(); // ��ܰ��|�l��
                }
            }
        }

        System.out.println("The contact has been imported.");
        br.close();
        fr.close();
    }

    public void exportContacts() throws IOException {
        FileWriter fw = new FileWriter("contacts.txt");
        for (Iterator<String> iter = contacts.keySet().iterator(); iter.hasNext();) {
            String key = iter.next();
            fw.write(key + contacts.get(key) + "\r\n");
        }
        System.out.println("The contact list has been exported.");
        fw.close();
    }

    /**
     * ����p���H�C��
     */
    public void showContacts() {
        System.out.println("Name\tBirthday\tPhone\t\tE-mail");
        System.out.println("--------------------------------------------------");
        for (Iterator<String> iter = contacts.keySet().iterator(); iter.hasNext();) {
            String key = iter.next();
            System.out.println(key + contacts.get(key));
        }
    }

    /**
     * �M���p���H�C��
     */
    public void clearList() {
        contacts.clear(); // ����ArrayList�����Ҧ�����
        System.out.println("The contact list is empty.");
    }

    /**
     * ���ҿ�J�榡
     *
     * @param String name
     * @param String birthday
     * @param String phone
     * @param String email
     * @return boolean
     */
    public static boolean isValidFormat(String name, String birthday, String phone, String email) {
        boolean isValidFormat = true;

        // ���ҩm�W�榡
        if (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid name format!");
            isValidFormat = false;
        }

        // ���ҹq�ܸ��X�榡
        if (!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$")) {
            System.out.println("Invalid phone format!");
            isValidFormat = false;
        }

        // ���ҹq�l�l��榡
        if (!email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
            System.out.println("Invalid email format!");
            isValidFormat = false;
        }

        // ���ҥX�ͤ���榡
        if (!birthday.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$")) {
            System.out.println("Invalid date format!");
            isValidFormat = false;
        }

        return isValidFormat;
    }

}
