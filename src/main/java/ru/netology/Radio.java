package ru.netology;

public class Radio {   //класс ru.netology.Radio, с большой буквы
    private int currentRadioStation;   //поле "текущая радиостанция"
    private int minRadioStation = 0;
    private int maxRadioStation = 9;

    private int currentVolume;   //поле "текущая громкость"
    private int minVolume = 0;
    private int maxVolume = 10;

    //радиостанции
    public void setCurrentRadioStation(int currentRadioStation) {   //"установи текущую радиостанцию", set - что-то меняет, но ничего обратно не ждем
        //имя переменной с маленькой буквы
        if (currentRadioStation < minRadioStation) {   //если номер радиостанции < мин номера, то
            return;   //return - завершаем выполнение этой команды
        }
        if (currentRadioStation > maxRadioStation) {
            return;
        }
        this.currentRadioStation = currentRadioStation;
    }

    public int getCurrentRadioStation() {   //"покажи текущую радиостанцию", get - ждем ответ от радио
        return currentRadioStation;
    }

    public void setNextStation() {   //"установи следующую радиостанцию"
        if (currentRadioStation < maxRadioStation) {
            currentRadioStation = currentRadioStation + 1;
        } else {
            currentRadioStation = minRadioStation;
        }
    }

    public void setPreviousStation() {   //"установи предыдущую радиостанцию"
        if (currentRadioStation > minRadioStation) {
            currentRadioStation = currentRadioStation - 1;
        } else {
            currentRadioStation = maxRadioStation;
        }
    }

    //громкость
    public void setCurrentVolume(int currentVolume) {   //"установи текущую громкость"
        if (currentVolume < minVolume) {   //если громкость < мин громкости, то
            return;
        }
        if (currentVolume > maxVolume) {   //если громкость > мах громкости, то
            return;
        }
        this.currentVolume = currentVolume;
    }

    public int getCurrentVolume() {   //"покажи текущую громкость"
        return currentVolume;
    }

    public void decreaseVolume() {   //"уменьши громкость"
        if (currentVolume > minVolume) {
            currentVolume = currentVolume - 1;
        }
    }

    public void increaseVolume() {   //"увеличь громкость"
        if (currentVolume < maxVolume) {
            currentVolume = currentVolume + 1;
        }
    }
}
