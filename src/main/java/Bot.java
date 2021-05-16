import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import javax.activation.CommandInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class Bot extends TelegramLongPollingBot implements LongPollingBot {

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    private final String BOT_USERNAME = "CalKodaBot";
    private final String BOT_TOKEN = "1828309914:AAFd5DL2uOq3bko3ucLD9axCiZGu_Mz3HlM";


    ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();

    Double num_1;
    Double num_2;
    Double res;
    String oper;
    private long chatId;


    private String getUserName(Message msg) {
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getLastName(), user.getFirstName());
    }

    public synchronized void sendMsg(Message msg, String s) {

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(msg.getChatId()));
        sendMessage.setText(s);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            //     log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

    @Override
    public void onUpdateReceived(Update update) {

        Exponentiation exp = new Exponentiation();

        ArrayList<KeyboardRow> keyboard = new ArrayList<KeyboardRow>();
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        KeyboardRow keyboardSecondRow = new KeyboardRow();

        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        Message message = update.getMessage();
        String txt = message.getText();


        if (txt.equals("/start") || (txt.equals("start"))) {
            keyboard.clear();
            keyboardFirstRow.add("Exp");
            keyboardFirstRow.add("Sqrt");
            keyboardSecondRow.add("Help");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            sendMsg(message, "Salam");
            return;
        }
        if (txt.equals("/exp") || (txt.equals("Exp"))){
            keyboard.clear();

            keyboardFirstRow.add("2");
            keyboardFirstRow.add("3");
            keyboardSecondRow.add("Back");
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            sendMsg(message, "re");
        }

        if (txt.equals("/2") || (txt.equals("3"))){
            keyboard.clear();
            Double d = Math.pow(num_1,num_2);

            String re= d.toString();
            keyboard.add(keyboardFirstRow);
            keyboard.add(keyboardSecondRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            sendMsg(message, re);
        }
    }
    public synchronized void exp(Message msg, String s){

    }


         /*   switch (message.getText()){

                case "/start":
                    sm(message,"Поехали");

                    break;

                case "2":
                    String mess = update.getMessage().getText();
                    sendMsg(update.getMessage().getChatId().toString(), mess);

                    break;
                case "/help":
                    sm(message, "Ну и чем я тебе помогу бедолага?");
                    break;

                case "Formulas":
                    sm(message, "Здесь скоро появятся формулы");
                    break;

                case "Sqrt":
                    sm(message, "Cча помогу найти корень... Подождите...");
                    break;

                case "Log":
                    sm(message,"Сложнаа...");
                    break;


                default:
                    sm(message,"Я таких команд не знаю, пока, но скоро узнаю");
                    break;

            }*/





/*

    private void sm(Message message,String s){
        SendMessage sm = new SendMessage();
        sm.enableMarkdown(true);

        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sm.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("2"));
        keyboardFirstRow.add(new KeyboardButton("Sqrt"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Log"));
        keyboardSecondRow.add(new KeyboardButton("Formulas"));



        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);

        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);

        sm.setChatId(message.getChatId().toString());
        sm.setText(s);
        try {
            execute(sm);
        }catch (TelegramApiException e)
        {e.printStackTrace();}
    }
*/





}

