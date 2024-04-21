package ru.skypro.zveropolis;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.skypro.zveropolis.configuration.TelegramBotConfiguration;
import ru.skypro.zveropolis.relocation.Relocation;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TelegramBotInit extends TelegramLongPollingBot {

    private final TelegramBotConfiguration telegramBotConfiguration;
    private final Relocation relocation;

    @Override
    public void onUpdateReceived(Update update) {
        relocation.doCrossroads(update);
//        Long chatId = update.getMessage().getChatId();
//        String text = update.getMessage().getText();
//        String message = "привет";
//
//            if (update.hasMessage() && update.getMessage().hasText()) {
//                SendMessage sendMessage = new SendMessage();
//                sendMessage.setChatId(chatId);
//                sendMessage.setText(message);
//                try {
//                    execute(sendMessage);
//                } catch (TelegramApiException e) {
//                    throw new RuntimeException(e);
//                }
//            }
    }

    @Override
    public String getBotUsername() {
        return telegramBotConfiguration.getName();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfiguration.getToken();
    }
}

