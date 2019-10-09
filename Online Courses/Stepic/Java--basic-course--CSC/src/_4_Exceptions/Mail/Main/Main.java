package _4_Exceptions.Mail.Main;

import java.util.logging.Level;
import java.util.logging.Logger;



public class Main {
    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    public static void main(String[] args) {

    }

    /*
Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
*/
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }

    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException () {   }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException () {   }
    }

    public static class UntrustworthyMailWorker implements MailService{

        private MailService[] ThirdPartyMailServices;
        private RealMailService realMailService = new RealMailService();

        public UntrustworthyMailWorker(MailService[] mailServices) {
            ThirdPartyMailServices = new MailService[mailServices.length];
            for(int i = 0; i < mailServices.length; i++){
                ThirdPartyMailServices[i] = mailServices[i];
            }
        }

        public RealMailService getRealMailService(){
            return realMailService;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            for(int i = 0; i < ThirdPartyMailServices.length; i++){
                    mail = ThirdPartyMailServices[i].processMail(mail);
            }
            return getRealMailService().processMail(mail);
        }
    }

    public static class Spy implements MailService{
        Logger LOGGER;

        public Spy(Logger logger){
            this.LOGGER = logger;
        }
        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailMessage){
                if(mail.getTo().equals(AUSTIN_POWERS) || mail.getFrom().equals(AUSTIN_POWERS)){
                    LOGGER.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[] {mail.getFrom(), mail.getTo(), ((MailMessage) mail).getMessage()});
                }
                else{
                    LOGGER.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[] {mail.getFrom(), mail.getTo()});
                }
            }
            return mail;
        }
    }

    public static class Thief implements MailService{

        private int minValue;
        private int stolenValue;

        public Thief(int minValue) {
            this.minValue = minValue;
        }

        public int getStolenValue(){
            return this.stolenValue;
        }

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minValue) {
                this.stolenValue += ((MailPackage) mail).getContent().getPrice();
                Package returnPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
                mail = new MailPackage(((MailPackage)mail).getFrom(), ((MailPackage)mail).getTo(), returnPackage);
            }
            return mail;
        }
    }

    public static class Inspector implements MailService{

        @Override
        public Sendable processMail(Sendable mail) {
            if(mail instanceof MailPackage){
                if(((MailPackage) mail).getContent().getContent().contains("stones")) {
                    throw new StolenPackageException();
                }
                if(((MailPackage) mail).getContent().getContent().equals(WEAPONS)||
                        ((MailPackage) mail).getContent().getContent().equals(BANNED_SUBSTANCE)){
                    throw new IllegalPackageException();
                }
            }
            return mail;
        }
    }
}
