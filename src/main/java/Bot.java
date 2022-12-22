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

    // ����� "AgACAgIAAxkBAAOTY6SSMUqFawmT3UWZhNHkwFdyJqoAAmPGMRvgCilJzDaufFF3mBwBAAMCAAN5AAMsBA"
    // ���� "AgACAgIAAxkBAAOVY6STqCuhloe1K8njNb_gt-KJcHoAAmjGMRvgCilJ6QrdM19IDL4BAAMCAAN5AAMsBA"
    // ��� "AgACAgIAAxkBAAOXY6SUGm73Tfy8yUBzx3Zsso2pV2gAAmzGMRvgCilJSAyW5cMc3RoBAAMCAAN5AAMsBA"
    // ����� "AgACAgIAAxkBAAOZY6SUZthl6y9zF7J9LvXCyb6FHm0AAm3GMRvgCilJmLakjZEs-YMBAAMCAAN5AAMsBA"
    // �������� "AgACAgIAAxkBAAObY6SUfOMIMvl8n6SxpxDxCaJ6HO4AAm_GMRvgCilJuzX5i4Ud4QMBAAMCAAN5AAMsBA"

    @Override
    public void onUpdateReceived(Update update) {

        SendPhoto sendPhoto = new SendPhoto (  );
        sendPhoto.setChatId (update.getMessage ().getChatId ().toString ());

        SendMessage sendMessage = new SendMessage (  );
        sendMessage.setChatId (update.getMessage ().getChatId ().toString ());

        KeyboardRow keyboardRow1 = new KeyboardRow ();
        keyboardRow1.add (new KeyboardButton ( "�����" ));
        keyboardRow1.add (new KeyboardButton ( "����" ));

        KeyboardRow keyboardRow2 = new KeyboardRow ();
        keyboardRow2.add (new KeyboardButton ( "���" ));
        keyboardRow2.add (new KeyboardButton ( "�����" ));
        keyboardRow2.add (new KeyboardButton ( "��������" ));

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
            case "�����" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOTY6SSMUqFawmT3UWZhNHkwFdyJqoAAmPGMRvgCilJzDaufFF3mBwBAAMCAAN5AAMsBA");
            case "����" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOVY6STqCuhloe1K8njNb_gt-KJcHoAAmjGMRvgCilJ6QrdM19IDL4BAAMCAAN5AAMsBA");
            case "���" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOXY6SUGm73Tfy8yUBzx3Zsso2pV2gAAmzGMRvgCilJSAyW5cMc3RoBAAMCAAN5AAMsBA");
            case "�����" ->
                    inputFile.setMedia ("AgACAgIAAxkBAAOZY6SUZthl6y9zF7J9LvXCyb6FHm0AAm3GMRvgCilJmLakjZEs-YMBAAMCAAN5AAMsBA");
            case "��������" ->
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
