public class TextByRole {
    public static void main(String[] args) {
        String[] roles = new String[]{"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"};
        String[] textLines = new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам " +
                "пренеприятное известие: к нам едет ревизор.", "Аммос Федорович: Как ревизор?", "Артемий Филиппович: " +
                "Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: " +
                "Господи боже! еще и с секретным предписаньем!"};
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
