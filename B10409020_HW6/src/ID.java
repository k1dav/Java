
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author k1dav
 */
public class ID {

    private String ID;
    private String Region;
    private String Gender;
    private int errorCode;  //  1格式錯誤  2身份證錯誤

    final private String Alp = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    final private String[] Area = {"台北市", "台中市", "基隆市", "台南市", "高雄市",
        "台北縣", "宜蘭縣", "桃園縣", "新竹縣", "苗栗縣", "台中縣", "南投縣",
        "彰化縣", "雲林縣", "嘉義縣", "台南縣", "高雄縣", "屏東縣", "花蓮縣",
        "台東縣", "澎湖縣", "陽明山", "金門縣", "連江縣", "嘉義市", "新竹市"};

    ID(String id) {
        this.ID = id;
        check();
    }

    public void check() {
        char[] ids = this.ID.toCharArray();
        int sum = 0;

        String patternStr = "^[a-zA-Z][1|2][0-9]{8}$";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(this.ID);
        if (!matcher.find()) {
            this.errorCode = 1;
            return;
        }

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

        if (sum % 10 != 0) {
            this.errorCode = 2;
            return;
        }
        this.errorCode = 0;
        return;
    }

    public String getRegion() {
        return this.Region;
    }

    public String getGender() {
        return this.Gender;
    }

    public String getID() {
        return this.ID;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

}
