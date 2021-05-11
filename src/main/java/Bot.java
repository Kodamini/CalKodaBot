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

import java.util.ArrayList;
import java.util.List;

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
    private final String BOT_TOKEN = "1777181508:AAFYYEiEccY4kurEG735EQSQMx4Q7FdurJ4";



    private String getUserName(Message msg) {
        User user = msg.getFrom();
        String userName = user.getUserName();
        return (userName != null) ? userName : String.format("%s %s", user.getLastName(), user.getFirstName());
    }

    @Override
    public void onUpdateReceived(Update update) {
        Start strt = new Start();

        Message message = update.getMessage();


    if(message != null && message.hasText()) {

        switch (message.getText()){

            case "/start":
                sm(message,"Поехали");
                break;

            case "Exponentiation":
                strt.smm(message, "Хуй тебе");

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

            }
        }


    }

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
        keyboardFirstRow.add(new KeyboardButton("Exponentiation"));
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





}

