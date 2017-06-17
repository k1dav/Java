
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

    private Map<String, Contact> contacts = new TreeMap<String, Contact>(); // 聯絡人列表
    private static Scanner scanner = new Scanner(System.in);

    /**
     * 程式進入點
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        String input;
        do {
            showMenu(); // 顯示選單
            input = scanner.next();
            System.out.println();

            switch (input) {
                case "1": // 新增聯絡人
                    addressBook.addContact();
                    break;
                case "2": // 顯示聯絡人列表
                    addressBook.showContacts();
                    break;
                case "3": // 編輯聯絡人 
                    addressBook.editContact();
                    break;
                case "4": // 刪除聯絡人 
                    addressBook.deleteContact();
                    break;
                case "5": // 匯入聯絡人
                    try {
                        addressBook.importContacts();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "6": // 匯出聯絡人
                    try {
                        addressBook.exportContacts();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "7": // 清除聯絡人列表
                    addressBook.clearList();
                    break;
            }

            System.out.println();
        } while (!input.equals("0"));
    }

    /**
     * 顯示選單
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
     * 新增聯絡人
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

        // 驗證輸入格式
        if (isValidFormat(name, birthdayString, phone, email)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
            Date birthday = null; // 宣告Date物件
            try {
                birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                contacts.put(name, new Contact(name, birthday, phone, email)); // 加入聯絡人
                System.out.println("The contact has been Edited.");
//                Collections.sort(contacts); // 排序(按出生日期)
            } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                e.printStackTrace(); // 顯示堆疊追蹤
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
                Date birthday = null; // 宣告Date物件
                try {
                    birthday = sdf.parse(birthdayString); // 解析日期字串並產生Date物件
                    contacts.remove(name); // 加入聯絡人
                    contacts.put(name, new Contact(name, birthday, phone, email));
                    System.out.println("The contact has been added.");
//                Collections.sort(contacts); // 排序(按出生日期)
                } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                    e.printStackTrace(); // 顯示堆疊追蹤
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // 格式化日期
                Date birthday = null; // 宣告Date物件
                try {
                    birthday = sdf.parse(div[1]); // 解析日期字串並產生Date物件
                    contacts.put(div[0], new Contact(div[0], birthday, div[2], div[3])); // 加入聯絡人
                } catch (ParseException e) { // 若字串不符日期格式則拋出ParseException之例外
                    e.printStackTrace(); // 顯示堆疊追蹤
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
     * 顯示聯絡人列表
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
     * 清除聯絡人列表
     */
    public void clearList() {
        contacts.clear(); // 移除ArrayList中的所有元素
        System.out.println("The contact list is empty.");
    }

    /**
     * 驗證輸入格式
     *
     * @param String name
     * @param String birthday
     * @param String phone
     * @param String email
     * @return boolean
     */
    public static boolean isValidFormat(String name, String birthday, String phone, String email) {
        boolean isValidFormat = true;

        // 驗證姓名格式
        if (!name.matches("^[a-zA-Z]+$")) {
            System.out.println("Invalid name format!");
            isValidFormat = false;
        }

        // 驗證電話號碼格式
        if (!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$")) {
            System.out.println("Invalid phone format!");
            isValidFormat = false;
        }

        // 驗證電子郵件格式
        if (!email.matches("^[_a-z0-9-]+([.][_a-z0-9-]+)*@[a-z0-9-]+([.][a-z0-9-]+)*$")) {
            System.out.println("Invalid email format!");
            isValidFormat = false;
        }

        // 驗證出生日期格式
        if (!birthday.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$")) {
            System.out.println("Invalid date format!");
            isValidFormat = false;
        }

        return isValidFormat;
    }

}
