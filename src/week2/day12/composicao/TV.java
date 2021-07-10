package week2.day12.composicao;

public class TV {
    private int volume = 25;
    private int channel = 13;

    void incrementVolume() {
        if (this.volume == 50) {
            return;
        }
        this.volume++;
    }

    void decrementVolume() {
        if (this.volume == 0) {
            return;
        }
        this.volume--;
    }

    void incrementChannel() {
        if (this.channel == 100) {
            this.channel = 1;
            return;
        }
        this.channel++;
    }

    void decrementChannel() {
        if (this.channel == 1) {
            this.channel = 100;
            return;
        }
        this.channel--;
    }

    void setChannel(int canal) {
        if (this.channel <= 1 || this.channel >= 100) {
            return;
        }
        this.channel = canal;
    }

    void showVolumeAndChannel() {
        System.out.printf("Volume: %d, Canal: %d%n", this.volume, this.channel);
    }
}
