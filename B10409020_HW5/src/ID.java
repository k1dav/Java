
/**
 *
 * @author k1dav
 */
public class ID {

    private String ID;
    private String Region;
    private String Gender;

    final private String Alp = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    final private String[] Area = {"台北市", "台中市", "基隆市", "台南市", "高雄市",
        "台北縣", "宜蘭縣", "桃園縣", "新竹縣", "苗栗縣", "台中縣", "南投縣",
        "彰化縣", "雲林縣", "嘉義縣", "台南縣", "高雄縣", "屏東縣", "花蓮縣",
        "台東縣", "澎湖縣", "陽明山", "金門縣", "連江縣", "嘉義市", "新竹市"};

    public int check(String id, int mode) {
        this.ID = id;
        char[] ids = id.toCharArray();
        int sum = 0;

        if (ids[1] == '1') {
            this.Gender = "男性";
        } else {
            this.Gender = "女性";
        }

        for (int i = 0; i < ids.length; i++) {
            if (i == 0) {
                this.Region = this.Area[this.Alp.indexOf(Character.toUpperCase(ids[i]))];
                int toNum = this.Alp.indexOf(Character.toUpperCase(ids[i])) + 10;
                sum = sum + toNum % 10 * 9 + (toNum - toNum % 10) / 10;
            } else {
                if (i != ids.length - 1) {
                    sum = sum + Character.getNumericValue(ids[i]) * (9 - i);
                } else {
                    sum = sum + Character.getNumericValue(ids[i]);
                }
            }
        }

        if (mode == 0) {
            if (sum % 10 != 0) {
                System.out.println("是位連身份證都怪怪der朋友呢！");
                return 0;
            }
            System.out.println("身份證正確");
            System.out.printf("是位出生在%s的%s朋友呢！\n", this.getRegion(), this.getGender());
            return 1;
        } else {
            if (sum % 10 == 0) {
                return 0;
            } else {
                return 10 - (sum % 10);
            }
        }

    }

    public String getRegion() {
        return this.Region;
    }

    public String getGender() {
        return this.Gender;
    }

    public void generate(String gender, String region) {
        StringBuffer newNumber = new StringBuffer();
        int zip = this.generateRegion(region);
        if (zip != -1) {
            newNumber.append(this.Alp.charAt(zip));
        } else {
            System.out.println("是位連臺灣縣市都不知道的朋友呢！");
            return;
        }

        if (gender.equals("男")) {
            newNumber.append("1");
        } else if (gender.equals("女")) {
            newNumber.append("2");
        } else {
            System.out.println("是位連人類性別都不知道的朋友呢！");
            return;
        }

        for (int i = 1; i <= 7; i++) {
            int num = (int) (Math.random() * 10);
            newNumber.append(num);
        }

        newNumber.append(this.check(newNumber.toString(), 1));
        this.ID = newNumber.toString();
        System.out.println("產生的身份證字號為：" + this.ID);
        this.check(this.ID, 0);
    }

    public int generateRegion(String region) {
        for (int i = 0; i < this.Area.length; i++) {
            if (this.Area[i].equals(region)) {
                return i;
            }
        }
        return -1;
    }
}
