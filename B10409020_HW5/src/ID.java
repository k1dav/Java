
/**
 *
 * @author k1dav
 */
public class ID {

    private String ID;
    private String Region;
    private String Gender;

    final private String Alp = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
    final private String[] Area = {"�x�_��", "�x����", "�򶩥�", "�x�n��", "������",
        "�x�_��", "�y����", "��鿤", "�s�˿�", "�]�߿�", "�x����", "�n�뿤",
        "���ƿ�", "���L��", "�Ÿq��", "�x�n��", "������", "�̪F��", "�Ὤ��",
        "�x�F��", "���", "�����s", "������", "�s����", "�Ÿq��", "�s�˥�"};

    public int check(String id, int mode) {
        this.ID = id;
        char[] ids = id.toCharArray();
        int sum = 0;

        if (ids[1] == '1') {
            this.Gender = "�k��";
        } else {
            this.Gender = "�k��";
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
                System.out.println("�O��s�����ҳ��ǩ�der�B�ͩO�I");
                return 0;
            }
            System.out.println("�����ҥ��T");
            System.out.printf("�O��X�ͦb%s��%s�B�ͩO�I\n", this.getRegion(), this.getGender());
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
            System.out.println("�O��s�O�W�����������D���B�ͩO�I");
            return;
        }

        if (gender.equals("�k")) {
            newNumber.append("1");
        } else if (gender.equals("�k")) {
            newNumber.append("2");
        } else {
            System.out.println("�O��s�H���ʧO�������D���B�ͩO�I");
            return;
        }

        for (int i = 1; i <= 7; i++) {
            int num = (int) (Math.random() * 10);
            newNumber.append(num);
        }

        newNumber.append(this.check(newNumber.toString(), 1));
        this.ID = newNumber.toString();
        System.out.println("���ͪ������Ҧr�����G" + this.ID);
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
