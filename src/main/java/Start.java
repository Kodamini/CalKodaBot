import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Start extends TelegramLongPollingBot {
    public static void main(String[] args) {

    }
    @Override
    public void onUpdateReceived(Update update) {
        Message message = new Message();

        if (message != null && message.hasText()){
            switch (message.getText()){
                case "X^2":
                case "X^3":
                case "X^4":
                case "X^5":
                case "X^6":
                case "X^7":
                case "X^8":
                case "X^9":

                    break;

                case "Back":
                    smm(message, "");
                    break;

                default:
                    smm(message,"Я таких команд не знаю");
                    break;



            }
        }
    }

    public void smm(Message message, String s){
        SendMessage smm = new SendMessage();
        smm.enableMarkdown(true);

        // Создаем клавиуатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        smm.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("X^2"));
        keyboardFirstRow.add(new KeyboardButton("X^3"));
        keyboardFirstRow.add(new KeyboardButton("X^4"));
        keyboardFirstRow.add(new KeyboardButton("X^5"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("X^6"));
        keyboardSecondRow.add(new KeyboardButton("X^7"));
        keyboardSecondRow.add(new KeyboardButton("X^8"));
        keyboardSecondRow.add(new KeyboardButton("X^9"));

        //Треттья строчка клавиатуры
        KeyboardRow keyboardThirdRow = new KeyboardRow();
        //Добавляем кнопки в третью строчку клавиатуры
        keyboardThirdRow.add(new KeyboardButton("Back"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        keyboard.add(keyboardThirdRow);
        // и устанваливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);

        smm.setChatId(message.getChatId().toString());
        smm.setText(s);
        try {
            execute(smm);
        }catch (TelegramApiException e)
        {e.printStackTrace();}
    }

    @Override
    public String getBotUsername() {
        Bot bot = new Bot();
        return bot.getBotUsername();
    }

    @Override
    public String getBotToken() {
        Bot bot = new Bot();
        return bot.getBotToken();
    }




}
