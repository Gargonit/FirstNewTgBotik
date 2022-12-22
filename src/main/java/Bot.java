import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "crooked_Image_Bot";
    }

    @Override
    public String getBotToken() {
        return "5687579446:AAHwfRh5MG3E0zSW205vIe1Wot291Sfh8u8";
    }

    // Веном "AgACAgIAAxkBAAOTY6SSMUqFawmT3UWZhNHkwFdyJqoAAmPGMRvgCilJzDaufFF3mBwBAAMCAAN5AAMsBA"
    // Гора "AgACAgIAAxkBAAOVY6STqCuhloe1K8njNb_gt-KJcHoAAmjGMRvgCilJ6QrdM19IDL4BAAMCAAN5AAMsBA"
    // Дом "AgACAgIAAxkBAAOXY6SUGm73Tfy8yUBzx3Zsso2pV2gAAmzGMRvgCilJSAyW5cMc3RoBAAMCAAN5AAMsBA"
    // Рыбки "AgACAgIAAxkBAAOZY6SUZthl6y9zF7J9LvXCyb6FHm0AAm3GMRvgCilJmLakjZEs-YMBAAMCAAN5AAMsBA"
    // Скорпион "AgACAgIAAxkBAAObY6SUfOMIMvl8n6SxpxDxCaJ6HO4AAm_GMRvgCilJuzX5i4Ud4QMBAAMCAAN5AAMsBA"

    @Override
    public void onUpdateReceived(Update update) {

        SendPhoto sendPhoto = new SendPhoto (  );
        sendPhoto.setChatId (update.getMessage ().getChatId ().toString ());

        SendMessage sendMessage = new SendMessage (  );
        sendMessage.setChatId (update.getMessage ().getChatId ().toString ());

        KeyboardRow keyboardRow1 = new KeyboardRow ();
        keyboardRow1.add (new KeyboardButton ( "Веном" ));
        keyboardRow1.add (new KeyboardButton ( "Гора" ));

        KeyboardRow keyboardRow2 = new KeyboardRow ();
        keyboardRow2.add (new KeyboardButton ( "Дом" ));
        keyboardRow2.add (new KeyboardButton ( "Рыбки" ));
        keyboardRow2.add (new KeyboardButton ( "Скорпион" ));

        List<KeyboardRow>list = new ArrayList<> ();
        list.add (keyboardRow1);
        list.add (keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup ();
        replyKeyboardMarkup.setKeyboard (list);
        sendMessage.setText ("Hi");
        sendMessage.setText(update.getMessage ().getText ());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try {
            execute (sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace ();
        }


        InputFile inputFile = new InputFile ();
        switch (update.getMessage ( ).getText ( )) {
            case "Веном" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOTY6SSMUqFawmT3UWZhNHkwFdyJqoAAmPGMRvgCilJzDaufFF3mBwBAAMCAAN5AAMsBA");
            case "Гора" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOVY6STqCuhloe1K8njNb_gt-KJcHoAAmjGMRvgCilJ6QrdM19IDL4BAAMCAAN5AAMsBA");
            case "Дом" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOXY6SUGm73Tfy8yUBzx3Zsso2pV2gAAmzGMRvgCilJSAyW5cMc3RoBAAMCAAN5AAMsBA");
            case "Рыбки" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOZY6SUZthl6y9zF7J9LvXCyb6FHm0AAm3GMRvgCilJmLakjZEs-YMBAAMCAAN5AAMsBA");
            case "Скорпион" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAObY6SUfOMIMvl8n6SxpxDxCaJ6HO4AAm_GMRvgCilJuzX5i4Ud4QMBAAMCAAN5AAMsBA");
        }
         sendPhoto.setPhoto (inputFile);
        try {
            execute (sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace ();
        }
    }
}
