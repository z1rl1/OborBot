package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    long chatIDAdmin = 702504731L;
    long chatID = 0;
    boolean pouskNaz = false;
    boolean pouskKatalog = false;
    boolean uzCrok = false;
    boolean uzObor = false;
    String numArStr = "";
    String numOborStr = "";
    private static final String START_COMMAND = "/start";
    private final DatabaseHandler database = new DatabaseHandler();
    private Klient klient = new Klient();

    @Override
    public String getBotUsername() {
        return "obor1995_bot";
    }

    @Override
    public String getBotToken() {
        return "5975129735:AAGLcZGYm3IGIWAkjUW1VKtz5sqrwMaXEto";
    }

    @Override
    public void onUpdateReceived(Update update) {
                    if (update.getMessage() != null && update.getMessage().hasText()) {
                        Message message = update.getMessage();
                        chatID = message.getChatId();
                        if (chatID == chatIDAdmin) {
                            try {
                                greetingAdmin();
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }
                            if (uzCrok) {
                                String[] words = message.getText().split(" ");
                                database.uzmenCrok(words[0], words[1], numArStr);
                                uzCrok = false;
                            }
                            if (uzObor) {
                                String[] words = message.getText().split("!");
                                database.uzmenObor(words[0], words[1], numOborStr);
                                uzObor = false;
                            }
                        } else {
                            klient.setChatId(String.valueOf(chatID));
                            if (message.getText().equals(START_COMMAND)) {
                                try {
                                    greeting();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (pouskNaz) {
                                if (update.getMessage().getText().equals("Беговая дорожка")) {
                                    srAr();
                                    klient.setIdObor("1");
                                } else if (update.getMessage().getText().equals("Эллиптический тренажер")) {
                                    srAr();
                                    klient.setIdObor("2");
                                } else if (update.getMessage().getText().equals("Гантели")) {
                                    srAr();
                                    klient.setIdObor("3");
                                } else if (update.getMessage().getText().equals("Ноутбук")) {
                                    srAr();
                                    klient.setIdObor("4");
                                } else if (update.getMessage().getText().equals("Принтер")) {
                                    srAr();
                                    klient.setIdObor("5");
                                } else if (update.getMessage().getText().equals("Монитор")) {
                                    srAr();
                                    klient.setIdObor("6");
                                } else if (update.getMessage().getText().equals("Бетоносмеситель")) {
                                    srAr();
                                    klient.setIdObor("7");
                                } else if (update.getMessage().getText().equals("Рубанок для столярных работ")) {
                                    srAr();
                                    klient.setIdObor("8");
                                } else if (update.getMessage().getText().equals("Штукатурная машина")) {
                                    srAr();
                                    klient.setIdObor("9");
                                } else if (update.getMessage() != null) {
                                    SendPhoto sendPhoto = SendPhoto.builder()
                                            .chatId(chatID)
                                            .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\1EHWUKY7KWc.jpg"))).caption("Ничего не найдено!").build();
                                    InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
                                    List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
                                    List<InlineKeyboardButton> rowInLine = new ArrayList<>();
                                    var button1 = new InlineKeyboardButton();
                                    button1.setText("НачМеню");
                                    button1.setCallbackData("2.2");
                                    rowInLine.add(button1);
                                    rowsInLine.add(rowInLine);
                                    markupInlIne.setKeyboard(rowsInLine);
                                    sendPhoto.setReplyMarkup(markupInlIne);
                                    try {
                                        execute(sendPhoto);
                                    } catch (TelegramApiException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            } else if (pouskKatalog) {
                                if (update.getMessage().getText().equals("1")) {
                                    srAr();
                                    klient.setIdObor("1");
                                } else if (update.getMessage().getText().equals("2")) {
                                    srAr();
                                    klient.setIdObor("2");
                                } else if (update.getMessage().getText().equals("3")) {
                                    srAr();
                                    klient.setIdObor("3");
                                } else if (update.getMessage().getText().equals("4")) {
                                    srAr();
                                    klient.setIdObor("4");
                                } else if (update.getMessage().getText().equals("5")) {
                                    srAr();
                                    klient.setIdObor("5");
                                } else if (update.getMessage().getText().equals("6")) {
                                    srAr();
                                    klient.setIdObor("6");
                                } else if (update.getMessage().getText().equals("7")) {
                                    srAr();
                                    klient.setIdObor("7");
                                } else if (update.getMessage().getText().equals("8")) {
                                    srAr();
                                    klient.setIdObor("8");
                                } else if (update.getMessage().getText().equals("9")) {
                                    srAr();
                                    klient.setIdObor("9");
                                } else if (update.getMessage() != null) {
                                    SendPhoto sendPhoto = SendPhoto.builder()
                                            .chatId(chatID)
                                            .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\1EHWUKY7KWc.jpg"))).caption("Ничего не найдено!").build();
                                    InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
                                    List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
                                    List<InlineKeyboardButton> rowInLine = new ArrayList<>();
                                    var button1 = new InlineKeyboardButton();
                                    button1.setText("НачМеню");
                                    button1.setCallbackData("2.2");
                                    rowInLine.add(button1);
                                    rowsInLine.add(rowInLine);
                                    markupInlIne.setKeyboard(rowsInLine);
                                    sendPhoto.setReplyMarkup(markupInlIne);
                                    try {
                                        execute(sendPhoto);
                                    } catch (TelegramApiException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        }
                    } else if (update.hasCallbackQuery()) {
                        String callBackData = update.getCallbackQuery().getData();
                        switch (callBackData) {
                            case "1.1" -> {
                                try {
                                    arendObor();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "1.2" -> {
                                try {
                                    allKat();
                                    pouskKatalog = true;
                                    pouskNaz = false;
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "1.3" -> {
                                pouskNaz = true;
                                pouskKatalog = false;
                            }
                            case "1.4" -> {
                                try {
                                    kateg();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "2.1" -> {
                                try {
                                    instr();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "2.2" -> {
                                try {
                                    greeting();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "Sport" -> {
                                sport();
                            }
                            case "Komp" -> {
                                komp();
                            }
                            case "Str" -> {
                                str();
                            }
                            case "Sport.1" -> {
                                srAr();
                                klient.setIdObor("1");
                            }
                            case "Sport.2" -> {
                                srAr();
                                klient.setIdObor("2");
                            }
                            case "Sport.3" -> {
                                srAr();
                                klient.setIdObor("3");
                            }
                            case "Komp.1" -> {
                                srAr();
                                klient.setIdObor("4");
                            }
                            case "Komp.2" -> {
                                srAr();
                                klient.setIdObor("5");
                            }
                            case "Komp.3" -> {
                                srAr();
                                klient.setIdObor("6");
                            }
                            case "Str.1" -> {
                                srAr();
                                klient.setIdObor("7");
                            }
                            case "Str.2" -> {
                                srAr();
                                klient.setIdObor("8");
                            }
                            case "Str.3" -> {
                                srAr();
                                klient.setIdObor("9");
                            }
                            case "srAr.1" -> {
                                sosPol();
                                klient.setIdArenda("1");
                            }
                            case "srAr.2" -> {
                                sosPol();
                                klient.setIdArenda("2");
                            }
                            case "srAr.3" -> {
                                sosPol();
                                klient.setIdArenda("3");
                            }
                            case "srAr.4" -> {
                                sosPol();
                                klient.setIdArenda("4");
                            }
                            case "sosPol.1" -> {
                                spOpl();
                                klient.setIdPol("1");
                            }
                            case "sosPol.2" -> {
                                spOpl();
                                klient.setIdPol("2");
                            }
                            case "spOpl.1" -> {
                                try {
                                    Oplata();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                                klient.setSpOp("Безнал");
                            }
                            case "spOpl.2" -> {
                                try {
                                    Oplata();
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                                klient.setSpOp("Нал");
                            }
                            case "OPLATA" -> {
                                try {
                                    end();
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                } catch (TelegramApiException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            case "Ad-1.1" -> {
                                oborAdmin();
                            }
                            case "Ad-2.1" -> {
                                arAdmin();
                            }
                            case "Ad-1.1.1" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "1";
                            }
                            case "Ad-1.1.2" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "2";
                            }
                            case "Ad-1.1.3" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "3";
                            }
                            case "Ad-1.1.4" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "4";
                            }
                            case "Ad-1.1.5" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "5";
                            }
                            case "Ad-1.1.6" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "6";
                            }
                            case "Ad-1.1.7" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "7";
                            }
                            case "Ad-1.1.8" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "8";
                            }
                            case "Ad-1.1.9" -> {
                                uzOborod();
                                uzObor = true;
                                numOborStr = "9";
                            }
                            case "Ad-2.2.1" -> {
                                uzCrok();
                                uzCrok = true;
                                numArStr = "1";
                            }
                            case "Ad-2.2.2" -> {
                                uzCrok();
                                uzCrok = true;
                                numArStr = "2";
                            }
                            case "Ad-2.2.3" -> {
                                uzCrok();
                                uzCrok = true;
                                numArStr = "3";
                            }
                            case "Ad-2.2.4" -> {
                                uzCrok();
                                uzCrok = true;
                                numArStr = "4";
                            }

                        }
                    }
    }

    public void greeting() throws TelegramApiException {
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).caption("Здравствуйте, вас " +
                        "приветсвует бот по аренде оборудования!" +
                        " Выберете нужный варинат!").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Арендовать оборудование");
        button1.setCallbackData("1.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("Инструкция");
        button2.setCallbackData("2.1");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        sendPhoto.setReplyMarkup(markupInlIne);
        execute(sendPhoto);
    }

    public void instr() throws TelegramApiException {
        SendPhoto sendInstr = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\instr.jpg"))).caption("Данный бот " +
                        "предназначен для аренды оборудования. Если вы хотите арендовать оборудование нажмите " +
                        "Аренда оборудования, потом вы можете просмотреть список оборудования, либо же " +
                        "найти вам нужное(нажимайте на соответствующие кнопки)!").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Назад");
        button1.setCallbackData("2.2");
        rowInLine.add(button1);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        sendInstr.setReplyMarkup(markupInlIne);
        execute(sendInstr);
    }

    public void arendObor() throws TelegramApiException{
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\hm.png"))).caption("Произведите поиск " +
                        "или посмотрите весь каталог(Если поиск по названию, то нажмите на кнопку и пишите название " +
                        "оборудования, функция станет доступной)").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Каталог");
        button1.setCallbackData("1.2");
        var button2 = new InlineKeyboardButton();
        button2.setText("Название");
        button2.setCallbackData("1.3");
        var button3 = new InlineKeyboardButton();
        button3.setText("Категория");
        button3.setCallbackData("1.4");
        var button4 = new InlineKeyboardButton();
        button4.setText("НачМеню");
        button4.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        execute(send);
    }

    public void kateg() throws SQLException, TelegramApiException {
        StringBuilder cap = new StringBuilder("Выберете нужную категорию\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\kat.png"))).build();
        String finish = database.kat();
        String[] words = finish.split(" ");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Sport");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Komp");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Str");
        var button4 = new InlineKeyboardButton();
        button4.setText("НачМеню");
        button4.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sport(){
        StringBuilder cap = new StringBuilder();
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\sport.png"))).build();
        String finish = null;
        try {
            finish = database.sportKat();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());

        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Sport.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Sport.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Sport.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("НачМеню");
        button4.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);

        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void str(){
        StringBuilder cap = new StringBuilder();
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\str.png"))).build();
        String finish = null;
        try {
            finish = database.strKat();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());

        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Str.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Str.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Str.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("НачМеню");
        button4.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);

        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void komp(){
        StringBuilder cap = new StringBuilder();
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\komp.png"))).build();
        String finish = null;
        try {
            finish = database.kompKat();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }

        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Komp.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Komp.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Komp.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("НачМеню");
        button4.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);

        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void srAr(){
        StringBuilder cap = new StringBuilder();
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\srok.png"))).build();
        String finish = null;
        try {
            finish = database.srokuArend();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("srAr.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("srAr.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("srAr.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("4");
        button4.setCallbackData("srAr.4");
        var button5 = new InlineKeyboardButton();
        button5.setText("НачМеню");
        button5.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowInLine.add(button5);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sosPol(){
        StringBuilder cap = new StringBuilder();
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\SpPol.png"))).build();
        String finish = null;
        try {
            finish = database.spPol();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("sosPol.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("sosPol.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("НачМеню");
        button3.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void spOpl(){
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\spOpl.png"))).caption("Выберите " +
                        "способ оплаты").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Безнал");
        button1.setCallbackData("spOpl.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("Нал");
        button2.setCallbackData("spOpl.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("НачМеню");
        button3.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void Oplata() throws TelegramApiException {
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\oplata.png"))).caption("Оплата " +
                        "оборудования!").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Оплатить");
        button1.setCallbackData("OPLATA");
        var button2 = new InlineKeyboardButton();
        button2.setText("НачМеню");
        button2.setCallbackData("2.2");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        sendPhoto.setReplyMarkup(markupInlIne);
        execute(sendPhoto);
    }

    public void end() throws SQLException, TelegramApiException {
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\ysp.png"))).caption("Успешно!").build();

        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button2 = new InlineKeyboardButton();
        button2.setText("НачМеню");
        button2.setCallbackData("2.2");
        rowInLine.add(button2);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        sendPhoto.setReplyMarkup(markupInlIne);
        execute(sendPhoto);

        String URL = "jdbc:sqlite:C:\\Users\\kiril\\tgBot.db";
        Connection conn = DriverManager.getConnection(URL);

        String chid = klient.getChatId();
        String CposOpl = klient.getSpOp(); //оборудование аренда получение оплата чатайди
        String IdObor = klient.getIdObor();
        String idPool = klient.getIdPol();
        String IdAr = klient.getIdArenda();

        String finish = null;
        try {
            finish = database.idOplaa(IdAr,idPool);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            klient.setIdOpl(words[i]);
        }
        String IdOpl = klient.getIdOpl();
        try {
            Statement statement = conn.createStatement();
            String query = "INSERT INTO Клиент (ChatId, СпособОплаты, IdObor, IdOplata) VALUES ('" +
                    chid + "', '" + CposOpl + "', '" + IdObor + "', '" + IdOpl + "')";
            statement.executeUpdate(query);
            System.out.println("Данные успешно добавлены в базу данных");
        } catch (SQLException e) {
            System.out.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    public void allKat() throws TelegramApiException {
        StringBuilder cap = new StringBuilder("Выберете нужное вам оборудование!(ВВЕДИТЕ ЦИФРУ)\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\naz.png"))).build();
        String finish = null;
        try {
            finish = database.vceTovars();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("НачМеню");
        button1.setCallbackData("2.2");
        rowInLine.add(button1);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void greetingAdmin() throws TelegramApiException {
        SendPhoto sendPhoto = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).caption("Что вы хотите изменить?").build();
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("Список оборудования");
        button1.setCallbackData("Ad-1.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("Сроки аренд");
        button2.setCallbackData("Ad-2.1");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        sendPhoto.setReplyMarkup(markupInlIne);
        execute(sendPhoto);
    }

    public void arAdmin(){
        StringBuilder cap = new StringBuilder("Что именно хотите изменить?\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).build();
        String finish = null;
        try {
            finish = database.vceCroku();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Ad-2.2.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Ad-2.2.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Ad-2.2.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("4");
        button4.setCallbackData("Ad-2.2.4");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowsInLine.add(rowInLine);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void uzCrok(){
        StringBuilder cap = new StringBuilder("Напишите через пробел новый срок аренды и цену\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).build();
        send.setCaption(cap.toString());
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void oborAdmin(){
        StringBuilder cap = new StringBuilder("Что именно хотите изменить(учитывайте категорию товара)?\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).build();
        String finish = null;
        try {
            finish = database.vceTovars();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String[] words = finish.split("!");
        for (int i = 0; i < words.length; i++) {
            cap.append(i+1).append(")").append(words[i]);
            cap.append("\n");
        }
        send.setCaption(cap.toString());
        InlineKeyboardMarkup markupInlIne = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
        List<InlineKeyboardButton> rowInLine  = new ArrayList<>();
        var button1 = new InlineKeyboardButton();
        button1.setText("1");
        button1.setCallbackData("Ad-1.1.1");
        var button2 = new InlineKeyboardButton();
        button2.setText("2");
        button2.setCallbackData("Ad-1.1.2");
        var button3 = new InlineKeyboardButton();
        button3.setText("3");
        button3.setCallbackData("Ad-1.1.3");
        var button4 = new InlineKeyboardButton();
        button4.setText("4");
        button4.setCallbackData("Ad-1.1.4");
        var button5 = new InlineKeyboardButton();
        button5.setText("5");
        button5.setCallbackData("Ad-1.1.5");
        rowInLine.add(button1);
        rowInLine.add(button2);
        rowInLine.add(button3);
        rowInLine.add(button4);
        rowInLine.add(button5);
        rowsInLine.add(rowInLine);
        List<InlineKeyboardButton> rowInLine1  = new ArrayList<>();
        var button6 = new InlineKeyboardButton();
        button6.setText("6");
        button6.setCallbackData("Ad-1.1.6");
        var button7 = new InlineKeyboardButton();
        button7.setText("7");
        button7.setCallbackData("Ad-1.1.7");
        var button8 = new InlineKeyboardButton();
        button8.setText("8");
        button8.setCallbackData("Ad-1.1.8");
        var button9 = new InlineKeyboardButton();
        button9.setText("9");
        button9.setCallbackData("Ad-1.1.9");
        rowInLine1.add(button6);
        rowInLine1.add(button7);
        rowInLine1.add(button8);
        rowInLine1.add(button9);
        rowsInLine.add(rowInLine1);
        markupInlIne.setKeyboard(rowsInLine);
        send.setReplyMarkup(markupInlIne);
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void uzOborod(){
        StringBuilder cap = new StringBuilder("Напишите через ! название и описание\n");
        SendPhoto send = SendPhoto.builder()
                .chatId(chatID)
                .photo(new InputFile(new File("C:\\Users\\kiril\\Desktop\\arenda.png"))).build();
        send.setCaption(cap.toString());
        try {
            execute(send);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

}
