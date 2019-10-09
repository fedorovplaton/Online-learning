package OOP.SpamFilter;

import com.sun.security.auth.module.Krb5LoginModule;

public class Main {
    public static void main(String[] args) {

    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(int i = 0; i < analyzers.length; i++){
            Label answer = analyzers[i].processText(text);
            if(answer != Label.OK) return  answer;
        }
        return Label.OK;
    }

    public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer{
        private String[] keywords;

        public SpamAnalyzer(String[] keywords){
            this.keywords = keywords;
        }

        @Override
        public String[] getKeywords() {
            return this.keywords;
        }

        @Override
        public Label getLabel() {
            return Label.SPAM;
        }
    }

    public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer{

        //private String[] keywords = new String[] {"=(",":(",":|"};

        @Override
        public String[] getKeywords() {
            return new String[] {"=(",":(",":|"};
        }

        @Override
        public Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    public class TooLongTextAnalyzer implements TextAnalyzer{

        private int maxLength;
        public TooLongTextAnalyzer(int maxLength){
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if(text.length() <= maxLength)
                return Label.OK;
            else
                return Label.TOO_LONG;
        }

        public Label getLabel() {
            return Label.TOO_LONG;
        }
    }

    abstract class KeywordAnalyzer  implements TextAnalyzer{
        abstract protected String[] getKeywords();
        abstract protected Label getLabel();

        @Override
        public Label processText(String text){
            StringBuilder t = new StringBuilder(text);
            for(int i = 0; i < getKeywords().length; i++){
                if(t.indexOf(getKeywords()[i]) != -1){
                    return getLabel();
                }
            }
            return Label.OK;
        }
    }
}