public class TextByRole {
    public static void main(String[] args) {
        String[] roles = new String[]{"����������", "����� ���������", "������� ����������", "���� �����"};
        String[] textLines = new String[]{"����������: � ��������� ���, �������, � ���, ����� �������� ��� " +
                "������������� ��������: � ��� ���� �������.", "����� ���������: ��� �������?", "������� ����������: " +
                "��� �������?", "����������: ������� �� ����������, ���������. � ��� � ��������� ������������.",
                "����� ���������: ��� �� ��!", "������� ����������: ��� �� ���� ������, ��� �����!", "���� �����: " +
                "������� ����! ��� � � ��������� ������������!"};
        System.out.println(printTextPerRole(roles, textLines));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sr = new StringBuilder();

        for (int i = 0; i < roles.length; ++i) {
            sr.append("\n").append(roles[i]).append(":").append("\n");
            for (int j = 0; j < textLines.length; ++j) {
                if (textLines[j].startsWith(roles[i] + ":")) {
                    String text1 = textLines[j].replaceFirst(roles[i] + ":", j + 1 + ")");
                    sr.append(text1).append("\n");
                }
            }
        }
        return sr.toString();
    }
}
