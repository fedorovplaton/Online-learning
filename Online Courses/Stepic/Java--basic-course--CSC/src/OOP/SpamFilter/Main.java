package OOP.SpamFilter;

public class Main {
    public static void main(String[] args) {

    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        return Label.OK;
    }

    public class SpamAnalyzer implements TextAnalyzer{

        @Override
        public Label processText(String text) {
            return null;
        }
    }

    public class NegativeTextAnalyzer implements TextAnalyzer{

        @Override
        public Label processText(String text) {
            return null;
        }
    }

    public class KeywordAnalyzer implements TextAnalyzer{

        @Override
        public Label processText(String text) {
            return null;
        }
    }
}
