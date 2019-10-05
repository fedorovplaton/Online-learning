package _2_BasicSyntax.PrintTextPerRole;

public class PrintTextPerRole {
    public static void main(String[] args) {
        String [] roles= {
                "Gorodnichij","Ammos Fedorovich",
                "Artemij Filippovich",
                "Luka Lukich"};
        String [] textLines={"Gorodnichij: Ja priglasil vas, gospoda, s tem, chtoby soobshhit' vam preneprijatnoe izvestie: k nam edet revizor.",
                "Ammos Fedorovich: Kak revizor?",
                "Artemij Filippovich: Kak revizor?",
                "Gorodnichij: Revizor iz Peterburga, inkognito. I eshhe s sekretnym predpisan'em.",
                "Ammos Fedorovich: Vot te na!",
                "Artemij Filippovich: Vot ne bylo zaboty, tak podaj!",
                "Luka Lukich: Gospodi bozhe! eshhe i s sekretnym predpisan'em!"};
        System.out.println(printTextPerRole(roles, textLines));
    }

    public static String printTextPerRole(String[] roles, String[] textLines) {
        int count = 1;
        StringBuilder[] texts = new StringBuilder[roles.length];
        for(int i = 0; i < texts.length; i++){
            texts[i]= new StringBuilder("");
        }

        for(int i = 0; i < textLines.length; i++){

            String[] nameText = textLines[i].split(":", 2);
            //int j = getRoleNameIndexByLine(roles, textLines[i]);
            int j = 0;
            while(!roles[j].equals(nameText[0])){
                j++;
            }

            /*
            int k = 0;
            while(textLines[i].charAt(k) != ':'){
                k++;
            }*/

            texts[j].append("" + count++ + ")" + nameText[1] + "\n");
        }

        StringBuilder ans = new StringBuilder("");
        for(int i = 0; i < texts.length; i++){
            ans.append(roles[i] + ':' + '\n' + texts[i] + '\n');
            //if(i != roles.length - 1) ans += '\n';
        }

        return ans.toString();
    }


    public static int getRoleNameIndexByLine(String[]roles, String line){
        int i = 0;
        while(line.charAt(i) != ':'){
            i++;
        }
        String roleName = line.substring(0, i);
        return getIndex(roles, roleName);
    }

    public static int getIndex(String[] roles, String roleName){
        for(int ansIndex = 0; ansIndex < roles.length; ansIndex++){
            if(roleName.equals(roles[ansIndex])) return ansIndex;
        }
        return -1;
    }
}
