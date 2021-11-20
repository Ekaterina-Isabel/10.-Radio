package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    Radio radio = new Radio();

//тесты для радиостанции
    @Test
    public void shouldNotSetCurrentRadioStationBelowMin() {   //"не должен устанавливать текущую радиостанцию ниже мин"
        radio.setCurrentRadioStation(4);   //вызови метод "установи текущую радиостанцию", передай ей число в круглых скобках
        radio.setCurrentRadioStation(-1);

        assertEquals(4, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetMinRadioStation() {   //"установи мин радиостанцию"
        radio.setCurrentRadioStation(4);
        radio.setCurrentRadioStation(0);

        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetMaxRadioStation() {   //"установи мax радиостанцию"
        radio.setCurrentRadioStation(4);
        radio.setCurrentRadioStation(9);

        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldNotSetCurrentRadioStationHigherMax() {   //"не должен устанавливать текущую радиостанцию выше мах"
        radio.setCurrentRadioStation(4);
        radio.setCurrentRadioStation(10);

        assertEquals(4, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetNextRadioStation() {   //"установи следующую радиостанцию"
        radio.setCurrentRadioStation(5);
        radio.setNextStation();

        assertEquals(6, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetMinRadioStationWhenIncreaseMax() {   //"установи min радиостанцию при увеличении max"
        radio.setCurrentRadioStation(9);
        radio.setNextStation();

        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldPreviousRadioStation() {   //"установи предыдущую радиостанцию"
        radio.setCurrentRadioStation(5);
        radio.setPreviousStation();

        assertEquals(4, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetMaxRadioStationWhenDecreaseMin() {   //"установи maх радиостанцию при уменьшении mix"
        radio.setCurrentRadioStation(0);
        radio.setPreviousStation();

        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetFromMinToNextRadioStation() {   //"установи с min на следующую радиостанцию"
        radio.setCurrentRadioStation(0);
        radio.setNextStation();

        assertEquals(1, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldSetFromPreviousToMaxRadioStation() {   //"установи с предыдущей на max радиостанцию"
        radio.setCurrentRadioStation(8);
        radio.setNextStation();

        assertEquals(9, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldFromNextToMinRadioStation() {   //"установи с последующей на min радиостанцию"
        radio.setCurrentRadioStation(1);
        radio.setPreviousStation();

        assertEquals(0, radio.getCurrentRadioStation());
    }

    @Test
    public void shouldFromMaxToPreviousRadioStation() {   //"установи с max на предыдущую радиостанцию"
        radio.setCurrentRadioStation(9);
        radio.setPreviousStation();

        assertEquals(8, radio.getCurrentRadioStation());
    }

//тесты для громкости
    @Test
    public void shouldNotSetCurrentVolumeBelowMin() {   //"не должен устанавливать текущую громкость ниже мин"
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(-1);

        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMinVolume() {   //"установи мин громкость"
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(0);

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldSetMaxVolume() {   //"установи мax громкость"
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(10);

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotSetCurrentVolumeHigherMax() {   //"не должен устанавливать текущую громкость выше мах"
        radio.setCurrentVolume(5);
        radio.setCurrentVolume(11);

        assertEquals(5, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseVolume() {   //"увеличь громкость на 1"
        radio.setCurrentVolume(7);
        radio.increaseVolume();

        assertEquals(8, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseVolume() {   //"уменьши громкость на 1"
        radio.setCurrentVolume(7);
        radio.decreaseVolume();

        assertEquals(6, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotToBeHigherMaxVolume() {   //"не должен быть выше мах громкости"
        radio.setCurrentVolume(10);
        radio.increaseVolume();
        radio.increaseVolume();

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldNotToBeBelowMinVolume() {   //"не д.б. ниже мin громкости"
        radio.setCurrentVolume(0);
        radio.decreaseVolume();
        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseFromMinToNextVolume() {   //"увеличь громкость с min на следующую на 1"
        radio.setCurrentVolume(0);
        radio.increaseVolume();

        assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    public void shouldIncreaseFromPreviousToMaxVolume() {   //"увеличь громкость с предыдущей на max"
        radio.setCurrentVolume(9);
        radio.increaseVolume();

        assertEquals(10, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseFromNextToMinVolume() {   //"уменьши громкость с последующей на min"
        radio.setCurrentVolume(1);
        radio.decreaseVolume();

        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void shouldDecreaseFromMaxToPreviousVolume() {   //"уменьши громкость с max на предыдущую"
        radio.setCurrentVolume(10);
        radio.decreaseVolume();

        assertEquals(9, radio.getCurrentVolume());
    }
}